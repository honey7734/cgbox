package movie.dao;

import java.sql.SQLException;
import java.util.List;

import vo.MovieVO;

public interface IMovieDao {
	
	public List<MovieVO> selectAll() throws SQLException;
	
}
