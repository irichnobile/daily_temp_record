//******************************************************************************
//	Temperature.java		Author: Ian Nobile
//
//	Encapsulates the concept of temperature in degrees in both Celsius and 
//	Fahrenheit. 
//	
//******************************************************************************

import java.text.DecimalFormat;

public class Temperature implements Comparable<Temperature>
{
	private float fDegrees = 0.0f;
	private char cScale = 'C';
	private DecimalFormat fmt = new DecimalFormat("#.0");
	
	
	//--------------------------------------------------------------------------
	//	The first constructor; accepts two parametres
	//--------------------------------------------------------------------------
	public Temperature(float degrees, char scale)
	{
		fDegrees = degrees;
		cScale = scale;
	}
	
	//--------------------------------------------------------------------------
	//	The second constructor, sans parametres
	//--------------------------------------------------------------------------
	public Temperature()
	{
		fDegrees = 0.0f;
		cScale = 'C';
	}
	
	
	//--------------------------------------------------------------------------
	//	Setter for temperature degrees and scale
	//--------------------------------------------------------------------------
	public void setTemperature(float degrees, char scale)	
	{
		fDegrees = degrees;
		cScale = scale;
	}
	
	//--------------------------------------------------------------------------
	//	Getter for temperature degrees
	//--------------------------------------------------------------------------
	public float getTemp()
	{
		return fDegrees;
	}
	
	//--------------------------------------------------------------------------
	//	Getter for temperature scale
	//--------------------------------------------------------------------------
	public char getTscale()
	{
		return cScale;
	}
	
	//--------------------------------------------------------------------------
	//	Displays temperature degrees and scale separated by a space
	//--------------------------------------------------------------------------
	public String toString()
	{
		return fmt.format(fDegrees) + " " + cScale; //	to one decimal place
	}
	
	//--------------------------------------------------------------------------
	//	Displays temperature in Celsius
	//--------------------------------------------------------------------------
	public String getCelsiusTemp()
	{
		String sCelsiusTemp = "";
		
		if(getTscale() == 'C')
		{
			sCelsiusTemp = fDegrees + " " + cScale;
		} //	end if
		else if(getTscale() == 'F')
		{
			sCelsiusTemp = (5.0 * (fDegrees - 32.0) / 9.0) + " C";
		} //	end elseif
		
		return sCelsiusTemp;
	}
	
	//--------------------------------------------------------------------------
	//	Displays temperature in Fahrenheit
	//--------------------------------------------------------------------------
	public String getFahrenheitTemp()
	{
		String sFahrenheitTemp = "";
		
		if(getTscale() == 'C')
		{
			sFahrenheitTemp = ((9.0 * fDegrees / 5.0) + 32.0) + " F";
		}
		else if(getTscale() == 'F')
		{
			sFahrenheitTemp = fDegrees + " " + cScale;
		}
		
		return sFahrenheitTemp;
	}
	
	//--------------------------------------------------------------------------
	//	Converts both temperatures to degrees Kelvin and returns the comparison
	//--------------------------------------------------------------------------
	@Override //	required
    public int compareTo(Temperature tOther)
	{	
		float fThisK = 0.0f;
		float fOtherK = 0.0f;
		int iCompVal = 2;
		
		//----------------------------------------------------------------------
		//	Converts to degrees Kelvin and sets comparison variables
		//----------------------------------------------------------------------
		if(cScale == 'C')
		{
			fThisK = (float) (getTemp() + 273.15);
		}
		else if(cScale == 'F')
		{
			fThisK = (float) ((5.0 * (getTemp() - 32.0) / 9.0) + 273.15);
		}
		
		if(tOther.getTscale() == 'C')
		{
			fOtherK = (float) (tOther.getTemp() + 273.15);
		}
		else if(tOther.getTscale() == 'F')
		{
			fOtherK = (float) ((5.0 * (tOther.getTemp() - 32.0) / 9.0) + 273.15);
		}
		
		//----------------------------------------------------------------------
		//	Compares the variables and returns the standard 0, 1, -1 results
		//----------------------------------------------------------------------
		if(fThisK > fOtherK)
		{
			iCompVal = 1;
		}
		else if(fThisK < fOtherK)
		{
			iCompVal = -1;
		}
		else if(fThisK == fOtherK)
		{
			iCompVal = 0;
		}
		
		return iCompVal;
    } //	end compareTo
	
} //	end class

