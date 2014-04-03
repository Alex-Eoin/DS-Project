// ChatServer.java
import  Chat.* ;
import org.omg.CORBA.*;
import java.io.* ;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;


public class ChatServer {

    public static void main(String args[]) {
	try{
			System.out.println("Starting Server ...") ;
	    	ORB orb = ORB.init(args, null);

			System.out.println("Initialising ChatServant ...") ;
			ChatRoom c = new ChatRoom_Tie(new ChatServant()) ;
	    	System.out.println("Connecting Orb...") ;
			orb.connect(c);

	    	System.out.println("Creating Object reference from the NameService..");
			org.omg.CORBA.Object nameObj=orb.resolve_initial_references("NameService...");
			NamingContext rootCtx=NamingContextHelper.narrow(nameObj);
			System.out.println("Creating Name Component...");
			NameComponent[] name = new NameComponent[1];
			name[0] = new NameComponent("Chatroom", "Object");
			System.out.println("Binding to root context...");
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
