/*****************************************************************************************
* Project Name: Lab_Pro 9 - Chapter 7 - Programming Challenge 10 - Driver's License Exam
* Description: This program asks the user to enter 20 answers and compares them 
*              to an answer key. Then it displays if the student passed or failed,
*              the number of correct answers and incorrect answers and the question
*              answered incorrectly.
*
* Developer: Andre Paquette
* Last Modified: 03/17/19
******************************************************************************************/

#include <iostream>
#include <sstream>
#include <string>
#include <cstdlib>
#include <cmath>

using namespace std;

// Prototypes
void displayResults(int, int, int[20]);
void setStudentAnswers(char[20]);
void testEvaluation(char[20], char[20]);


int main()
{
	char cStudentAnswers[20];
	char cAnswerKey[] = {'A', 'D', 'B', 'B', 'C',
					     'B', 'A', 'B', 'C', 'D',
					     'A', 'C', 'D', 'B', 'D',
					     'C', 'C', 'A', 'D', 'B'};

	// call the functions
	setStudentAnswers(cStudentAnswers);
	testEvaluation(cAnswerKey, cStudentAnswers);

	// pausing for console to stay visible
	system("pause");

	return 0;
}


// function that displays the exam results
void displayResults(int iCorrectAnswers, int iIncorrectAnswers, int iIncorrectQuestionNumbers[20])
{
	cout << "-------------------------------------------------------" << endl;

	// display pass or fail message
	if (iCorrectAnswers >= 15)
	{
		// pass
		cout << "Congratulations! You passed the exam.\n" << endl;
	}
	else
	{
		// fail
		cout << "Sorry! You failed the exam.\n" << endl;
	}

	// display number of correct answers
	cout << "You answered " << iCorrectAnswers << " questions correctly." << endl;

	// display number of incorrect answers
	cout << "You answered " << iIncorrectAnswers << " questions incorrectly.\n" << endl;

	// display the questions answered incorrectly
	cout << "The question(s) you answered incorrectly are: " << endl;
	for (int i = 0; i <= iIncorrectAnswers - 1; i++)
	{
		cout << "Question " << iIncorrectQuestionNumbers[i] << endl;
	}
}


// function to set the cStudentAnswers array
void setStudentAnswers(char cStudentAnswers[20])
{
	// loop 20 times for 20 answers
	for (int count = 0; count <= 19; count++)
	{
		cout << "Please enter the answer for question " << count + 1 << ": ";
		cin >> cStudentAnswers[count];
		
		// convert lower case to upper case
		cStudentAnswers[count] = toupper(cStudentAnswers[count]);


		// answer validation answer must be A, B, C or D
		while (cStudentAnswers[count] < 'A' || cStudentAnswers[count] > 'D')
		{
			cout << "INVALID ENTRY\n"
				 << "The answers can only be A, B, C or D (must be uppercase)\n"
			 	 << "Please re-enter the answer: ";
			cin >> cStudentAnswers[count];
			cStudentAnswers[count] = toupper(cStudentAnswers[count]);
		}
	}
}

void testEvaluation(char cAnswerKey[20], char cStudentAnswers[20])
{
	int iCorrectAnswers = 0,
		iIncorrectAnswers = 0,
		i = 0;
	int iIncorrectQuestionNumbers[20];

	// arrays comparison to set correct and incorrect answers
	for (int count = 0; count <= 19; count++)
	{
		if (cAnswerKey[count] == cStudentAnswers[count])
		{
			// increment correct answers
			iCorrectAnswers = iCorrectAnswers + 1;
		}
		else
		{
			// increment incorrect answers
			iIncorrectAnswers = iIncorrectAnswers + 1;

			// assign incorrect question number to array
			iIncorrectQuestionNumbers[i] = count + 1;
			i = i + 1;
		}
	}

	// call to function
	displayResults(iCorrectAnswers, iIncorrectAnswers, iIncorrectQuestionNumbers);
}
