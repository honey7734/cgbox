package cgbox.service;

import java.util.List;

import cgbox.vo.QnAVO;

public interface IQnAService {
	
	
	public List<QnAVO> QnAList();
	
	public int answerQnA(QnAVO vo);
}
