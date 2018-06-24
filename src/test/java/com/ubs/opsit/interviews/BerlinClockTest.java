package com.sony.temp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;



public class BerlinClockTest {
	
	TimeConverterImpl Tci = null;
	
	@Before
	public void createInstance()
	{
		Tci = new TimeConverterImpl();
	}

    @Test
    public void thisTestShouldPassIfYouHaveEverythingIsSetupCorrectly() {
        //new Example().sayHi();
        assertThat(true, is(true));
    }
    
    @Test
    public void validateNullTime()
    {
    	assertFalse(Tci.validate(null));
    }
    
    @Test
    public void validatedTimeFormat()
    {
    	assertFalse(Tci.validate("23:59"));
    }
    
    @Test
    public void invalidHourTest()
    {
    	boolean flag = Tci.validate("25:00:00");    	
    	assertFalse(flag);
    }
    
    @Test
    public void validHourTest()
    {
    	assertTrue(Tci.validate("24:00:00"));
    }
    
    @Test
    public void invalidMinuteTest()
    {
    	assertFalse("invalid minute value", Tci.validate("23:67:00"));
    }
    
    @Test
    public void validMinuteTest()
    {
    	assertTrue("minute value is valid", Tci.validate("23:59:45"));
    }
    
    @Test
    public void invalidSecondTest()
    {
    	assertFalse(Tci.validate("13:17:60"));
    }
    
    @Test
    public void validSecondTest()
    {
    	assertTrue(Tci.validate("17:45:00"));
    }
    
    @Test
    public void generateLineTwoTest()
    {
    	assertEquals("RRRR",Tci.generateTimeLine(4, 0, "R"));
    }
    
    @Test
    public void generateLineFourTest()
    {
    	assertEquals("YYRYYRYYRYY", Tci.generateTimeLine(11, 0, "Y").replaceAll("YYY", "YYR"));
    }
    
    /*Scenario: Midnight
    When the time is 00:00:00*/
    @Test
    public void exampleStroy1Test()
    {
    	   	
    	String expectedResult = String.join(System.getProperty("line.separator"), Arrays.asList("Y","OOOO","OOOO","OOOOOOOOOOO","OOOO"));
    	assertEquals(expectedResult, Tci.convertTime("00:00:00"));
    }
    
    /*Scenario: Midnight
    When the time is 24:00:00*/
    @Test
    public void exampleStroy2Test()
    {
    	   	
    	String expectedResult = String.join(System.getProperty("line.separator"), Arrays.asList("Y","RRRR","RRRR","OOOOOOOOOOO","OOOO"));
    	assertEquals(expectedResult, Tci.convertTime("24:00:00"));
    }
    
    @After
    public void clearObject()
    {
    	Tci = null;
    }
}
