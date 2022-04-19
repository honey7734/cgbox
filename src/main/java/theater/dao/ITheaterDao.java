package theater.dao;

import java.sql.SQLException;
import java.util.List;

import vo.TheaterVO;

public interface ITheaterDao {
	
	public List<TheaterVO> selectAllByMtheaterNo(int no) throws SQLException;

}
