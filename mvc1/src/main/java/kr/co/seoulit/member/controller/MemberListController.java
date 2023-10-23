package kr.co.seoulit.member.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.co.seoulit.common.servlet.ModelAndView;
import kr.co.seoulit.common.servlet.mvc.Controller;
import kr.co.seoulit.member.sf.MemberServiceFacade;
import kr.co.seoulit.member.sf.MemberServiceFacadeImpl;
import kr.co.seoulit.member.to.MemberBean;

public class MemberListController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response){
		// TODO Auto-generated method stub
		 String uri=request.getRequestURI();
		 String contextPath=request.getContextPath();
		 String viewName=uri.split("[.]")[0].substring(contextPath.length());
		 // split("[.]") => 정규표현식
		 HashMap<String,Object> map=new HashMap<String,Object>();
		 ModelAndView mav=null;
	 	try {		
			MemberServiceFacade sf=MemberServiceFacadeImpl.getInstance();
			List<MemberBean> list=sf.getMemberList();
	 		 map.put("memberlist", list);
	 		 mav=new ModelAndView(viewName,map);
	 		 map.put("errorCode", 0);
	 		 map.put("errorMsg", "success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
	 		 map.put("errorCode", -1);
	 		 map.put("errorMsg", e.getMessage());
	 		 mav=new ModelAndView("error",map);
		}	
		return mav;
	}
}
