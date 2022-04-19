package theater.service;

import java.sql.SQLException;
import java.util.List;

import theater.dao.ITheaterDao;
import theater.dao.TheaterDaoImpl;
import vo.TheaterVO;

public class TheaterServiceImpl implements ITheaterService{

	private ITheaterDao dao;
	private static ITheaterService service;
	private TheaterServiceImpl() {
		dao = TheaterDaoImpl.getInstance();
	}
	
	public static ITheaterService getInstance() {
		if(service == null) service = new TheaterServiceImpl();
		
		return service;
	}
	@Override
	public List<TheaterVO> selectAllByMtheaterNo(int no) {
		List<TheaterVO> list = null;
		
		try {
			list = dao.selectAllByMtheaterNo(no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
