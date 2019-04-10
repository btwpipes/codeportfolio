/**********************************************************************************
* Project Name: Collopy Text - Chapter 8 - Reports - Part2
* Description: Read data file, calculate gross pay, insurance cost
*              income tax, and net pay. Display the report.
*
* Developer: Andre Paquette
* Last Modified: 04/05/19
**********************************************************************************/

#include <iostream>
#include <sstream>
#include <string>
#include <cstdlib>
#include <cmath>
#include <fstream>
#include <iomanip>

using namespace std;


// CLASS
class Report
{
public:
	// METHODS
	void mainLine(void);


private:
	// VARIABLES
	bool bEndFlag;

	ifstream reportFile;

	int branchNumber,
		divisionNumber,
		departmentNumber,
		hoursWorked;

	double	hourlyPayRate;
	const double TAX_RATE = 0.19;

	string firstName,
		   lastName;

	string heading = "\n                           **********************************\n"
				 "                           **        PAYROLL REPORT        **\n"
				 "                           **                              **\n"
				 "                           **   Developer: Andre Paquette  **\n"
				 "                           **********************************\n";
	string categories = "Br#   Div#   Dept#  EmpName              Gross     Insurance         Tax         Net";
	string dashline = "--------------------------------------------------------------------------------------";


	// METHODS
	void initialization();
	void openFile(void);
	void prnHeadings(void);
	void process();
	void readIt();
	double calculateGrossPay();
	double calculateInsuranceCost();
	double calculateIncomeTax();
	double calculateNetPay();
	void accumulate();
	void writeIt();
	void eoj();

}; // end of class


/**********************************************************************************
* PROGRAM MAIN
***********************************************************************************/
void main(void)
{
	// create an instance of Report class
	Report payroll;

	// call to r1 method
	payroll.mainLine();

	// pause console window
	system("pause");

}  // end of MAIN


/**********************************************************************************
* MAINLINE CONTROL WORKFLOW
**********************************************************************************/
void Report::mainLine()
{
	initialization();

	while (!reportFile.eof())
	{
		process();
	}

	eoj();

}  // end of mainline()


/**********************************************************************************
* INITIALIZATION
**********************************************************************************/
void Report::initialization()
{
	openFile();
	if (!reportFile.fail())
	{
		prnHeadings();
	}

}  // end of initialization()


/**********************************************************************************
* OPEN REPORT FILE
**********************************************************************************/
void Report::openFile(void)
{
	reportFile.open("reports.dat");

	if (reportFile.fail())
		cout << "Report file open failed" << endl;

}  // end of OpenFile()


/**********************************************************************************
* PRINT HEADINGS
**********************************************************************************/
void Report::prnHeadings(void)
{
	cout << heading << endl;
	cout << endl << endl;
	cout << categories << endl;
	cout << dashline << endl;

}  // end of prnHeadings()


/**********************************************************************************
* WORKFLOW PROCESS
**********************************************************************************/
void Report::process()
{
	readIt();
	writeIt();

}  // end of process()


/**********************************************************************************
* READ FILE DATA
**********************************************************************************/
void Report::readIt()
{
	reportFile >> branchNumber >> divisionNumber >> departmentNumber
		>> firstName >> lastName >> hoursWorked >> hourlyPayRate;

}  // end of readIt()


/**********************************************************************************
* DISPLAY REPORT TO THE USER
**********************************************************************************/
void Report::writeIt()
{
	cout << left << setw(6) << branchNumber << setw(7) << divisionNumber
		<< setw(7) << departmentNumber << setw(19) << firstName + " " + lastName
		<< fixed << setprecision(2) << setw(7) << right << calculateGrossPay() << setw(14)
		<< fixed << setprecision(2) << calculateInsuranceCost() << setw(12) << calculateIncomeTax()
		<< setw(12) << calculateNetPay() << endl;

}  // end of writeIt()


/**********************************************************************************
* CALCULATE GROSS PAY METHOD
**********************************************************************************/
double Report::calculateGrossPay()
{
	if (hoursWorked <= 40)
	{
		return hoursWorked * hourlyPayRate;
	}
	else
	{
		return (40 * hourlyPayRate) + ((hourlyPayRate * 2) * (hoursWorked - 40));
	}

}  // end calculateGrossPay()


/**********************************************************************************
* CALCULATE INSURANCE COST METHOD
**********************************************************************************/
double Report::calculateInsuranceCost()
{
	if (calculateGrossPay() < 325.00)
	{
		return 40.00;
	}
	if (calculateGrossPay() >= 325.00 && calculateGrossPay() <= 550.00)
	{
		return 55.00;
	}
	else
	{
		return 80.00;
	}

}  // end calculateInsuranceCost()


/**********************************************************************************
* CALCULATE INCOME TAX METHOD
**********************************************************************************/
double Report::calculateIncomeTax()
{
	return calculateGrossPay() * TAX_RATE;

}  // end of calculateIncomeTax()


/**********************************************************************************
* CALCULATE NET PAY METHOD
**********************************************************************************/
double Report::calculateNetPay()
{
	return calculateGrossPay() - calculateInsuranceCost() - calculateIncomeTax();

}  // end of calculateNetPay()


/**********************************************************************************
* ACCCUMULATE TOTALS FOR 
**********************************************************************************/
void Report::accumulate()
{

}  // end of accumulate()


/**********************************************************************************
* END OF JOB
**********************************************************************************/
void Report::eoj()
{
	reportFile.close();
	cout << "\n------<E N D  O F  P R O G R A M>-------\n";

}  // end of eoj()



