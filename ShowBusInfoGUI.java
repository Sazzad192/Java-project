import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class ShowBusInfoGUI extends JFrame
{
	Connection conn = null;
	ResultSet rs = null;
	Statement st = null;
	 public ShowBusInfoGUI()
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
		 String query="Select * from busschedule";
		 try{
		 	rs=st.executeQuery(query);
		 }catch(Exception ex)
		 {
		 	System.out.println(ex.getMessage());
		 }
	 	try{
	 		while(rs.next())
	 		{
	 			int num= rs.getInt("busId");
	 			JLabel title= new JLabel("Bus No: "+num);
	 			this.add(title);

	 			String num2= rs.getString("startFrom");
	 			JLabel title2= new JLabel("Pick-Up Point: "+num2);
	 			this.add(title2);

	 			String num4= rs.getString("stopTo");
	 			JLabel title4= new JLabel("Destination: "+num4);
	 			this.add(title4);

	 			String num5= rs.getString("date");
	 			JLabel title5= new JLabel("Date: "+num5);
	 			this.add(title5);

	 			String num7= rs.getString("startMonth");
	 			JLabel title7= new JLabel("Month: "+num7);
	 			this.add(title7);

	 			String num8= rs.getString("startYear");
	 			JLabel title8= new JLabel("Year: "+num8);
	 			this.add(title8);

	 			String num6= rs.getString("time");
	 			JLabel title6= new JLabel("Time: "+num6);
	 			this.add(title6);

	 			JLabel t= new JLabel("********************************************************");

	 			this.add(t);
	 		}
	 	}catch(Exception ex)
	 	{
	 		System.out.println(ex.getMessage());
	 	}
	 }
}