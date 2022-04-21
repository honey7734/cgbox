package movie.dao;

import java.sql.SQLException;
import java.util.List;

import movie.vo.MovieVO;

/*import vo.MovieVO;*/

public interface IMovieDao {
	
	public List<MovieVO> selectAll() throws SQLException;
	
	public String selectNameByNo(String mno) throws SQLException;
	
	//
	
	public int insertMovie(MovieVO vo);
	
	public String selectImg(String movieName);
	
//	public MovieVO selectImg(String movieName);
	
	public List<String> selectMovieName();
}
