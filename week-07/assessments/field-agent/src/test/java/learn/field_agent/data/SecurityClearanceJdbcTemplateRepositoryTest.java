package learn.field_agent.data;

import learn.field_agent.models.SecurityClearance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class SecurityClearanceJdbcTemplateRepositoryTest {

    @Autowired
    SecurityClearanceJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }


    @Test
    void deleteByIdWhenSecurityClearanceIdDoesNotExist() {
        int securityClearanceId = -1;

        boolean result = repository.deleteById(securityClearanceId);

        assertFalse(result);
    }

    @Test
    void updateWhenSecurityClearanceIsUpdated() {
        SecurityClearance securityClearance = new SecurityClearance(1, "Top Secret");
        assertTrue(repository.update(securityClearance));
    }



    @Test
    void addWhenSecurityClearanceIsValid() {
        SecurityClearance securityClearance = new SecurityClearance();
        securityClearance.setName("Top Secret");
        SecurityClearance addedSecurityClearance = repository.add(securityClearance);
        assertNotNull(addedSecurityClearance);
        assertNotNull(addedSecurityClearance.getSecurityClearanceId());
    }


    @Test
    void shouldFindById() {
        SecurityClearance secret = new SecurityClearance(1, "Secret");
        SecurityClearance topSecret = new SecurityClearance(2, "Top Secret");

        SecurityClearance actual = repository.findById(1);
        assertEquals(secret, actual);

        actual = repository.findById(2);
        assertEquals(topSecret, actual);

        actual = repository.findById(3);
        assertEquals(null, actual);
    }
}