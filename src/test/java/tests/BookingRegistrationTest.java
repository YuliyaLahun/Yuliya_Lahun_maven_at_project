package tests;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import pages.BookingLoginPage;
import pages.TrashMailPage;

public class BookingRegistrationTest {

    private static final Logger LOGGER =
            Logger.getLogger(BookingRegistrationTest.class.getName());

    TrashMailPage trashMailPage= new TrashMailPage();
    BookingLoginPage bookingLoginPage = new BookingLoginPage();
    String email;

    @Before
    public void setup(){
        LOGGER.info("Create trash email");
        email = trashMailPage.createDisposaleEmail();
    }

    @Test
    public void bookingRegistrationTest(){
       bookingLoginPage.registerInBooking(email);
    }
}
