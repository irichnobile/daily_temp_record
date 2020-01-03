//******************************************************************************
//	DailyTempRecord.java		Author: Ian Nobile
//
//	Client program using the Temperature and Daily_Temperature classes to create 
//	objects for recorded temperatures of a sequence of days read from an input 
//	file, “TempRec.txt”.
//	
//******************************************************************************

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DailyTempRecord //	no explicit connexion to Temperature/Daily_Temps
{
	//--------------------------------------------------------------------------
	//	The main method, demonstrating all methods from Temperature/Daily_Temps
	//	("Throws" necessary to ensure file is present and !null)
	//--------------------------------------------------------------------------
	public static void main (String[] args) throws FileNotFoundException
	{
		float fDegrees = 0.0f;
		char cScale = 'C';
		int iNumDays = 0;
		int i = 0;
		File file = new File("TempRec.dat"); //	.dat file loaded here
		Scanner scan = new Scanner(file);
		Temperature[] aTemp = new Temperature[10]; //	creates Temp. array
		
		while(scan.hasNextLine())
		{
			fDegrees = scan.nextFloat();
			cScale = scan.next().charAt(0);
			Temperature tTemp = new Temperature(fDegrees, cScale);
			aTemp[i]=tTemp;
			iNumDays++;
			i++;
		}
		
		scan.close(); //stops data leakage
		
		//-----------------------------------------------------------------------
		//	Report begins here:
		//-----------------------------------------------------------------------
		Daily_Temperatures record = new Daily_Temperatures(aTemp, iNumDays);
		System.out.println("The Scanner has read the following temperatures:"); 
		record.getTempList();
		System.out.println("\nWithin this list: ");
		System.out.println("the maximum temperature in Celsius is " 
				+ record.MaxTemp('C') + ", ");
		System.out.println("the maximum temperature in Fahrenheit is " 
				+ record.MaxTemp('F') + ", ");
		System.out.println("the minimum temperature in Celsius is " 
				+ record.MinTemp('C') + ", ");
		System.out.println("the minimum temperature in Fahrenheit is " 
				+ record.MinTemp('F') + ", ");
		System.out.println("the average temperature in Celsius is " 
				+ record.AvgTemp('C') + " C, ");
		System.out.println("the average temperature in Fahrenheit is " 
				+ record.AvgTemp('F') + " F ");
		System.out.print("and on " + record.DaysBelowFreezing() 
		+ " days did the temperature dip below the freezing point.");
		
	} //	end main

} //	end class

