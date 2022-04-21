package cgbox.pay.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import cgbox.vo.MovieInfoVO;
import cgbox.vo.ReserveVO;
import cgbox.vo.ScreenVO;
import cgbox.vo.SeatVO;
import cgbox.vo.TheaterVO;
import cgbox.vo.selectmconVO;

public interface IPayService {

	public List<selectmconVO> selectmcon(int customerno);
		
	 public String checkproduct (HashMap<String,Integer> map);
		
	    public int updateproductcount(HashMap<String,Integer> map) ;
	
	    public int insertmcon (HashMap<String,Integer> map);
	
	    public List<Integer> checkno ();
	    
	    public int discountprice (int prodno);
	    
	    public List<ReserveVO> selectreserve (int customerno);
	    
	    
	    public String selectMname(int screenno);
	    public TheaterVO  selectTinfo (int screenno);
	    public String getTname(int mtheaterno);
	    
	    public SeatVO rowcol (int seatno);
	    
	    public ScreenVO startend (int screenno);
	    
	    
	    public List<MovieInfoVO> minfo (int customerno) ;
}
