package movie.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import vo.MovieVO;

public class MovieDaoImpl implements IMovieDao {
	private SqlMapClient client; 
	private static IMovieDao dao;
	private MovieDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	public static IMovieDao getInstance() {
		if(dao == null) dao = new MovieDaoImpl();
		
		return dao;
	}
	
	@Override
	public List<MovieVO> selectAll() throws SQLException {
		return client.queryForList("movie.selectAll");
	}

}
