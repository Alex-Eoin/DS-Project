import Chat.*;

class ChatServant implements ChatRoomOperations {
	
	/** Declarations */
	GameBoard game;
	
	Member[] members ;
	Player[] players ;
	String[] names;
	
	String homeTeam, awayTeam, word;
	int playerType, numberMembers, numberPlayers;

	/** Contructor */
	public ChatServant() {
		members = new Member[10];
		players = new Player[2];
		names = new String[10];
		numberMembers = numberPlayers = 0;
		homeTeam = awayTeam = "Empty";
	}

	/** Register for Chat (callback) */
	public void registerCB(Member m, String name) {
		members[numberMembers] = m ;
		names[numberMembers] = name ;
		// For each Member, callback
		for (int i=0; i<numberMembers; i++) {
			members[i].callBack("New Member: " + name) ;
		}
		numberMembers++ ;
		m.callBack("Thank you " + name + ", you are now registered");
		//Display Member addition on Server
		System.out.println(name + " has just joined the chat room.");
	}

	/** Register for a game */
	public String registerGame(Player p, String name) {
		// Prevent players not already registered for Chat, also only 2 players allowed
		if (!searchForName(name)) return "Not Found";
		if (numberPlayers >= 2) return "Room Full";
		// Add player and callback
		players[numberPlayers] = p ;
		numberPlayers++ ;
		p.callBack("Thank you " + name + ", you are now registered for the game");
		// Display Member addition on Server
		System.out.println(name + " has just joined the game room.");
		// If homeTeam not set, set as this player, otherwise set awayTeam
		if (homeTeam.equals("Empty")){
			homeTeam = name;
			playerType = 0;
		} else if (awayTeam.equals("Empty")){
			awayTeam = name;
			playerType = 1;
		}
		// Callback to each player and member 
		for (int i=0; i< numberPlayers; i++) {
			members[i].callBack(name + " has entered a game") ;
			players[i].callBack("New Player: " + name) ;
		}
		// If it's the away player, then the game is ready for creation, return away
		if(playerType == 1){
			createGame();
			for (int i=0; i< numberPlayers; i++) {
				players[i].callBack("Game created " + homeTeam + " vs " + awayTeam) ;
			}
			return "Away";
		} else {
			return "Home";
		}
	}
	/** Searches player memberList for player just added */
	private boolean searchForName(String name){
		for (int i=0; i< numberMembers; i++) {
			if(names[i].equals(name)) return true; //name found
		}
		return false;
	}
	
	/** flushes values assigned to game data */
	public void exitGame(){
		numberPlayers = 0;
		homeTeam = "Empty";
		awayTeam = "Empty";
	}

	/** creates a gameboard and informs the players*/
	private void createGame(){
		game = new GameBoard(homeTeam, awayTeam, word);
		String s = game.getMask();
		for (int i=0; i<numberPlayers; i++)	{
			players[i].callBack("Game word: [" + s + "]") ;
		}
	}
	/** Home play is to create the word (called once per game */
	public void homePlay(String word){
		this.word = word;
	}
	
	/** away play returns a message generated from the game board (returned multiple times */
	public String awayPlay(String word){
		String s = game.haveGuess(word);
		System.out.println(s);
		for (int i=0; i<numberPlayers; i++)	{
			players[i].callBack("Game Message: " + s) ;
		}
		if (s.substring(0,10).equals("GAME OVER!")) exitGame();
		return s;
	}
	
	/** chat sends message to members for chat type and players for anything else (using callback) */
	public void chat(String type, String c, String name) {
		System.out.println(name + " said: " + c);
		String s = "Message from " + name + ": " + c  ;
		if (type.equals("Chat")){
			for (int i=0; i<numberMembers; i++)	{
				members[i].callBack(s) ;
			}
		} else {
			for (int i=0; i<numberPlayers; i++)	{
				players[i].callBack(type + ": " + c) ;
			}
		}
	}

}
