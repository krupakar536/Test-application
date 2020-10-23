package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Login_DAO;
import Model.Login_Model;

/**
 * Servlet implementation class Login_Controller
 */
@WebServlet("/Login_Controller")
public class Login_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String username=request.getParameter("user");
		String password=request.getParameter("pass");
		
		Login_Model lm=new Login_Model();
		
		lm.setUsername(username);
		lm.setPassword(password);
		
		Login_DAO ld=new Login_DAO();
		
		try
		{
			boolean status=false;
			status=ld.login(lm);
			if(status)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Homepage.jsp");
				rd.forward(request, response);
			}
			
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('incorrect username or password...!');");
				out.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			}
		}
		catch(SQLException e)
		{
			out.println(e);
		}
		catch(ClassNotFoundException e)
		{
			out.println(e);
		}
	}

}
