package example.transaction;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.UsersMapper;
import domain.Users;
import domain.UsersExample;
import domain.UsersExample.Criteria;
import util.MybatisUtil;

public class TransactionExample {

    public static void main(String[] args) throws IOException {
        String configPath = "mybatis-config.xml";
        MybatisUtil.initSqlSessionFactory(configPath);
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        
        selectByExampleTest(usersMapper);
        
        
        sqlSession.commit();
        sqlSession.close();
    }

    private static void selectByExampleTest(UsersMapper usersMapper) {
        UsersExample example = new UsersExample();
        Criteria criteria = example.createCriteria();
        criteria.andSexEqualTo(0);
        List<Users> users = usersMapper.selectByExample(example);
        for(Users user : users){
            System.out.println(user.getName());
        }
        
    }

}
