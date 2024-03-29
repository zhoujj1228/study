package dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import domain.Users;
import domain.UsersExample;

public interface UsersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated Mon Aug 27 11:01:17 CST 2018
     */
    int countByExample(UsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated Mon Aug 27 11:01:17 CST 2018
     */
    int deleteByExample(UsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated Mon Aug 27 11:01:17 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated Mon Aug 27 11:01:17 CST 2018
     */
    int insert(Users record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated Mon Aug 27 11:01:17 CST 2018
     */
    int insertSelective(Users record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated Mon Aug 27 11:01:17 CST 2018
     */
    List<Users> selectByExample(UsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated Mon Aug 27 11:01:17 CST 2018
     */
    Users selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated Mon Aug 27 11:01:17 CST 2018
     */
    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated Mon Aug 27 11:01:17 CST 2018
     */
    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    /**
     * 根据Users类进行更新，按主键更新值不为null的字段
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Users record);

    /**
     * 根据Users类进行更新，按主键更新所有值（即使值为null）
     * @param record
     * @return
     */
    int updateByPrimaryKey(Users record);
}