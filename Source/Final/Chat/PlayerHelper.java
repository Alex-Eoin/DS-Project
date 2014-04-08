package Chat;


/**
* Chat/PlayerHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Chat.idl
* 08 April 2014 18:54:33 o'clock IST
*/

abstract public class PlayerHelper
{
  private static String  _id = "IDL:Chat/Player:1.0";

  public static void insert (org.omg.CORBA.Any a, Chat.Player that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Chat.Player extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (Chat.PlayerHelper.id (), "Player");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Chat.Player read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_PlayerStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Chat.Player value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static Chat.Player narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Chat.Player)
      return (Chat.Player)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Chat._PlayerStub stub = new Chat._PlayerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static Chat.Player unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Chat.Player)
      return (Chat.Player)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Chat._PlayerStub stub = new Chat._PlayerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}