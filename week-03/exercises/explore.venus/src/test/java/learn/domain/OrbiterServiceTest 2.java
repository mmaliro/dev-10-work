/*package learn.domain;

import learn.data.DataAccessException;
import learn.data.OrbiterRepositoryDouble;
import learn.models.Orbiter;
import learn.models.OrbiterType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrbiterServiceTest {

    OrbiterService service = new OrbiterService(new OrbiterRepositoryDouble());
    @Test
    void shouldAddOrbiter() {

    }

    @Test
    void shouldNotAddNullOrbiter() throws DataAccessException {
        OrbiterResult result = service.add(null);
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldNotAddAstronautWithNoRoom() throws DataAccessException {
        OrbiterResult result = service.add(new Orbiter(0, "Test Astro", OrbiterType.ASTRONAUT, null));
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldBeAbleToAddAstronaut() throws DataAccessException {
        service.add(new Orbiter(0, "Test Mod", OrbiterType.MODULE, null));
        OrbiterResult result = service.add(new Orbiter(0, "Test Astro", OrbiterType.ASTRONAUT, null));
        assertTrue(result.isSuccess());
        assertNotNull(result.getPayload());
    }

}

 */