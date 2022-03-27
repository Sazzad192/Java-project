import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminGUI extends JFrame implements ActionListener
{
	JTextField adminName;
	JPasswordField adminPassword;
	JButton go;
	JLabel l;

	Database db;

	public AdminGUI()
	{
		db=new Database();

		adminName=new JTextField(10);
		adminPassword=new JPasswordField(10);
		go=new JButton("Go");

		this.setLayout(new FlowLayout());
		l=new JLabel("Welcome to Admin Panel");
		l.setFont(new Font("Times New Roman", Font.BOLD,16));
		l.setBounds(140,0,100,30);
		l.setForeground (Color.RED);
		this.add(l);
		this.add(new JLabel("    Username: "));
		this.add(adminName);
		this.add(new JLabel("      Password: "));
		this.add(adminPassword);
		this.add(go);

		go.addActionListener(this);

		this.setSize(260,260);
		this.setLayout(new FlowLayout());
	}

	public void actionPerformed(ActionEvent a)
	 {
	 	if(a.getSource().equals(go))
	 	{
			if(validateField())
			{
				Admin admin=new Admin(adminName.getText(),new String(adminPassword.getPassword()));
				if(db.validateAdmin(admin))
				{
					AdminInfoGUI info=new AdminInfoGUI();
					info.setVisible(true);
					info.setBounds(680,280,110,200);
					info.setResizable(false);
					info.setDefaultCloseOperation(AdminGUI.EXIT_ON_CLOSE);
					info.setTitle("adminGUI");
					info.getContentPane().setBackground(Color.ORANGE);
					info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Info");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Provide Valid Info");
			}
		}
	 }

	boolean validateField()
	{
		boolean result=true;

		if(adminName.getText()==null || adminPassword.getText()==null || adminName.getText().equals("") || new String(adminPassword.getPassword()).equals(""))
		{
			result=false;
		}
		return result;
	}
}