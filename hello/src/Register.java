import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Register extends JFrame
{

	private JPanel contentPane;
	private JTextField Name;
	private JTextField Password;

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
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the Connection.
	 */
	public Connection createconnection () throws ClassNotFoundException
	{
		String driverName="oracle.jdbc.driver.OracleDriver";  
		String url="jdbc:oracle:thin:@127.0.0.1:1521:gzc";  //test为数据库名称，1521为连接数据库的默认端口  
		String user="system";   //aa为用户名  
		String password="abc123";  //123为密码  
		  
		PreparedStatement pstmt = null;  
		ResultSet rs = null;  
		//frame = new JFrame();
		  
		//数据库连接对象  
//		final Connection conn = null; 
		final Statement sql = null;
		Connection conn = null;
		try
		{
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, password);
			
			//conn.close();
//			JOptionPane jo = new JOptionPane();
//			jo.showMessageDialog(frame, "数据库连接成功");
		} catch (SQLException e2)
		{
			// TODO Auto-generated catch block
			e2.printStackTrace();
			JOptionPane jo1 = new JOptionPane();
			jo1.showMessageDialog(null, e2.getMessage());
		}
		return conn;
	}

	/**
	 * Create the frame.
	 */
	public Register()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel label = new JLabel("\u767B\u9646\u754C\u9762");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 28, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 153, SpringLayout.WEST, contentPane);
		label.setFont(new Font("宋体", Font.PLAIN, 24));
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 27, SpringLayout.SOUTH, label);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 115, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_1, 37, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_1, 0, SpringLayout.WEST, lblNewLabel);
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		contentPane.add(label_1);
		
		Name = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, Name, 0, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, Name, 165, SpringLayout.EAST, lblNewLabel);
		contentPane.add(Name);
		Name.setColumns(10);
		
		Password = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, Name, 0, SpringLayout.WEST, Password);
		sl_contentPane.putConstraint(SpringLayout.WEST, Password, 46, SpringLayout.EAST, label_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, Password, -96, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, Password, 0, SpringLayout.NORTH, label_1);
		Password.setColumns(10);
		contentPane.add(Password);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					Connection conn = createconnection();
					java.sql.Statement sql = conn.createStatement();
					String str = "insert into myuser values('"+Name.getText()+"','"+Password.getText()+"')";
					JOptionPane jo =new JOptionPane();
					jo.showMessageDialog(null, str);
					int num = sql.executeUpdate(str);
					JOptionPane jo1 = new JOptionPane();
					if(num==1)
					{
						
						jo1.showMessageDialog(null, "用户注册成功,可以登录了");
					}
					else
					{
						jo1.showMessageDialog(null, "Sorry,你没有注册成功");
					}
					conn.close();
//					nihao window = new nihao();
					
				} catch (ClassNotFoundException | SQLException e1)
				{
					// TODO Auto-generated catch block
					JOptionPane jo1 = new JOptionPane();
					jo1.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST, Name);
		contentPane.add(button);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801\u4E0D\u8981\u8D85\u8FC718\u4E2A\u5B57\u7B26");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, 8, SpringLayout.SOUTH, label_2);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label_2, -63, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_2, -109, SpringLayout.EAST, contentPane);
		contentPane.add(label_2);
	}
}
