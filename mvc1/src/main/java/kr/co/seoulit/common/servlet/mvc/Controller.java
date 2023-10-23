package kr.co.seoulit.common.servlet.mvc;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.seoulit.common.servlet.ModelAndView;

public interface Controller {
	ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)throws IOException;
}
