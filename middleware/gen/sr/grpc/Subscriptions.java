// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: subscriptions.proto

package sr.grpc;

public final class Subscriptions {
  private Subscriptions() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sr_grpc_MeetingRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sr_grpc_MeetingRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sr_grpc_Person_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sr_grpc_Person_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sr_grpc_MeetingResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sr_grpc_MeetingResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sr_grpc_WeatherRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sr_grpc_WeatherRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sr_grpc_WeatherResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sr_grpc_WeatherResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023subscriptions.proto\022\007sr.grpc\"\036\n\016Meetin" +
      "gRequest\022\014\n\004team\030\001 \001(\t\"\'\n\006Person\022\014\n\004name" +
      "\030\001 \001(\t\022\017\n\007surname\030\002 \001(\t\"\203\001\n\017MeetingRespo" +
      "nse\022\014\n\004team\030\001 \001(\t\022\014\n\004room\030\002 \001(\t\022\020\n\010datet" +
      "ime\030\003 \001(\t\022\033\n\004type\030\005 \001(\0162\r.sr.grpc.Type\022%" +
      "\n\014participants\030\004 \003(\0132\017.sr.grpc.Person\"M\n" +
      "\016WeatherRequest\022\014\n\004city\030\001 \001(\t\022\032\n\022desired" +
      "Temperature\030\002 \001(\002\022\021\n\ttolerance\030\003 \001(\002\"]\n\017" +
      "WeatherResponse\022\014\n\004city\030\001 \001(\t\022\023\n\013tempera" +
      "ture\030\002 \001(\002\022\'\n\nconditions\030\003 \001(\0162\023.sr.grpc" +
      ".Conditions*4\n\004Type\022\013\n\007STANDUP\020\000\022\020\n\014COMP" +
      "ANY_WIDE\020\001\022\r\n\tDIRECTORS\020\002*:\n\nConditions\022" +
      "\t\n\005SUNNY\020\000\022\n\n\006CLOUDY\020\001\022\t\n\005RAINY\020\002\022\n\n\006STO" +
      "RMY\020\0032\250\001\n\023SubscriptionService\022G\n\020subscri" +
      "beWeather\022\027.sr.grpc.WeatherRequest\032\030.sr." +
      "grpc.WeatherResponse0\001\022H\n\021subscribeMeeti" +
      "ngs\022\027.sr.grpc.MeetingRequest\032\030.sr.grpc.M" +
      "eetingResponse0\001B\002P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_sr_grpc_MeetingRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_sr_grpc_MeetingRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sr_grpc_MeetingRequest_descriptor,
        new java.lang.String[] { "Team", });
    internal_static_sr_grpc_Person_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_sr_grpc_Person_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sr_grpc_Person_descriptor,
        new java.lang.String[] { "Name", "Surname", });
    internal_static_sr_grpc_MeetingResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_sr_grpc_MeetingResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sr_grpc_MeetingResponse_descriptor,
        new java.lang.String[] { "Team", "Room", "Datetime", "Type", "Participants", });
    internal_static_sr_grpc_WeatherRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_sr_grpc_WeatherRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sr_grpc_WeatherRequest_descriptor,
        new java.lang.String[] { "City", "DesiredTemperature", "Tolerance", });
    internal_static_sr_grpc_WeatherResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_sr_grpc_WeatherResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sr_grpc_WeatherResponse_descriptor,
        new java.lang.String[] { "City", "Temperature", "Conditions", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
