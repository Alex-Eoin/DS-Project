// ChatClient.java

import Chat.* ;
import java.io.* ;
import org.omg.CORBA.* ;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

public class ChatClient {
    public static void main(String[] args) {
		String msg = "";
		try {
    		ORB orb = ORB.init(args, null);

	    	//Get the Object reference from the NameService
			org.omg.CORBA.Object nameObj=orb.resolve_initial_references("NameService");
			NamingContext rootCtx=NamingContextHelper.narrow(nameObj);
			NameComponent[] name = new NameComponent[1];
			name[0] = new NameComponent("Chatroom", "Object");
			org.omg.CORBA.Object obj = rootCtx.resolve(name);
			ChatRoom room = ChatRoomHelper.narrow(obj);

  			Member m = new Member_Tie(new MemberImpl()) ;

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Please enter your name before entering the chat room:");
			String CustomerName=reader.readLine();

			room.registerCB(m, CustomerName);

			BufferedReader b = new BufferedReader(new InputStreamReader(System.in)) ;

			do {
				System.out.println("Enter Message:") ;
				msg = b.readLine() ;
				room.chat(msg, CustomerName) ;
				if (msg == "exit")
					System.out.println("msg="+msg) ;
			} while (msg != "exit");

		} catch (Exception e) {
	 	   	System.out.println("ERROR : " + e) ;
	    		e.printStackTrace(System.out);
		}
    }
}


class MemberImpl implements MemberOperations {
	public void callBack(String message) {
		System.out.println(message) ;
	}
}

