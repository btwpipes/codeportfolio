/********************************************************************************************
* Project Name: Final Project CIST2361 - Checkers game
* Description: This program is a checkers game between 2 players.
*              This game doesn't allow for King pieces.
*
* Developer: Andre Paquette
* Last Modified: 04/17/19
*********************************************************************************************/

#include <iostream>
#include <iomanip>
#include <sstream>
#include <fstream>
#include <string>
#include <cstdlib>
#include <cmath>
#include <ctime>
#include <Windows.h>
#include "MMSystem.h"

using namespace std;


// Create class Checkers
class Checkers
{
public:
	// Methods
	void mainline();


private:
	// Fields
	bool isGameOver = false;

	char song1[60],
		 song2[60],
		 gamePieces[8][8],
		 playerPiece[1][1],
		 playerMove[1][1];

	int playerTurn = 1,
		numberOfMoves = 0,
		pieceRow,
		pieceColumn,
		moveRow,
		moveColumn,
		menuSelection,
		inGameMenuSelection;
		
	long clockTick;

	string currentActionTaken;



	// Methods
	void checkForWinner();
	void displayGameBoard();
	void displayGoodbyeMessage();
	void displayHeading();
	void displayInGameMenuOption();
	void displayInstructions();
	void displayMenuOptions();
	void endingGameSound();
	void initialization();
	void initializeGameBoard();
	void playerMoveSelection();
	void playerPieceSelection();
	void playTheGame();
	void saveDataFile();
	bool searchForPiece();
	void selectedInGameOption();
	void selectedMenuOption();
	void startingGameSound();
	void validateInGameSelection();
	void validateMenuSelection();
	void validateMove();
	void validateMoveColumn();
	void validateMoveRow();
	void validatePiece();
	void validatePieceColumn();
	void validatePieceRow();

};


/********************************************************************************************
* MAIN FUNCTION
*********************************************************************************************/
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


/********************************************************************************************
* CONTROLS PROGRAM FLOW
*********************************************************************************************/
void Checkers::mainline()
{
	// initialize of program
	initialization();

	// initialize gameboard
	initializeGameBoard();

	// display main menu
	displayMenuOptions();


	// display gameboard to console window
	displayGameBoard();

	// play the game
	playTheGame();

	// play sound
	endingGameSound();

	// display goodbye
	displayGoodbyeMessage();


}  // end of mainline()


/********************************************************************************************
* PLAY SELECTED SOUND AT THE START OF THE PROGRAM
*********************************************************************************************/
void Checkers::startingGameSound()
{
	strcpy_s(song1, "C:\\MusicBox\\Music\\StartSound_Final.wav");

	PlaySoundA(TEXT(song1), NULL, SND_ASYNC);
}


/********************************************************************************************
* INITIALIZES THE PROGRAM
*********************************************************************************************/
void Checkers::initialization()
{
	// set time to now
	clockTick = time(0);

	// display title
	displayHeading();

	// play sound
	startingGameSound();

}  // end of initialization() 


/********************************************************************************************
* INITIALIZES GAMEBOARD FOR A NEW GAME
*********************************************************************************************/
void Checkers::initializeGameBoard()
{
	// local array to reset game pieces to the start of the game
	char pieces[8][8] = { {' ', 'r', ' ', 'r', ' ', 'r', ' ', 'r'},
						 {'r', ' ', 'r', ' ', 'r', ' ', 'r', ' '},
						 {' ', 'r', ' ', 'r', ' ', 'r', ' ', 'r'},
						 {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
						 {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
						 {'b', ' ', 'b', ' ', 'b', ' ', 'b', ' '},
						 {' ', 'b', ' ', 'b', ' ', 'b', ' ', 'b'},
						 {'b', ' ', 'b', ' ', 'b', ' ', 'b', ' '} };

	// reset object array to start of game
	for (int i = 0; i < 8; i++)
	{
		for (int j = 0; j < 8; j++)
		{
			gamePieces[i][j] = pieces[i][j];
		}
	}

}  // end of initializeGameBoard()


/********************************************************************************************
* DISPLAY MENU OPTIONS TO CONSOLE WINDOW
*********************************************************************************************/
void Checkers::displayMenuOptions()
{
	// display menu selection until user select option 1
	while (menuSelection != 1)
	{
		cout << "\nMAIN PROGRAM MENU OPTIONS" << endl
			<< "***************************" << endl
			<< "1) Start the checkers game" << endl
			<< "2) Show the game instructions" << endl
			<< "3) Show what a checkers board look like" << endl
			<< "4) Quit the program (This will exit the program immediately)" << endl << endl
			<< "Make your selection and press enter : ";

		cin >> menuSelection;

		// call to method
		validateMenuSelection();

		// call to method
		selectedMenuOption();
	}
}


/********************************************************************************************
* VALIDATE THAT THE USER ENTERS A NUMBER BETWEEN 1 AND 4
*********************************************************************************************/
void Checkers::validateMenuSelection()
{
	// validate that user enter a number between 1 and 4
	while (menuSelection < 1 || menuSelection > 4)
	{
		cout << "INVALID ENTRY." << endl
			<< "You must enter a selection between the numbers 1 and 4." << endl
			<< "Please re-enter your selection: ";

		cin >> menuSelection;
	}

}


/********************************************************************************************
* DIRECT PROGRAM WORKFLOW BASED ON USER SELECTION
*********************************************************************************************/
void Checkers::selectedMenuOption()
{
	switch (menuSelection)
	{
	case 1:
	{
		currentActionTaken = "Start the game.";
		saveDataFile();
		break;
	}

	case 2:
	{
		currentActionTaken = "Display the game intructions.";
		saveDataFile();
		displayInstructions();
		break;
	}

	case 3:
	{
		currentActionTaken = "Display the initial gameboard.";
		saveDataFile();
		displayGameBoard();
		break;
	}

	case 4:
	{
		currentActionTaken = "Quit the program. Bypass all methods.";
		saveDataFile();
		endingGameSound();  // won't hear it since the program quits immediately
		exit(0);
		break;
	}
	}

}


/********************************************************************************************
* DISPLAY GAMEBOARD TO CONSOLE WINDOW
*********************************************************************************************/
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


/********************************************************************************************
* PLAY THE GAME UNTIL A PLAYER WINS THE GAME
*********************************************************************************************/
void Checkers::playTheGame()
{
	// play game until winner
	while (!isGameOver)
	{
		// call to method
		playerPieceSelection();

		// call to method
		validatePiece();

		// call to method
		playerMoveSelection();

		// call to method
		validateMove();

		// call to method
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

		// keep track of total of moves
		numberOfMoves++;

		// call to method if game not over
		if (!isGameOver)
		{
			displayInGameMenuOption();
		}

		// display game board if user opt to continue the game
		if (inGameMenuSelection == 1)
		{
			displayGameBoard();
		}
	}

}  // end of playTheGame()


/********************************************************************************************
* PROMPT PLAYER1 TO SELECT A PIECE TO PLAY
*********************************************************************************************/
void Checkers::playerPieceSelection()
{
	// prompt user for a piece to play
	cout << "PLAYER " << playerTurn << endl
		<< "Please select the piece you want to play." << endl
		<< "Enter the row number: ";
	cin >> pieceRow;

	// call to method
	validatePieceRow();

	// substract 1 to match array index
	pieceRow -= 1;

	cout << "Now enter the column number: ";
	cin >> pieceColumn;

	// call to method
	validatePieceColumn();

	// substract 1 to match array index
	pieceColumn -= 1;

	// assign game piece to playerPiece array
	playerPiece[0][0] = gamePieces[pieceRow][pieceColumn];

}  // end of player1Piece()


/********************************************************************************************
* PROMPT PLAYER1 TO SELECT A MOVE
*********************************************************************************************/
void Checkers::playerMoveSelection()
{
	// prompt user for a piece to play
	cout << "\nHere you can enter 99 to change the selected piece," << endl
		<< "enter -99 if you cannot move any piece(s)," << endl
		<< "or select where to move the selected piece." << endl
		<< "Enter the row number or 99 or -99: ";
	cin >> moveRow;

	// call to method
	validateMoveRow();

	// subtract 1 to match array index
	moveRow -= 1;

	cout << "Now enter the column number or 99 or -99: ";
	cin >> moveColumn;

	// call to method
	validateMoveColumn();

	// subtract 1 to match array index
	moveColumn -= 1;

}  // end of player1Move()


/********************************************************************************************
* VALIDATE THE ROW ENTERED BY THE USER
*********************************************************************************************/
void Checkers::validatePieceRow()
{
	// validate that selected row is between 1 and 8
	while (pieceRow < 1 || pieceRow > 8)
	{
		cout << "INVALID ROW." << endl
			<< "The row must be between the number 1 and 8." << endl
			<< "Please re-enter a row: ";
		cin >> pieceRow;
	}

}  // end of validateRow()


/********************************************************************************************
* VALIDATE THE COLUMN ENTERED BY THE USER
*********************************************************************************************/
void Checkers::validatePieceColumn()
{
	// validate that selected column is between 1 and 8
	while (pieceColumn < 1 || pieceColumn > 8)
	{
		cout << "INVALID COLUMN." << endl
			<< "The column must be between the number 1 and 8." << endl
			<< "Please re-enter a column: ";
		cin >> pieceColumn;
	}

}  // end of validateColumn()


/********************************************************************************************
* VALIDATE THE ROW ENTERED BY THE USER
*********************************************************************************************/
void Checkers::validateMoveRow()
{
	// validate that selected row is between 1 and 8 or 99 or -99
	while (moveRow != -99 && moveRow < 1 || moveRow > 8 && moveRow != 99)
	{
		cout << "INVALID ENTRY." << endl
			<< "You entry must be 99, -99 or a row number between 1 and 8." << endl
			<< "Please re-enter a value: ";
		cin >> moveRow;
	}

}  // end of validateRow()


/********************************************************************************************
* VALIDATE THE COLUMN ENTERED BY THE USER
*********************************************************************************************/
void Checkers::validateMoveColumn()
{
	// validate that selected row is between 1 and 8 or 99 or -99
	while (moveColumn != -99 && moveColumn < 1 || moveColumn > 8 && moveColumn != 99)
	{
		cout << "INVALID COLUMN." << endl
			<< "You entry must be 99, -99 or a column number between 1 and 8." << endl
			<< "Please re-enter a value: ";
		cin >> moveColumn;
	}

}  // end of validateColumn()

/********************************************************************************************
* VALIDATE THE PIECE SELECTED BY THE USER
*********************************************************************************************/
void Checkers::validatePiece()
{
	// validate that player selects correct piece
	if (playerTurn == 1)
	{
		while (playerPiece[0][0] == 'r' || playerPiece[0][0] == 'R' || playerPiece[0][0] == ' ')
		{
			cout << "\nINVALID PIECE CHOOSEN." << endl
				<< "Player " << playerTurn << " must pick a piece with the letter b or B." << endl
				<< "Please re-enter a row: ";
			cin >> pieceRow;

			// call to method
			validatePieceRow();

			// substract 1 to match array index
			pieceRow -= 1;

			cout << "Now re-enter a column: ";
			cin >> pieceColumn;

			// call to method
			validatePieceColumn();

			// substract 1 to match array index
			pieceColumn -= 1;

			// re-assign a piece
			playerPiece[0][0] = gamePieces[pieceRow][pieceColumn];
		}
	}
	else if (playerTurn == 2)
	{
		while (playerPiece[0][0] == 'b' || playerPiece[0][0] == 'B' || playerPiece[0][0] == ' ')
		{
			cout << "\nINVALID PIECE CHOOSEN." << endl
				<< "Player " << playerTurn << " must pick a piece with the letter r or R." << endl
				<< "Please re-enter a row: ";
			cin >> pieceRow;

			// call to method
			validatePieceRow();

			// substract 1 to match array index
			pieceRow -= 1;

			cout << "Now re-enter a column: ";
			cin >> pieceColumn;

			// call to method
			validatePieceColumn();

			// substract 1 to match array index
			pieceColumn -= 1;

			// re-assign a piece
			playerPiece[0][0] = gamePieces[pieceRow][pieceColumn];
		}
	}

}  // end of validatePiece()


/********************************************************************************************
* VALIDATE THE MOVE SELECTED BY THE USER
*********************************************************************************************/
void Checkers::validateMove()
{
	// local variables
	char temp;
	bool legalMove = false;

	// player can select a new piece to play
	if (moveRow == 98 || moveColumn == 98)
	{
		playTheGame();
	}
	// if player don't forfeit the game if validates the move
	else if (moveRow != -100 || moveRow != -100)
	{
		// repeat until player selects a legal move
		while (legalMove == false)
		{
			// make sure player don't move piece over another piece
			while (gamePieces[moveRow][moveColumn] == 'r' || gamePieces[moveRow][moveColumn] == 'R' ||
				gamePieces[moveRow][moveColumn] == 'b' || gamePieces[moveRow][moveColumn] == 'B')
			{
				cout << "\nILLEGAL MOVE." << endl
					<< "Player " << playerTurn << ", your piece must land on an empty space." << endl
					<< "Please re-enter a row: ";
				cin >> moveRow;

				// call to method
				validateMoveRow();

				// substract 1 to match array index
				moveRow -= 1;

				cout << "Now re-enter a column: ";
				cin >> moveColumn;

				// call to method
				validateMoveColumn();

				// substract 1 to match array index
				moveColumn -= 1;
			}
			// valid moves for player 1
			if (playerTurn == 1)
			{
				if (moveRow == pieceRow - 1 && moveColumn == pieceColumn + 1)
				{
					// swapping pieces on the board
					temp = gamePieces[pieceRow][pieceColumn];
					gamePieces[pieceRow][pieceColumn] = ' ';
					gamePieces[moveRow][moveColumn] = temp;

					legalMove = true;
				}
				else if (moveRow == pieceRow - 1 && moveColumn == pieceColumn - 1)
				{
					// swapping pieces on the board
					temp = gamePieces[pieceRow][pieceColumn];
					gamePieces[pieceRow][pieceColumn] = ' ';
					gamePieces[moveRow][moveColumn] = temp;

					legalMove = true;
				}
				else if (moveRow == pieceRow - 2 && moveColumn == pieceColumn + 2)
				{
					if (gamePieces[pieceRow - 1][pieceColumn + 1] == 'r')
					{
						// swapping pieces on the board
						temp = gamePieces[pieceRow][pieceColumn];
						gamePieces[pieceRow][pieceColumn] = ' ';
						gamePieces[moveRow][moveColumn] = temp;

						// remove red piece
						gamePieces[pieceRow - 1][pieceColumn + 1] = ' ';

						legalMove = true;
					}
				}
				else if (moveRow == pieceRow - 2 && moveColumn == pieceColumn - 2)
				{
					if (gamePieces[pieceRow - 1][pieceColumn - 1] == 'r')
					{
						// swapping pieces on the board
						temp = gamePieces[pieceRow][pieceColumn];
						gamePieces[pieceRow][pieceColumn] = ' ';
						gamePieces[moveRow][moveColumn] = temp;

						// remove red piece
						gamePieces[pieceRow - 1][pieceColumn - 1] = ' ';

						legalMove = true;
					}
				}
				else
				{
					cout << "\nILLEGAL MOVE." << endl
						<< "Player " << playerTurn << ", you can only move one space diagonally." << endl
						<< "You can move 2 spaces diagonally only if you jump/take an opponent's piece." << endl
						<< "Please re-enter a row: ";
					cin >> moveRow;

					// call to method
					validateMoveRow();

					// substract 1 to match array index
					moveRow -= 1;

					cout << "Now re-enter a column: ";
					cin >> moveColumn;

					// call to method
					validateMoveColumn();

					// subtract 1 to match array index
					moveColumn -= 1;
				}
			}
			// valid moves for player 2
			if (playerTurn == 2)
			{
				if (moveRow == pieceRow + 1 && moveColumn == pieceColumn + 1)
				{
					// swapping pieces on the board
					temp = gamePieces[pieceRow][pieceColumn];
					gamePieces[pieceRow][pieceColumn] = ' ';
					gamePieces[moveRow][moveColumn] = temp;

					legalMove = true;
				}
				else if (moveRow == pieceRow + 1 && moveColumn == pieceColumn - 1)
				{
					// swapping pieces on the board
					temp = gamePieces[pieceRow][pieceColumn];
					gamePieces[pieceRow][pieceColumn] = ' ';
					gamePieces[moveRow][moveColumn] = temp;

					legalMove = true;
				}
				else if (moveRow == pieceRow + 2 && moveColumn == pieceColumn + 2)
				{
					if (gamePieces[pieceRow + 1][pieceColumn + 1] == 'b')
					{
						// swapping pieces on the board
						temp = gamePieces[pieceRow][pieceColumn];
						gamePieces[pieceRow][pieceColumn] = ' ';
						gamePieces[moveRow][moveColumn] = temp;

						// remove black piece
						gamePieces[pieceRow + 1][pieceColumn + 1] = ' ';

						legalMove = true;
					}
				}
				else if (moveRow == pieceRow + 2 && moveColumn == pieceColumn - 2)
				{
					if (gamePieces[pieceRow + 1][pieceColumn - 1] == 'b')
					{
						// swapping pieces on the board
						temp = gamePieces[pieceRow][pieceColumn];
						gamePieces[pieceRow][pieceColumn] = ' ';
						gamePieces[moveRow][moveColumn] = temp;

						// remove black piece
						gamePieces[pieceRow + 1][pieceColumn - 1] = ' ';

						legalMove = true;
					}
				}
				else
				{
					cout << "\nILLEGAL MOVE." << endl
						<< "Player " << playerTurn << ", you can only move one space diagonally." << endl
						<< "You can move 2 spaces diagonally only if you jump/take an opponent's piece." << endl
						<< "Please re-enter a row: ";
					cin >> moveRow;

					// call to method
					validateMoveRow();

					// substract 1 to match array index
					moveRow -= 1;

					cout << "Now re-enter a column: ";
					cin >> moveColumn;

					// call to method
					validateMoveColumn();
					
					// substract 1 to match array index
					moveColumn -= 1;
				}
			}
		}
	}

}  // end of validateMove()


/********************************************************************************************
* CHECK FOR A WINNER
*********************************************************************************************/
void Checkers::checkForWinner()
{
	// if player selects that they cannot make any moves
	if (moveRow == -100 || moveColumn == -100)
	{
		isGameOver = true;

		// display game winner
		if (playerTurn == 1)
		{
			cout << "\n**********    G A M E  O V E R    *********" << endl
				<< "CONGRATULATIONS PLAYER " << playerTurn + 1 << "; YOU WON THE GAME!" << endl;
		}
		else
		{
			cout << "\n**********    G A M E  O V E R    *********" << endl
				<< "CONGRATULATIONS PLAYER " << playerTurn - 1 << "; YOU WON THE GAME!" << endl;
		}

		// call to method
		playTheGame();

	}

	// determine if pieces are left on the board
	if (moveRow != -100)
	{
		// if method return true declares winner
		if (searchForPiece())
		{
			cout << "\n**********    G A M E  O V E R    *********" << endl
				<< "CONGRATULATIONS PLAYER " << playerTurn << "; YOU WON THE GAME!" << endl;
		}
	}

}  // end of checkForWinner()


/********************************************************************************************
* CHECK IF PIECES ARE LEFT
*********************************************************************************************/
bool Checkers::searchForPiece()
{
	// search for red piece on the board
	if (playerTurn == 1)
	{
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				if (gamePieces[i][j] == 'r')
				{
					isGameOver = false;
					break;
				}
				else
				{
					isGameOver = true;
				}
			}

			if (isGameOver == false)
			{
				break;
			}
		}
	}
	// search for black piece on the board
	if (playerTurn == 2)
	{
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				if (gamePieces[i][j] == 'b')
				{
					isGameOver = false;
					break;
				}
				else
				{

					isGameOver = true;
				}
			}

			if (isGameOver == false)
			{
				break;
			}
		}
	}

	return isGameOver;
}


/********************************************************************************************
* DISPLAY THE IN GAME MENU OPTIONS TO THE CONSOLE WINDOW
*********************************************************************************************/
void Checkers::displayInGameMenuOption()
{
	// display in-game menu to the user
	do
	{
		cout << "\n\nIN-GAME MENU OPTIONS" << endl
			<< "*********************" << endl
			<< "1) Continue the game" << endl
			<< "2) Show how many moves have been made so far" << endl
			<< "3) Show the current checkers board" << endl
			<< "4) Forfeit the game" << endl << endl
			<< "Player " << playerTurn << ", make your selection and press enter : ";

		cin >> inGameMenuSelection;

		// call to method
		validateInGameSelection();

		// call to method
		selectedInGameOption();

	} while (inGameMenuSelection != 1 && inGameMenuSelection != 4);

}


/********************************************************************************************
* VALIDATE THAT THE USER ENTERS A NUMBER BETWEEN 1 AND 4
*********************************************************************************************/
void Checkers::validateInGameSelection()
{
	// validate that user select valid option
	while (inGameMenuSelection < 1 || inGameMenuSelection > 4)
	{
		cout << "INVALID ENTRY." << endl
			<< "You must enter a selection between the numbers 1 and 4." << endl
			<< "Please re-enter your selection: ";

		cin >> inGameMenuSelection;
	}
}


/********************************************************************************************
* DIRECT GAME WORKFLOW BASED ON PLAYER SELECTION
*********************************************************************************************/
void Checkers::selectedInGameOption()
{
	switch (inGameMenuSelection)
	{
	case 1:
	{
		currentActionTaken = "Continue the game.";
		saveDataFile();
		break;
	}

	case 2:
	{
		currentActionTaken = "Show the number of moves.";
		saveDataFile();
		cout << "\nThere has been " << numberOfMoves << " moves made so far in the game." << endl;
		break;
	}

	case 3:
	{
		currentActionTaken = "Display the current gameboard.";
		saveDataFile();
		displayGameBoard();
		break;
	}

	case 4:
	{
		isGameOver = true;
		currentActionTaken = "Forfeit the game.";
		saveDataFile();

		if (playerTurn == 1)
		{
			cout << "\n**********    G A M E  O V E R    *********" << endl
				<< "CONGRATULATIONS PLAYER " << playerTurn + 1 << "; YOU WON THE GAME!" << endl;
		}
		else
		{
			cout << "\n**********    G A M E  O V E R    *********" << endl
				<< "CONGRATULATIONS PLAYER " << playerTurn - 1 << "; YOU WON THE GAME!" << endl;
		}
		break;
	}
	}


}


/********************************************************************************************
* SAVE TIME IN SECONDS AND MENU OPTION PICK TO DATA FILE
*********************************************************************************************/
void Checkers::saveDataFile()
{
	ofstream outFile;
	long currentTime;
	string sFileName;

	// assign current time to variable
	currentTime = time(0);

	sFileName = "statFile.txt";
	outFile.open(sFileName, ios::app);

	if (outFile.fail())
		cout << "Sequential file open failed" << endl;

	// write to data file
	outFile << currentTime << "  " << currentActionTaken;
	outFile << endl;

	// close data file
	outFile.close();

}


/********************************************************************************************
* PLAY SELECTED SOUND AT THE END OF THE GAME
*********************************************************************************************/
void Checkers::endingGameSound()
{
	strcpy_s(song2, "C:\\MusicBox\\Music\\EndGame.wav");

	PlaySound(TEXT(song2), NULL, SND_ASYNC);
}


/********************************************************************************************
* DISPLAY PROJECT HEADING TO CONSOLE WINDOW
*********************************************************************************************/
void Checkers::displayHeading()
{
	// display heading to console
	cout << "\n      *****************************************************\n"
		<< "      **          FINAL PROJECT - CHECKERS GAME          **\n"
		<< "      **                    DEVELOPER:                   **\n"
		<< "      **                  Andre Paquette                 **\n"
		<< "      *****************************************************\n" << endl;

}  // end of displayHeading()


/********************************************************************************************
* DISPLAY GAME INSTRUCTIONS TO CONSOLE WINDOW
*********************************************************************************************/
void Checkers::displayInstructions()
{
	// display game instructions
	cout << "\n\nGAME INSTRUCTIONS:" << endl
		<< "This is a 2 players game. The player with the black pieces start first." << endl
		<< "Each player takes turns moving a piece. The piece can only move by" << endl
		<< "one space forward diagonally. You can take an opponent piece by" << endl
		<< "jumping over it. The game ends when one player has lost all his/her" << endl
		<< "pieces or when he/she cannot make a valid move." << endl << endl;

	cout << "PLAYER 1: You have the pieces identified by 'b' or 'B'." << endl
		<< "PLAYER 2: You have the pieces identified by 'r' or 'R'." << endl << endl;

	cout << "GOOD LUCK & LET THE GAME BEGIN!!!" << endl << endl;

}  // end of displayInstructions()


/********************************************************************************************
* DISPLAY GOODBYE MESSAGE TO CONSOLE WINDOW
*********************************************************************************************/
void Checkers::displayGoodbyeMessage()
{
	// display goodbye message
	cout << "\n\n\n****************** THANK YOU FOR PLAYING MY CHECKERS GAME ******************" << endl
		<< "============================================================================" << endl << endl;

}  // end of displayGoodbyeMessage()


