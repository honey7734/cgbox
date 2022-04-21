package seat.service;

import cgbox.vo.SeatVO;

/*import vo.SeatVO;*/

public interface ISeatService {
	
	public int selectSeatNo(SeatVO vo);
	public SeatVO selectSeatByNo(int sno);
}
