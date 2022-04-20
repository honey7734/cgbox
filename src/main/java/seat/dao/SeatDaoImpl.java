package seat.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import vo.SeatVO;

public class SeatDaoImpl implements ISeatDao {
	private SqlMapClient client;
	private static ISeatDao dao;
	private SeatDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	public static ISeatDao getInstance() {
		if(dao == null) dao = new SeatDaoImpl();
		
		return dao;
	}
	
	@Override
	public int selectSeatNo(SeatVO vo) throws SQLException {
		return (int) client.queryForObject("seat.selectSeatNo", vo);
	}

}
