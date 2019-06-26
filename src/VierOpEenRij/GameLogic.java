package VierOpEenRij;
import static VierOpEenRij.Game.gameGrid;

public class GameLogic {
	byte row = 1;
	byte column = 1;
	boolean win = false;
	
	public boolean checkLeftDiagonal(byte originRow, byte originColumn) {
		row = originRow;
		column = originColumn;
		
		if((row - 1 >= 0 & row - 1 < 6) & (column - 1 >= 0 & column - 1 < 7)) {
			if (gameGrid[row - 1][column - 1] == gameGrid[originRow][originColumn]) {	// 2 op een rij
				if((row - 2 >= 0 & row - 2 < 6) & (column - 2 >= 0 & column - 2 < 7)) {	
					if(gameGrid[row - 2][column - 2] == gameGrid[originRow][originColumn]) { // 3 op een rij
						if((row - 3 >= 0 & row - 3 < 6) & (column - 3 >= 0 & column - 3 < 7)) {
							if(gameGrid[row - 3][column - 3] == gameGrid[originRow][originColumn]) { // 4 op een rij
								win = true;
							}
							else {
								//set coords to row -2, column -2 (origincoords -2), go other way
								row -= 2;
								column -= 2;								
							}
						}
						else {
							//set coords to row - 2, column - 2 (origincoords -2),go other way
							row -= 2;
							column -= 2;					
						}
					}
					else {
						// set coords to row -1, column -1 (origincoords -1),go other way
						row -= 1;
						column -= 1;
					}
				}
				else {
					// set coords to row -1, column-1 (origincoords -1),go other way
					row -= 1;
					column -= 1;
				}
			}
		}
			
		//Staat er 4 op een rij schuin naar beneden?
		if((row + 1 >= 0 & row + 1 < 6) & (column + 1 >= 0 & column + 1 < 7)) {
			if (gameGrid[row + 1][column + 1] == gameGrid[originRow][originColumn]) {	// 2 op een rij
				if((row + 2 >= 0 & row + 2 < 6) & (column + 2 >= 0 & column + 2 < 7)) {	
					if(gameGrid[row + 2][column + 2] == gameGrid[originRow][originColumn]) { // 3 op een rij
						if((row + 3 >= 0 & row + 3 < 6) & (column + 3 >= 0 & column + 3 < 7)) {
							if(gameGrid[row + 3][column + 3] == gameGrid[originRow][originColumn]) { // 4 op een rij
								win = true;
							}
						}
					}
				}
			}
		}
		return win;
	}	
	
	
	public boolean checkRightDiagonal(byte originRow, byte originColumn) {
		row = originRow;
		column = originColumn;		
		
		if((row - 1 >= 0 & row - 1 < 6) & (column - 1 >= 0 & column - 1 < 7)) {
			if (gameGrid[row - 1][column - 1] == gameGrid[originRow][originColumn]) {	// 2 op een rij
				if((row - 2 >= 0 & row - 2 < 6) & (column - 2 >= 0 & column - 2 < 7)) {	
					if(gameGrid[row - 2][column - 2] == gameGrid[originRow][originColumn]) { // 3 op een rij
						if((row - 3 >= 0 & row - 3 < 6) & (column - 3 >= 0 & column - 3 < 7)) {
							if(gameGrid[row - 3][column - 3] == gameGrid[originRow][originColumn]) { // 4 op een rij
								win = true;
							}
							else {
								//set coords to row -2, column -2 (origincoords -2), go other way
								row -= 2;
								column -= 2;								
							}
						}
						else {
							//set coords to row - 2, column - 2 (origincoords -2),go other way
							row -= 2;
							column -= 2;					
						}
					}
					else {
						// set coords to row -1, column -1 (origincoords -1),go other way
						row -= 1;
						column -= 1;
					}
				}
				else {
					// set coords to row -1, column-1 (origincoords -1),go other way
					row -= 1;
					column -= 1;
				}
			}
		}
			
		//Staat er 4 op een rij schuin naar beneden?
		if((row + 1 >= 0 & row + 1 < 6) & (column - 1 >= 0 & column - 1 < 7)) {
			if (gameGrid[row + 1][column - 1] == gameGrid[originRow][originColumn]) {	// 2 op een rij
				if((row + 2 >= 0 & row + 2 < 6) & (column - 2 >= 0 & column - 2 < 7)) {	
					if(gameGrid[row + 2][column - 2] == gameGrid[originRow][originColumn]) { // 3 op een rij
						if((row + 3 >= 0 & row + 3 < 6) & (column - 3 >= 0 & column - 3 < 7)) {
							if(gameGrid[row + 3][column - 3] == gameGrid[originRow][originColumn]) { // 4 op een rij
								win = true;
							}
						}
					}
				}
			}
		}
		return win;
	}	
	
	
	public boolean checkVertical(byte originRow, byte originColumn) {
		row = originRow;
		column = originColumn;
		
		//Staat er vier op een rij verticaal naar boven?
		if((row - 1 >= 0 & row - 1 < 6)) {
			if (gameGrid[row - 1][column] == gameGrid[originRow][originColumn]) {	// 2 op een rij
				if((row - 2 >= 0 & row - 2 < 6)) {	
					if(gameGrid[row - 2][column] == gameGrid[originRow][originColumn]) { // 3 op een rij
						if((row - 3 >= 0 & row - 3 < 6)) {
							if(gameGrid[row - 3][column] == gameGrid[originRow][originColumn]) { // 4 op een rij
								win = true;
							}
							else {
								//set coords to row -2 (origincoords -2), go other way
								row -= 2;																
							}
						}
						else {
							//set coords to row - 2 (origincoords -2),go other way
							row -= 2;					
						}
					}
					else {
						// set coords to row -1 (origincoords -1),go other way
						row -= 1;
					}
				}
				else {
					// set coords to row -1 (origincoords -1),go other way
					row -= 1;
				}
			}			
		}
			
		//Staat er 4 op een rij verticaal naar beneden?
		if((row + 1 >= 0 & row + 1 < 6)) {
			if (gameGrid[row + 1][column] == gameGrid[originRow][originColumn]) {	// 2 op een rij
				if((row + 2 >= 0 & row + 2 < 6)) {	
					if(gameGrid[row + 2][column] == gameGrid[originRow][originColumn]) { // 3 op een rij
						if((row + 3 >= 0 & row + 3 < 6)) {
							if(gameGrid[row + 3][column] == gameGrid[originRow][originColumn]) { // 4 op een rij
								win = true;
							}
						}
					}
				}
			}
		}
		return win;
	}	
	
	
	public boolean checkHorizontal(byte originRow, byte originColumn) {
		row = originRow;
		column = originColumn;
		
		//Staat er vier op een rij horizontaal naar links?
		if((column - 1 >= 0 & column - 1 < 7)) {
			if (gameGrid[row][column - 1] == gameGrid[originRow][originColumn]) {	// 2 op een rij
				if((column - 2 >= 0 & column - 2 < 7)) {	
					if(gameGrid[row][column - 2] == gameGrid[originRow][originColumn]) { // 3 op een rij
						if((column - 3 >= 0 & column - 3 < 7)) {
							if(gameGrid[row][column - 3] == gameGrid[originRow][originColumn]) { // 4 op een rij
								win = true;
							}
							else {
								//set coords to column -2 (origincoords -2), go other way
								column -= 2;								
							}
						}
						else {
							//set coords to column - 2 (origincoords -2),go other way
							column -= 2;					
						}
					}
					else {
						// set coords to column -1 (origincoords -1),go other way
						column -= 1;
					}
				}
				else {
					// set coords to column-1 (origincoords -1),go other way
					column -= 1;
				}
			} //the two else statements for the first two if statements have been left out because there are no coords changes
		}
			
		//Staat er 4 op een rij horizontaal naar rechts?
		if((column + 1 >= 0 & column + 1 < 7)) {
			if (gameGrid[row][column + 1] == gameGrid[originRow][originColumn]) {	// 2 op een rij
				if((column + 2 >= 0 & column + 2 < 7)) {	
					if(gameGrid[row][column + 2] == gameGrid[originRow][originColumn]) { // 3 op een rij
						if((column + 3 >= 0 & column + 3 < 7)) {
							if(gameGrid[row][column + 3] == gameGrid[originRow][originColumn]) { // 4 op een rij
								win = true;
							}
						}
					}
				}
			}
		}
		return win;
	}
}

