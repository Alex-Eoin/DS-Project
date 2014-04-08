package Chat;


/**
* Chat/_ChatRoomStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Chat.idl
* 08 April 2014 18:54:33 o'clock IST
*/

public class _ChatRoomStub extends org.omg.CORBA.portable.ObjectImpl implements Chat.ChatRoom
{


  // Chat methods
  public void registerCB (Chat.Member m, String name)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("registerCB", false);
                Chat.MemberHelper.write ($out, m);
                $out.write_string (name);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                registerCB (m, name        );
            } finally {
                _releaseReply ($in);
            }
  } // registerCB

  public void chat (String type, String c, String name)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("chat", false);
                $out.write_string (type);
                $out.write_string (c);
                $out.write_string (name);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                chat (type, c, name        );
            } finally {
                _releaseReply ($in);
            }
  } // chat


  // Game related methods
  public String registerGame (Chat.Player p, String name)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("registerGame", true);
                Chat.PlayerHelper.write ($out, p);
                $out.write_string (name);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return registerGame (p, name        );
            } finally {
                _releaseReply ($in);
            }
  } // registerGame

  public void homePlay (String word)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("homePlay", false);
                $out.write_string (word);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                homePlay (word        );
            } finally {
                _releaseReply ($in);
            }
  } // homePlay

  public String awayPlay (String word)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("awayPlay", true);
                $out.write_string (word);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return awayPlay (word        );
            } finally {
                _releaseReply ($in);
            }
  } // awayPlay

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Chat/ChatRoom:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _ChatRoomStub
