/********************************************************************************
* Project Name: Final Project CIST2361 - Checkers game
* Description: This program is a checkers game between 2 players
*
* Author: Andre Paquette
* Last Modified: 04/04/19
********************************************************************************/

#include <iostream>
#include <iomanip>
#include <sstream>
#include <fstream>
#include <string>
#include <cstdlib>
#include <cmath>

using namespace std;


// Create class Checkers
class Checkers
{
public:
	// Methods
	void mainline();


private:
	// Fields
	char gamePieces[8][8];
	bool gameOver = false;
	int playerTurn = 1;
	char playerPiece[1][1];
	char playerMove[1][1];
	int row,
		col,
		r1,
		c1;


	// Methods
	void displayHeading();
	void displayInstructions();
	void initialization();
	void initializeGameBoard();
	void displayGameBoard();
	void playTheGame();
	void playerPieceSelection();
	void playerMoveSelection();
	void validatePieceRow();
	void validatePieceColumn();
	void validateMoveRow();
	void validateMoveColumn();
	void validatePiece();
	void validateMove();
	void checkForWinner();
	bool searchForPiece();
	void displayGoodbyeMessage();

};


/********************************************************************************
* MAIN FUNCTION
********************************************************************************/
int main()
{
	// instantiate class object
	Checkers game1;

	// call to mainline()
	game1.mainline();

	// pause console window
	system("pause");

	return 0;

} // end of main()


/********************************************************************************
* CONTROLS PROGRAM FLOW
********************************************************************************/
void Checkers::mainline()
{
	// initialize of program
	initialization();

	// initialize gameboard
	initializeGameBoard();

	// display gameboard to console window
	displayGameBoard();

	playTheGame();

	displayGoodbyeMessage();

	
}  // end of mainline()


/********************************************************************************
* INITIALIZES THE PROGRAM
********************************************************************************/
void Checkers::initialization()
{
	// display title
	displayHeading();

	// display instructions
	displayInstructions();

}  // end of initialization() 


/********************************************************************************
* INITIALIZES GAMEBOARD FOR A NEW GAME 
********************************************************************************/
void Checkers::initializeGameBoard()
{
	// local array to reset game pieces to the start of the game
	char pieces[8][8] = {{' ', 'r', ' ', 'r', ' ', 'r', ' ', 'r'},
		 				 {'r', ' ', 'r', ' ', 'r', ' ', 'r', ' '},
				   	     {' ', 'r', ' ', 'r', ' ', 'r', ' ', 'r'},
					     {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
					     {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
					     {'b', ' ', 'b', ' ', 'b', ' ', 'b', ' '},
					     {' ', 'b', ' ', 'b', ' ', 'b', ' ', 'b'},
					     {'b', ' ', 'b', ' ', 'b', ' ', 'b', ' '}};

	// reset object array to start of game
	for (int i = 0; i < 8; i++)
	{
		for (int j = 0; j < 8; j++)
		{
			gamePieces[i][j] = pieces[i][j];
		}
	}	

}  // end of initializeGameBoard()


/********************************************************************************
* DISPLAY GAMEBOARD TO CONSOLE WINDOW
********************************************************************************/
void Checkers::displayGameBoard()
{
	// display top of gameboard
	cout << "\n      1     2     3     4     5     6     7     8" << endl
		<< "    _______________________________________________";
	// loop to display array elements with board separation
	for (int row = 0; row < 8; row++)
	{
		cout << "\n   |     |     |     |     |     |     |     |     |" << endl;
		cout << row + 1;
		for (int col = 0; col < 8; col++)
		{
			cout << "  |  " << gamePieces[row][col];
		}
		cout << "  |\n   |_____|_____|_____|_____|_____|_____|_____|_____|";
	}
	// line separator
	cout << endl << endl;

}  // end of displayGameBoard()


/********************************************************************************
* PLAY THE GAME UNTIL A PLAYER WINS THE GAME
********************************************************************************/
void Checkers::playTheGame()
{
	while (!gameOver)
	{
		playerPieceSelection();
	}

}  // end of playTheGame()


/********************************************************************************
* PROMPT PLAYER1 TO SELECT A PIECE TO PLAY
********************************************************************************/
void Checkers::playerPieceSelection()
{
	// prompt user for a piece to play
	cout << "PLAYER " << playerTurn << endl
		 << "Please select the piece you want to play." << endl
		 << "Enter the row number or -99 if you have no piece left: ";
	cin >> row;
	validatePieceRow();
	row -= 1;

	cout << "Now enter the column number or -99 if you have no piece left: ";
	cin >> col;
	validatePieceColumn();
	col -= 1;

	playerPiece[0][0] = gamePieces[row][col];

	// call to function to validate player's piece
	validatePiece();


}  // end of player1Piece()


/********************************************************************************
* PROMPT PLAYER1 TO SELECT A MOVE
********************************************************************************/
void Checkers::playerMoveSelection()
{
	// prompt user for a piece to play
	cout << "\nPlease select where to move the piece." << endl
		 << "Enter the row number or -99 to make a new piece selection: ";
	cin >> r1;
	validateMoveRow();
	r1 -= 1;

	cout << "Now enter the column number or -99 to make a new piece selection: ";
	cin >> c1;
	validateMoveColumn();
	c1 -= 1;

	validateMove();

	/*
	// keep track of player's turn
	if (playerTurn == 1)
	{
		playerTurn++;
	}
	else
	{
		playerTurn--;
	}
	*/
	
}  // end of player1Move()


/********************************************************************************
* VALIDATE THE ROW ENTERED BY THE USER
********************************************************************************/
void Checkers::validatePieceRow()
{
	while (row != -99 && row < 1 || row > 8)
	{
		cout << "INVALID ROW." << endl
			 << "The row must be between the number 1 and 8." << endl
			 << "Please re-enter a row: ";
		cin >> row;
	}

}  // end of validateRow()


/********************************************************************************
* VALIDATE THE COLUMN ENTERED BY THE USER
********************************************************************************/
void Checkers::validatePieceColumn()
{
	while (col != -99 && col < 1 || col > 8)
	{
		cout << "INVALID COLUMN." << endl
			 << "The column must be between the number 1 and 8." << endl
			 << "Please re-enter a column: ";
		cin >> col;
	}

}  // end of validateColumn()


/********************************************************************************
* VALIDATE THE ROW ENTERED BY THE USER
********************************************************************************/
void Checkers::validateMoveRow()
{
	while (r1 != -99 && r1 < 1 || r1 > 8)
	{
		cout << "INVALID ROW." << endl
			<< "The row must be between the number 1 and 8." << endl
			<< "Please re-enter a row: ";
		cin >> r1;
	}

}  // end of validateRow()


/********************************************************************************
* VALIDATE THE COLUMN ENTERED BY THE USER
********************************************************************************/
void Checkers::validateMoveColumn()
{
	while (c1 != -99 && c1 < 1 || c1 > 8)
	{
		cout << "INVALID COLUMN." << endl
			<< "The column must be between the number 1 and 8." << endl
			<< "Please re-enter a column: ";
		cin >> c1;
	}

}  // end of validateColumn()

/********************************************************************************
* VALIDATE THE PIECE SELECTED BY THE USER
********************************************************************************/
void Checkers::validatePiece()
{
	if (playerTurn == 1)
	{
		while (playerPiece[0][0] == 'r' || playerPiece[0][0] == 'R' || playerPiece[0][0] == ' ')
		{
			cout << "\nINVALID PIECE CHOOSEN." << endl
				 << "Player " << playerTurn << " must pick a piece with the letter b or B." << endl
				 << "Please re-enter a row: ";
			cin >> row;
			validatePieceRow();
			row -= 1;

			cout << "Now re-enter a column: ";
			cin >> col;
			validatePieceColumn();
			col -= 1;

			// re-assign a piece
			playerPiece[0][0] = gamePieces[row][col];
		}
	}
	else if (playerTurn == 2)
	{
		while (playerPiece[0][0] == 'b' || playerPiece[0][0] == 'B' || playerPiece[0][0] == ' ')
		{
			cout << "\nINVALID PIECE CHOOSEN." << endl
				 << "Player " << playerTurn << " must pick a piece with the letter r or R." << endl
			 	 << "Please re-enter a row: ";
			cin >> row;
			validatePieceRow();
			row -= 1;

			cout << "Now re-enter a column: ";
			cin >> col;
			validatePieceColumn();
			col -= 1;

			// re-assign a piece
			playerPiece[0][0] = gamePieces[row][col];
		}
	}

	playerMoveSelection();

}  // end of validatePiece()


/********************************************************************************
* VALIDATE THE MOVE SELECTED BY THE USER
********************************************************************************/
void Checkers::validateMove()
{
	char temp;
	bool legalMove = false;

	if (r1 == -100 || c1 == -100)
	{
		playTheGame();
	}

	while (gamePieces[r1][c1] == 'r' || gamePieces[r1][c1] == 'R' ||
		   gamePieces[r1][c1] == 'b' || gamePieces[r1][c1] == 'B')
	{
		cout << "\nILLEGAL MOVE." << endl
			<< "Player " << playerTurn << ", your piece must land on an empty space." << endl
			<< "Please re-enter a row: ";
		cin >> r1;
		validateMoveRow();
		r1 -= 1;
		
		cout << "Now re-enter a column: ";
		cin >> c1;
		validateMoveColumn();
		c1 -= 1;
	}
	

	// swapping pieces on the board
	temp = gamePieces[row][col];
	gamePieces[row][col] = ' ';
	gamePieces[r1][c1] = temp;


	checkForWinner();


	// keep track of player's turn
	if (playerTurn == 1)
	{
		playerTurn++;
	}
	else
	{
		playerTurn--;
	}

	
	displayGameBoard();

}  // end of validateMove()


/********************************************************************************
* CHECK FOR A WINNER
********************************************************************************/
void Checkers::checkForWinner()
{
	if (searchForPiece())
	{

	}
	if (row == -100 || col == -100)
	{
		gameOver = true;

		cout << "\nPLAYER " << playerTurn + 1 << ", YOU WON THE GAME!" << endl;
	}

}  // end of checkForWinner()


bool Checkers::searchForPiece()
{

	return gameOver;
}



/********************************************************************************
* DISPLAY PROJECT HEADING TO CONSOLE WINDOW
********************************************************************************/
void Checkers::displayHeading()
{
	cout << "\n      *****************************************************\n"
		 << "      **          FINAL PROJECT - CHECKERS GAME          **\n"
		 << "      **                    DEVELOPERS:                  **\n"
		 << "      **                  Andre Paquette                 **\n"
		 << "      *****************************************************\n" << endl;
	
}  // end of displayHeading()


/********************************************************************************
* DISPLAY GAME INSTRUCTIONS TO CONSOLE WINDOW
********************************************************************************/
void Checkers::displayInstructions()
{
	cout << "GAME INSTRUCTIONS:" << endl
		 << "This is a 2 players game. The player with the black pieces start first." << endl
		 << "Each player takes turns moving a piece. The piece can only move by" << endl
		 << "one space forward diagonally. You can take an opponent piece by" << endl
		 << "jumping over it. The game ends when one player has lost all his/her" << endl
		 << "pieces or when he/she cannot make a valid move." << endl << endl;

	cout << "PLAYER 1: You have the pieces identified by 'b' or 'B'." << endl
		 << "PLAYER 2: You have the pieces identified by 'r' or 'R'." << endl << endl;

	cout << "GOOD LUCK & LET THE GAME BEGIN!!!" << endl << endl;
		
}  // end of displayInstructions()


void Checkers::displayGoodbyeMessage()
{
	cout << "\n****************** THANK YOU FOR PLAYING MY CHECKERS GAME ******************" << endl
		<< "============================================================================" << endl << endl;

}  // end of displayGoodbyeMessage()