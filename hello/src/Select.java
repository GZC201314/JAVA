import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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


public class Select extends JFrame
{

	private JPanel contentPane;
	private JTextField sno;
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
					Select frame = new Select();
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
//			e2.printStackTrace();
			JOptionPane jo1 = new JOptionPane();
			jo1.showMessageDialog(null, e2.getMessage());
		}
		return conn;
	}
	

	/**
	 * Create the frame.
	 */
	public Select()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel label = new JLabel("\u5B66\u751F\u4FE1\u606F\u67E5\u8BE2\u754C\u9762");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 183, SpringLayout.WEST, contentPane);
		label.setFont(new Font("宋体", Font.PLAIN, 23));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5B66\u53F7");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_1, 45, SpringLayout.SOUTH, label);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_1, -368, SpringLayout.EAST, contentPane);
		label_1.setFont(new Font("宋体", Font.PLAIN, 17));
		contentPane.add(label_1);
		
		sno = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, sno, 1, SpringLayout.NORTH, label_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, sno, 27, SpringLayout.EAST, label_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, sno, 141, SpringLayout.EAST, label_1);
		contentPane.add(sno);
		sno.setColumns(20);
		
		JLabel label_2 = new JLabel("\u67E5\u8BE2\u7ED3\u679C\u8F93\u51FA");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_2, 103, SpringLayout.SOUTH, label);
		label_2.setFont(new Font("宋体", Font.PLAIN, 17));
		sl_contentPane.putConstraint(SpringLayout.WEST, label_2, 196, SpringLayout.WEST, contentPane);
		contentPane.add(label_2);
		
		table = new JTable();
		sl_contentPane.putConstraint(SpringLayout.WEST, table, 15, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, table, -10, SpringLayout.EAST, contentPane);
		table.setBorder(new LineBorder(Color.DARK_GRAY));
		sl_contentPane.putConstraint(SpringLayout.NORTH, table, 42, SpringLayout.SOUTH, label_2);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		
		table.setRowHeight(25);
		table.setFont(new Font("宋体", Font.PLAIN, 14));
		contentPane.add(table);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					Connection conn = createconnection();
					java.sql.Statement sql = conn.createStatement();
					String str = "select * from s where sno ="+sno.getText()+"";
					ResultSet rs = sql.executeQuery(str);
//					if(rs.wasNull())
//					{
//						JOptionPane jo = new JOptionPane();
//						jo.showMessageDialog(null, "没有找到你的信息,请检查你的输入");
//					}
					String Name[] = {"学号","姓名","性别","学院","身份证号","年龄"};
					for(int i=0;i<6;i++)
						table.setValueAt(Name[i], 0, i);
					int num =1;
					while(rs.next())
					{
						for(int i=0;i<6;i++)
							table.setValueAt(rs.getString(i+1), num, i);
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
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 64, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button, -35, SpringLayout.SOUTH, contentPane);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Select.this.dispose();
				MainWindow Main = new MainWindow();
				Main.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button_1, 0, SpringLayout.SOUTH, button);
		sl_contentPane.putConstraint(SpringLayout.EAST, button_1, -171, SpringLayout.EAST, contentPane);
		contentPane.add(button_1);
	}
}
