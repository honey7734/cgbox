package seat.dao;

import java.sql.SQLException;

import cgbox.vo.SeatVO;

/*import vo.SeatVO;*/
public interface ISeatDao {
	
	public int selectSeatNo(SeatVO vo) throws SQLException;
	public SeatVO selectSeatByNo(int sno) throws SQLException;
}
