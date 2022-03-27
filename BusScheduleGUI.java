import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BusScheduleGUI extends JFrame
{
	Database db;
	public BusScheduleGUI ()
	{
		db = new Database();
		
		//labels
		JLabel labelFrom = new JLabel("From: ");
		JLabel labelTo = new JLabel("    To: ");
		JLabel labelDate = new JLabel("      Date: ");
		JLabel labelMonth = new JLabel("     Month: ");
		JLabel labelYear = new JLabel("      Year: ");
		JLabel labelTime = new JLabel("      Time:");
		
		//input components
		JTextField date = new JTextField(10);
		JTextField time = new JTextField(10);
		
		String placeList[] = {"Dhaka(Kuril)","Chittagong", "Sylhet", "Coxs-Bazar", "Rajshahi", "Barishal", "Khulna", "Rangamati"};
		String dateList[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		String monthList[] = {"Jan","Feb", "Mar","Apr","May", "Jun","Jul","Aug", "Sep","Oct","Nov", "Dec"};
		String yearList[] = {"2019","2020","2021","2022","2023","2024","2025"};
		String timeList[] = {"09.00 AM","03.00 PM", "09.00 PM"};
		JComboBox startFrom = new JComboBox(placeList);		
		JComboBox stopTo = new JComboBox(placeList);
		JComboBox startDate = new JComboBox(dateList);
		JComboBox startMonth = new JComboBox(monthList);
		JComboBox startYear = new JComboBox(yearList);
		JComboBox startTime = new JComboBox(timeList);
		JButton check = new JButton("Check");
		
		//adding the components
		this.setLayout(new FlowLayout());
		this.add(labelFrom);
		this.add(startFrom);
		this.add(labelTo);
		this.add(stopTo);
		this.add(labelDate);
		this.add(startDate);
		this.add(labelMonth);
		this.add(startMonth);
		this.add(labelYear);
		this.add(startYear);
		this.add(labelTime);
		this.add(startTime);
		this.add(check);
		
		
		check.addActionListener
		(
		new ActionListener ()
		{
			public void actionPerformed(ActionEvent e)
			{
				BusSchedule busschedule = new BusSchedule();
				
				busschedule.from = startFrom.getSelectedItem().toString();
				busschedule.to = stopTo.getSelectedItem().toString();
				busschedule.date = startDate.getSelectedItem().toString();
				busschedule.month = startMonth.getSelectedItem().toString();
				busschedule.year = startYear.getSelectedItem().toString();
				busschedule.time = startTime.getSelectedItem().toString();
				
				db.checkUser(busschedule);
				if(e.getSource().equals(check))
				{
					TicketPriceGUI tckt=new TicketPriceGUI();
					tckt.setVisible(true);
					tckt.setBounds(680,280,110,200);
					tckt.setResizable(false);
					tckt.setTitle("TicketPriceGUI");
					tckt.getContentPane().setBackground(Color.RED);
					tckt.setDefaultCloseOperation(AdminGUI.EXIT_ON_CLOSE);
				}
			}
		}
		);
	}
}