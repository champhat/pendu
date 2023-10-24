package pendu;

import java.util.Random;
import java.util.Scanner;

/*
 * 
 */
public class Main {

	public static void main(String[] args) {

		final Random random = new Random();
		final String[] words = "toto tata perdu branche voiture toutankamon".split(" ");
		String generateWordToUser = words[random.nextInt(words.length)];
		UserGame usergame = new UserGame(generateWordToUser,10);
		
		System.out.println("Début du jeu.");
		
		while(true) {
			System.out.println(usergame.toString());
			final char letter = scanLetter("entrez une lettre");
			
			usergame.userLetter(letter);
			
			if(usergame.isLost()) {
				System.out.println(usergame);
				System.out.println("Perdu !");
			}
			
			if(usergame.isWon()) {
				System.out.println(usergame);
				System.out.println("Gagné !");
			}
			
			if(usergame.isLost() ||usergame.isWon()) {
				char replayAnswer = scanLetter("voulez-vous rejouer y / n ?");
				
				if(replayAnswer == 'y') {
					generateWordToUser = words[random.nextInt(words.length)];
					usergame = new UserGame(generateWordToUser,10);
				}else {
					System.out.println("ok merci bye bye !");
					break;
				}
			}
			
		}
		
		
		
	}

	private static char scanLetter(String question) {
		
		final Scanner scan = new Scanner(System.in);		
		Character letter = null;
		
		do {
			
			System.out.println(question);
			String input =  scan.nextLine();
			
			if(input.length()==1) {
				letter = input.charAt(0);
			}
			
		}while (letter ==null);
		
		return letter;
	}

}
