/********************************************************************
* Project Name: Pro_Lab12 - CH 9 - PC 12 - Element Shifter
* Description: Write a function that accepts an int array and size
*              as arguments. The function should return a pointer.
*
* Author: Andre Paquette
* Last Modified: 04/03/19
********************************************************************/

#include <iostream>
#include <iomanip>

using namespace std;

// Prototype
int * shifted_array(const int *, int);

int main()
{
	// variables
	int array[20];
	int *shifted;
	int size;

	// prompt user for array size
	cout << "Please enter the size fo the array: ";
	cin >> size;

	// prompt user to enter integer values for the array
	cout << "Please enter integers to store into the array" << endl;
	for (int i = 0; i < size; i++)
	{
		cout << "Please enter an integer for element " << i + 1 << ": ";
		cin >> array[i];
	}

	// line separator
	cout << endl;

	// call to function
	shifted = shifted_array(array, size);

	// display to element of shifted array
	cout << "The elements after shifting the array are: " << endl;
	for (int i = 0; i < size + 1; i++)
	{
		cout << *(shifted + i) << " ";
	}

	// line separator
	cout << endl;

	system("pause");

	return 0;
}


// function that returns a pointer
int * shifted_array(const int *arr, int size)
{
	// dynamically allocate new int array
	int *newArray = new int[size + 1];

	// assign 0 to 1st element
	newArray[0] = 0;

	// variable for newArray subscript
	int j = 1;

	for (int i = 0; i < size; i++)
	{
		// copy array[] elements into newArray[]
		newArray[j] = arr[i];
		j++;
	}

	return newArray;
}