package movie.service;

import java.sql.SQLException;
import java.util.List;

import movie.dao.IMovieDao;
import movie.dao.MovieDaoImpl;
import vo.MovieVO;

public class MovieServiceImpl implements IMovieService {
	
	private IMovieDao dao;
	private static IMovieService service;
	private MovieServiceImpl() {
		dao = MovieDaoImpl.getInstance();
	}
	public static IMovieService getInstance() {
		if(service == null) service = new MovieServiceImpl();
		
		return service;
	}
	@Override
	public List<MovieVO> selectAll() {
		List<MovieVO> list = null;
		
		try {
			list = dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
