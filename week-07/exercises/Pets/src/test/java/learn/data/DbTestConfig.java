package learn.data;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@ComponentScan
public class DbTestConfig {

    @Bean
    public DataSource getDataSource() {
        MysqlDataSource result = new MysqlDataSource();
        // Url is for the test database.
        result.setUrl("jdbc:mysql://localhost:3306/pets_test");
        result.setUser("root");
        result.setPassword("_LoveyogirlsA9");
        return result;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
