package movie.service;

import java.sql.SQLException;
import java.util.List;

import movie.dao.IMovieDao;
import movie.dao.MovieDaoImpl;
/*import vo.MovieVO;*/
import movie.vo.MovieVO;

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
	
	@Override
	public String selectNameByNo(String mno) {
		String result = null;
		
		try {
			result = dao.selectNameByNo(mno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int insertMovie(MovieVO vo) {
		// TODO Auto-generated method stub
		return dao.insertMovie(vo);
	}

	@Override
	public List<String> selectMovieName() {
		// TODO Auto-generated method stub
		return dao.selectMovieName();
	}

//	@Override
//	public MovieVO selectImg(String movieName) {
//		// TODO Auto-generated method stub
//		return dao.selectImg(movieName);
//	}

	@Override
	public String selectImg(String movieName) {
		// TODO Auto-generated method stub
		return dao.selectImg(movieName);
	}
}
