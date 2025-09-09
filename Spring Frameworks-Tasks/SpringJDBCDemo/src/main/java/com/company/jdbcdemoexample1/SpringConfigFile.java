package com.company.jdbcdemoexample1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringConfigFile {

    @Bean
    public DataSource datasource() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/wiprotraining"); // ✅ fixed
        datasource.setUsername("root");
        datasource.setPassword("newpassword");
        return datasource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource datasource) { // ✅ inject datasource
        return new JdbcTemplate(datasource);
    }
}
