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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class S_modify extends JFrame
{

	private JPanel contentPane;
	private JTextField sno;
	private JTextField sname;
	private JTextField id;

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
					S_modify frame = new S_modify();
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
	public S_modify()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel label = new JLabel("\u5B66\u751F\u4FE1\u606F\u4FEE\u6539\u754C\u9762");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 175, SpringLayout.WEST, contentPane);
		label.setFont(new Font("宋体", Font.PLAIN, 23));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5B66\u53F7");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_1, 32, SpringLayout.SOUTH, label);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_1, 130, SpringLayout.WEST, contentPane);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u59D3\u540D");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_2, 22, SpringLayout.SOUTH, label_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_2, 0, SpringLayout.WEST, label_1);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u5B66\u9662");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_3, 25, SpringLayout.SOUTH, label_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_3, 0, SpringLayout.WEST, label_1);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u6027\u522B");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_4, 189, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_4, 0, SpringLayout.WEST, label_1);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u5E74\u9F84");
		sl_contentPane.putConstraint(SpringLayout.WEST, label_6, 0, SpringLayout.WEST, label_1);
		contentPane.add(label_6);
		
		sno = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, sno, 37, SpringLayout.SOUTH, label);
		sl_contentPane.putConstraint(SpringLayout.WEST, sno, 49, SpringLayout.EAST, label_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, sno, 177, SpringLayout.EAST, label_1);
		contentPane.add(sno);
		sno.setColumns(10);
		
		sname = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, sname, -3, SpringLayout.NORTH, label_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, sname, 0, SpringLayout.WEST, sno);
		sl_contentPane.putConstraint(SpringLayout.EAST, sname, 128, SpringLayout.WEST, sno);
		sname.setColumns(10);
		contentPane.add(sname);
		
		final JComboBox dept = new JComboBox();
		dept.setModel(new DefaultComboBoxModel(new String[] {"", "\u8BA1\u7B97\u673A\u5B66\u9662", "\u673A\u68B0\u5B66\u9662", "\u5546\u5B66\u9662", "\u7535\u6C14\u5B66\u9662", "\u6587\u6CD5\u5B66\u9662", "\u6750\u6599\u5B66\u9662", "\u5316\u5B66\u5B66\u9662", "\u51B6\u91D1\u5B66\u9662", "\u5EFA\u5DE5\u5B66\u9662", "\u7BA1\u5DE5\u5B66\u9662", "\u827A\u672F\u5B66\u9662", "\u7814\u7A76\u751F\u5B66\u9662"}));
		sl_contentPane.putConstraint(SpringLayout.NORTH, dept, -3, SpringLayout.NORTH, label_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, dept, 5, SpringLayout.WEST, sno);
		sl_contentPane.putConstraint(SpringLayout.EAST, dept, 0, SpringLayout.EAST, sno);
		contentPane.add(dept);
		
		final JComboBox sex = new JComboBox();
		sex.setModel(new DefaultComboBoxModel(new String[] {"", "\u7537", "\u5973"}));
		sl_contentPane.putConstraint(SpringLayout.NORTH, sex, -3, SpringLayout.NORTH, label_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, sex, 75, SpringLayout.EAST, label_4);
		sl_contentPane.putConstraint(SpringLayout.EAST, sex, 141, SpringLayout.EAST, label_4);
		contentPane.add(sex);
		
		id = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_5, 3, SpringLayout.NORTH, id);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_5, -35, SpringLayout.WEST, id);
		sl_contentPane.putConstraint(SpringLayout.NORTH, id, 32, SpringLayout.SOUTH, sex);
		sl_contentPane.putConstraint(SpringLayout.WEST, id, 0, SpringLayout.WEST, sno);
		sl_contentPane.putConstraint(SpringLayout.EAST, id, -5, SpringLayout.EAST, sno);
		id.setColumns(10);
		contentPane.add(id);
		
		final JComboBox age = new JComboBox();
		age.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"}));
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_6, 3, SpringLayout.NORTH, age);
		sl_contentPane.putConstraint(SpringLayout.NORTH, age, 27, SpringLayout.SOUTH, id);
		sl_contentPane.putConstraint(SpringLayout.WEST, age, 5, SpringLayout.WEST, sex);
		sl_contentPane.putConstraint(SpringLayout.EAST, age, 0, SpringLayout.EAST, sex);
		contentPane.add(age);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					Connection conn = createconnection();
					java.sql.Statement sql = conn.createStatement();
					String str = "update s set sno='"+sno.getText()+"',sname='"+sname.getText()+"',ssex='"+sex.getSelectedItem()+"',deptno='"+dept.getSelectedItem()+"',sid='"+id.getText()+"',age='"+age.getSelectedItem()+"' where sno='"+sno.getText()+"'";
					int num = sql.executeUpdate(str);
					JOptionPane jo = new JOptionPane();
					if(num == 1)
					{
//						JOptionPane jo = new JOptionPane();
						jo.showMessageDialog(null, "信息修改成功");
					}
					else
					{
						jo.showMessageDialog(null, "信息更新失败");
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
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 60, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				S_modify.this.dispose();
				MainWindow Main = new MainWindow();
				Main.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, button_1, 0, SpringLayout.NORTH, button);
		sl_contentPane.putConstraint(SpringLayout.EAST, button_1, -79, SpringLayout.EAST, contentPane);
		contentPane.add(button_1);
	}
}
