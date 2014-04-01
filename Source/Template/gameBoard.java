public class gameBoard {
	
	Member homeTeam, awayTeam;
	int homeLife, awayLife, homeScore, awayScore;
	String gameWord, currentState, result;
	
	
	public String createWord(String gameWord){
		this.gameWord = gameWord;
	}
	
	public String haveGuess(char guess){
		if(gameWord.indexOf(guess) == -1) { //not found
			awayLife--;
			if(awayLife > 0) return currentState;
			else return awayLostGame();
		}
		
	}
	
	private int searchStringforChar(char c){
		String searchString = gameWord;
		int count = 0;
		while (searchString.indexOf(c) != -1){
			count++;
			searchString = searchString.substring(searchString.indexOf(c));
		}
		return count;
		//alt: int count = StringUtils.countMatches("a.b.c.d", ".");
	}
	
	private void replaceUnderscore(char c){
		String search = gameWord;
		char[] current = currentState.toCharArray();
		int length = current.length;
		for (int i; i < length; i++){
			if (search.charAt(i) == c) current[i] = c;
		}
		currentState = new String(current);
	}
	
	
	public String haveGuess(String guess){
		
	}
		
	public String awayLostGame(){
		homeScore++;
		result = awayTeam.toString() + " has lost all their lives. Correct answer was " + gameWord + 
		"\nCurrent score is " + homeTeam.toString() + " " + String.valueOf(homeScore) + 
		":" + 
		String.valueOf(awayScore) + " " + awayTeam.toString();
	}
	
	public String homeLostGame(){

	}
	
	
	
}