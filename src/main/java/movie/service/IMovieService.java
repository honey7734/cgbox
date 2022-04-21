package movie.service;

import java.util.List;

import movie.vo.MovieVO;

/*import vo.MovieVO;*/

public interface IMovieService {
	
	public List<MovieVO> selectAll();
	
	public String selectNameByNo(String mno);
	
	//
	
	public int insertMovie(MovieVO vo);
	
	public String selectImg(String movieName);
	
//	public MovieVO selectImg(String movieName);
	
	public List<String> selectMovieName();
}
