package springdb;


/**
 * 1.使用@Transactional注解
 * 配置文件添加<tx:annotation-driven transaction-manager="txManager"/>
 * 或是java配置类中添加@EnableTransactionManagement
 * 
 * 2.使用多数据源配置
 * 继承AbstractRoutingDataSource并重写determineCurrentLookupKey方法(用于选择数据源)
 * 新建数据源选择工具类
 * 注意:数据源选择需要在事务启动之前执行
 * 
 * @author Jay
 * @date 2018年8月22日
 */
public class TestSpringDB {

}
