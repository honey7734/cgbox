package screen.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import vo.ScreenVO;

public class ScreenDaoImpl implements IScreenDao {

	private SqlMapClient client;
	private static IScreenDao dao;
	private ScreenDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	public static IScreenDao getInstance() {
		if(dao == null) dao = new ScreenDaoImpl();
		
		return dao;
	}
	
	
	@Override
	public List<ScreenVO> selectScreenList(ScreenVO vo) throws SQLException {
		return client.queryForList("screen.selectScreenList", vo);
	}

}
