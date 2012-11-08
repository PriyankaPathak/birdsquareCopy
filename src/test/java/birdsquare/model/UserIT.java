package birdsquare.model;

import birdsquare.helper.BirdSquareSession;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserIT {

    private BirdSquareSession birdSquareSession;

    @Before
    public void setUp() {
        birdSquareSession = new BirdSquareSession();
    }

    @Test
    public void shouldBeAbleToFetchPointsGivenAUserId() throws Exception {
        User persistedUser = new User();
        persistedUser.setName("Naz");
        birdSquareSession.saveOrUpdate(persistedUser);

        User loadedUser = (User) birdSquareSession.get(User.class, persistedUser.getId());
        assertEquals(persistedUser.getName(), loadedUser.getName());
        assertEquals(persistedUser.getPoints(), loadedUser.getPoints());
        birdSquareSession.delete(persistedUser);
    }
}
