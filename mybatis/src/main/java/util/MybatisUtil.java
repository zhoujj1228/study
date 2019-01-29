package util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static SqlSessionFactory factory;
	private static Object initLock = new Object();
	private static String defaultConfigPath = "mybatis-config.xml";
	
	public static void initSqlSessionFactory(String configPath) throws IOException{
		if(configPath == null){
			//使用classpath根目录下配置文件
			configPath = defaultConfigPath;
		}
		if(factory == null){
			synchronized (initLock) {
				if(factory == null){
					InputStream inputStream = Resources.getResourceAsStream(configPath);
			        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			        factory = builder.build(inputStream);
				}
			}
		}
	}
	
    public static SqlSession getSqlSession() throws IOException{
        SqlSession session = factory.openSession();
        return session;
    }
}
