package kr.co.seoulit.member.controller;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.co.seoulit.common.servlet.ModelAndView;
import kr.co.seoulit.common.servlet.mvc.Controller;
import kr.co.seoulit.member.sf.MemberServiceFacade;
import kr.co.seoulit.member.sf.MemberServiceFacadeImpl;
import kr.co.seoulit.member.to.MemberBean;
import net.sf.json.JSONObject;

public class MemberAjaxListController implements Controller {
	
	@Override
 	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response){
		// TODO Auto-generated method stub
		 HashMap<String,Object> map=new HashMap<String,Object>();
		 
	 	try {		
			MemberServiceFacade sf=MemberServiceFacadeImpl.getInstance();
			List<MemberBean> list=sf.getMemberList();
	 		 map.put("memberlist", list);
	 		 map.put("errorCode", 0);
	 		 map.put("errorMsg", "success");
	 		 PrintWriter out=response.getWriter();
	 		 JSONObject json=JSONObject.fromObject(map);
	 		 out.print(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
	 		 map.put("errorCode", -1);
	 		 map.put("errorMsg", e.getMessage());
	 		 try {
	 			 PrintWriter out=response.getWriter();
		 		 JSONObject json=JSONObject.fromObject(map);
		 		 out.print(json);
	 		 }catch (Exception e1) {
	 			 e1.printStackTrace();
	 		 }
		}	
		return null;
	}
}
