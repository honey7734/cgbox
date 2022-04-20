package theater.service;

import java.util.List;

import vo.TheaterVO;

public interface ITheaterService {
	
	public List<TheaterVO> selectAllByMtheaterNo(int no);
	
	public TheaterVO selectAllByTheaterNo(int tno);

	public int selectTheaterNoByScreenNo(int sno);
}
