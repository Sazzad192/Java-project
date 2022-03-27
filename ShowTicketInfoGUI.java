import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class ShowTicketInfoGUI extends JFrame
{
	Connection conn = null;
	ResultSet rs = null;
	Statement st = null;
	 public ShowTicketInfoGUI()
	 {
	 	this.setBounds(400,0,200,5000);
	 	this.setLayout(new FlowLayout());
	 	try
		 {
			 conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bus_service","root","");
			 st = conn.createStatement();
		 }catch (Exception ex)
		 {
			 JOptionPane.showMessageDialog(null,ex.getMessage());
		 }
		 String query="Select * from ticketprice";
		 try{
		 	rs=st.executeQuery(query);
		 }catch(Exception ex)
		 {
		 	System.out.println(ex.getMessage());
		 }
	 	try{
	 		while(rs.next())
	 		{
	 			int num= rs.getInt("ticketId");
	 			JLabel title= new JLabel("Ticket No: "+num);
	 			this.add(title);

	 			String num2= rs.getString("seat");
	 			JLabel title2= new JLabel("Seat No.: "+num2);
	 			this.add(title2);

	 			String num4= rs.getString("payment");
	 			JLabel title4= new JLabel("Payment Method: "+num4);
	 			this.add(title4);


	 			JLabel t= new JLabel("********************************************************");

	 			this.add(t);
	 		}
	 	}catch(Exception ex)
	 	{
	 		System.out.println(ex.getMessage());
	 	}
	 }
}