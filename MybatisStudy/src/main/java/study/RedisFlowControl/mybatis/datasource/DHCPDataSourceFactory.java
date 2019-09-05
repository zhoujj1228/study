package study.RedisFlowControl.mybatis.datasource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;
        
public class DHCPDataSourceFactory extends UnpooledDataSourceFactory {

  public DHCPDataSourceFactory() {
    this.dataSource = new BasicDataSource();
  }
  
}
