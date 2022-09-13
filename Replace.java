package com.Exchange;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Replace")
public class Replace extends HttpServlet{
	 public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	 String uname=req.getParameter("username");
    	  
    	    String givenright=req.getParameter("givenright");
    	    String givenleft=req.getParameter("givenleft");
    	    String toleft=req.getParameter("toleft");
    	    String toright=req.getParameter("toright");
    	    String para=req.getParameter("givenstring");
    	    for (int i = 0; i < para.length();i++) {
                if(para.charAt(i)==givenleft.charAt(0)){
                  para= para.replace(givenleft.charAt(0), toleft.charAt(0));
//                   System.out.println(para);
                   i++;
                }
                if(i==para.length()){
                          break;
                }
                if (para.charAt(i) == givenright.charAt(0)) {
                        para = para.replace(givenright.charAt(0), toright.charAt(0));
//                          System.out.println(para);
                          
                }
               }
    	    HttpSession session= req.getSession();
 		   session.setAttribute("uname", uname);
 		   session.setAttribute("string", para);
 	//	   System.out.println(session.getAttribute("upass")+""+session.getAttribute("uname"));
// 		   System.out.println(para);
 		   RequestDispatcher rd= req.getRequestDispatcher("Front.jsp");
 		   rd.forward(req, res);
    	   
	 }
    	
}
