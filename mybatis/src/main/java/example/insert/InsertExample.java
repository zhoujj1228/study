package example.insert;

import java.io.IOException;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import dao.UsersMapper;
import domain.Users;
import util.MybatisUtil;

public class InsertExample {

    public static void main(String[] args) throws IOException {
        String configPath = "mybatis-config.xml";
        SqlSession sqlSession = MybatisUtil.getSqlSession(configPath);
        
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        
        insertTest(usersMapper);
        
        sqlSession.commit();
        sqlSession.close();
    }

    private static void insertTest(UsersMapper usersMapper) {
        Users user = new Users();
        user.setBirthday(new Date());
        user.setName("insertTest1");
        user.setId(9);
        usersMapper.insert(user);
    }
    
    

}
