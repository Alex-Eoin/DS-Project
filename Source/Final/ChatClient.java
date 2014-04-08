// ChatClient.java

import Chat.* ;
import java.io.* ;
import org.omg.CORBA.* ;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

public class ChatClient {
    public static void main(String[] args) {
		String msg, CustomerName;
		ORB orb;
		org.omg.CORBA.Object nameObj, obj;
		NamingContext rootCtx;
		NameComponent[] name = new NameComponent[1];
		ChatRoom room;
		Member m;
		BufferedReader reader;

		System.out.println("Welcome to Hangman Chat ");
		System.out.println("- Written and Created by x10205691 and x10201271 ");		
		
		try {
    		// Orb
			orb = ORB.init(args, null);
			// Naming Object
			nameObj = orb.resolve_initial_references("NameService");
			// Root Context
			rootCtx=NamingContextHelper.narrow(nameObj);	
			// Chatroom Name Component
			name[0] = new NameComponent("Chatroom", "Object");
			obj = rootCtx.resolve(name);
			room = ChatRoomHelper.narrow(obj);
			// Member Object
			m = new Member_Tie(new MemberImpl()) ;
			// Reader for user input
			reader = new BufferedReader(new InputStreamReader(System.in));
			// Prompt and get user input
			System.out.println("Please enter your name before entering the chat room:");
			CustomerName = reader.readLine();
			// Register member for chat
			room.registerCB(m, CustomerName);

			do {
				hang(1);
				System.out.println("Enter Message:") ;
				msg = reader.readLine() ;
				// Chat (to chat room members)
				room.chat("Chat", msg, CustomerName) ;
				if (msg == "exit")
					System.out.println("msg="+msg) ;
			} while (msg != "exit");

		} catch (Exception e) {
	 	   	System.out.println("ERROR : " + e) ;
	    		e.printStackTrace(System.out);
		}
    }
	
	/** hang
	* Waits a number of seconds, allowing server responses to be published in correct sequence
	*/
	private static void hang(int seconds){
		try {
			Thread.sleep(seconds * 1000);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}


class MemberImpl implements MemberOperations {
	public void callBack(String message) {
		System.out.println(message) ;
	}
}
