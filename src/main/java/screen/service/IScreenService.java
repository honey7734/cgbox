package screen.service;

import java.util.List;

import vo.ScreenVO;

public interface IScreenService {
	
	public List<ScreenVO> selectScreenList(ScreenVO vo);
	
}
