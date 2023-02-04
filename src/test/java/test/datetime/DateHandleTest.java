package test.datetime;

import datetime.DateHandle;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DateHandleTest {
    DateHandle dateHandle = new DateHandle();

    @Test (dataProvider = "getDataDateDiff")
    public void testGetDateDiff(String startDateStr, String closeDateStr, int expectedDays){
        Assert.assertEquals(dateHandle.getDateDiff(startDateStr, closeDateStr), expectedDays);
    }

    @Test (dataProvider = "getDataCloseDate")
    public void testGetCloseDateAddMonths(String startDateStr, int months, String expectedCloseDate){
        Assert.assertEquals(dateHandle.getCloseDateAddMonths(startDateStr, months), expectedCloseDate);
    }
    @DataProvider
    public Object[][] getDataDateDiff(){
        Object[][] data = new Object[][] {
                {"20170220", "20211224", 1768},
                {"20230101", "20230101", 0},
                {"20000201", "20000301", 29},
                {"20211231", "20221231", 365},
        };
        return data;
    }
    @DataProvider
    public Object[][] getDataCloseDate(){
        Object[][] data = new Object[][] {
                {"20170228", 1, "20170331"},
                {"20230101", 1, "20230129"},
                {"19991230", 2, "20000228"},
        };
        return data;
    }
}
