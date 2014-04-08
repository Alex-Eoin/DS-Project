import Chat.*;

public class GameBoard {
	
	/* Declarations */
	int lives;
	String gameWord, wordMask, result, homeTeam, awayTeam;
	
	/** Constructor 
	* Assigns string values for 'homeTeam', 'awayTeam', 'gameWord', 'wordMask' and player 'lives'
	*/
	public GameBoard(String homeTeam, String awayTeam, String word){
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		createWord(word);
		lives = 5;
	}
	
	/** Assigns values to 'gameWord' and creates a 'wordMask' of underscores 
	*/
	public void createWord(String gameWord){
		this.gameWord = gameWord;
		char[] cString = new char[gameWord.length()];
		for(int i = 0; i < gameWord.length(); i++){
			cString[i] = '_';
		}
		wordMask = new String(cString);
	}
	
	/** Returns the masked word 
	*/
	public String getMask(){
		return wordMask;
	}
	
	/** Game logic, updates 'lives' or 'wordMask' depending on whether character is found
	* If all lives lost, or all char guessed, calls away/homeLostGame
	*/
	public String haveGuess(char guess){
		if(gameWord.indexOf(guess) == -1) { //not found
			lives--;
			if(lives > 0) return "["+ wordMask + "] Incorrect guess. Life lost, " + lives + " remaining!";
			else return awayLostGame();
		} else {
			replaceUnderscore(guess);
			if(wordMask.indexOf('_') == -1) return homeLostGame();
		}
		return "["+ wordMask + "] Correct guess. " + lives + " lives remaining!";
	}
	
	/** Overloaded method which takes the char value of the guess 
	*/ 
	public String haveGuess(String guess){
		return haveGuess(guess.charAt(0));
	}
	
	/** Searches word for char and returns a count
	* Not used in current version of the project 
	*/
	private int searchStringforChar(char c){
		String searchString = gameWord;
		int count = 0;
		while (searchString.indexOf(c) != -1){
			count++;
			searchString = searchString.substring(searchString.indexOf(c));
		}
		return count;
	}
	
	/** Replaces each occurence of the character in the gameWord 
	* in the matching index of the mask, to slowly reveal the word to the player
	*/
	private void replaceUnderscore(char c){
		String search = gameWord;
		char[] current = wordMask.toCharArray();
		int length = current.length;
		for (int i = 0; i < length; i++){
			if (search.charAt(i) == c) current[i] = c;
		}
		wordMask = new String(current);
	}
	
	/** Compile return string */
	public String awayLostGame(){
		result = "GAME OVER! ... " + awayTeam.toString() + " has lost all their lives. Correct answer was " + gameWord;
		return result;
	}
	
	/** Compile return string */
	public String homeLostGame(){
		result = "GAME OVER! ... " + awayTeam.toString() + " has guessed correctly. Correct answer was " + gameWord;
		return result;
	}
}