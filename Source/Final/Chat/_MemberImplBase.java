package Chat;


/**
* Chat/_MemberImplBase.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Chat.idl
* 04 April 2014 14:45:11 o'clock IST
*/

public abstract class _MemberImplBase extends org.omg.CORBA.portable.ObjectImpl
                implements Chat.Member, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors
  public _MemberImplBase ()
  {
  }

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("callBack", new java.lang.Integer (0));
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
       case 0:  // Chat/Member/callBack
       {
         String message = in.read_string ();
         this.callBack (message);
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
    "IDL:Chat/Member:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }


} // class _MemberImplBase
