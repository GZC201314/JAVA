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
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Teacher extends JFrame
{

	private JPanel contentPane;
	private JTextField tno;
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
					Teacher frame = new Teacher();
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
	public Teacher()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel label = new JLabel("\u6559\u5E08\u4FE1\u606F\u67E5\u8BE2\u754C\u9762");
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 167, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label, -273, SpringLayout.SOUTH, contentPane);
		label.setFont(new Font("宋体", Font.PLAIN, 23));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u6559\u5E08\u53F7");
		sl_contentPane.putConstraint(SpringLayout.WEST, label_1, 238, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label_1, -252, SpringLayout.SOUTH, contentPane);
		contentPane.add(label_1);
		
		tno = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, tno, 6, SpringLayout.SOUTH, label_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, tno, 222, SpringLayout.WEST, contentPane);
		contentPane.add(tno);
		tno.setColumns(10);
		
		table = new JTable();
		sl_contentPane.putConstraint(SpringLayout.NORTH, table, 40, SpringLayout.SOUTH, tno);
		sl_contentPane.putConstraint(SpringLayout.WEST, table, 56, SpringLayout.WEST, contentPane);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, ""},
				{null, null, null, null, null, null},
			},
			new String[] {
				"\u6559\u5E08\u53F7", "\u6559\u5E08\u540D", "\u6027\u522B", "\u5B66\u9662", "\u804C\u79F0", "\u8EAB\u4EFD\u8BC1\u53F7"
			}
		));
		
		contentPane.add(table);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					String Name[] = {"教师号","姓名","性别","学院","职称","身份证号"};
					Connection conn = createconnection();
					java.sql.Statement sql = conn.createStatement();
					ResultSet rs = sql.executeQuery("select * from t where tno = '"+tno.getText()+"'");
					if(rs == null)
					{
						JOptionPane jo = new JOptionPane();
						jo.showMessageDialog(null, "没有找到你的信息,请检查你的输入,或者联系管理员");
					}
					for(int i=0;i<6;i++)
					{
						table.setValueAt(Name[i], 0, i);
					}
					while(rs.next())
					{
						for(int i=0;i<6;i++)
						{
							table.setValueAt(rs.getString(i+1), 1, i);
						}
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
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 45, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Teacher.this.dispose();
				MainWindow Main = new MainWindow();
				Main.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, button_1, 0, SpringLayout.NORTH, button);
		sl_contentPane.putConstraint(SpringLayout.EAST, button_1, -82, SpringLayout.EAST, contentPane);
		contentPane.add(button_1);
	}
}
