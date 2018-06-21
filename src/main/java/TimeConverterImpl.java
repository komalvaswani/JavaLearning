package com.sony.temp;

import java.util.Arrays;
import java.util.Collections;

public class TimeConverterImpl implements TimeConverter {
	
	int hour=0, minute = 0, second = 0;

    @Override
    public String convertTime(String aTime) {
    	// TODO Auto-generated method stub
    	
		String firstLine = null, SecondLine = null, ThirdLine = null, FourthLine = null, FifthLine = null;
		String finalResult = null;
		try {
			if (validate(aTime)) {				
					// print first line
						firstLine = (second % 2 == 0 ? "Y" : "0");
						
					// print second and third line
						int lightOn = hour / 5;
						int lightOff = 4 - lightOn;
						SecondLine = generateTimeLine(lightOn, lightOff,"R");						

						lightOn = hour % 5;
						lightOff = 4 - lightOn;
						ThirdLine = generateTimeLine(lightOn, lightOff, "R");
											
					// print fourth and fifth line
						lightOn = minute / 5;
						lightOff = 11 - lightOn;
						FourthLine = generateTimeLine(lightOn, lightOff, "Y").replaceAll("YYY", "YYR");
						
						lightOn = minute % 5;
						lightOff = 4 - lightOn;
						FifthLine = generateTimeLine(lightOn, lightOff, "Y");
									
			}
		} // end of try
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		finalResult = String.join(System.getProperty("line.separator"),
				Arrays.asList(firstLine, SecondLine, ThirdLine, FourthLine, FifthLine));
		return finalResult;
    
    }
    
    public boolean validate(String time)
    {
		boolean flag = false;
		String[] splittedTime = time.split(":");
		hour = Integer.parseInt(splittedTime[0]);
		minute = Integer.parseInt(splittedTime[1]);
		second = Integer.parseInt(splittedTime[2]);
		if (hour >= 0 && hour <= 24 && minute >= 0 && minute <= 59 && second >= 0 && second <= 59) {
			flag = true;
		} else {

			flag = false;
		}
		return flag;
    }
    
    public String generateTimeLine(int lightOn,int lightOff,String color)
    {
    	return (String.join("", Collections.nCopies(lightOn, color)) + String.join("", Collections.nCopies(lightOff, "0")));
    }
    
    public static void main(String[] args) {
    	
		TimeConverterImpl tc = new TimeConverterImpl();		
		System.out.println(tc.convertTime("13:17:00"));
	}

}
