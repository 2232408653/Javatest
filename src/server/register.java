package server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import eneity.UserInfo;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	res.setHeader("Access-Control-Allow-Origin", "*");
	req.setCharacterEncoding("UTF-8");
	res.setCharacterEncoding("utf-8");
	res.setContentType("application/json;charset:utf-8");
	PrintWriter pw=res.getWriter();
	String uname=req.getParameterMap().toString();
	System.out.println(uname);
	UserDao userdao=new UserDao();
	UserInfo user=null;
	user=userdao.selectByuname(uname);
	if(user!=null) {
		pw.print("yes");
	}else {
		pw.print("no");
	}
	//System.out.println(req.getRequestURL());
	//System.out.println(req.getRemoteAddr());
}

}
