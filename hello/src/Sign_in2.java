import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Sign_in2 extends JFrame
{

	private JPanel contentPane;
	private JTextField uname;
	private JPasswordField pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Sign_in frame = new Sign_in();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sign_in2()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("\u7BA1\u7406\u5458\u767B\u9646\u754C\u9762");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 114, SpringLayout.WEST, contentPane);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 23));
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setFont(new Font("宋体", Font.PLAIN, 17));
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 30, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 81, SpringLayout.WEST, contentPane);
		contentPane.add(label);
		
		uname = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, uname, 0, SpringLayout.NORTH, label);
		sl_contentPane.putConstraint(SpringLayout.WEST, uname, 26, SpringLayout.EAST, label);
		contentPane.add(uname);
		uname.setColumns(20);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_1, 33, SpringLayout.SOUTH, label);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_1, 0, SpringLayout.WEST, label);
		label_1.setFont(new Font("宋体", Font.PLAIN, 17));
		contentPane.add(label_1);
		
		pwd = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.EAST, uname, 0, SpringLayout.EAST, pwd);
		sl_contentPane.putConstraint(SpringLayout.WEST, pwd, 43, SpringLayout.EAST, label_1);
		pwd.setFont(new Font("宋体", Font.PLAIN, 12));
		pwd.setColumns(20);
		sl_contentPane.putConstraint(SpringLayout.NORTH, pwd, 0, SpringLayout.NORTH, label_1);
		contentPane.add(pwd);
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					Connection conn = nihao.createconnection();
					java.sql.Statement sql = conn.createStatement();
					String psw = new String(pwd.getPassword());
//					JOptionPane jo1 = new JOptionPane();
//					jo1.showMessageDialog(null, psw);
					ResultSet rs = sql.executeQuery("select count(*) from myuser where uname='"+uname.getText()+"' and upsw='"+psw+"'");
					int num =
					0;
					while(rs.next())
						num = rs.getInt(1);
//					while(rs)
//					jo1.showMessageDialog(null, num);
					if(num ==0)
					{
						JOptionPane jo = new JOptionPane();
						jo.showMessageDialog(null, "该用户没有找到,请检查输入");
					}
					if(num ==1)
					{
						Sign_in2.this.dispose();
						Updata_room adduser = new Updata_room();
						adduser.setVisible(true);
					}
				} catch (ClassNotFoundException | SQLException e1)
				{
					JOptionPane jo = new JOptionPane();
					jo.showMessageDialog(null, e1.getMessage());
					// TODO Auto-generated catch block
//					e1.printStackTrace();
				} 
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSignIn, 44, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnSignIn, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnSignIn);
		
		JButton button = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sign_in2.this.dispose();
				MainWindow Main = new MainWindow();
				Main.setVisible(true);
//				Sign_in signin = new Sign_in();
//				signin.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 91, SpringLayout.EAST, btnSignIn);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button, 0, SpringLayout.SOUTH, btnSignIn);
		contentPane.add(button);
	}
}
