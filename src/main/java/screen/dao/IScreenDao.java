package screen.dao;

import java.sql.SQLException;
import java.util.List;

import vo.ScreenVO;

public interface IScreenDao {
	
	public List<ScreenVO> selectScreenList(ScreenVO vo) throws SQLException;

}
