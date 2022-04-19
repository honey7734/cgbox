package theater.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import vo.TheaterVO;

public class TheaterDaoImpl implements ITheaterDao {
	
	private SqlMapClient client;
	private static ITheaterDao dao;
	private TheaterDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	public static ITheaterDao getInstance() {
		if(dao == null) dao = new TheaterDaoImpl();
		
		return dao;
	}
		
	@Override
	public List<TheaterVO> selectAllByMtheaterNo(int no) throws SQLException {
		return client.queryForList("theater.selectAllByMtheaterNo", no);
	}

}
