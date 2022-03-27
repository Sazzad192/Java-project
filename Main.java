import javax.swing.*;
import java.awt.*;
public class Main
{
	public static void main(String[] args)
	{	
		LoginGUI login = new LoginGUI();
		login.setVisible(true);
		login.setTitle("login");
		login.setBounds(680,280,100,350);
		login.setResizable(false);
		login.getContentPane().setBackground(Color.YELLOW);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}