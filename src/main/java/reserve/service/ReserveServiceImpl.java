package reserve.service;

import java.sql.SQLException;

import reserve.dao.IReserveDao;
import reserve.dao.ReserveDaoImpl;
import vo.ReserveVO;

public class ReserveServiceImpl implements IReserveService {
	
	private IReserveDao dao;
	private static IReserveService service;
	private ReserveServiceImpl() {
		dao = ReserveDaoImpl.getInstance();
	}
	public static IReserveService getInstance() {
		if(service == null) service = new ReserveServiceImpl();
		
		return service;
	}
	
	@Override
	public void insertNew(ReserveVO vo) {
		try {
			dao.insertNew(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
