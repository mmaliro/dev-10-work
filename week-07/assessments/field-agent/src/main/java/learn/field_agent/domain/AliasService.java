package learn.field_agent.domain;

import learn.field_agent.data.AgentRepository;
import learn.field_agent.data.AliasRepository;
import learn.field_agent.models.Agent;
import learn.field_agent.models.Alias;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AliasService {

    private final AliasRepository aliasRepository;
    private final AgentRepository agentRepository;

    public AliasService(AliasRepository aliasRepository, AgentRepository agentRepository) {
        this.aliasRepository = aliasRepository;
        this.agentRepository = agentRepository;
    }

    public Result<Alias> add(Alias alias) {
        Result<Alias> result = validate(alias);
        if (!result.isSuccess()) {
            return result;
        }

        alias = aliasRepository.add(alias);
        if (alias == null) {
            result.addMessage("could not save alias", ResultType.INVALID);
            return result;
        }

        result.setPayload(alias);
        return result;
    }

    public Result<Alias> update(Alias alias) {
        Result<Alias> result = validate(alias);
        if (!result.isSuccess()) {
            return result;
        }
        boolean success = aliasRepository.update(alias);
        if (!success) {
            result.addMessage("alias id " + alias.getAliasId() + " not found", ResultType.NOT_FOUND);
        }
        return result;
    }

    public Result<Void> deleteById(int aliasId) {
        boolean success = aliasRepository.deleteById(aliasId);
        Result<Void> result = new Result<>();
        if (!success) {
            result.addMessage("alias id " + aliasId + " not found", ResultType.NOT_FOUND);
        }
        return result;
    }

    private Result<Alias> validate(Alias alias) {
        Result<Alias> result = new Result<>();
        if (alias == null) {
            result.addMessage("alias is null", ResultType.INVALID);
            return result;
        }

        if (Validations.isNullOrBlank(alias.getName())) {
            result.addMessage("name is required", ResultType.INVALID);
            return result;
        }

        Agent agent = agentRepository.findById(alias.getAgentId());
        for (Alias a : agent.getAliases()) {
            boolean namesMatch = a.getName().equalsIgnoreCase(alias.getName())
                    && a.getAliasId() != alias.getAliasId();
            boolean personasMatch = Objects.equals(a.getPersona(), alias.getPersona());
            if (namesMatch && personasMatch) {
                result.addMessage("duplicate name and persona", ResultType.INVALID);
            }
        }

        return result;
    }
}