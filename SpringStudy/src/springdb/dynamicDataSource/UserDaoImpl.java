package springdb.dynamicDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl implements UserDao{

    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public void setJdbcTempplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public void find() {
        List<User> users = this.jdbcTemplate.query(
                "select * from users order by id desc", new RowMapper<User>() {
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                return user;
            }
        });
        for(User user : users){
            System.out.println("query test : " + user.getId() + "\t" + user.getName());
        }
        System.out.println();
    }

    @Override
    public void insert() {
        this.jdbcTemplate.update(
                "insert into users (name, sex, birthday, mail, mobile, nation, married) "
                + "values(? , 0, '1992-10-03', '578074766@qq.com', '18825156753', ?, 0);",
                "jay2", "han");
    }

    @Override
    public void update() {
        this.jdbcTemplate.update(
                "update users set name = ? where name = ?",
                "jay22", "jay2");        
    }

    @Override
    public void delete() {
        this.jdbcTemplate.update(
                "delete from users where name = ?",
                "jay22");        
    }

    
}
