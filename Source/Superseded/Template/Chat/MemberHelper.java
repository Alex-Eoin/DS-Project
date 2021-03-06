package Chat;


/**
* Chat/MemberHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Chatroom.idl
* 01 April 2014 19:33:20 o'clock IST
*/

abstract public class MemberHelper
{
  private static String  _id = "IDL:Chat/Member:1.0";

  public static void insert (org.omg.CORBA.Any a, Chat.Member that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Chat.Member extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (Chat.MemberHelper.id (), "Member");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Chat.Member read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_MemberStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Chat.Member value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static Chat.Member narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Chat.Member)
      return (Chat.Member)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Chat._MemberStub stub = new Chat._MemberStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static Chat.Member unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Chat.Member)
      return (Chat.Member)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Chat._MemberStub stub = new Chat._MemberStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
