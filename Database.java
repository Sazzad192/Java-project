import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class Database
{
	 Connection conn = null;
	 ResultSet rs = null;
	 Statement st = null;
	 
	 public Database()
	 {
		 try
		 {
			 conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bus_service","root","");
			 st = conn.createStatement();
		 }catch (Exception ex)
		 {
			 JOptionPane.showMessageDialog(null,ex.getMessage());
		 }
	 }

	 //REGISTRATION Task
	 public void registerUser(User user)
	 {
		String query = "INSERT INTO `user` (`userid`, `username`, `password`, `email`, `phone`) VALUES (NULL, '"+user.username+"', '"+user.password+"', '"+user.email+"', '"+user.phone+"');";
		try
		{
			st.executeUpdate(query);
			
		}catch (Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	 }
	 
	//BUS_SCHEDULE Task
	public void checkUser(BusSchedule busschedule)
	 {
		String query = "INSERT INTO `busschedule` (`busId`, `startFrom`, `stopTo`, `date`, `startMonth`, `startYear`, `time`) VALUES (NULL, '"+busschedule.from+"', '"+busschedule.to+"', "+busschedule.date+", '"+busschedule.month+"', '"+busschedule.year+"', '"+busschedule.time+"');";
		try
		{
			st.executeUpdate(query);
			
		}catch (Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	 }


	 //TICKET_PRICE Task
	 public void checkUser(TicketPrice ticketprice)
	 {
		String query = "INSERT INTO `ticketprice` (`ticketId`, `seat`, `payment`) VALUES (NULL, '"+ticketprice.seats+"', '"+ticketprice.payments+"');";
		try
		{
			st.executeUpdate(query);
			
		}catch (Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	 }

	 // CHECK_USER Task
	 public boolean validateUser(User user)
	 {
		 String query = "select password from user where username='"+user.username+"'";
		 try
		 {
			rs = st.executeQuery(query);
			while (rs.next())
			{
				if (rs.getString("password").equals(user.password))
				{
					return true;
				}
			}
		 }catch(Exception ex)
		 {
			 JOptionPane.showMessageDialog(null, ex.getMessage());
		 }
		 return false;
	 }

	 //CHECK_ADMIN Task
	 public boolean validateAdmin(Admin admin)
	 {
		 String query = "select adminPassword from admin where adminName='"+admin.adminName+"'";
		 try
		 {
			rs = st.executeQuery(query);
			while (rs.next())
			{
				if (rs.getString("adminPassword").equals(admin.adminPassword))
				{
					return true;
				}
			}
		 }catch(Exception ex)
		 {
			 JOptionPane.showMessageDialog(null, ex.getMessage());
		 }
		 return false;
	 }
}