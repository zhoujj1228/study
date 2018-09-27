package example.init;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao.UsersMapper;
import domain.Users;
import util.MybatisUtil;

public class SessionFactoryExample {

    public static void main(String[] args) throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession session = factory.openSession();
        
        UsersMapper userMapper = session.getMapper(UsersMapper.class);
        Users user = userMapper.selectByPrimaryKey(4);
        System.out.println(user.getName());
        session.close();
        
    }
    

}
