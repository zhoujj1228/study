package example.update;

import java.io.IOException;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import dao.UsersMapper;
import domain.Users;
import domain.UsersExample;
import domain.UsersExample.Criteria;
import util.MybatisUtil;

public class UpdateExample {
    public static void main(String[] args) throws IOException {
        String configPath = "mybatis-config.xml";
        SqlSession sqlSession = MybatisUtil.getSqlSession(configPath);
        
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        start(usersMapper);
        
        //updateByPrimaryKeyTest(usersMapper);
        //updateByPrimaryKeySelectiveTest(usersMapper);
        
        //updateByExampleTest(usersMapper);
        //updateByExampleSelectiveTest(usersMapper);
        
        end(usersMapper);
        
        sqlSession.commit();
        sqlSession.close();
    }

    private static void end(UsersMapper usersMapper) {
        int num = usersMapper.deleteByPrimaryKey(9);
        System.out.println(num);
    }

    private static void start(UsersMapper usersMapper) {
        Users user = new Users();
        user.setBirthday(new Date());
        user.setName("insertTest1");
        user.setId(9);
        usersMapper.insert(user);
        
    }

    private static void updateByExampleSelectiveTest(UsersMapper usersMapper) {
        Users user = new Users();
        user.setMail("u4mail");
        user.setId(9);
        UsersExample example = new UsersExample();
        Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo("u3name");
        int num = usersMapper.updateByExampleSelective(user, example);
        System.out.println(num);
        
    }

    private static void updateByExampleTest(UsersMapper usersMapper) {
        Users user = new Users();
        user.setMobile("u3mobile");
        user.setName("u3name");
        user.setId(9);
        UsersExample example = new UsersExample();
        Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo("u1name");
        int num = usersMapper.updateByExample(user, example);
        System.out.println(num);
        
    }

    private static void updateByPrimaryKeySelectiveTest(UsersMapper usersMapper) {
        Users user = new Users();
        user.setMail("u2mail");
        user.setId(9);
        int num = usersMapper.updateByPrimaryKeySelective(user);
        System.out.println(num);
        
    }

    /**
     * 根据
     * @param usersMapper
     */
    private static void updateByPrimaryKeyTest(UsersMapper usersMapper) {
        Users user = new Users();
        user.setMail("u1mail");
        user.setName("u1name");
        user.setId(9);
        int num = usersMapper.updateByPrimaryKey(user);
        System.out.println(num);
    }
}
