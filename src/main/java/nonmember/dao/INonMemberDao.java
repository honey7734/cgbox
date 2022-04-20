package nonmember.dao;

import java.sql.SQLException;

import vo.NonMemberVO;

public interface INonMemberDao {
	
	public void insertNonMember(NonMemberVO vo) throws SQLException;

	public void insertCustomer(int num) throws SQLException;
	
	public int selectMaxCustomer() throws SQLException;

}
