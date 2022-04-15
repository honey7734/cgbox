package member.dao;



import java.sql.SQLException;
import java.util.Map;

import vo.MemberVO;

public interface IMemberDao {

	public MemberVO loginMember(Map<String, String> map) throws SQLException;

}
