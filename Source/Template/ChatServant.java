import Chat.*;

class ChatServant implements ChatRoomOperations
{
	Member[] members ;
	String[] names ;
	String[] currentGame = {"empty", "empty", "data", "data"}; 
	GameBoard game;
	String homeTeam = "Empty";
	String awayTeam = "Empty";
	
	int numberMembers ;

	ChatServant() {
		members = new Member[10];
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

	public void registerGame(Member m, String name) {
		if (homeTeam.equals("Empty")){
			homeTeam = name;
		} else if (awayTeam.equals("Empty")){
			awayTeam = name;
		}
		if(!(homeTeam.equals("Empty") && homeTeam.equals("Empty"))){
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
		System.out.println(name + " has just joined the chat room.");

	}
	
	public void exitGame(){
		
	}
	
	public void chat(String c, String name) {
		System.out.println(name + " said: " + c);
		String s = "Message from " + name + ": " + c  ;
		for (int i=0; i<numberMembers; i++)	{
			members[i].callBack(s) ;
		}
	}
	
	
}
