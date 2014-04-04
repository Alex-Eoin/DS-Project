// GameClient.java

import Chat.* ;
import java.io.* ;
import org.omg.CORBA.* ;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

public class GameClient {
    public static void main(String[] args) {
		String playerType;
		String msg = "";
		ORB orb;
		org.omg.CORBA.Object nameObj, obj;
		NamingContext rootCtx;
		NameComponent[] name = new NameComponent[1];
		ChatRoom gameRoom;
		Player p;
		BufferedReader reader;
		
		try {
    		orb = ORB.init(args, null);
			nameObj=orb.resolve_initial_references("NameService");
			rootCtx=NamingContextHelper.narrow(nameObj);
			name[0] = new NameComponent("Chatroom", "Object");
			obj = rootCtx.resolve(name);
			gameRoom = ChatRoomHelper.narrow(obj);
  			p = new Player_Tie(new PlayerImpl()) ;

			reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Please enter your name before entering the game room:");
			String CustomerName=reader.readLine();

			playerType = gameRoom.registerGame(p, CustomerName);
			
			reader = new BufferedReader(new InputStreamReader(System.in));
			
			if (playerType.equals("Home"))	{
				System.out.println("Home team-");
				System.out.println("Please enter a word for the game:");
				msg = reader.readLine();
				gameRoom.chat("Game Message", CustomerName+ " has entered a word, waiting on another player", "System");
				do {
					msg = reader.readLine() ;
					gameRoom.chat("Game Message", msg, CustomerName);
				} while (msg != "exit");					
			} else {
				System.out.println("Away team-");
				do {
					System.out.println("Guess a letter contained in the word:");
					System.out.println("Enter Message:") ;
					msg = reader.readLine() ;
					gameRoom.chat("Game Message", msg, CustomerName);
					if (msg == "exit") System.out.println("msg="+msg) ;
				} while (msg != "exit");	
			}
			

			

		} catch (Exception e) {
	 	   	System.out.println("ERROR : " + e) ;
	    		e.printStackTrace(System.out);
		}
    }
}

class PlayerImpl implements PlayerOperations {
	public void callBack(String message) {
		System.out.println(message) ;
	}
}
