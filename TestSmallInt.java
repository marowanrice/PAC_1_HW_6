// TestSmallInt.java
// Rowan Rice
// October 18, 2019

import java.util.Scanner;

public class TestSmallInt
{
	public static void main (String [] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.print("Give me an integer between " + 
			SmallInt.MINVALUE + " and " + SmallInt.MAXVALUE + ": ");

		int integer = input.nextInt();

		SmallInt enteredInt = new SmallInt(integer);

		System.out.println("Decimal representation: " + enteredInt.getDec());

		System.out.println("Binary representation: " + enteredInt.getBin());

		System.out.println("Hexadecimal representation: " + enteredInt.getHex());

	}
}