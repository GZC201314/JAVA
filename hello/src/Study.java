import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Study extends JFrame
{

	private JPanel contentPane;
	private JTextField tname;
	private JTextField cname;
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
					Study frame = new Study();
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
	public Study()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel label = new JLabel("\u4E0A\u8BFE\u5730\u70B9\u67E5\u8BE2\u754C\u9762");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 104, SpringLayout.WEST, contentPane);
		label.setFont(new Font("宋体", Font.PLAIN, 23));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u4EFB\u8BFE\u8001\u5E08\u540D");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_1, 63, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_1, 49, SpringLayout.WEST, contentPane);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8BFE\u7A0B\u540D");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_2, 0, SpringLayout.NORTH, label_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_2, -122, SpringLayout.EAST, contentPane);
		contentPane.add(label_2);
		
		tname = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, tname, 18, SpringLayout.SOUTH, label_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, tname, 30, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, tname, 133, SpringLayout.WEST, contentPane);
		contentPane.add(tname);
		tname.setColumns(10);
		
		cname = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, cname, 0, SpringLayout.NORTH, tname);
		sl_contentPane.putConstraint(SpringLayout.EAST, cname, -88, SpringLayout.EAST, contentPane);
		cname.setColumns(10);
		contentPane.add(cname);
		
		table = new JTable();
		table.setBorder(new LineBorder(Color.DARK_GRAY));
		table.setFont(new Font("宋体", Font.PLAIN, 17));
		sl_contentPane.putConstraint(SpringLayout.NORTH, table, 22, SpringLayout.SOUTH, tname);
		sl_contentPane.putConstraint(SpringLayout.WEST, table, 0, SpringLayout.WEST, tname);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "", null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u6559\u5BA4\u540D", "\u8BFE\u7A0B\u540D", "\u4E0A\u8BFE\u65F6\u95F4", "\u8282\u6570"
			}
		));
		table.setRowHeight(25);
		contentPane.add(table);
		
		JLabel label_3 = new JLabel("\u7ED3\u679C\u8F93\u51FA");
		sl_contentPane.putConstraint(SpringLayout.WEST, label_3, 157, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label_3, -25, SpringLayout.NORTH, table);
		contentPane.add(label_3);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
//					JOptionPane jo1 = new JOptionPane();
					Connection conn = createconnection();
					java.sql.Statement sql = conn.createStatement(); 
					String str = "select room.rno,c.cname,s_c.weekday,s_c.period from room,c,t,s_c where s_c.cno = c.cno and s_c.tno = t.tno and s_c.rno = room.rno and t.tname = '"+tname.getText()+"' and c.cname = '"+cname.getText()+"'";
//					jo1.showMessageDialog(null, str);
					ResultSet rs = sql.executeQuery(str);
					String Name[] = {"教室名","课程名","上课时间","节数"};
					for(int i=0;i<4;i++)
					{
						table.setValueAt(Name[i], 0, i);
					}
//					if(rs == null)
//					{
//						JOptionPane jo = new JOptionPane();
//						jo.showMessageDialog(null, "没有找到相应的信息");
//					}
					
					while(rs.next())
					{
//						jo1.showMessageDialog(null, rs.getString(1));
						int num =1;
						for(int i=0;i<4;i++)
						{
							table.setValueAt(rs.getString(i+1), num, i);
						}
						num++;
						return;
					}
					if(rs.next() == false)
					{
						JOptionPane jo = new JOptionPane();
						jo.showMessageDialog(null, "没有找到相应的信息");
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
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 63, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Study.this.dispose();
				MainWindow Main = new MainWindow();
				Main.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button_1, 0, SpringLayout.SOUTH, button);
		sl_contentPane.putConstraint(SpringLayout.EAST, button_1, 0, SpringLayout.EAST, table);
		contentPane.add(button_1);
	}
}
