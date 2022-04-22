package cgbox.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import cgbox.vo.QnAVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

public class QnADaoImpl implements IQnADao {

	private SqlMapClient client;
	private static IQnADao dao;
	private QnADaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	public static IQnADao getInstance() {
		if(dao==null) dao = new QnADaoImpl();
		return dao;
	}
	@Override
	public List<QnAVO> QnAList() throws SQLException {
		// TODO Auto-generated method stub
		return client.queryForList("QnA.QnAList");
	}
	@Override
	public int answerQnA(QnAVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return (int)client.update("QnA.answerQnA", vo);
	}
}
