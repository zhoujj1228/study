package springdb.jdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    
    
    /**
     * ������ɾ�Ĳ�Ĳ�������������������
     */
    @Transactional
    @Override
	public void transaction() {
        userDao.find();
        userDao.insert();
        userDao.find();
        userDao.update();
        userDao.find();
        userDao.delete();
        userDao.find();
	}
    

}
