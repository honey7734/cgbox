package theater.service;

import java.util.List;

import vo.TheaterVO;

public interface ITheaterService {
	
	public List<TheaterVO> selectAllByMtheaterNo(int no);

}
