package learn.field_agent.data;

import learn.field_agent.models.Alias;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AliasJdbcTemplateRepositoryTest {

    final static int NEXT_ID = 4;

    @Autowired
    AliasJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }

    @Test
    void shouldAdd() {
        Alias arg = new Alias(0, "Test Alias", "Test Persona", 4);
        Alias expected = new Alias(NEXT_ID, "Test Alias", "Test Persona", 4);
        Alias actual = repository.add(arg);
        assertEquals(expected, actual);
    }

    @Test
    void shouldUpdateExisting() {
        Alias arg = new Alias(2, "Updated Alias", "Updated Persona", 1);
        boolean actual = repository.update(arg);
        assertTrue(actual);
    }

    @Test
    void shouldNotUpdateMissing() {
        Alias arg = new Alias(225, "Updated Alias", "Updated Persona", 1);
        boolean actual = repository.update(arg);
        assertFalse(actual);
    }

    @Test
    void shouldDeleteExisting() {
        boolean actual = repository.deleteById(3);
        assertTrue(actual);
    }

    @Test
    void shouldNotDeleteMissing() {
        boolean actual = repository.deleteById(225);
        assertFalse(actual);
    }
}