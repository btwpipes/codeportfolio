/**********************************************************
* Project Name: Pro_Lab12 - CH 9 - PC 10 - Reverse Array
* Description: This program asks the user to enter integers
*              into an array. Calls a function to get a pointer
*              which has the array in reverse order.
*
* Author: Andre Paquette
* Last Modified: 04/03/19
***********************************************************/

#include <iostream>
#include <iomanip>

using namespace std;

//prototype
int * reversed_array(int[], int);


// main function
int main()
{
	// variables
	const int SIZE = 10;
	int integers[SIZE];
	int *reversedArray = nullptr;
	int size;

	// prompt to user
	for (int i = 0; i < SIZE; i++)
	{
		cout << "Please enter an integer for number " << i + 1 << ": ";
		cin >> integers[i];
	}

	// line separator
	cout << "---------------------------------------------------" << endl;



	// display the integers array
	cout << "These are the numbers you entered: " << endl;
	for (int i = 0; i < SIZE; i++)
	{
		cout << integers[i] << " ";
	}

	// ad new line
	cout << endl << endl;

	// call function reversed_array
	reversedArray = reversed_array(integers, SIZE);

	// display the reversedArray
	cout << "These are your numbers in reverse order: " << endl;
	for (int i = 0; i < SIZE; i++)
	{
		cout << reversedArray[i] << " ";
	}

	// ad new line
	cout << endl;

	system("pause");

	return 0;
}


// This function copies the elements from integers[] array in reverse order
int * reversed_array(int integersArray[], int arraySize)
{
	// pointer
	int *newArray;

	// variable for newArray subscript
	int j = 0;

	// dynamically allocate a new interger array
	newArray = new int[arraySize];

	// copy integers[] elements in reverse order into newArray[]
	for (int i = arraySize - 1; i >= 0; i--)
	{
		newArray[j] = integersArray[i];
		j++;
	}

	// return pointer
	return newArray;
}