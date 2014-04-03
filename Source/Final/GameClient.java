// GameClient.java

import Chat.* ;
import java.io.* ;
import org.omg.CORBA.* ;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

public class ChatClient {
    public static void main(String[] args) {
		int playerType;
		String msg = "";
		ORB orb;
		org.omg.CORBA.Object nameObj, obj;
		NamingContext rootCtx;
		NameComponent[] name = new NameComponent[1];
		ChatRoom gameRoom;
		Member m;
		BufferedReader reader;
		
		try {
    		orb = ORB.init(args, null);
			nameObj=orb.resolve_initial_references("NameService");
			rootCtx=NamingContextHelper.narrow(nameObj);
			name[0] = new NameComponent("Chatroom", "Object");
			obj = rootCtx.resolve(name);
			gameRoom = ChatRoomHelper.narrow(obj);
  			m = new Member_Tie(new MemberImpl()) ;

			reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Please enter your name before entering the game room:");
			String CustomerName=reader.readLine();

			playerType = room.registerGame(CustomerName);
			
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

