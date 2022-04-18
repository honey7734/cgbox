package mtheater.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import vo.MTheaterVO;

public class MTheatherDaoImpl implements IMTheaterDao {

	private SqlMapClient client;
	private static IMTheaterDao dao;
	private MTheatherDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IMTheaterDao getInstance() {
		if(dao == null) dao = new MTheatherDaoImpl();
		
		return dao;
	}
		
	@Override
	public List<MTheaterVO> selectAll() throws SQLException {
		return client.queryForList("mtheater.selectAll");
	}

}
