package Chat;


/**
* Chat/_ChatRoomImplBase.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Chat.idl
* 04 April 2014 14:45:11 o'clock IST
*/

public abstract class _ChatRoomImplBase extends org.omg.CORBA.portable.ObjectImpl
                implements Chat.ChatRoom, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors
  public _ChatRoomImplBase ()
  {
  }

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("registerCB", new java.lang.Integer (0));
    _methods.put ("registerGame", new java.lang.Integer (1));
    _methods.put ("chat", new java.lang.Integer (2));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // Chat/ChatRoom/registerCB
       {
         Chat.Member m = Chat.MemberHelper.read (in);
         String name = in.read_string ();
         this.registerCB (m, name);
         out = $rh.createReply();
         break;
       }

       case 1:  // Chat/ChatRoom/registerGame
       {
         Chat.Player p = Chat.PlayerHelper.read (in);
         String name = in.read_string ();
         String $result = null;
         $result = this.registerGame (p, name);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 2:  // Chat/ChatRoom/chat
       {
         String type = in.read_string ();
         String c = in.read_string ();
         String name = in.read_string ();
         this.chat (type, c, name);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Chat/ChatRoom:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }


} // class _ChatRoomImplBase