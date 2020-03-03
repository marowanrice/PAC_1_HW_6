// SmallInt.java
// Rowan Rice
// October 18, 2019

/* 
This class can convert an integer to its binary representation
and its hexadecimal representation.
*/

public class SmallInt
{

	private int value;

	// constants
	public static final int MAXVALUE = 1000;
	public static final int MINVALUE = 0;
	public static final int ZERO = 0;
	public static final int BINPOWER = 2;
	public static final int HEXPOWER = 16;
	public static final int HEXREMAINDER = 10;


	// constructor using an entered integer sets value
	public SmallInt(int userInt)
	{
		value = checkInt(userInt);
	}

	// method that checks whether the user entered a valid integer
	// if valid, returns the integer
	// if invalid, returns 0
	private int checkInt(int intToCheck)
	{
		if ((intToCheck > MAXVALUE) || (intToCheck < MINVALUE))
		{
			System.out.println("Error: integer must be between "
				+ MINVALUE + " and " + MAXVALUE);
			return ZERO;
		}

		return intToCheck;
	}

	// getter method for value
	public String getDec()
	{
		return ("" + value);
	}

	// setter method for value
	// calls the check method to make sure it's a valid entry
	public void setDec(int setInt)
	{
		value = checkInt(setInt);
	}

	/*
	This instance method getBin converts the integer stored in the 
	variable value into its binary representation. 

	The algorithm is:
		0. store the value of "value" variable in new integer variable ("intToBin")
		1. divide "intToBin" by 2 and store the quotient in "quotient" variable (/)
		2. store the remainder of that expression in "remainder" variable (%)
		3. insert "remainder" at the beginning of the string ("binStg")
		4. continue this loop until "quotient" is 0

	Everytime the integer is divided by 2, the remainder becomes part of the 
	binary representation. 

	For example, 
		40 / 2 = 20
		40 % 2 = 0
			--> Store 0 at the beginning of the string
			String: 0
			Quotient: 20 (therefore, continue since not 0)

		20 / 2 = 10
		20 % 2 = 0
			--> Store 0 in the first index of the string (before all other elements)
			String: 00
			Quotient: 10 (therefore, continue since not 0)
			

		10 / 2 = 5
		10 % 2 = 0
			--> Store 0 in the first index of the string (before all other elements)
			String: 000
			Quotient: 5 (therefore, continue since not 0)
			

		5 / 2 = 2
		5 % 2 = 1
			--> Store 1 in the first index of the string (before all other elements)
			String: 1000
			Quotient: 2 (therefore, continue since not 0)
			

		2 / 2 = 1
		2 % 2 = 0
			--> Store 0 in the first index of the string (before all other elements)
			String: 01000
			Quotient: 1 (therefore, continue since not 0)
			

		1 / 2 = 0
		1 % 2 = 1
			--> Store 1 in the first index of the string (before all other elements)
			String: 101000
			Quotient: 0 (therefore, end loop)
			

		The quotient of that final expression is 0, so the binary representation
		string is complete and can be returned.
	*/

	public String getBin()
	{
		// make an empty StringBuilder
		StringBuilder binStg = new StringBuilder();

		int quotient = ZERO;
		int remainder = ZERO;
		int intToBin = value;

		do 
		{
			quotient = intToBin / BINPOWER;
			remainder = intToBin % BINPOWER;
			binStg = binStg.insert(0, remainder);
			intToBin = quotient;
		}	
		while (quotient != ZERO);


		String s = binStg.toString();
		return s;
	}


/*
	This instance method getHex converts the integer stored in the 
	variable value into its hexadecimal representation. 

	The algorithm is:
		0. store the value of "value" variable in new integer variable ("intToHex")
		1. divide "intToHex" by 16 and store the quotient in "quotient" variable (/)
		2. store the remainder of that expression in "remainder" variable (%)
		3. if "remainder" is less than 10, insert "remainder" at the beginning 
				of the string ("hexStg")
		4. if "remainder" is 10 or greater, convert it to the corresponding
				hexadecimal symbol (A-F); then insert that symbol at the
				beginning of the string ("hexStg")
		5. continue this loop until "quotient" is 0

	Everytime the integer is divided by 16, the remainder becomes part of the 
	hexadecimal representation. 

	For example, 
		999 / 16 = 62
		999 % 16 = 7
			--> 7 is less than 10, so store 7 at the beginning of the string
			String: 7
			Quotient: 62 (therefore, continue since not 0)

		62 / 16 = 3
		62 % 16 = 14
			--> 14 is greater than 10, so convert to hexadecimal symbol (E)
				and store E in the first index of the string 
				(before all other elements)
			String: E7
			Quotient: 3 (therefore, continue since not 0)
			

		3 / 16 = 0
		3 % 16 = 3
			--> 3 is less than 10, so store 3 in the first index of the string 
				(before all other elements)
			String: 3E7
			Quotient: 0 (therefore, end loop)
			

		The quotient of that final expression is 0, so the hexadecimal 
		representation string is complete and can be returned.		
	*/

	public String getHex()
	{
		// make an empty StringBuilder
		StringBuilder hexStg = new StringBuilder();

		int quotient = ZERO;
		int remainder = ZERO;
		int intToHex = value;

		do 
		{
			quotient = intToHex / HEXPOWER;
			remainder = intToHex % HEXPOWER;
			
			if (remainder < HEXREMAINDER)
			{
				hexStg = hexStg.insert(0, remainder);
			}

			else
			{
				hexStg = hexStg.insert(0, (char)('A' + (remainder - HEXREMAINDER)));
			}

			intToHex = quotient;
		}	
		while (quotient != ZERO);


		String s = hexStg.toString();
		return s;

	}

}