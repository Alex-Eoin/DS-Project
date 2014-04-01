// ChatServer.java
import  Chat.* ;
import org.omg.CORBA.*;
import java.io.* ;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;


public class ChatServer {

    public static void main(String args[]) {
	try{
	    	// create and initialize the ORB
	    	ORB orb = ORB.init(args, null);

			ChatRoom c = new ChatRoom_Tie(new ChatServant()) ;
	    	orb.connect(c);

	    	//Create  Object reference from the NameService
			org.omg.CORBA.Object nameObj=orb.resolve_initial_references("NameService");
			NamingContext rootCtx=NamingContextHelper.narrow(nameObj);
			NameComponent[] name = new NameComponent[1];
			name[0] = new NameComponent("Chatroom", "Object");
			rootCtx.rebind(name,c);
/*
	    	ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("IOR")) ;
	    	out.writeObject(orb.object_to_string(c)) ;
			out.close() ;
*/
			System.out.println("The Chat Room is now open for gossip ...") ;
			orb.run();

		} catch (Exception e) {
	    		System.err.println("ERROR: " + e);
	    		e.printStackTrace(System.out);
		}
    }
}
