import java.awt.EventQueue;

import javax.swing.DefaultDesktopManager;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import com.ibm.icu.text.SimpleDateFormat;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JComboBox;
import java.awt.TextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.JobAttributes;
import java.awt.Window;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.Font;
import javax.swing.SpringLayout;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class nihao
{
	private JDesktopPane desk;

	private static JFrame frame;
	private JLabel lblNewLabel;
	private JTextField counter;
	private JPasswordField passwordField;

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
					nihao window = new nihao();

					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ClassNotFoundException 
	 */
	public nihao() throws ClassNotFoundException
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 * 
	 * @throws SQLException
	 */
	static String getCurrenTime() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH");
		return sdf.format(d);
	}
	
	
	static Connection createconnection () throws ClassNotFoundException
	{
		String driverName="oracle.jdbc.driver.OracleDriver";  
		String url="jdbc:oracle:thin:@127.0.0.1:1521:gzc";  //test为数据库名称，1521为连接数据库的默认端口  
		String user="system";   //aa为用户名  
		String password="abc123";  //123为密码  
		  
		PreparedStatement pstmt = null;  
		ResultSet rs = null;  
		frame = new JFrame();
		  
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
			jo1.showMessageDialog(frame, e2.getMessage());
		}
		return conn;
	}
	private void initialize() throws ClassNotFoundException
	{
		String driverName="oracle.jdbc.driver.OracleDriver";  
		String url="jdbc:oracle:thin:@127.0.0.1:1521:gzc";  //test为数据库名称，1521为连接数据库的默认端口  
		String user="system";   //aa为用户名  
		String password="abc123";  //123为密码  
		  
		PreparedStatement pstmt = null;  
		ResultSet rs = null;  
		frame = new JFrame();
		  
		//数据库连接对象  
//		final Connection conn = null; 
		final Statement sql = null;
		try
		{
			Class.forName(driverName);
			final Connection conn = DriverManager.getConnection(url, user, password);
			conn.close();
			JOptionPane jo = new JOptionPane();
			jo.showMessageDialog(frame, "数据库连接成功");
		} catch (SQLException e2)
		{
			// TODO Auto-generated catch block
			e2.printStackTrace();
			JOptionPane jo1 = new JOptionPane();
			jo1.showMessageDialog(frame, e2.getMessage());
		}
//			JOptionPane jo = new JOptionPane();
//			jo.showMessageDialog(null, "12连接数据库失败");
//		desk = new JDesktopPane();
//		desk.setDesktopManager(new DefaultDesktopManager());
		
		frame.getContentPane().setBackground(new Color(204, 153, 204));
		frame.getContentPane().setFont(new Font("宋体", Font.PLAIN, 8));
		frame.setBounds(100, 100, 572, 342);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lblNewLabel = new JLabel("\u6B22\u8FCE\u767B\u9646");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 23));
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 5,
				SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 214,
				SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().setLayout(springLayout);
		frame.getContentPane().add(lblNewLabel);

		JLabel Namelable = new JLabel("\u8D26\u6237");
		springLayout.putConstraint(SpringLayout.NORTH, Namelable, 60,
				SpringLayout.SOUTH, lblNewLabel);
		Namelable.setFont(new Font("宋体", Font.PLAIN, 18));
		frame.getContentPane().add(Namelable);

		counter = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, counter, 345,
				SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, Namelable, -18,
				SpringLayout.WEST, counter);
		springLayout.putConstraint(SpringLayout.NORTH, counter, 0,
				SpringLayout.NORTH, Namelable);
		springLayout.putConstraint(SpringLayout.EAST, counter, -103,
				SpringLayout.EAST, frame.getContentPane());
		counter.setFont(new Font("宋体", Font.PLAIN, 15));
		frame.getContentPane().add(counter);
		counter.setColumns(10);

		JLabel mima = new JLabel("\u5BC6\u7801");
		springLayout.putConstraint(SpringLayout.NORTH, mima, 40,
				SpringLayout.SOUTH, Namelable);
		springLayout.putConstraint(SpringLayout.EAST, mima, 0,
				SpringLayout.EAST, Namelable);
		mima.setFont(new Font("宋体", Font.PLAIN, 18));
		frame.getContentPane().add(mima);

		passwordField = new JPasswordField(18);
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, 2,
				SpringLayout.NORTH, mima);
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 345,
				SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, passwordField, -128,
				SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, passwordField, 0,
				SpringLayout.EAST, counter);
		frame.getContentPane().add(passwordField);

		JButton load = new JButton("\u767B\u5F55");
		load.addMouseListener(new MouseAdapter()
		{
			// 登录确定
			@Override
			public void mouseClicked(MouseEvent e)
			{
				try
				{
					Connection conn = createconnection();
					java.sql.Statement sql = conn.createStatement();
					ResultSet rs = sql.executeQuery("select * from myuser");
					FileOutputStream fos = new FileOutputStream(new File("test.txt"));
					String password = new String(passwordField.getPassword());
//					String str = rs.getString(1)+rs.getString(2);
//					byte[] arr = str.getBytes();
//					fos.write(arr);
					while(rs.next())
					{
						
						//byte[] arr = str.getBytes();
						//fos.write(arr);
						if(counter.getText().equals(rs.getString(1))&& 
								password.equals(rs.getString(2)))
						{
							String str = rs.getString(1)+rs.getString(2);
							byte[] arr = str.getBytes();
							fos.write(arr);
							JOptionPane jo =new JOptionPane();
							jo.showMessageDialog(null, "用户已找到,登陆成功");
							
							conn.close();
							nihao.this.frame.dispose();
							MainWindow Main = new MainWindow();
							Main.setVisible(true);
							//添加
							
							break;
						}

							
					}
//					if(rs.next()==false)
//					{
//						JOptionPane jo = new JOptionPane();
//						jo.showMessageDialog(null, "当前找不到你的用户信息,请联系管理员");
//					}
				} catch (ClassNotFoundException | SQLException | IOException e1)
				{
					JOptionPane jo =new JOptionPane();
					jo.showMessageDialog(null, e1.getMessage());
					// TODO Auto-generated catch block
//					e1.printStackTrace();
				}
				
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, load, 48,
				SpringLayout.SOUTH, mima);
		springLayout.putConstraint(SpringLayout.SOUTH, load, 82,
				SpringLayout.SOUTH, mima);
		springLayout.putConstraint(SpringLayout.EAST, load, -229,
				SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(load);

		JButton NewUser = new JButton("\u6CE8\u518C");
		NewUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Register rir = new Register();
				rir.setVisible(true);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, NewUser, 0,
				SpringLayout.NORTH, load);
		springLayout.putConstraint(SpringLayout.WEST, NewUser, 76,
				SpringLayout.EAST, load);
		springLayout.putConstraint(SpringLayout.SOUTH, NewUser, 0,
				SpringLayout.SOUTH, load);
		frame.getContentPane().add(NewUser);
		frame.getContentPane().setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[]
				{ counter }));
	}
}
