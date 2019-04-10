/***************************************************************************************
* Project Name: Midterm Project - Project 3B - Loan Calculation
* Description: This program asks the user for a loan amount and interest rate; it 
*              then calculates and display the minimum monthly payment, and asks
*              the user to enter a monthly payment amount. It calculates and 
*              display the total of interest paid. 
*
* Developers: Juan Coreas, Andre Paquette
* Last Modified: 02/22/19
***************************************************************************************/

#include <iostream>
#include <sstream>
#include <string>
#include <cstdlib>
#include <cmath>
#include <iomanip>

using namespace std;


class LoanCalculator
{
public:
	// public method
	void mainLine();

private:
	// private fields
	double interestRate,
		loanAmount,
		monthlyPayment,
		interestAmount,
		minimumPayment,
		totalInterest = 0;

	int numberOfMonths = 1;



	// private methods
	void displayHeading();
	void displayGreetings();
	void setLoanAmount();
	void setInterestRate();
	void calculateMinimumPayment();
	void setMonthlyPayment();
	void validateMonthlyPayment();
	void loanCalculation();
	void displayLastPayment();
	void displayResult();

};

int main()
{
	LoanCalculator loanReport2;

	loanReport2.mainLine();
	
	system("pause");

	return 0;
}



/***************************************************************************************
* public method to control program flow
***************************************************************************************/
void LoanCalculator::mainLine()
{
	displayHeading();
	displayGreetings();
	setLoanAmount();
	setInterestRate();
	calculateMinimumPayment();
	setMonthlyPayment();
	loanCalculation();
	displayResult();

	return;
}


/***************************************************************************************
* display the program heading
***************************************************************************************/
void LoanCalculator::displayHeading()
{
	cout << "***************************************************\n"
		 << "**         MIDTERM PROJECT - PROJECT 3B          **\n"
		 << "**                 DEVELOPERS:                   **\n"
		 << "**               Andre Paquette                  **\n"
		 << "***************************************************\n" << endl;

	return;
}


/***************************************************************************************
* Display greetings to the user
***************************************************************************************/
void LoanCalculator::displayGreetings()
{
	cout << "If you enter the loan amount and interest rate;\n"
		<< "I will display the minimum payment. After entering\n"
		<< "your monthly payment, I will calculate and display\n"
		<< "the total interest paid and the number of months\n"
		<< "it will take to repay the loan.\n" << endl;

	return;
}


/***************************************************************************************
* Prompt user to input loan amount
***************************************************************************************/
void LoanCalculator::setLoanAmount()
{
	cout << "Please enter the loan amount: ";
	cin >> loanAmount;

	return;
}


/***************************************************************************************
* Prompt user to input interest rate
***************************************************************************************/
void LoanCalculator::setInterestRate()
{
	cout << "Please enter the interest rate: ";
	cin >> interestRate;

	return;
}


/***************************************************************************************
* Calculate the minimum monthly payment
***************************************************************************************/
void LoanCalculator::calculateMinimumPayment()
{
	minimumPayment = loanAmount * (interestRate / 100 / 12);
	cout << showpoint << fixed << setprecision(2)
		 << "\nThe minimum monthly payment is: $" << minimumPayment << endl;

	return;
}


/***************************************************************************************
* Prompt user to input monthly payment
***************************************************************************************/
void LoanCalculator::setMonthlyPayment()
{
	cout << "Please enter your monthly payment: ";
	cin >> monthlyPayment;

	validateMonthlyPayment();

	return;
}


/***************************************************************************************
* Validate monthly payment
***************************************************************************************/
void LoanCalculator::validateMonthlyPayment()
{
	while (monthlyPayment < minimumPayment)
	{
		cout << "The monthly payment amount is too low.\n"
			 << "Please re-enter a bigger amount: ";
		cin >> monthlyPayment;
	}

	return;
}


/***************************************************************************************
* Calculate number of months to repay loan
***************************************************************************************/
void LoanCalculator::loanCalculation()
{
	while (loanAmount > monthlyPayment)
	{
		interestAmount = loanAmount * (interestRate / 100 / 12);

		loanAmount += interestAmount - monthlyPayment;

		if (loanAmount < monthlyPayment)
		{
			displayLastPayment();
		}

		totalInterest += interestAmount;
		numberOfMonths++;
	}

	return;
}


/***************************************************************************************
* Display last payment if less than monthly payment
***************************************************************************************/
void LoanCalculator::displayLastPayment()
{
	cout << showpoint << fixed << setprecision(2)
		<< "\nYour last payment is: $" << loanAmount << endl;

	return;
}


/***************************************************************************************
* Display result to the user
***************************************************************************************/
void LoanCalculator::displayResult()
{
	cout << showpoint << fixed << setprecision(2)
		 << "\nThe total interest paid is: $" << totalInterest << endl
		 << "You paid back your loan in " << numberOfMonths << " months.\n" << endl;

	return;
}

// END OF PROGRAM

