package learn.field_agent.data;

import learn.field_agent.models.Alias;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class AliasJdbcTemplateRepository implements AliasRepository {

    private final JdbcTemplate jdbcTemplate;

    public AliasJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Alias add(Alias alias) {

        String sql = "insert into alias (`name`, persona, agent_id) " +
                "values (?,?,?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        int rowsAffected = jdbcTemplate.update(conn -> {
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, alias.getName());
            statement.setString(2, alias.getPersona());
            statement.setInt(3, alias.getAgentId());
            return statement;
        }, keyHolder);

        if (rowsAffected > 0) {
            alias.setAliasId(keyHolder.getKey().intValue());
            return alias;
        }

        return null;
    }

    public boolean update(Alias alias) {

        String sql = "update alias set " +
                "`name` = ?, " +
                "persona = ? " +
                "where alias_id = ?;";

        return jdbcTemplate.update(sql,
                alias.getName(),
                alias.getPersona(),
                alias.getAliasId()) > 0;
    }

    public boolean deleteById(int aliasId) {
        String sql = "delete from alias where alias_id = ?;";
        return jdbcTemplate.update(sql, aliasId) > 0;
    }
}