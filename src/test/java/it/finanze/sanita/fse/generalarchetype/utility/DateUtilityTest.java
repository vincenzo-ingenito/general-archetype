package it.finanze.sanita.fse.generalarchetype.utility;
  

import java.util.Calendar;
import java.util.Date; 
 
import static org.junit.jupiter.api.Assertions.assertEquals; 
 

import org.junit.jupiter.api.Test;
 

public class DateUtilityTest {
 
     @Test
    public void testGetDifferenceDays() {
        Date date1 = new Date(10000);  
        Date date2 = new Date(10000); 

        long difference = DateUtility.getDifferenceDays(date1, date2);

        assertEquals(0, difference);  
    }

    @Test
    public void testAddDay() {
        Date date = new Date(1000);   

        Date result = DateUtility.addDay(date, 5);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(result);
 
        assertEquals(1970, calendar.get(Calendar.YEAR));
        assertEquals(0, calendar.get(Calendar.MONTH));
        assertEquals(6, calendar.get(Calendar.DAY_OF_MONTH));
    } 
}
