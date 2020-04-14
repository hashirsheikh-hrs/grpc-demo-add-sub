# grpc-demo-add-sub
This is the demo code to evaluburate about grpc server and client.

#Server
To build server use try to execute following command - 
  ./gradlew installDist
  
It will create a folder 'install' inside /build folder of project directory. you will find setup file inside calculator folder as follow below path - 
  build/install/CalculatorService/bin/calculator-server

Now open terminal and execute calculator-server file on it. It will start server and listening the port 50051 by default.

#Client
Just run the app on you device, check the your server address and enter the host detail on host coloumn.
