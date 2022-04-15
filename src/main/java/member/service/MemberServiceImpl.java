package member.service;

import java.sql.SQLException;
import java.util.Map;

import member.dao.IMemberDao;
import member.dao.MemberDaoImpl;
import vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	
	private IMemberDao dao;
	private static IMemberService service;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(service == null) service = new MemberServiceImpl();
		
		return service;
	}
	
	
	@Override
	public MemberVO loginMember(Map<String, String> map){
		MemberVO memvo = null;
		try {
			memvo =  dao.loginMember(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memvo;
	}

}
