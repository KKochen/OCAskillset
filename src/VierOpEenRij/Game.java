package VierOpEenRij;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
	public static byte[][] gameGrid = new byte[6][7];
	public Scanner input = new Scanner(System.in);
	GameLogic gameLogic = new GameLogic();
	public byte player = 0;
	public boolean win = false;
	public byte mode = 0;
	
	
	public void beginGame(byte gameMode) {
		mode = gameMode;
		//Beslis wie er mag beginnen
		System.out.println("Gooi een munt op voor wie mag beginnen.");
		double tossResult = Math.random();
		if(tossResult <= 0.49) {
			player = 1;
			System.out.println("Speler 1 mag beginnen. Kies een rij om je schijf in te gooien.");
			playGame(player);
		}
		else {
			player = 2;
			if(mode == 1) System.out.println("Computer mag beginnen. Kies een rij om je schijf in te gooien.");
			else System.out.println("Speler 2 mag beginnen. Kies een rij om je schijf in te gooien.");
			playGame(player);
		}
	}
	
	public void playGame(byte player) {
		String gridOutput;
		//Print het spelveld.
		do {
			gridOutput = Arrays.deepToString(gameGrid).replace("], ", "]\n"); //Van StackOverflow geplukt.			
			System.out.println(gridOutput.substring(1,gridOutput.length() - 1)); //zelf uitgevogeld.
			System.out.println("Speler " + player + " is aan de beurt.");
			
			//Kolom kiezen met veiligheidschecks.
			byte column = 0;
			byte row = 0;
		
			//Computer kiest kolom.
			if(mode == 1 && player == 2) {
				byte temp = (byte)(Math.random() * 7);
				if(temp <= 0) column = 1;
				else if(temp > 7) column = 7;
				else column = temp;				
			};
			
			//Speler kiest kolom (met veiligheidschecks).			
			if((mode == 1 && player == 1) || mode == 2) {
				while(true) {
					System.out.print("Kies een kolomnummer van 1 tot 7: ");
					column = input.nextByte();
					if(column < 1 || column > 7) 
						System.out.println("Verkeerd kolom nummer.");
					else if(gameGrid[0][column-1] != 0)
						System.out.println("Deze kolom is vol. Kies een andere.");
					else
						break;
				}
			}
				
			//Appel op je hoofd doet zeer he Newton?
			ROWCOUNTER: for(byte i = 5; i >= 0; i--) {
							if (gameGrid[i][column-1] == 0) {		
								gameGrid[i][column-1] = player;
								row = i;
								break ROWCOUNTER;
							}
						}
		
			//Heeft de speler vier op een rij?
			do {
			win = gameLogic.checkLeftDiagonal(row,(byte)(column-1));
			if(win) break;
			win = gameLogic.checkVertical(row,(byte)(column-1));
			if(win) break;
			win = gameLogic.checkRightDiagonal(row,(byte)(column-1));
			if(win) break;
			win = gameLogic.checkHorizontal(row,(byte)(column-1));
			if(win) break;
			} while (win);
		
			//Controleer of het speelveld vol is
			boolean fullGrid = true;
			
			for(int i = 0; i < gameGrid[0].length; i++) {
				if(gameGrid[0][i] == 0) fullGrid = false;
			}
		
			if(win) {
				if(mode == 1 && player == 2) System.out.println("Computer heeft gewonnen.");
				System.out.println("Hoera! Speler " + player + " heeft gewonnen!");
				gridOutput = Arrays.deepToString(gameGrid).replace("], ", "]\n");
				
			}
			else if(fullGrid) {
				System.out.println("Gelijk gespeeld.");
				break;
				}			
			else {
					if(player == 1) player = 2;
					else player = 1;
			}
		
				
			
			
			
		} while(!win);
		
		//Laat de winnende zet zien.
		System.out.println(gridOutput.substring(1,gridOutput.length() - 1));
		
		//Speelbord leegmaken voor het volgende spel.
		for(int i = 0; i < gameGrid.length; i++){
			for(int j = 0; j < gameGrid[i].length; j++){
				gameGrid[i][j] = 0;
			}
		}		
	}
}
