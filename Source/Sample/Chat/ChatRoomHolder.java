package Chat;

/**
* Chat/ChatRoomHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Chatroom.idl
* 03 April 2014 17:13:14 o'clock IST
*/

public final class ChatRoomHolder implements org.omg.CORBA.portable.Streamable
{
  public Chat.ChatRoom value = null;

  public ChatRoomHolder ()
  {
  }

  public ChatRoomHolder (Chat.ChatRoom initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Chat.ChatRoomHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Chat.ChatRoomHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Chat.ChatRoomHelper.type ();
  }

}
