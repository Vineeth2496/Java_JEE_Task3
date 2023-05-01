

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.properties.jdbcCon;

public class InstaAction extends GenericServlet {
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Firstname=request.getParameter("fn");
		String Lastname=request.getParameter("ln");
		String Username=request.getParameter("un");
		String Password=request.getParameter("pass");
		String Gender=request.getParameter("gm");
//		String Gender1=request.getParameter("gf");
//		String Gender2=request.getParameter("go");
		String Email=request.getParameter("e");
		String Country=request.getParameter("c");
		
		//System.out.println(fn+ "" +ln);
		
		
		
		try
		{
	/*		jdbcCon c=new jdbcCon();
			Connection con=c.con();
			System.out.println(con);
	*/	
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "vine96");
			System.out.println(con);		
		
			PreparedStatement ps=con.prepareStatement("insert into jeeinsta values(?,?,?,?,?,?,?)");
			ps.setString(1, Firstname);
			ps.setString(2, Lastname);
			ps.setString(3, Username);
			ps.setString(4, Password);
			ps.setString(5, Gender);
			ps.setString(6, Email);
			ps.setString(7, Country);
			int i=ps.executeUpdate();
		
			PrintWriter out=response.getWriter();
			
			out.println("Account is Registered: "+ i);
			System.out.println("Updated data: "+i);
			
		}
		catch (Exception e1) {
			// TODO: handle exception
		}
	
	}

}
