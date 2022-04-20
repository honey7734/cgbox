package theater.dao;

import java.sql.SQLException;
import java.util.List;

import vo.TheaterVO;

public interface ITheaterDao {
	
	public List<TheaterVO> selectAllByMtheaterNo(int no) throws SQLException;
	
	public TheaterVO selectAllByTheaterNo(int tno) throws SQLException;

	public int selectTheaterNoByScreenNo(int sno) throws SQLException;

}
