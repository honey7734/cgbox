package nonmember.service;


import vo.NonMemberVO;

public interface INonMemberService {
	
	public int insertNonMember(NonMemberVO vo);
	
	public void insertCustomer(int num);
	
	public int selectMaxCustomer();
}
