import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class LoginGUI extends JFrame implements ActionListener
{
	JTextField uname;
	JPasswordField password;
	JButton login, registration, admin;
	JLabel l, or, c;
	Database db;
	public LoginGUI()
	{
		db = new Database();
		uname = new JTextField(10);
		password = new JPasswordField(10);
		login = new JButton("    Login    ");
		registration = new JButton("    Registration    ");
		admin = new JButton("    Admin    ");

		l=new JLabel("RFN BUS SERVICE");
		l.setFont(new Font("Times New Roman", Font.BOLD,16));
		l.setBounds(140,0,100,30);
		l.setForeground (Color.BLUE);
		c=new JLabel("                                  Since 2019");
		c.setFont(new Font("Elephant", Font.ITALIC,10));
		c.setBounds(140,0,100,30);
		c.setForeground (Color.BLACK);

		this.add(l);
		this.add(c);
		this.add(new JLabel("Username: "));
		this.add(uname);
		this.add(new JLabel("Password: "));
		this.add(password);
		this.add(login);
		or=new JLabel("        Or        ");
		or.setBounds(140,0,100,30);
		this.add(or);
		this.add(registration);
		or=new JLabel("        Or        ");
		or.setBounds(220,0,100,30);
		this.add(or);
		this.add(admin);
		login.addActionListener(this);
		registration.addActionListener(this);
		admin.addActionListener(this);
		this.setSize(260,260);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent ev)
	{
		if(ev.getSource().equals(login))
		{
			if(validateField())
			{
				User user=new User(uname.getText(),new String(password.getPassword()));
				if(db.validateUser(user))
				{
					BusScheduleGUI busschedule = new BusScheduleGUI();
					busschedule.setVisible(true);
					busschedule.setBounds(680,280,100,280);
					busschedule.setResizable(false);
					busschedule.setTitle("busschedule");
					busschedule.getContentPane().setBackground(Color.GREEN);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Provided information is not valid");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Please provide valid information");
			}
		}
		else if(ev.getSource().equals(registration))
		{
			RegistrationGUI reg = new RegistrationGUI();
			reg.setVisible(true);
			reg.setTitle("registration");
			reg.setBounds(680,280,240,300);
			reg.setResizable(false);
			reg.getContentPane().setBackground(Color.PINK);
			reg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		}
		else if(ev.getSource().equals(admin))
		{
			AdminGUI admin=new AdminGUI();
			admin.setVisible(true);
			admin.setTitle("admin");
			admin.setBounds(680,280,235,200);
			admin.setResizable(false);
			admin.getContentPane().setBackground(Color.WHITE);
			admin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		}
	}
	
	boolean validateField()
	{
		boolean result = true;
		if (uname.getText()== null || password.getText() == null || uname.getText().equals("") || new String(password.getPassword()).equals(""))
			result = false;
		return result;
	}
}