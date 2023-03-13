package learn.field_agent.domain;

import learn.field_agent.data.SecurityClearanceRepository;
import learn.field_agent.models.SecurityClearance;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class SecurityClearanceServiceTest {

    @Autowired
    SecurityClearanceService service;

    @MockBean
    SecurityClearanceRepository repository;



    @Test
    void deleteByIdWhenSecurityClearanceDoesNotExist() {
        SecurityClearanceRepository repository = mock(SecurityClearanceRepository.class);
        SecurityClearanceService service = new SecurityClearanceService(repository);
        int securityClearanceId = 1;
        when(repository.deleteById(securityClearanceId)).thenReturn(false);

        boolean result = service.deleteById(securityClearanceId);

        assertFalse(result);
    }

    @Test
    void deleteByIdWhenSecurityClearanceExists() {
        SecurityClearanceRepository repository = mock(SecurityClearanceRepository.class);
        SecurityClearanceService service = new SecurityClearanceService(repository);
        int securityClearanceId = 1;
        when(repository.deleteById(securityClearanceId)).thenReturn(true);

        boolean result = service.deleteById(securityClearanceId);

        assertTrue(result);
    }

    @Test
    void updateWhenSecurityClearanceIdIsNotSet() {
        SecurityClearanceRepository repository = mock(SecurityClearanceRepository.class);
        SecurityClearanceService service = new SecurityClearanceService(repository);
        SecurityClearance securityClearance = new SecurityClearance();
        securityClearance.setName("Top Secret");

        Result<SecurityClearance> result = service.update(securityClearance);

        assertFalse(result.isSuccess());
        assertEquals(
                "securityClearanceId must be set for `update` operation",
                result.getMessages().get(0));
    }


    @Test
    void updateWhenNameAlreadyExists() {
        SecurityClearanceRepository repository = mock(SecurityClearanceRepository.class);
        SecurityClearanceService service = new SecurityClearanceService(repository);
        SecurityClearance securityClearance = new SecurityClearance();
        securityClearance.setName("Top Secret");
        securityClearance.setSecurityClearanceId(1);

        List<SecurityClearance> existingSecurityClearances = List.of(securityClearance);
        when(repository.findAll()).thenReturn(existingSecurityClearances);

        Result<SecurityClearance> result = service.update(securityClearance);

        assertFalse(result.isSuccess());
        assertEquals("Name already exists", result.getMessages().get(0));
    }

    @Test
    void addWhenNameIsNull() {
        SecurityClearanceRepository repository = mock(SecurityClearanceRepository.class);
        SecurityClearanceService service = new SecurityClearanceService(repository);
        SecurityClearance securityClearance = new SecurityClearance();
        securityClearance.setName(null);

        Result<SecurityClearance> result = service.add(securityClearance);

        assertFalse(result.isSuccess());
        assertEquals(1, result.getMessages().size());
        assertEquals("name is required", result.getMessages().get(0));
    }

    @Test
    void addSecurityClearance() {
        SecurityClearance securityClearance = new SecurityClearance();
        securityClearance.setName("Secret");

        when(repository.add(securityClearance)).thenReturn(securityClearance);

        Result<SecurityClearance> result = service.add(securityClearance);

        assertTrue(result.isSuccess());
        assertEquals("Secret", result.getPayload().getName());
    }

    @Test
    void findByIdWhenSecurityClearanceIdIsNotFound() {
        SecurityClearanceRepository repository = mock(SecurityClearanceRepository.class);
        SecurityClearanceService service = new SecurityClearanceService(repository);
        int securityClearanceId = 1;
        when(repository.findById(securityClearanceId)).thenReturn(null);

        SecurityClearance result = service.findById(securityClearanceId);

        assertNull(result);
    }

    @Test
    void findByIdWhenSecurityClearanceIdIsFound() {
        SecurityClearanceRepository repository = mock(SecurityClearanceRepository.class);
        SecurityClearanceService service = new SecurityClearanceService(repository);
        int securityClearanceId = 1;
        SecurityClearance expectedSecurityClearance =
                new SecurityClearance(securityClearanceId, "Top Secret");
        when(repository.findById(securityClearanceId)).thenReturn(expectedSecurityClearance);

        SecurityClearance actualSecurityClearance = service.findById(securityClearanceId);

        assertEquals(expectedSecurityClearance, actualSecurityClearance);
    }

    @Test
    void findAllShouldReturnAllSecurityClearances() {
        SecurityClearanceRepository repository = mock(SecurityClearanceRepository.class);
        SecurityClearanceService service = new SecurityClearanceService(repository);
        List<SecurityClearance> expected =
                List.of(
                        new SecurityClearance(1, "Secret"),
                        new SecurityClearance(2, "Top Secret"));

        when(repository.findAll()).thenReturn(expected);

        List<SecurityClearance> actual = service.findAll();

        assertEquals(expected, actual);
    }
}