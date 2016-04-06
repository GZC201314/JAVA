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
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.Color;


public class Student extends JFrame
{

	private JPanel contentPane;
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
					Student frame = new Student();
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
	public Student()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.DARK_GRAY));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel label = new JLabel("\u67E5\u770B\u5B66\u751F\u4FE1\u606F\u754C\u9762");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 91, SpringLayout.WEST, contentPane);
		label.setFont(new Font("华文新魏", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(label);
		
		tname = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, tname, 46, SpringLayout.SOUTH, label);
		sl_contentPane.putConstraint(SpringLayout.WEST, tname, 29, SpringLayout.WEST, contentPane);
		contentPane.add(tname);
		tname.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6559\u5E08\u540D");
		sl_contentPane.putConstraint(SpringLayout.WEST, label_1, 41, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label_1, -15, SpringLayout.NORTH, tname);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5B66\u9662\u540D");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_2, 0, SpringLayout.NORTH, label_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_2, 131, SpringLayout.EAST, label_1);
		contentPane.add(label_2);
		
		table = new JTable();
		table.setBorder(new LineBorder(Color.DARK_GRAY));
		table.setRowHeight(20);
		sl_contentPane.putConstraint(SpringLayout.NORTH, table, 19, SpringLayout.SOUTH, tname);
		sl_contentPane.putConstraint(SpringLayout.WEST, table, 0, SpringLayout.WEST, contentPane);
		table.setModel(new DefaultTableModel(
			new Object[500][6],
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5B66\u9662", "\u8EAB\u4EFD\u8BC1\u53F7", "\u5E74\u9F84"
			}
		));
		table.getColumnModel().getColumn(4).setMinWidth(17);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane jsc = new JScrollPane(table);
		sl_contentPane.putConstraint(SpringLayout.NORTH, jsc, 34, SpringLayout.SOUTH, tname);
		sl_contentPane.putConstraint(SpringLayout.WEST, jsc, 0, SpringLayout.WEST, tname);
		sl_contentPane.putConstraint(SpringLayout.EAST, jsc, 464, SpringLayout.WEST, contentPane);
		setPreferredSize(new Dimension(100, 70));
		jsc.setAutoscrolls(true);
		jsc.setPreferredSize(new Dimension(100, 70));
//		jsc.setLocation(100, 100);
//		add(jsc,BorderLayout.EAST);
//		jsc.doLayout();
//		jsc.
//		jsc.
		jsc.setSize(100, 70);
		contentPane.add(jsc,BorderLayout.AFTER_LAST_LINE);
		table.setFont(new Font("宋体", Font.PLAIN, 12));
//		contentPane.add(table);
		
		JButton OK = new JButton("\u786E\u5B9A");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, jsc, -106, SpringLayout.NORTH, OK);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, OK, -63, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, OK, 0, SpringLayout.EAST, tname);
		contentPane.add(OK);
		
		JButton button = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, OK);
		sl_contentPane.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, label);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Student.this.dispose();
				MainWindow Main = new MainWindow();
				Main.setVisible(true);
			}
		});
		contentPane.add(button);
		
		final JComboBox comboBox = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox, 6, SpringLayout.SOUTH, label_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox, 66, SpringLayout.EAST, tname);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox, -247, SpringLayout.EAST, contentPane);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "\u8BA1\u7B97\u673A\u5B66\u9662", "\u673A\u68B0\u5B66\u9662", "\u7535\u6C14\u5B66\u9662", "\u5546\u5B66\u9662", "\u6750\u6599\u5B66\u9662", "\u5316\u5B66\u5B66\u9662", "\u51B6\u91D1\u5B66\u9662", "\u827A\u672F\u5B66\u9662", "\u5916\u56FD\u8BED\u5B66\u9662", "\u6570\u7406\u5B66\u9662", "\u7BA1\u5DE5\u5B66\u9662", "\u5EFA\u7B51\u5B66\u9662", "\u6587\u6CD5\u5B66\u9662", "\u7814\u7A76\u751F\u5B66\u9662"}));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, comboBox, -19, SpringLayout.NORTH, table);
		contentPane.add(comboBox);
		
//		JButton OK = new JButton("\u786E\u5B9A");
		OK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					Connection conn = createconnection();
					java.sql.Statement sql = conn.createStatement();
					ResultSet rs = sql.executeQuery("select count(*) from t where tname = '"+tname.getText()+"'");
					
					while(rs.next())
					{
						int count = Integer.valueOf(rs.getString(1));
						if(count ==0)
						{
							JOptionPane jo1 = new JOptionPane();
							jo1.showMessageDialog(null, "该老师没有检索到,请检查输入或联系管理员!");
						}
					}
					//					if(rs==null)
//					{
//						JOptionPane jo1 = new JOptionPane();
//						jo1.showMessageDialog(null, "该老师没有检索到,请检查输入或联系管理员!");
//					}
					//						得到老师所在的学院名
					rs = sql.executeQuery("select dept.deptname from dept,t where t.deptno=dept.deptno and t.tname ='"+tname.getText()+"'");
					String Name[] ={"学号","姓名","性别","学院","身份证号","年龄"};
//					for(int i=0;i<6;i++)
//					{
//						table.setValueAt(Name[i], 0, i);
//					}
//					table.clearSelection();
					table.remove(getMenuBar());
					while(rs.next())
//					commit
					{
//						JOptionPane jo1 = new JOptionPane();
//						jo1.showMessageDialog(null, rs.getString(1));
						if(rs.getString(1).equals(comboBox.getSelectedItem()))
						{
							ResultSet rs1 = sql.executeQuery("select s.sno,s.sname,s.ssex,dept.deptname,s.sid,s.age from s,dept where s.deptno = dept.deptno and dept.deptname='"+comboBox.getSelectedItem()+"'");
							int num=0;
							while(rs1.next())
							{
								
								for(int i=0;i<6;i++)
								{
									table.setValueAt(rs1.getString(i+1), num, i);
								}
								num++;
							}
							return;
						}
						
					}
					if(rs.next()==false)
					{
						JOptionPane jo = new JOptionPane();
						jo.showMessageDialog(null,
								"你不是这个学院的老师,所以你没有访问该学院学生信息的权限!");
					}
//					ResultSet rs2 = sql.executeQuery("select * from t,dept where t.deptno = dept.deptno and dept.deptname ="+comboBox.getSelectedItem()+"and t.tname ="+tname.getText()+"");
//					if(rs2.next()==false)
//					{
//						JOptionPane jo = new JOptionPane();
//						jo.showMessageDialog(null, "你不是这个学院的老师,所以你没有访问该学院学生信息的权限!");
//					}
					
				} catch (ClassNotFoundException | SQLException e1)
				{
					JOptionPane jo = new JOptionPane();
					jo.showMessageDialog(null, e1.getMessage());
					// TODO Auto-generated catch block
//					e1.printStackTrace();
				}
				
			}
		});
//		sl_contentPane.putConstraint(SpringLayout.NORTH, OK, 37, SpringLayout.SOUTH, table);
//		sl_contentPane.putConstraint(SpringLayout.WEST, OK, 0, SpringLayout.WEST, tname);
//		contentPane.add(OK);
//		
//		JButton button = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
//		sl_contentPane.putConstraint(SpringLayout.WEST, button, 90, SpringLayout.EAST, OK);
//		sl_contentPane.putConstraint(SpringLayout.SOUTH, button, 0, SpringLayout.SOUTH, OK);
//		contentPane.add(button);
//		
//		JComboBox comboBox = new JComboBox();
//		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "\u8BA1\u7B97\u673A\u5B66\u9662", "\u673A\u68B0\u5B66\u9662", "\u7535\u6C14\u5B66\u9662", "\u5546\u5B66\u9662", "\u6750\u6599\u5B66\u9662", "\u5316\u5B66\u5B66\u9662", "\u827A\u672F\u5B66\u9662", "\u5916\u56FD\u8BED\u5B66\u9662", "\u6570\u7406\u5B66\u9662", "\u7BA1\u5DE5\u5B66\u9662", "\u5EFA\u7B51\u5B66\u9662", "\u6587\u6CD5\u5B66\u9662", "\u7814\u7A76\u751F\u5B66\u9662"}));
//		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox, 0, SpringLayout.NORTH, tname);
//		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox, 77, SpringLayout.EAST, tname);
//		sl_contentPane.putConstraint(SpringLayout.SOUTH, comboBox, -19, SpringLayout.NORTH, table);
//		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, label);
//		contentPane.add(comboBox);
	}
}
