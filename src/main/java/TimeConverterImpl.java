package com.sony.temp;

import java.beans.beancontext.BeanContextServiceRevokedListener;
import java.util.Arrays;
import java.util.Collections;

public class TimeConverterImpl implements TimeConverter {

    @Override
    public String convertTime(String aTime) {
    	// TODO Auto-generated method stub
		String firstLine = null, SecondLine = null, ThirdLine = null, FourthLine = null, FifthLine = null;
		String finalResult = null;
		try {
			if (aTime != null) {
				String[] splittedTime = aTime.split(":");
				if (splittedTime.length == 3) {
					int hour = Integer.parseInt(splittedTime[0]);
					int minute = Integer.parseInt(splittedTime[1]);
					int second = Integer.parseInt(splittedTime[2]);
					// print first line
					if (second >= 0 && second < 60) {
						if (second % 2 == 0)
							firstLine = "Y";
						else
							firstLine = "0";
					}
					else
						throw new IllegalArgumentException("provided second value is not valid");
					// print second and third line

					if (hour >= 0 && hour < 25) {
						int lightOn = hour / 5;
						int lightOff = 4 - lightOn;

						SecondLine = String.join("", Collections.nCopies(lightOn, "R"));
						SecondLine += String.join("", Collections.nCopies(lightOff, "0"));

						lightOn = hour % 5;
						lightOff = 4 - lightOn;
						ThirdLine = String.join("", Collections.nCopies(lightOn, "R"));
						ThirdLine += String.join("", Collections.nCopies(lightOff, "0"));

					}
					else
						throw new IllegalArgumentException("provided hour value is not valid");
					// print fourth and fifth line

					if (minute >= 0 && minute < 60) {
						int lightOn = minute / 5;
						int lightOff = 11 - lightOn;

						FourthLine = String.join("", Collections.nCopies(lightOn, "Y")).replaceAll("YYY", "YYR");
						FourthLine += String.join("", Collections.nCopies(lightOff, "0"));

						lightOn = minute % 5;
						lightOff = 4 - lightOn;
						FifthLine = String.join("", Collections.nCopies(lightOn, "Y"));
						FifthLine += String.join("", Collections.nCopies(lightOff, "0"));

					}
					else
						throw new IllegalArgumentException("provided minute value is not valid");
				} else
					throw new IllegalArgumentException("provided time value is not valid");
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
    
        
    public static void main(String[] args) {
    	
		TimeConverterImpl tc = new TimeConverterImpl();
		System.out.println(tc.convertTime("24:00:00"));
	}

}
