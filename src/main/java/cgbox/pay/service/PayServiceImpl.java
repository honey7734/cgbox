package cgbox.pay.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import cgbox.pay.dao.IPayDao;
import cgbox.pay.dao.PayDaoImpl;
import cgbox.vo.MovieInfoVO;
import cgbox.vo.ReserveVO;
import cgbox.vo.ScreenVO;
import cgbox.vo.SeatVO;
import cgbox.vo.TheaterVO;
import cgbox.vo.selectmconVO;

public class PayServiceImpl implements IPayService  {
		private static IPayService service;
		private IPayDao dao;
		private PayServiceImpl() {
			dao = PayDaoImpl.getInstance();
		}
	    public static IPayService getInstance() {
	    	if(service ==null) {
	    		service = new PayServiceImpl();
	    	}
	    	return service;
	    }
	
	
	@Override
	public List<selectmconVO> selectmcon(int customerno) {
	List<selectmconVO> mconlist = null;
	
	try {
		mconlist = dao.selectmcon(customerno);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		return mconlist;
	}
	
	@Override
	public String checkproduct(HashMap<String,Integer> map) {
		String productcnt = null;
		try {
		productcnt = dao.checkproduct(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productcnt;
	}
	@Override
	public int updateproductcount(HashMap<String, Integer> map) {
		int count =0;
		try {
		count =	dao.updateproductcount(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public int insertmcon(HashMap<String, Integer> map) {
		int count =0;
		try {
			count =	dao.insertmcon(map);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return count;
	}
	@Override
	public List<Integer> checkno() {
		List<Integer> list = null;
		try {
		list =	dao.checkno();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int discountprice(int prodno) {
		int price = 0;
		try {
			price = dao.discountprice(prodno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return price;
	}
	@Override
	public List<ReserveVO> selectreserve(int customerno) {
		List<ReserveVO> list =null;
		try {
			list = dao.selectreserve(customerno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public String selectMname(int screenno) {
		String mname = null;
		try {
		mname=	dao.selectMname(screenno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mname;
	}
	@Override
	public TheaterVO selectTinfo(int screenno) {
		TheaterVO vo = null;
		try {
		vo=	dao.selectTinfo(screenno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}
	@Override
	public String getTname(int mtheaterno) {
	    String mtheatername = null;
	    try {
		mtheatername =dao.getTname(mtheaterno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mtheatername;
	}
	@Override
	public SeatVO rowcol(int seatno) {
		// TODO Auto-generated method stub
		SeatVO vo = null;
		try {
		vo=	dao.rowcol(seatno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}
	@Override
	public ScreenVO startend(int screenno) {
		   ScreenVO vo = null;
		   try {
			vo =dao.startend(screenno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}
	@Override
	public List<MovieInfoVO> minfo(int customerno) {
		// TODO Auto-generated method stub
		List<MovieInfoVO> list = null;
		try {
			list = dao.minfo(customerno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list ;
	}

	
}
