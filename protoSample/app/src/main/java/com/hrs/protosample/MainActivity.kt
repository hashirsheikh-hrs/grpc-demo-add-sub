package com.hrs.protosample

import android.app.Activity
import android.os.AsyncTask
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.hrs.protosample.databinding.ActivityMainBinding
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import io.grpc.examples.helloworld.GreeterGrpc
import io.grpc.examples.helloworld.HelloRequest
import yuloh.math.*
import java.io.PrintWriter
import java.io.StringWriter
import java.lang.ref.WeakReference
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        mainBinding.Add.setOnClickListener {
            val action = "0"
            actionFun(mainBinding, action);
        }

        mainBinding.Sub.setOnClickListener {

            val action = "1"
            actionFun(mainBinding, action);
        }
    }

    private fun actionFun(mainBinding: ActivityMainBinding, action: String){
        val x = mainBinding.X.text.toString()
        val y = mainBinding.Y.text.toString()
        val host = mainBinding.hostAdd.text.toString()
        val port = mainBinding.port.text.toString()
        mainBinding.result.text = ""
        GrpcTask(mainBinding).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, host, port, x, y, action)
    }

    inner class GrpcTask(mainBinding: ActivityMainBinding)  : AsyncTask<String?, Void?, String>() {
        private val activityReference: WeakReference<ActivityMainBinding> = WeakReference(mainBinding)
        private var channel: ManagedChannel? = null

        override fun onPostExecute(result: String) {
            try {
                channel?.shutdown()?.awaitTermination(1, TimeUnit.SECONDS)
            } catch (e: InterruptedException) {
                Thread.currentThread().interrupt()
            }
            val activity = activityReference.get() ?: return
            activity.result.text = result
        }

        override fun doInBackground(vararg p0: String?): String {
            return try {
                val host = p0[0]?:"http://34245bbc.ngrok.io/"
                val port = p0[1]?.toIntOrNull()?:80
                val x = p0[2]?.toIntOrNull()?:0
                val y = p0[3]?.toIntOrNull()?:0
                val action = p0[4]?.toIntOrNull()?:0

                channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build()
                val stub = CalculatorGrpc.newBlockingStub(channel)
                if(action == 0){
                    val req = AddRequest.newBuilder().setX(x).setY(y).build()
                    val res = stub.add(req)
                    return res.sum.toString()
                }else{
                    val req = SubtractRequest.newBuilder().setX(x).setY(y).build()
                    val res = stub.subtract(req)
                    return res.diff.toString()
                }
                return ""
            } catch (e: Exception) {
                val sw = StringWriter()
                val pw = PrintWriter(sw)
                e.printStackTrace(pw)
                pw.flush()
                String.format("Failed... : %n%s", sw)
            }
        }
    }
}
