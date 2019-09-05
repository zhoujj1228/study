package study.RedisFlowControl.init.db;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import study.RedisFlowControl.mybatis.dao.Esb2FlowCtrlMapper;
import study.RedisFlowControl.mybatis.model.Esb2FlowCtrl;
import study.RedisFlowControl.mybatis.model.Esb2FlowCtrlExample;
import study.RedisFlowControl.mybatis.util.MybatisUtil;

public class DBInitializer {
	public static void main(String[] args) throws IOException {
		String configPath = "mybatis-config.xml";
        SqlSession sqlSession = MybatisUtil.getSqlSession(configPath);
		Esb2FlowCtrlMapper efcMapper = sqlSession.getMapper(Esb2FlowCtrlMapper.class);
		Esb2FlowCtrlExample example = new Esb2FlowCtrlExample();
		List<Esb2FlowCtrl> efcList = efcMapper.selectByExample(example);
		System.out.println(efcList.size());
	}
}
