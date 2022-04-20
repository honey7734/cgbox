package reserve.dao;

import java.sql.SQLException;

import vo.ReserveVO;

public interface IReserveDao {
	
	public void insertNew(ReserveVO vo) throws SQLException;
	
}
