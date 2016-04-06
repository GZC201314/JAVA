import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Modify extends JFrame
{

	private JPanel contentPane;
	private JTextField tname;
	private JTextField tno;
	private JTextField sex;
	private JTextField dept;
	private JTextField title;
	private JTextField tid;

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
					Modify frame = new Modify();
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
	public Modify()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel label = new JLabel("\u6559\u5BA4\u4FE1\u606F\u4FEE\u6539\u754C\u9762");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, label, -119, SpringLayout.EAST, contentPane);
		label.setFont(new Font("宋体", Font.PLAIN, 23));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u6559\u5E08\u540D");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_1, 26, SpringLayout.SOUTH, label);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_1, 131, SpringLayout.WEST, contentPane);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u6559\u5E08\u53F7");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_2, 20, SpringLayout.SOUTH, label_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_2, 0, SpringLayout.WEST, label_1);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u6027\u522B");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_3, 17, SpringLayout.SOUTH, label_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_3, 0, SpringLayout.EAST, label_1);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u5B66\u9662");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_4, 19, SpringLayout.SOUTH, label_3);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_4, 0, SpringLayout.EAST, label_1);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u804C\u79F0");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_5, 21, SpringLayout.SOUTH, label_4);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_5, 0, SpringLayout.EAST, label_1);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_6, 24, SpringLayout.SOUTH, label_5);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_6, 0, SpringLayout.EAST, label_1);
		contentPane.add(label_6);
		
		tname = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, tname, 0, SpringLayout.NORTH, label_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, tname, 30, SpringLayout.EAST, label_1);
		contentPane.add(tname);
		tname.setColumns(20);
		
		tno = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, tno, 0, SpringLayout.NORTH, label_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, tno, 0, SpringLayout.EAST, tname);
		tno.setColumns(20);
		contentPane.add(tno);
		
		sex = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, sex, 0, SpringLayout.NORTH, label_3);
		sl_contentPane.putConstraint(SpringLayout.EAST, sex, 0, SpringLayout.EAST, tname);
		sex.setColumns(20);
		contentPane.add(sex);
		
		dept = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, dept, 0, SpringLayout.NORTH, label_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, dept, 0, SpringLayout.WEST, tname);
		dept.setColumns(20);
		contentPane.add(dept);
		
		title = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, title, 0, SpringLayout.NORTH, label_5);
		sl_contentPane.putConstraint(SpringLayout.WEST, title, 0, SpringLayout.WEST, tname);
		title.setColumns(20);
		contentPane.add(title);
		
		tid = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, tid, 0, SpringLayout.SOUTH, label_6);
		sl_contentPane.putConstraint(SpringLayout.EAST, tid, 0, SpringLayout.EAST, tname);
		tid.setColumns(20);
		contentPane.add(tid);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					
					JOptionPane jo = new JOptionPane();
					String sql1 = "update t set tno ='"+tno.getText()+"',tname='"+tname.getText()+"',tsex='"+sex.getText()+"',deptno='"+dept.getText()+"',title='"+title.getText()+"'," +
							"tid='"+tid.getText()+"' where tno = '"+tno.getText()+"'";
					jo.showMessageDialog(null, sql1);
					Connection conn = createconnection();
					java.sql.Statement sql = conn.createStatement();
					int count = sql.executeUpdate(sql1);
					if(count == 1)
					{
//						JOptionPane jo = new JOptionPane();
						jo.showMessageDialog(null, "信息修改成功");
					}
					else
					{
						jo.showMessageDialog(null, "信息修改失败,请检查输入或者联系管理员");
					}
					
					
				} catch (ClassNotFoundException | SQLException e1)
				{
					JOptionPane jo1 = new JOptionPane();
					jo1.showMessageDialog(null, e1.getMessage());
					// TODO Auto-generated catch block
//					e1.printStackTrace();
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 41, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Modify .this.dispose();
				MainWindow Main = new MainWindow();
				Main.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button_1, 0, SpringLayout.SOUTH, button);
		sl_contentPane.putConstraint(SpringLayout.EAST, button_1, -44, SpringLayout.EAST, contentPane);
		contentPane.add(button_1);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tname, tno, sex, dept, title, tid, button, button_1}));
	}

}
