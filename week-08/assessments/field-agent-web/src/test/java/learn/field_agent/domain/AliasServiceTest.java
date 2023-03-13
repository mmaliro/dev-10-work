package learn.field_agent.domain;

import learn.field_agent.data.AgentRepository;
import learn.field_agent.data.AliasRepository;
import learn.field_agent.models.Agent;
import learn.field_agent.models.Alias;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static learn.field_agent.TestHelper.makeAgent;
import static learn.field_agent.TestHelper.makeResult;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AliasServiceTest {

    @MockBean
    AliasRepository aliasRepository;

    @MockBean
    AgentRepository agentRepository;

    @Autowired
    AliasService service;

    @Test
    void shouldAdd() {
        Result<Alias> expected = makeResult(new Alias(5, "Name", "Persona", 1));

        when(aliasRepository.add(any())).thenReturn(new Alias(5, "Name", "Persona", 1));
        when(agentRepository.findById(anyInt())).thenReturn(makeAgent());

        Alias arg = new Alias(0, "Name", "Persona", 1);
        Result<Alias> actual = service.add(arg);

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddBlankName() {

        Result<Alias> expected = makeResult("name is required", ResultType.INVALID);

        Alias arg = new Alias(0, "\t", "Persona", 1);
        Result<Alias> actual = service.add(arg);

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddDuplicatePersona() {

        Result<Alias> expected = makeResult("duplicate name and persona", ResultType.INVALID);

        Agent agent = makeAgent();
        when(agentRepository.findById(anyInt())).thenReturn(agent);

        Alias arg = new Alias(0, "Name #1", "Persona #1", 1);
        Result<Alias> actual = service.add(arg);

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddNull() {
        Result<Alias> expected = makeResult("alias is null", ResultType.INVALID);
        Result<Alias> actual = service.add(null);
        assertEquals(expected, actual);
    }

    @Test
    void shouldUpdateExisting() {
        Result<Alias> expected = makeResult(null);
        when(aliasRepository.update(any())).thenReturn(true);
        when(agentRepository.findById(anyInt())).thenReturn(makeAgent());
        Alias arg = new Alias(3, "Name", "Persona", 1);
        Result<Alias> actual = service.update(arg);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotUpdateMissing() {
        Result<Alias> expected = makeResult("alias id 15 not found", ResultType.NOT_FOUND);
        when(aliasRepository.update(any())).thenReturn(false);
        when(agentRepository.findById(anyInt())).thenReturn(makeAgent());
        Alias arg = new Alias(15, "Name", "Persona", 1);
        Result<Alias> actual = service.update(arg);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotUpdateBlankName() {
        Result<Alias> expected = makeResult("name is required", ResultType.INVALID);
        Alias arg = new Alias(3, " ", "Persona", 1);
        Result<Alias> actual = service.update(arg);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotUpdateDuplicatePersona() {

        Result<Alias> expected = makeResult("duplicate name and persona", ResultType.INVALID);

        Agent agent = makeAgent();
        when(agentRepository.findById(anyInt())).thenReturn(agent);

        Alias arg = new Alias(2, "Name #1", "Persona #1", 1);
        Result<Alias> actual = service.add(arg);

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotUpdateNull() {
        Result<Alias> expected = makeResult("alias is null", ResultType.INVALID);
        Result<Alias> actual = service.update(null);
        assertEquals(expected, actual);
    }

    @Test
    void shouldDeleteExisting() {
        Result<Void> expected = makeResult(null);
        when(aliasRepository.deleteById(anyInt())).thenReturn(true);
        Result<Void> actual = service.deleteById(5);
    }

    @Test
    void shouldNotDeleteMissing() {
        Result<Void> expected = makeResult("alias id 15 not found", ResultType.NOT_FOUND);
        Result<Void> actual = service.deleteById(15);
        assertEquals(expected, actual);
    }

}