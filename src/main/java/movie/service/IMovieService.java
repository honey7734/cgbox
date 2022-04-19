package movie.service;

import java.util.List;

import vo.MovieVO;

public interface IMovieService {
	
	public List<MovieVO> selectAll();
	
}
