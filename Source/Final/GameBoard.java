import Chat.*;

public class GameBoard {
	
	int  playerLife, awayLife;
	String gameWord, currentState, result, homeTeam, awayTeam;
	
	public GameBoard(String homeTeam, String awayTeam){
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		playerLife = 5;
	}
	
	public String createWord(String gameWord){
		this.gameWord = gameWord;
		char[] cString = new char[gameWord.length()];
		for(int i = 0; i < gameWord.length(); i++){
			cString[i] = '_';
		}
		currentState = new String(cString);
		return currentState;
	}
	
	public String haveGuess(char guess){
		if(gameWord.indexOf(guess) == -1) { //not found
			awayLife--;
			if(awayLife > 0) return currentState;
			else return awayLostGame();
		} else {
			replaceUnderscore(guess);
			if(currentState.indexOf('_') == -1) homeLostGame();
		}
		return currentState;
	}
	
	private int searchStringforChar(char c){
		String searchString = gameWord;
		int count = 0;
		while (searchString.indexOf(c) != -1){
			count++;
			searchString = searchString.substring(searchString.indexOf(c));
		}
		return count;
	}
	
	private void replaceUnderscore(char c){
		String search = gameWord;
		char[] current = currentState.toCharArray();
		int length = current.length;
		for (int i = 0; i < length; i++){
			if (search.charAt(i) == c) current[i] = c;
		}
		currentState = new String(current);
	}
	
	public String awayLostGame(){
		result = awayTeam.toString() + " has lost all their lives. Correct answer was " + gameWord;
		return result;
	}
	
	public String homeLostGame(){
		result = awayTeam.toString() + " has guessed correctly. Correct answer was " + gameWord;
		return result;
	}
}