// GameClient.java

import Chat.* ;
import java.io.* ;
import org.omg.CORBA.* ;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

public class GameClient {
    public static void main(String[] args) {
		String playerType, word, guess, result;
		String msg, playerName;
		ORB orb;
		org.omg.CORBA.Object nameObj, obj;
		NamingContext rootCtx;
		NameComponent[] name = new NameComponent[1];
		ChatRoom gameRoom;
		Player p;
		BufferedReader reader;
		
		System.out.println("Welcome to the Hangman Game Room ");
		System.out.println("- Written and Created by x10205691 and x10201271 ");		
		
		try {
			// Orb
    		orb = ORB.init(args, null);
			// Naming Object
			nameObj = orb.resolve_initial_references("NameService");
			// Root Context
			rootCtx = NamingContextHelper.narrow(nameObj);
			// Chatroom Name Component
			name[0] = new NameComponent("Chatroom", "Object");
			obj = rootCtx.resolve(name);
			gameRoom = ChatRoomHelper.narrow(obj);
			// Player Object
  			p = new Player_Tie(new PlayerImpl()) ;
			// Reader for user input
			reader = new BufferedReader(new InputStreamReader(System.in));
			// Prompt and get user input
			System.out.println("Please enter your name before entering the game room:");
			playerName=reader.readLine();
			// Register player for game and return type (for moves)
			playerType = gameRoom.registerGame(p, playerName);
			
			// Depending on response
			// Player not found
			if (playerType.equals("Not Found"))	{
				p.callBack("Only players registered in chat can register in the gameroom and play hangman");
				hang(3);
			// Already 2 players
			} else if (playerType.equals("Room Full"))	{
				p.callBack("Hangman room is full...try again later");
				hang(3);
			// Plyer registered is a home (first) player
			} else if (playerType.equals("Home")) {
				p.callBack("The game is hangman. As the first player, please choose a word.");
				word = reader.readLine();
				p.callBack("The word chosen is "+ word);
				gameRoom.homePlay(word);
				gameRoom.chat("Game Message", playerName+ " has entered a word, waiting on another player", "System");
				do {
					msg = reader.readLine() ;
					gameRoom.chat("Game Message from " + playerName, msg, "");
				} while (msg != "exit");		
			// Player registered is away (second) player
			} else {
				p.callBack("The game is hangman. As the second player, please guess a letter from the word.");
				p.callBack("You have 5 lives");
				p.callBack("Guess a letter contained in the word:");
				do {
					guess = reader.readLine() ;
					//gameRoom.chat("Game Message", playerName + " guessed [" + guess+ "]", "");
					result = gameRoom.awayPlay(guess);
					hang(1);
					if (!result.substring(0,10).equals("GAME OVER!")) { 
						p.callBack("Guess again:");
					} else {
						hang(5);
						msg = "exit";
					}
				} while (msg != "exit");	
			}

		} catch (Exception e) {
	 	   	System.out.println("ERROR : " + e) ;
	    		e.printStackTrace(System.out);
		}
    }
	private static void hang(int seconds){
		try {
			Thread.sleep(seconds * 1000);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	
}

class PlayerImpl implements PlayerOperations {
	public void callBack(String message) {
		System.out.println(message) ;
	}
}
