package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.prod.vo.ProdVO;

public class ProdDaoImpl implements IProdDao {
	private static IProdDao dao;
	
	private ProdDaoImpl() {}
	
	public static IProdDao getInstance() {
		if(dao == null) dao = new ProdDaoImpl();
		return dao;
	}

	@Override
	public List<ProdVO> getAllProd(SqlMapClient client, String category) throws SQLException {
		
		return client.queryForList("prod.getAllProd", category);
				
	}

	@Override
	public int cartCount(SqlMapClient client, int cid) throws SQLException {
		return (int)client.queryForObject("prod.cartCount", cid);
	}

	@Override
	public int findCart(SqlMapClient client, int cid) throws SQLException {
		
		return (int)client.queryForObject("prod.findCart", cid);
	}

	@Override
	public int insertCart(SqlMapClient client, int cid) throws SQLException {
		int cnt = 0;
		Object obj = client.insert("prod.insertCart", cid);
		if(obj == null) cnt = 1;
		
		return cnt;
	}

	@Override
	public int insertCartprod(SqlMapClient client, Map<String, Integer> map) throws SQLException {
		int cnt = 0;
		Object obj = client.insert("prod.insertCartprod", map);
		if(obj == null) cnt = 1;
		return cnt;
	}
	
}
