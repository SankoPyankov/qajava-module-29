import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.assertEquals;

public class PersonTest {

    public static void currentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

    @BeforeTest
    public static void beforeTime() {
        System.out.println("Before test");
        currentTime();
    }

    @AfterTest
    public static void afterTime() {
        System.out.println("After test");
        currentTime();
    }

    @DataProvider(name = "dataIsTeenager")
    Object[][] dataProvider() {
        return new Object[][] {
                {0, false},
                {7, false},
                {12, false},
                {13, true},
                {14, true},
                {16, true},
                {18, true},
                {19, true},
                {20, false},
                {25, false},
                {99, false},
        };
    }

    @Test(dataProvider = "dataIsTeenager")
    void testIsTeenager(int arg1, boolean expected) {
        boolean isTeenager = Person.isTeenager(arg1);
        System.out.println("Result: " + arg1 + ", " + isTeenager + "; Expected: " + expected);
        assertEquals(isTeenager, expected);
    }
}
