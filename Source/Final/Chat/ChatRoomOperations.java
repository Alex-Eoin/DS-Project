package Chat;


/**
* Chat/ChatRoomOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Chat.idl
* 04 April 2014 14:45:11 o'clock IST
*/

public interface ChatRoomOperations 
{
  void registerCB (Chat.Member m, String name);
  String registerGame (Chat.Player p, String name);
  void chat (String type, String c, String name);
} // interface ChatRoomOperations
