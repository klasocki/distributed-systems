// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: subscriptions.proto

package sr.grpc;

public interface WeatherResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:sr.grpc.WeatherResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string city = 1;</code>
   * @return The city.
   */
  java.lang.String getCity();
  /**
   * <code>string city = 1;</code>
   * @return The bytes for city.
   */
  com.google.protobuf.ByteString
      getCityBytes();

  /**
   * <code>float temperature = 2;</code>
   * @return The temperature.
   */
  float getTemperature();

  /**
   * <code>.sr.grpc.Conditions conditions = 3;</code>
   * @return The enum numeric value on the wire for conditions.
   */
  int getConditionsValue();
  /**
   * <code>.sr.grpc.Conditions conditions = 3;</code>
   * @return The conditions.
   */
  sr.grpc.Conditions getConditions();
}