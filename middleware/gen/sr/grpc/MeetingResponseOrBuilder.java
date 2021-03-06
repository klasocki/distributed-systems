// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: subscriptions.proto

package sr.grpc;

public interface MeetingResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:sr.grpc.MeetingResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string team = 1;</code>
   * @return The team.
   */
  java.lang.String getTeam();
  /**
   * <code>string team = 1;</code>
   * @return The bytes for team.
   */
  com.google.protobuf.ByteString
      getTeamBytes();

  /**
   * <code>string room = 2;</code>
   * @return The room.
   */
  java.lang.String getRoom();
  /**
   * <code>string room = 2;</code>
   * @return The bytes for room.
   */
  com.google.protobuf.ByteString
      getRoomBytes();

  /**
   * <code>string datetime = 3;</code>
   * @return The datetime.
   */
  java.lang.String getDatetime();
  /**
   * <code>string datetime = 3;</code>
   * @return The bytes for datetime.
   */
  com.google.protobuf.ByteString
      getDatetimeBytes();

  /**
   * <code>.sr.grpc.Type type = 5;</code>
   * @return The enum numeric value on the wire for type.
   */
  int getTypeValue();
  /**
   * <code>.sr.grpc.Type type = 5;</code>
   * @return The type.
   */
  sr.grpc.Type getType();

  /**
   * <code>repeated .sr.grpc.Person participants = 4;</code>
   */
  java.util.List<sr.grpc.Person> 
      getParticipantsList();
  /**
   * <code>repeated .sr.grpc.Person participants = 4;</code>
   */
  sr.grpc.Person getParticipants(int index);
  /**
   * <code>repeated .sr.grpc.Person participants = 4;</code>
   */
  int getParticipantsCount();
  /**
   * <code>repeated .sr.grpc.Person participants = 4;</code>
   */
  java.util.List<? extends sr.grpc.PersonOrBuilder> 
      getParticipantsOrBuilderList();
  /**
   * <code>repeated .sr.grpc.Person participants = 4;</code>
   */
  sr.grpc.PersonOrBuilder getParticipantsOrBuilder(
      int index);
}
