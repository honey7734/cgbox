package seat.service;

import java.sql.SQLException;

import seat.dao.ISeatDao;
import seat.dao.SeatDaoImpl;
import vo.SeatVO;

public class SeatServiceImpl implements ISeatService {
	private ISeatDao dao;
	private static ISeatService service;
	private SeatServiceImpl() {
		dao = SeatDaoImpl.getInstance();
	}
	public static ISeatService getInstance() {
		if(service == null) service = new SeatServiceImpl();
		
		return service;
	}
	
	@Override
	public int selectSeatNo(SeatVO vo) {
		int result = 0;
		
		try {
			result = dao.selectSeatNo(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

}
