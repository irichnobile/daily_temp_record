//******************************************************************************
//	Daily_Temperatures.java		Author: Ian Nobile
//
//	Encapsulates the concept of daily temperatures for a sequence of days (e.g., 
//	a week, 10 days, or one month).
//	
//******************************************************************************

//	import ...

public class Daily_Temperatures
{
	private Temperature[] aDailyTemps;
	private int iNumDays = 0;
	
	//--------------------------------------------------------------------------
	//	Constructor for arrays of Temperature objects, accepts two parametres
	//--------------------------------------------------------------------------
	public Daily_Temperatures(Temperature[] temperatures, int days)
	{
		aDailyTemps = temperatures;
		iNumDays = days;
	}
	
	//--------------------------------------------------------------------------
	//	Compares each temperature to the freezing point and logs the total
	//--------------------------------------------------------------------------
	public int DaysBelowFreezing() 
	{
		int DaysBelowFreezing = 0;
		Temperature tFreezingC = new Temperature(0, 'C');
		Temperature tFreezingF = new Temperature(32, 'F');
		
		for(int i = 0; i < iNumDays; i++)
		{
			if(aDailyTemps[i].getTscale() == 'C')
			{
				if(aDailyTemps[i].compareTo(tFreezingC) < 0)
				{
					DaysBelowFreezing++;
				}
			}
			else if(aDailyTemps[i].getTscale() == 'F')
			{
				if(aDailyTemps[i].compareTo(tFreezingF) < 0)
				{
					DaysBelowFreezing++;
				} // end if
			} //	end else if
		} //	end for
		return DaysBelowFreezing;
	}
	
	//--------------------------------------------------------------------------
	//	Returns highest temperature in desired scale (according to parametre)
	//--------------------------------------------------------------------------
	public Temperature MaxTemp(char scale)
	{
		Temperature MaxTemp = aDailyTemps[0];
		
		for(int i = 0; i < iNumDays; i++)
		{
			if(aDailyTemps[i].compareTo(MaxTemp)>0)
				MaxTemp = aDailyTemps[i];
		}
		
		//----------------------------------------------------------------------
		//	Sets new temperature scale and degrees if different to parametre
		//----------------------------------------------------------------------
		if(scale == 'C'&&MaxTemp.getTscale()=='F')
		{
			MaxTemp.setTemperature((float) 
					(5.0 * (MaxTemp.getTemp() - 32.0) / 9.0), 'C');
		}
		if(scale == 'F'&&MaxTemp.getTscale()=='C')
		{
			MaxTemp.setTemperature((float) 
					((9.0 * MaxTemp.getTemp() / 5.0) + 32.0), 'F');
		}
		
		return MaxTemp;
	}
	
	//--------------------------------------------------------------------------
	//	Returns lowest temperature in desired scale (according to parametre)
	//--------------------------------------------------------------------------
	public Temperature MinTemp(char scale)
	{
		Temperature MinTemp = aDailyTemps[0];
		
		for(int i = 0; i < iNumDays; i++)
		{
			if(aDailyTemps[i].compareTo(MinTemp)<0)
				MinTemp = aDailyTemps[i];
		}
		
		//----------------------------------------------------------------------
		//	Sets new temperature scale and degrees if different to parametre
		//----------------------------------------------------------------------
		if(scale == 'C'&&MinTemp.getTscale()=='F')
		{
			MinTemp.setTemperature((float) 
					(5.0 * (MinTemp.getTemp() - 32.0) / 9.0), 'C');
		}
		
		if(scale == 'F'&&MinTemp.getTscale()=='C')
		{
			MinTemp.setTemperature((float) 
					((9.0 * MinTemp.getTemp() / 5.0) + 32.0), 'F');
		}
		
		return MinTemp;
	}
	
	//--------------------------------------------------------------------------
	//	Returns average temperature in desired scale (according to parametre)
	//--------------------------------------------------------------------------
	public float AvgTemp(char scale)
	{
		float fTotal = 0.0f;
		float fAvgTemp = 0.0f;
		
		if(scale == 'C')
		{
			for(int i = 0; i < iNumDays; i++)
			{
				if(aDailyTemps[i].getTscale()=='C')
				{
					fTotal += aDailyTemps[i].getTemp();
				}
				else if(aDailyTemps[i].getTscale() == 'F')	
				{
					fTotal+=(5.0 * (aDailyTemps[i].getTemp() - 32.0) / 9.0);
				}
			}
			fAvgTemp = Math.round(fTotal/iNumDays);
		}
		else if(scale == 'F')
		{
			for(int i = 0; i < iNumDays; i++)
			{
				if(aDailyTemps[i].getTscale()=='C')
				{
					fTotal+=((9.0 * aDailyTemps[i].getTemp()) / 5.0) + 32.0;
				}
				else if(aDailyTemps[i].getTscale() == 'F')	
				{
					fTotal += aDailyTemps[i].getTemp();
				}
			}
			fAvgTemp = Math.round(fTotal/iNumDays);
		}
		return fAvgTemp;
	}
	
	//--------------------------------------------------------------------------
	//	Prints objects in Temperature array (invoking toString method of each)
	//--------------------------------------------------------------------------
	public void getTempList()
	{
		for(int i=0; i<iNumDays; i++)
		{
			System.out.println(aDailyTemps[i]);
		}
	}
	
} //	end class

