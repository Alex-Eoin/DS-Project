import Chat.*;

class ChatServant implements ChatRoomOperations
{
	Member[] members ;
	Member[] players ;
	
	int playerType;
	String[] names ;
	GameBoard game;
	String homeTeam = "Empty";
	String awayTeam = "Empty";
	
	int numberMembers, numberPlayers;

	ChatServant() {
		members = new Member[10];
		players = new Member[2];
		names = new String[10];
		numberMembers = 0 ;
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

	public int registerGame(Member m, String name) {
		players[numberPlayers] = m ;
		
		if (homeTeam.equals("Empty")){
			homeTeam = name;
			playerType = 0;
		} else if (awayTeam.equals("Empty")){
			awayTeam = name;
			playerType = 1;
		}
		numberMembers++ ;
		if(playerType == 1){
			//create game
			//callback game created
		}
		members[numberMembers] = m ;
		names[numberMembers] = name ;
	
		for (int i=0; i<numberMembers; i++) {
			members[i].callBack("New Member: " + name) ;
		}
		
		numberMembers++ ;
		m.callBack("Thank you " + name + ", you are now registered");
		System.out.println(name + " has just joined the game room.");
	}
	
	public void exitGame(){
		
	}
	
	private createGame(){
		game = new GameBoard(homeTeam, awayTeam);
	}
	
	private broadcast(){
	
	}
	
	public void chat(String c, String name) {
		System.out.println(name + " said: " + c);
		String s = "Message from " + name + ": " + c  ;
		for (int i=0; i<numberMembers; i++)	{
			members[i].callBack(s) ;
		}
	}
	
	
}
