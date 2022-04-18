package mtheater.dao;

import java.sql.SQLException;
import java.util.List;

import vo.MTheaterVO;

public interface IMTheaterDao {
	
	public List<MTheaterVO> selectAll() throws SQLException;
	
}
