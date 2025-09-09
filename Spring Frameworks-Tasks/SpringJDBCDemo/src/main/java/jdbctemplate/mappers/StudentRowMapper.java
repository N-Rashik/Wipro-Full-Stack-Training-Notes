package jdbctemplate.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import jdbctemplate.Beans.Student;   

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student obj = new Student();
        
        // Example: mapping columns from your "student" table
        obj.setId(rs.getInt("id"));
        obj.setEmail(rs.getString("email"));
        obj.setName(rs.getString("name"));
        
        return obj;
    }
}
