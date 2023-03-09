package learn.field_agent;

import learn.field_agent.domain.Result;
import learn.field_agent.domain.ResultType;
import learn.field_agent.models.Agent;
import learn.field_agent.models.Alias;

import java.time.LocalDate;
import java.util.List;

public class TestHelper {
    public static <T> Result<T> makeResult(String message, ResultType type) {
        Result<T> result = new Result<>();
        result.addMessage(message, type);
        return result;
    }

    public static <T> Result<T> makeResult(T payload) {
        Result<T> result = new Result<>();
        result.setPayload(payload);
        return result;
    }

    public static Agent makeAgent() {
        //('Hazel','C','Sauven','1954-09-16',76),
        Agent agent = new Agent();
        agent.setAgentId(1);
        agent.setFirstName("Hazel");
        agent.setMiddleName("C");
        agent.setLastName("Sauven");
        agent.setDob(LocalDate.of(1954, 9, 16));
        agent.setHeightInInches(76);

        agent.setAliases(List.of(
                new Alias(1, "Name #1", "Persona #1", 1),
                new Alias(2, "Name #2", "Persona #2", 1)
        ));

        return agent;
    }
}
