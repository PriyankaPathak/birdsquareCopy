package birdsquare.model;

import birdsquare.helper.BirdSquareSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CheckinTest {

    private Checkin checkin;

    @Before
    public void setUp() {
        checkin = createCheckin();
    }

    @Test
    public void shouldSetTodayAsTheDateOfCheckIn() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals(dateFormat.format(new Date()), dateFormat.format(checkin.getDate()));
    }

    private Checkin createCheckin() {
        Checkin checkin = new Checkin();
        checkin.setBirdName("foobar");
        checkin.setNumber(16);
        return checkin;
    }
}
