package springdb.dynamicDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private ApplicationContext applicationContext;
    
    /**
     * ���Զ�����Դ����������
     */
    @Override
	public void transaction() {
        DynamicDataSourceHolder.setDataSource("write");
        //�����ڴ˴�����transactionDo()����Ϊû���������࣬����ͨ��ʹ�����·�ʽ
        applicationContext.getBean(UserService.class).transactionDo();
        
        
	}

    @Transactional
    public void transactionDo(){
        userDao.find();
        userDao.insert();
        userDao.find();
        userDao.update();
        userDao.find();
        userDao.delete();
        userDao.find();
    }


    @Override
    public void test() {

        System.out.println("-----read_DB----");
        DynamicDataSourceHolder.setDataSource("read");
        userDao.find();

        System.out.println("-----write_DB----");
        DynamicDataSourceHolder.setDataSource("write");
        userDao.find();
        
    }
    

}
