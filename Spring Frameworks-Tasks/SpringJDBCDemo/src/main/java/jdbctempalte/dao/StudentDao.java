package jdbctempalte.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import jdbctemplate.Beans.Student;

public class StudentDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insertStudent(Student obj)
	{
		String insertquery="insert into student values(?,?,?)";
		int count=jdbcTemplate.update(insertquery,obj.getId(),obj.);
		return count;
	}

}
