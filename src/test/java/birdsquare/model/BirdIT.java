package birdsquare.model;

import birdsquare.helper.BirdSquareSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BirdIT {

    private BirdSquareSession birdSquareSession;

    @Before
    public void setUp() {
        birdSquareSession = new BirdSquareSession();
    }

    @Test
    public void shouldLoadAllBirds() throws Exception {
        List allBirds = birdSquareSession.getAll(Bird.class);
//        for (Object bird : allBirds) {
//            System.out.println(((Bird)bird).getCommon_name());
//        }
        assertTrue(allBirds.size() > 0);
    }
}
