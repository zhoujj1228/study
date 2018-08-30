package springdb.jdbcTemplate;

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
        User user = this.jdbcTemplate.queryForObject(
                //"select * from users order by id desc"
                "select * from users where name = 'jay'"
                , new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int num) throws SQLException {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                System.out.println(user.getId() + "\t" + user.getName());
                return user;
            }
        });
        System.out.println("queryForObject1 test : " + user.getName());
        
        int count = this.jdbcTemplate.queryForObject(
                "select count(*) from users where name = ?", Integer.class, "jay");
        System.out.println("queryForObject2 test : " + count);
        
        String name = this.jdbcTemplate.queryForObject(
                "select name from users where id = ?",
                new Object[]{6}, String.class);
        System.out.println("queryForObject3 test : " + name);
        
        List<User> users = this.jdbcTemplate.query(
                "select * from users order by id desc", new RowMapper<User>() {
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                return user;
            }
        });
        System.out.println("query1 test : " + users.get(0).getName());
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
                "update userss set name = ? where name = ?",
                "jay22", "jay2");        
    }

    @Override
    public void delete() {
        this.jdbcTemplate.update(
                "delete from users where name = ?",
                "jay22");        
    }

    
}
