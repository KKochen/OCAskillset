package VierOpEenRij;
import java.util.Scanner; 

public class Menu {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {

		while(true) {
			System.out.print("Welkom bij vier op een rij. Wilt u met 1 of 2 spelers spelen? Kies 3 om het spel te stoppen: ");
			byte playerMode = input.nextByte();
			
			Game game = new Game();
		
			if(playerMode == 1) {
				System.out.println("Speler 1 vs. Computer. Veel plezier!");
				game.beginGame((byte)1);
			}
			else if(playerMode == 2){
				System.out.println("Speler 1 vs. Speler 2. Veel plezier!");
				game.beginGame((byte)2);
			}
			else if(playerMode == 3){
				System.out.println("Spel beeindigd.");
				break;
			}			
			else {
				System.out.println("Je hebt een onjuist nummer ingevoerd.");
			}
		}
	}
}
