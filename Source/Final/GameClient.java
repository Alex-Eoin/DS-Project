// GameClient.java

import Chat.* ;
import java.io.* ;
import org.omg.CORBA.* ;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

public class GameClient {
    public static void main(String[] args) {
		String playerType, word, guess;
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
			if (playerType.equals("Not Found"))	{
				p.callBack("Only players registered in chat can register in the gameroom and play hangman");
				try {
					Thread.sleep(3000);
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
			} else if (playerType.equals("Home"))	{
				p.callBack("The game is hangman. As the first player, please choose a word.");
				word = reader.readLine();
				p.callBack("The word chosen is "+ word);
				gameRoom.homePlay(word);
				gameRoom.chat("Game Message", CustomerName+ " has entered a word, waiting on another player", "System");
				do {
					msg = reader.readLine() ;
					gameRoom.chat("Game Message from " + CustomerName, msg, "");
				} while (msg != "exit");					
			} else {
				p.callBack("The game is hangman. As the second player, please guess a letter from the word.");
				p.callBack("You have 5 lives");
				p.callBack("Guess a letter contained in the word:");
				do {
					guess = reader.readLine() ;
					//gameRoom.chat("Game Message", CustomerName + " guessed [" + guess+ "]", "");
					gameRoom.awayPlay(guess);
					try {
						Thread.sleep(1000);
					} catch(InterruptedException ex) {
						Thread.currentThread().interrupt();
					}
					p.callBack("Guess again:");
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
