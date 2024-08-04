package com.example.students_list.model;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JDBCStudentsListRepository  implements StudentsListRepository{

    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<Student> findAll() {
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    @Override
    public void addStudent(Student student) {
        student.setId(System.currentTimeMillis());
        String sql
                = "INSERT INTO student (id, firstName, lastName, email, phone) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getPhone());

    }

    @Override
    public void editStudent(Student student) {
        String sql = "UPDATE student SET firstName = ?, lastName = ?, email = ?, phone = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getPhone()
                , student.getId());
    }

    @Override
    public void deleteStudent(long id) {
        String sql = "DELETE FROM student WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Student> findById(long id) {
        String sql = "SELECT * FROM student WHERE id = ?";
        Student student = DataAccessUtils.singleResult(
                jdbcTemplate.query(
                        sql,
                        new ArgumentPreparedStatementSetter(new Object[] {id}),
                        new RowMapperResultSetExtractor<>(new StudentRowMapper())
                )
        );
        return Optional.ofNullable(student);
    }
}
