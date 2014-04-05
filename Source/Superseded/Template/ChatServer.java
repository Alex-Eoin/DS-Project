// ChatServer.java
import Chat.* ;
import org.omg.CORBA.*;
import java.io.* ;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;


public class ChatServer {

    public static void main(String args[]) {
		/** Declarations */
		ORB orb;
		ChatRoom c;
		org.omg.CORBA.Object nameObj;
		NameComponent[] name = new NameComponent[1];
		NamingContext rootCtx;
		
		try{
			
	    	orb = ORB.init(args, null);
			c = new ChatRoom_Tie(new ChatServant()) ;
	    	orb.connect(c);

			nameObj = orb.resolve_initial_references("NameService");
			rootCtx=NamingContextHelper.narrow(nameObj);
			name[0] = new NameComponent("Chatroom", "Object");
			rootCtx.rebind(name,c);

			System.out.println("The Game Server is now running ...") ;
			orb.run();

		} catch (Exception e) {
	    		System.err.println("ERROR: " + e);
	    		e.printStackTrace(System.out);
		}
    }
	
	
}
