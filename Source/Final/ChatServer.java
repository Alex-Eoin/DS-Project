// ChatServer.java

import  Chat.* ;
import org.omg.CORBA.*;
import java.io.* ;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;


public class ChatServer {

    public static void main(String args[]) {
		/* Declarations */
		org.omg.CORBA.Object nameObj;
		ORB orb;
		ChatRoom c;
		NameComponent[] name = new NameComponent[1];
		NamingContext rootCtx;
		
		
		System.out.println("Starting Server ...") ;
		
		try{
			
			System.out.println("Creating Chatroom and connecting Orb...") ;
				orb = ORB.init(args, null);
				c = new ChatRoom_Tie(new ChatServant()) ;			
				orb.connect(c);

			System.out.println("Creating Object reference from the NameService..");
				nameObj = orb.resolve_initial_references("NameService");
				rootCtx = NamingContextHelper.narrow(nameObj);
				
			System.out.println("Assigning Name Component and binding to Root...");
				name[0] = new NameComponent("Chatroom", "Object");
				rootCtx.rebind(name,c);

			System.out.println("Server is running and available for clients ...") ;
				orb.run();

		} catch (Exception e) {
				System.err.println("ERROR: " + e);
	    		e.printStackTrace(System.out);
		}
    }
}
