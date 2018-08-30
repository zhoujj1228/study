package springdb.jdbcTemplate;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@EnableTransactionManagement
public class SpringDBConfig {
	
	@Bean
	public DataSource dataSource(){
	    BasicDataSource ds = new BasicDataSource();
	    ds.setDriverClassName("com.mysql.jdbc.Driver");
	    ds.setUrl("jdbc:mysql://127.0.0.1:3306/myworld?useUnicode=true&characterEncoding=UTF-8");
	    ds.setUsername("test1");
	    ds.setPassword("test1");
	    return ds;
	}
	
	@Bean
	public DataSourceTransactionManager txManager(){
	    DataSourceTransactionManager dstm = new DataSourceTransactionManager();
	    dstm.setDataSource(dataSource());
	    return dstm;
	}
	
}
