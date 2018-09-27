package example.select;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.UsersMapper;
import domain.Users;
import domain.UsersExample;
import domain.UsersExample.Criteria;
import util.MybatisUtil;

public class SelectExample {

    public static void main(String[] args) throws IOException {
        String configPath = "mybatis-config.xml";
        SqlSession sqlSession = MybatisUtil.getSqlSession(configPath);
        
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        
        selectByPrimaryKeyTest(usersMapper);
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

    private static void selectByPrimaryKeyTest(UsersMapper usersMapper) {
        Users user = usersMapper.selectByPrimaryKey(4);
        System.out.println(user.getName());
        
    }

}
