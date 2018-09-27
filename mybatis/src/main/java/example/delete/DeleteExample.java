package example.delete;

import java.io.IOException;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import dao.UsersMapper;
import domain.Users;
import domain.UsersExample;
import domain.UsersExample.Criteria;
import util.MybatisUtil;

public class DeleteExample {

    public static void main(String[] args) throws IOException {
        String configPath = "mybatis-config.xml";
        SqlSession sqlSession = MybatisUtil.getSqlSession(configPath);
        
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        
        deleteByPrimaryKeyTest(usersMapper);
        deleteByExampleTest(usersMapper);
        
        sqlSession.commit();
        sqlSession.close();
    }

    private static void deleteByExampleTest(UsersMapper usersMapper) {
        UsersExample example = new UsersExample();
        Criteria criteria = example.createCriteria();
        criteria.andNameLike("insert%");
        int deleteByExampleNum = usersMapper.deleteByExample(example);
        System.out.println(deleteByExampleNum);
    }

    private static void deleteByPrimaryKeyTest(UsersMapper usersMapper) {
        int num = usersMapper.deleteByPrimaryKey(9);
        System.out.println(num);
    }

}
