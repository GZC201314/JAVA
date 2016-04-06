import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Studyself extends JFrame
{

	private JPanel contentPane;
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
					Studyself frame = new Studyself();
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
	public Studyself()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel label = new JLabel("\u6211\u8981\u4E0A\u81EA\u4E60\u754C\u9762");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 167, SpringLayout.WEST, contentPane);
		label.setFont(new Font("宋体", Font.PLAIN, 23));
		contentPane.add(label);
		
		table = new JTable();
		table.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, Color.GRAY));
		table.setToolTipText("\u5E74\u540E");
		table.setFont(new Font("宋体", Font.PLAIN, 16));
//		table.getColumnModel().getColumn(4).setMinWidth(17);
		sl_contentPane.putConstraint(SpringLayout.NORTH, table, 82, SpringLayout.SOUTH, label);
		sl_contentPane.putConstraint(SpringLayout.WEST, table, 109, SpringLayout.WEST, contentPane);
		table.setModel(new DefaultTableModel(
			new Object[100][4],
			new String[] {
				"\u6559\u5BA4\u53F7", "\u6559\u5BA4\u540D", "\u6559\u5BA4\u697C\u5C42", "\u662F\u5426\u53EF\u7528"
			}
		));
		table.setRowHeight(25);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane jsc = new JScrollPane(table);
		sl_contentPane.putConstraint(SpringLayout.EAST, jsc, -25, SpringLayout.EAST, contentPane);
//		setPreferredSize(new Dimension(100, 70));
		jsc.setAutoscrolls(true);
		jsc.setPreferredSize(new Dimension(100, 70));
//		jsc.setSize(100, 70);
		contentPane.add(jsc,BorderLayout.AFTER_LAST_LINE);
		
		
//		contentPane.add(table);
		
		JLabel label_1 = new JLabel("\u6559\u5BA4\u4FE1\u606F\u663E\u793A\u6846");
		sl_contentPane.putConstraint(SpringLayout.NORTH, jsc, 17, SpringLayout.SOUTH, label_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, jsc, 302, SpringLayout.WEST, label_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_1, 203, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label_1, -26, SpringLayout.NORTH, table);
		label_1.setFont(new Font("宋体", Font.PLAIN, 17));
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u70B9\u6B64\u67E5\u8BE2\u7A7A\u6559\u5BA4\u4FE1\u606F");
		sl_contentPane.putConstraint(SpringLayout.WEST, jsc, -35, SpringLayout.WEST, label_2);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, jsc, -2403, SpringLayout.NORTH, label_2);
		label_2.setFont(new Font("宋体", Font.PLAIN, 17));
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_2, 53, SpringLayout.SOUTH, table);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_2, 80, SpringLayout.WEST, contentPane);
		contentPane.add(label_2);
		
		JButton button = new JButton("\u67E5\u8BE2");
//		contentPane.add(button);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					String Name[] = {"教室号","教室名","楼层","是否可用"};
					Connection conn = createconnection();
					java.sql.Statement sql = conn.createStatement();
					ResultSet rs = sql.executeQuery("Select rno,Bname,empty from room where empty ='1'");
					for(int i=0;i<4;i++)
					{
						table.setValueAt(Name[i], 0, i);
					}
					int num=1;
					while(rs.next())
					{
						char floor = getfloor(rs);

						for(int i=0;i<4;i++)
						{
							if(i!=1)
								table.setValueAt(rs.getString(i+1), num, i);
							else
							{
								table.setValueAt(floor, num, i);
//								i--;
							}
						}
						num++;
					}
					
				} catch (ClassNotFoundException | SQLException e1)
				{
					JOptionPane jo = new JOptionPane();
					jo.showMessageDialog(null, e1.getMessage());
					// TODO Auto-generated catch block
//					e1.printStackTrace();
				}
			}

			private char getfloor(ResultSet rs) throws SQLException
			{
				String str = rs.getString(2);
				char[] arr = str.toCharArray();
				for (char c : arr)
				{
					if(c>'0'&& c<'9')
					{
						return c;
					}
				}
				return (Character) null;
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, 21, SpringLayout.SOUTH, label_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 116, SpringLayout.WEST, contentPane);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Studyself.this.dispose();
				MainWindow Main = new MainWindow();
				Main.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, button_1, 0, SpringLayout.NORTH, button);
		sl_contentPane.putConstraint(SpringLayout.EAST, button_1, -112, SpringLayout.EAST, contentPane);
		contentPane.add(button_1);
		
		JButton OK = new JButton("\u67E5\u8BE2");
		OK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				///
				try
				{
					String Name[] = {"教室号","教室名","楼层","是否可用"};
					Connection conn = createconnection();
					java.sql.Statement sql = conn.createStatement();
					ResultSet rs = sql.executeQuery("Select rno,Bname,empty from room where empty ='1'");
//					for(int i=0;i<4;i++)
//					{
//						table.setValueAt(Name[i], 0, i);
//					}
					int num=0;
					while(rs.next())
					{
						char floor = getfloor(rs);

						for(int i=0;i<3;i++)
						{
							if(i!=2)
								table.setValueAt(rs.getString(i+1), num, i);
							else
							{
								table.setValueAt(rs.getString(i+1), num, i+1);
//								i--;
							}
						}
						table.setValueAt(floor, num, 2);
						num++;
					}
					
				} catch (ClassNotFoundException | SQLException e1)
				{
					JOptionPane jo = new JOptionPane();
					jo.showMessageDialog(null, e1.getMessage());
					// TODO Auto-generated catch block
//					e1.printStackTrace();
				}
			}
			private char getfloor(ResultSet rs) throws SQLException
			{
				String str = rs.getString(2);
				char[] arr = str.toCharArray();
				for (char c : arr)
				{
					if(c>'0'&& c<'9')
					{
						return c;
					}
				}
				return (Character) null;
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, OK, 71, SpringLayout.SOUTH, jsc);
		sl_contentPane.putConstraint(SpringLayout.WEST, OK, 56, SpringLayout.WEST, contentPane);
		contentPane.add(OK);
		
		JButton retn = new JButton("\u8FD4\u56DE\u4E3B\u83DC\u5355");
		retn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Studyself.this.dispose();
				MainWindow Main = new MainWindow();
				Main.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, retn, 0, SpringLayout.NORTH, OK);
		sl_contentPane.putConstraint(SpringLayout.EAST, retn, 0, SpringLayout.EAST, button_1);
		contentPane.add(retn);
	}
}
