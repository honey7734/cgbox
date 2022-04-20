package seat.dao;

import java.sql.SQLException;

import vo.SeatVO;

public interface ISeatDao {
	
	public int selectSeatNo(SeatVO vo) throws SQLException;
	
}
