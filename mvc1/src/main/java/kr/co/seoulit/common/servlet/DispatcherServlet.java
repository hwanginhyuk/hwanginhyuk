package kr.co.seoulit.common.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.seoulit.common.servlet.context.ApplicationContext;
import kr.co.seoulit.common.servlet.mapper.SimpleUrlHandlerMapping;
import kr.co.seoulit.common.servlet.mvc.Controller;
import kr.co.seoulit.common.servlet.view.InternalResourceViewResolver;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private ApplicationContext applicationContext;
	private SimpleUrlHandlerMapping simpleUrlHandlerMapping;
	private InternalResourceViewResolver internalResourceViewResolver;
    /**
     * Default constructor. 
     */
    public DispatcherServlet() {
        // TODO Auto-generated constructor stub
    }

    
    
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		ServletContext application=this.getServletContext();
		applicationContext=new ApplicationContext(config,application);
		simpleUrlHandlerMapping=SimpleUrlHandlerMapping.getInstance(application);
		internalResourceViewResolver=InternalResourceViewResolver.getInstance(application);
	}




	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		Controller controller=simpleUrlHandlerMapping.getController(applicationContext,request);
		ModelAndView modelAndView=controller.handleRequest(request,response);
		if(modelAndView!=null)
			internalResourceViewResolver.resolveView(modelAndView,request,response);	
	}
}
