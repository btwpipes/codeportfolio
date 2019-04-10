/*********************************************************************************
* Project Name: Lab 10 - Chapter 8 - PC 1 - Charge Account Validation
* Description: This program asks the user for an account and validates it
*              against a valid account key array. (array search program)
*
* Developer: Andre Paquette
* Last Modified: 03/20/19
**********************************************************************************/

#include <iostream>
#include <sstream>
#include <string>
#include <cstdlib>
#include <cmath>

using namespace std;

// Prototypes
void displaySearchResult(bool);
int setChargeAccount();
void validateChargeAccount(int, const int[], int);


/*********************************************************************************
* MAIN FUNCTION
*********************************************************************************/
int main()
{
	// variables
	int iChargeAccount;
	const int SIZE = 18;
	int iValidAccount[] = { 5658845, 4520125, 7895122, 8777541, 8451277, 1302850,
					        8080152, 4562555, 5552012, 5050552, 7825877, 1250255,
					        1005231, 6545231, 3852085, 7576651, 7881200, 4581002 };

	// variable assignment with call to function
	iChargeAccount = setChargeAccount();

	// line separator
	cout << "---------------------------------------------------------------" << endl;

	// call to function
	validateChargeAccount(iChargeAccount, iValidAccount, SIZE);

	// pausing console window
	system("pause");

	return 0;
}

/*********************************************************************************
* Function to set the charge account to validate
*********************************************************************************/
int setChargeAccount()
{
	// variable
	int iAccount;

	// prompt user for entry
	cout << "Please enter the charge account to validate: ";
	cin >> iAccount;

	return iAccount;
}


/*********************************************************************************
* Function searching to match account entered to valid account key array
*********************************************************************************/
void validateChargeAccount(int iChargeAccount, const int iValidAccount[], int size)
{
	// variables
	bool bValidAccount = false;
	int count = 0;

	// search routine to find value
	while (!bValidAccount && count < size)
	{
		if (iChargeAccount == iValidAccount[count])
		{
			// if account entered is found set boolean to true
			bValidAccount = true;
		}

		count++;
	}

	// call to function
	displaySearchResult(bValidAccount);
}


/*********************************************************************************
 * Function to display result to user
*********************************************************************************/
void displaySearchResult(bool bValidAccount)
{
	if (bValidAccount)  // if true account is valid
	{
		cout << "The account you entered is valid." << endl;
	}
	else               // else account is invalid
	{
		cout << "The account you entered is invalid." << endl;
	}
}


// END OF PROGRAM