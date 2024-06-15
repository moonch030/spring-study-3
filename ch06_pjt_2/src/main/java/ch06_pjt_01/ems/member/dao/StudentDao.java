package ch06_pjt_01.ems.member.dao;

import ch06_pjt_01.ems.member.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

    public StudentDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
    

	public void insert(Student student) {
        String sql = "INSERT INTO student (sNum, sId, sPw, sName, sAge, sGender, sMajor) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, student.getsNum(), student.getsId(), student.getsPw(), student.getsName(), student.getsAge(), String.valueOf(student.getsGender()), student.getsMajor());
    }

    public Student select(String sNum) {
    	String sql = "SELECT * FROM student WHERE sNum = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{sNum}, new RowMapper<Student>() {
                @Override
                public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Student student = new Student();
                    student.setsNum(rs.getString("sNum"));
                    student.setsId(rs.getString("sId"));
                    student.setsPw(rs.getString("sPw"));
                    student.setsName(rs.getString("sName"));
                    student.setsAge(rs.getInt("sAge"));
                    student.setsGender(rs.getString("sGender").charAt(0));
                    student.setsMajor(rs.getString("sMajor"));
                    return student;
                }
            });
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    public void update(Student student) {
        String sql = "UPDATE student SET sId = ?, sPw = ?, sName = ?, sAge = ?, sGender = ?, sMajor = ? WHERE sNum = ?";
        jdbcTemplate.update(sql, student.getsId(), student.getsPw(), student.getsName(),
                student.getsAge(), String.valueOf(student.getsGender()), student.getsMajor(), student.getsNum());
    }

    public void delete(String sNum) {
        String sql = "DELETE FROM student WHERE sNum = ?";
        jdbcTemplate.update(sql, sNum);
    }

    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }
}
