// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: math.proto

package yuloh.math;

public final class CalculatorProto {
  private CalculatorProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_yuloh_math_AddRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_yuloh_math_AddRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_yuloh_math_AddReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_yuloh_math_AddReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_yuloh_math_SubtractRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_yuloh_math_SubtractRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_yuloh_math_SubtractReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_yuloh_math_SubtractReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nmath.proto\022\nyuloh.math\"\"\n\nAddRequest\022\t" +
      "\n\001x\030\001 \001(\005\022\t\n\001y\030\002 \001(\005\"\027\n\010AddReply\022\013\n\003sum\030" +
      "\001 \001(\005\"\'\n\017SubtractRequest\022\t\n\001x\030\001 \001(\005\022\t\n\001y" +
      "\030\002 \001(\005\"\035\n\rSubtractReply\022\014\n\004diff\030\001 \001(\0052\211\001" +
      "\n\nCalculator\0225\n\003add\022\026.yuloh.math.AddRequ" +
      "est\032\024.yuloh.math.AddReply\"\000\022D\n\010subtract\022" +
      "\033.yuloh.math.SubtractRequest\032\031.yuloh.mat" +
      "h.SubtractReply\"\000B(\n\nyuloh.mathB\017Calcula" +
      "torProtoP\001\242\002\003HLW\320\002\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_yuloh_math_AddRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_yuloh_math_AddRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_yuloh_math_AddRequest_descriptor,
        new java.lang.String[] { "X", "Y", });
    internal_static_yuloh_math_AddReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_yuloh_math_AddReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_yuloh_math_AddReply_descriptor,
        new java.lang.String[] { "Sum", });
    internal_static_yuloh_math_SubtractRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_yuloh_math_SubtractRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_yuloh_math_SubtractRequest_descriptor,
        new java.lang.String[] { "X", "Y", });
    internal_static_yuloh_math_SubtractReply_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_yuloh_math_SubtractReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_yuloh_math_SubtractReply_descriptor,
        new java.lang.String[] { "Diff", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
