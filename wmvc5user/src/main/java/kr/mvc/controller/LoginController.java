package kr.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.mvc.model.UserManager;

public class LoginController implements Controller{
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("userid");
		String pwd = request.getParameter("password");
		
		// 모델과 통신
		UserManager manager = UserManager.instance();
		boolean b = manager.login(id, pwd);
		
		ModelAndView modelAndView = new ModelAndView();
		if(b) {
			// 로그인에 성공 자격을 갖춤
			HttpSession session = request.getSession(true);
			session.setAttribute("userid", id);
			modelAndView.setViewName("list.m2");
		}else {
			modelAndView.setViewName("fail.html");
		}
		
		modelAndView.setRedirect(true);
		return modelAndView;
	}
}
