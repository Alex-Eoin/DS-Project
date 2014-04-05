import Chat.*;

class ChatServant implements ChatRoomOperations
{
	Member[] members ;
	Player[] players ;

	int playerType;
	String[] names;
	GameBoard game;
	String homeTeam = "Empty";
	String awayTeam = "Empty";
	String word;

	int numberMembers, numberPlayers;

	ChatServant() {
		members = new Member[10];
		players = new Player[2];
		names = new String[10];
		numberMembers = 0;
		numberPlayers = 0;
	}

	public void registerCB(Member m, String name) {
		members[numberMembers] = m ;
		names[numberMembers] = name ;
		for (int i=0; i<numberMembers; i++) {
			members[i].callBack("New Member: " + name) ;
		}
		numberMembers++ ;
		m.callBack("Thank you " + name + ", you are now registered");
		System.out.println(name + " has just joined the chat room.");
	}

	public String registerGame(Player p, String name) {
		if (!searchForName(name)) return "Not Found";
		
		players[numberPlayers] = p ;
		
		numberPlayers++ ;
		p.callBack("Thank you " + name + ", you are now registered for the game");
		System.out.println(name + " has just joined the game room.");
		if (homeTeam.equals("Empty")){
			homeTeam = name;
			playerType = 0;
		} else if (awayTeam.equals("Empty")){
			awayTeam = name;
			playerType = 1;
		}
		
		for (int i=0; i< numberPlayers; i++) {
			members[i].callBack(name + " has entered a game") ;
			players[i].callBack("New Player: " + name) ;
		}
		
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
	private boolean searchForName(String name){
		for (int i=0; i< numberMembers; i++) {
			if(names[i].equals(name)) return true; //name found
		}
		return false;
	}
	
	public void exitGame(){

	}

	private void createGame(){
		game = new GameBoard(homeTeam, awayTeam, word);
		String s = game.getMask();
		for (int i=0; i<numberPlayers; i++)	{
			players[i].callBack("Game word: [" + s + "]") ;
		}
	}
	
	public void homePlay(String word){
		this.word = word;
	}
	
	public String awayPlay(String word){
		String s = game.haveGuess(word);
		System.out.println(s);
		for (int i=0; i<numberPlayers; i++)	{
			players[i].callBack("Game Message: " + s) ;
		}
		return s;
	}
	
	

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
