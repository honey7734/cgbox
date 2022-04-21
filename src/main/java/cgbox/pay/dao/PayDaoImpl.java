package cgbox.pay.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import cgbox.vo.MovieInfoVO;
import cgbox.vo.ReserveVO;
import cgbox.vo.ScreenVO;
import cgbox.vo.SeatVO;
import cgbox.vo.TheaterVO;
import cgbox.vo.selectmconVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

public class PayDaoImpl implements IPayDao{
 

	private static IPayDao dao;
	private SqlMapClient client = SqlMapClientFactory.getSqlMapClient();
    private PayDaoImpl() {
	
     }
  public static IPayDao getInstance() {
	   if(dao == null) {
		   dao = new PayDaoImpl();
	   }
	  return dao;
  }
  

	
	@Override
	public List<selectmconVO> selectmcon(int customerno) throws SQLException {
		 
		return client.queryForList("pay.selectmcon",customerno);
	}
	@Override
	public String checkproduct(HashMap<String,Integer> map) throws SQLException {
		
		return (String) client.queryForObject("pay.checkproduct",map);	}
	
	@Override
	public int updateproductcount(HashMap<String, Integer> map) throws SQLException {
		
		return client.update("pay.updateproductcount",map);
	}
	@Override
	public int insertmcon(HashMap<String, Integer> map) throws SQLException {
		// TODO Auto-generated method stub
		int count =0;
		Object obj = client.insert("pay.insertmcon",map);
		if(obj==null) {
			count =1;
		}
		return count;
	}
	@Override
	public List<Integer> checkno() throws SQLException {
		
		return client.queryForList("pay.checkno");
	}
	@Override
	public int discountprice(int prodno) throws SQLException {
		// TODO Auto-generated method stub
		return (int) client.queryForObject("pay.discountprice",prodno);
	}
	@Override
	public List<ReserveVO> selectreserve(int customerno) throws SQLException {
		// TODO Auto-generated method stub
		return client.queryForList("pay.selectreserve",customerno);
	}
	@Override
	public String selectMname(int screenno) throws SQLException {
		// TODO Auto-generated method stub
		return (String) client.queryForObject("pay.selectMname",screenno);
	}
	@Override
	public TheaterVO selectTinfo(int screenno) throws SQLException {
		// TODO Auto-generated method stub
		return (TheaterVO) client.queryForObject("pay.selectTinfo",screenno);
	}
	@Override
	public String getTname(int mtheaterno) throws SQLException {
		// TODO Auto-generated method stub
		return (String) client.queryForObject("pay.getTname",mtheaterno);
	}
	@Override
	public SeatVO rowcol(int seatno) throws SQLException {
		// TODO Auto-generated method stub
		return (SeatVO) client.queryForObject("pay.rowcol",seatno);
	}
	@Override
	public ScreenVO startend(int screenno) throws SQLException {
		// TODO Auto-generated method stub
		return (ScreenVO) client.queryForObject("pay.startend",screenno);
	}
	
	
	
	
	@Override
	public List<MovieInfoVO> minfo(int customerno) throws SQLException {
		// TODO Auto-generated method stub
		return client.queryForList("pay.minfo",customerno);
	}

	
	
	
	
}
