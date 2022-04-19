package screen.service;

import java.sql.SQLException;
import java.util.List;

import screen.dao.IScreenDao;
import screen.dao.ScreenDaoImpl;
import vo.ScreenVO;

public class ScreenServiceImpl implements IScreenService {

	private IScreenDao dao;
	private static IScreenService service;
	private ScreenServiceImpl() {
		dao = ScreenDaoImpl.getInstance();
	}
	public static IScreenService getInstance() {
		if(service == null) service = new ScreenServiceImpl();
		
		return service;
	}
	
	@Override
	public List<ScreenVO> selectScreenList(ScreenVO vo) {
		List<ScreenVO> list = null;
		
		try {
			list = dao.selectScreenList(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
