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
		
		if(playerType == 1){
			createGame();
			chat("Game message", "Game created", "System");
		}

		for (int i=0; i< numberPlayers; i++) {
			players[i].callBack("New Player: " + name) ;
		}
		return "complete":
	}
	
	public void exitGame(){
		
	}
	
	private void createGame(){
		game = new GameBoard(homeTeam, awayTeam);
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
				players[i].callBack(type) ;
			}
		} 
	}
	
	
}
