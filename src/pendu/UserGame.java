package pendu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 
 */
public class UserGame  {
	
	/**
	 * Stores the secret word that the player wants to discover
	 */
	private final List <Character> secretWord = new ArrayList<Character>();
	
	/**
	 * 
	 */
	private int lifePoints;
	
	private final List <Character> userWord = new ArrayList<Character>();
	
	private final Set <Character> userLetter = new HashSet<>();
	
	public UserGame(String generateWordToUser, int defaultLifePoint) {
		
		for(char c : generateWordToUser.toCharArray()) {
			secretWord.add(c);
			lifePoints = defaultLifePoint ;
		}
		
		for (int index = 0; index < generateWordToUser.length(); index++ ) {
			userWord.add('_');
		}
		
	}

	public void userLetter(char letter) {
		
		userLetter.add(letter);
		
		if(secretWord.contains(letter) && !userWord.contains(letter)) {
			
		int index =0;
		for (char c : secretWord) {
			if(c == letter) {
				userWord.set(index, c);
			}
			index ++;
		}
			
		}else {
			lifePoints -=1;
		}
		
	}

	public boolean isLost() {
		return lifePoints <=0 ;
	}

	public boolean isWon() {
		return !userWord.contains('_');
	}
	
	@Override
	public String toString() {
		return "UserGame [secretWord=" + secretWord + ","
				+ " lifePoint=" + lifePoints + ","
				+ " userWord=" + userWord + ","
				+ " userletter=" + userLetter +
				"]";
	}

}
