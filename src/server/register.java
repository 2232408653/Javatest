package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

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
	//res.setHeader("Access-Control-Allow-Origin", "*");
	res.addHeader("Access-Control-Allow-Origin", "*");
	res.addHeader("Access-Control-Allow-Method", "*");
	res.addHeader("Access-Control-Allow-Headers","Content-Type");
	res.addHeader("Access-Control-Max-Age", "3600");
	req.setCharacterEncoding("UTF-8");
	res.setCharacterEncoding("utf-8");
	res.setContentType("application/json;charset:utf-8");
	PrintWriter pw=res.getWriter();
	Map map = req.getParameterMap();
	System.out.println(map.isEmpty());
	String uname=req.getParameter("uname");
	String upwd=req.getParameter("upwd");
	String upower=req.getParameter("upower");
	String upass=req.getParameter("upass");
	UserInfo u=new UserInfo(uname,upwd,upower,upass);
	System.out.println(u.toString());
	System.out.println(uname);
	UserDao userdao=new UserDao();
	UserInfo user=null;
	//user=userdao.selectByuname(uname);
	int i =userdao.insertUserInfo(u);
	if(i==1) {
		pw.print("ok");
	}else {
		pw.print("wrong");
	}
	//System.out.println(req.getRequestURL());
	//System.out.println(req.getRemoteAddr());
}

}
