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
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Course extends JFrame
{

	private JPanel contentPane;
	private JTextField cname;
	private JTextField tname;
	private JTable table;

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
					Course frame = new Course();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	
	public Connection createconnection () throws ClassNotFoundException
	{
		String driverName="oracle.jdbc.driver.OracleDriver";  
		String url="jdbc:oracle:thin:@127.0.0.1:1521:gzc";  //test为数据库名称，1521为连接数据库的默认端口  
		String user="system";   //aa为用户名  
		String password="abc123";  //123为密码  
		  
		PreparedStatement pstmt = null;  
//		ResultSet rs = null;  
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
	public Course()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("\u8BFE\u7A0B\u67E5\u8BE2\u754C\u9762");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 190, SpringLayout.WEST, contentPane);
		lblNewLabel.setFont(new Font("华文新魏", Font.BOLD | Font.ITALIC, 23));
		contentPane.add(lblNewLabel);
		
		cname = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, cname, 85, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, cname, 55, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, cname, 173, SpringLayout.WEST, contentPane);
		contentPane.add(cname);
		cname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u5728\u6B64\u8F93\u5165\u8BFE\u7A0B\u540D");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 65, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -20, SpringLayout.NORTH, cname);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BFE\u7A0B\u7ED3\u679C\u8F93\u51FA");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 145, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u8BF7\u8F93\u5165\u4F60\u7684\u4EFB\u8BFE\u8001\u5E08\u540D");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 0, SpringLayout.NORTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 85, SpringLayout.EAST, lblNewLabel_1);
		contentPane.add(lblNewLabel_3);
		
		tname = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, tname, 0, SpringLayout.NORTH, cname);
		sl_contentPane.putConstraint(SpringLayout.WEST, tname, 85, SpringLayout.EAST, cname);
		sl_contentPane.putConstraint(SpringLayout.EAST, tname, -1, SpringLayout.EAST, lblNewLabel_3);
		contentPane.add(tname);
		tname.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 337, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button, -26, SpringLayout.SOUTH, contentPane);
		
	contentPane.add(button);
		
		JButton button_1 = new JButton("\u56DE\u5230\u4E3B\u754C\u9762");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainWindow Main = new MainWindow();
				Main.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, button_1, 0, SpringLayout.NORTH, button);
		sl_contentPane.putConstraint(SpringLayout.WEST, button_1, 21, SpringLayout.EAST, button);
		contentPane.add(button_1);
		
		table = new JTable();
		table.setRowHeight(20);
		sl_contentPane.putConstraint(SpringLayout.NORTH, table, 175, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -25, SpringLayout.NORTH, table);
		sl_contentPane.putConstraint(SpringLayout.WEST, table, 0, SpringLayout.WEST, contentPane);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, "", "", null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"\u6559\u5BA4\u540D", "\u6559\u5BA4\u540D", "\u6559\u5E08\u6027\u522B", "\u4E0A\u8BFE\u65F6\u95F4", "\u4E0A\u8BFE\u8282\u6570", "\u5B66\u5206"
			}
		));
		table.setFont(new Font("宋体", Font.PLAIN, 17));
		contentPane.add(table);
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					Connection conn = createconnection();
					java.sql.Statement sql = conn.createStatement();
					String Cname = cname.getText();
					String Tname = tname.getText();
//					String Querysql = "";
					//select s_c.rno from s_c,c,t where s_c.cno =c.cno
//					and s_c.tno = t.tno and t.tname='teacher' and c.cname ='database'
					ResultSet rs = sql.executeQuery("select s_c.rno,t.tname,t.tsex,s_c.weekday,s_c.period,c.credit from t,s_c,c " +
							"where c.cname ='"+Cname+"' and c.cno=s_c.cno and t.tname='"+Tname+"' and s_c.tno = t.tno");
					String name[] ={"教室","教师名","教师性别","上课时间","上课节数","课程学分"};
					for(int i=0;i<6;i++)
					{
						table.setValueAt(name[i], 0, i);
					}
					while(rs.next())
					{
						for(int i=0;i<6;i++)
						{
							table.setValueAt(rs.getString(i+1), 1, i);
						}
					}
//					select room.rname,t.tname,t.tsex s_c.period s_c.weekday from t,s_c,c,room
					//where cname = c.cname and c.cno=s_c.cno,tname=t.tname and
					//room.cno= s_c.cno and s_c.tno = t.tno;
				} catch (ClassNotFoundException | SQLException e1)
				{
					// TODO Auto-generated catch block
					JOptionPane jo = new JOptionPane();
					jo.showMessageDialog(null, e1.getMessage());
//					e1.printStackTrace();
				}
				
			}
		});
//		contentPane.add(button);
//		
//		JButton button_1 = new JButton("\u56DE\u5230\u4E3B\u754C\u9762");
//		sl_contentPane.putConstraint(SpringLayout.NORTH, button_1, 0, SpringLayout.NORTH, button);
//		sl_contentPane.putConstraint(SpringLayout.WEST, button_1, 21, SpringLayout.EAST, button);
//		contentPane.add(button_1);
//		
//		table = new JTable();
//		sl_contentPane.putConstraint(SpringLayout.NORTH, table, 175, SpringLayout.NORTH, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -25, SpringLayout.NORTH, table);
//		sl_contentPane.putConstraint(SpringLayout.WEST, table, 0, SpringLayout.WEST, contentPane);
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, "", "", null, null},
//				{null, null, null, null, null, null},
//			},
//			new String[] {
//				"\u6559\u5BA4\u540D", "\u6559\u5BA4\u540D", "\u6559\u5E08\u6027\u522B", "\u4E0A\u8BFE\u65F6\u95F4", "\u4E0A\u8BFE\u8282\u6570", "\u5B66\u5206"
//			}
//		));
//		table.setFont(new Font("宋体", Font.PLAIN, 17));
//		contentPane.add(table);
	}
}
