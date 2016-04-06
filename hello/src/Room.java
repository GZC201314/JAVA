import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.ibm.icu.text.SimpleDateFormat;


public class Room extends JFrame
{

	private JPanel contentPane;
	private JTextField Rno;
	private JTable table;
	Object a[][] =
	null;
	private JTextField Date;
	private JTextField Tno;
	private JTextField UseStyte;
	private JComboBox combox;
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
					Room frame = new Room();
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
	
	
	public String getCurrenTime() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH");
		return sdf.format(d);
	}
	

	/**
	 * Create the frame.
	 */
	public Room()
	{
//		final Vector vect =null;//声明一个向量对象 
//		
//		final AbstractTableModel tm;//声明一个类AbstractTableModel对象 
//		JTable jg_table;//声明一个类JTable对象 
//		//final Vector vect;//声明一个向量对象 
//		JScrollPane jsp;//声明一个滚动杠对象 
//		final String title[]={"教室号","教师名","楼层","是否可用"}; 
//		
//		//vect=new Vector();//实例化向量 
//		tm=new AbstractTableModel(){ 
//		public int getColumnCount(){ 
//		return title.length;}//取得表格列数 
//		public int getRowCount(){ 
//		return vect.size();}//取得表格行数 
//		public Object getValueAt(int row,int column){ 
//		if(!vect.isEmpty()) 
//		return 
//		((Vector)vect.elementAt(row)).elementAt(column); 
//		else 
//		return null;}//取得单元格中的属性值 
//		public String getColumnName(int column){ 
//		return title[column];}//设置表格列名 
//		public void setValueAt(Object value,int row,int column){} 
//		//数据模型不可编辑，该方法设置为空 
//		public Class getColumnClass(int c){ 
//		return getValueAt(0,c).getClass(); 
//		}//取得列所属对象类 
//		public boolean isCellEditable(int row,int column){ 
//		return false;}//设置单元格不可编辑，为缺省实现 
//		}; 
//		//2、定制表格： 
//		jg_table=new JTable(tm);//生成自己的数据模型 
//		jg_table.setToolTipText("显示全部查询结果");//设置帮助提示 
//		jg_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
//		//设置表格调整尺寸模式 
//		jg_table.setCellSelectionEnabled(false);//设置单元格选择方式 
//		jg_table.setShowVerticalLines(true);//设置是否显示单元格间的分割线 
//		jg_table.setShowHorizontalLines(true); 
//		jsp=new JScrollPane(jg_table);//给表格加上滚动杠 
//		con
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton button = new JButton("\u67E5\u8BE2\u7A7A\u6559\u5BA4");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try
				{
					Connection conn = createconnection();
					java.sql.Statement sql = conn.createStatement();
					ResultSet rs = sql.executeQuery("select * from room");
//					conn.close();
//					int raw = rs.getRow();
//					JOptionPane jo = new JOptionPane();
//					jo.showMessageDialog(null, raw);
//					sql.e
					int num=1;
					Object Name[]={"教室号","教室名","楼层","是否可用"};
						//给表格加上滚动杠 
//					JScrollPane jsp = new JScrollPane(table);
					for(int i=0;i<4;i++)
						table.setValueAt(Name[i], 0, i);
					while(rs.next())
					{

						
//						for(int i=0;i<raw;i++)
						if(rs.getString(4).equals("1"))
						{
							
							for(int j=0;j<4;j++)
							{
//								JOptionPane po = new JOptionPane();
//								po.showMessageDialog(null, rs.getString(j+1));
//								a[num][j]=rs.getString(j+1);
								table.setValueAt(rs.getString(j+1), num, j);
							}
							num++;
						}
						

					}

					table.repaint();
					
//					tm.fireTableStructureChanged();
					
				} catch (ClassNotFoundException | SQLException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane po =new JOptionPane();
					po.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, 35, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 45, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button, 67, SpringLayout.NORTH, contentPane);
		contentPane.add(button);
		
		Rno = new JTextField();
		Rno.setFont(new Font("宋体", Font.PLAIN, 17));
		sl_contentPane.putConstraint(SpringLayout.NORTH, Rno, 107, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, Rno, -155, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, Rno, -5, SpringLayout.EAST, contentPane);
		contentPane.add(Rno);
		Rno.setColumns(10);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8981\u501F\u7528\u7684\u6559\u5BA4\u53F7");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label, -17, SpringLayout.NORTH, Rno);
		sl_contentPane.putConstraint(SpringLayout.EAST, label, -10, SpringLayout.EAST, contentPane);
		contentPane.add(label);
		
		JButton OK = new JButton("\u7533\u8BF7");
		sl_contentPane.putConstraint(SpringLayout.WEST, OK, 0, SpringLayout.WEST, Rno);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, OK, -45, SpringLayout.SOUTH, contentPane);
		
//		public String getCurrenTime() {
//			Date d = new Date();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
//			return sdf.format(d);
//		}
		
		OK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				JOptionPane jo = new JOptionPane();
				String Udate[] = Date.getText().split("_");
				int Uyear = Integer.valueOf(Udate[0]);
				int Umounth = Integer.valueOf(Udate[1]);
				int Uday = Integer.valueOf(Udate[2]);
				
				
				String Ndate[] = nihao.getCurrenTime().split("_");
				int Nyear = Integer.valueOf(Ndate[0]);
				int Nmounth = Integer.valueOf(Ndate[1]);
				int Nday = Integer.valueOf(Ndate[2]);
				int Nhour = Integer.valueOf(Ndate[3]);
				
				
				if(Uyear < Nyear)
				{
					jo.showMessageDialog(null, "借用时间小于当前时间,你是要穿越吗?");
					return;
				}
				if(Uyear == Nyear && Umounth <Nmounth)
				{
					jo.showMessageDialog(null, "借用时间小于当前时间,你是要穿越吗?");
					return;
				}
				if(Uyear == Nyear && Umounth == Nmounth && Uday <Nday)
				{
					jo.showMessageDialog(null, "借用时间小于当前时间,你是要穿越吗?");
					return;
				}
				if(Uyear == Nyear && Umounth == Nmounth && Uday == Nday)
				{
					if("上午".equals(combox.getSelectedItem())&&Nhour >12)
					{
						jo.showMessageDialog(null, "借用时间小于当前时间,你是要穿越吗?");
						return;
					}
					if("下午".equals(combox.getSelectedItem())&&Nhour >18)
					{
						jo.showMessageDialog(null, "借用时间小于当前时间,你是要穿越吗?");
						return;
					}
				}
				try
				{
					Connection conn = nihao.createconnection();
					java.sql.Statement sql = conn.createStatement();
					int num = sql.executeUpdate("insert into ruse values('"+Rno.getText()+"','"+Tno.getText()+"','"+Date.getText()+"',null,'"+combox.getSelectedItem()+"','"+UseStyte.getText()+"','1')");
//					int Num = sql.executeUpdate("delete from room where rno ='"+Rno.getText()+"'");
					int Num = sql.executeUpdate("update room set empty ='0' where rno ='"+Rno.getText()+"'");
					if(Num==1 && num == 1)
						jo.showMessageDialog(null, "借用教室成功");
				} catch (ClassNotFoundException | SQLException e1)
				{
					jo.showMessageDialog(null, e1.getMessage());
					// TODO Auto-generated catch block
//					e1.printStackTrace();
				}
				
				
//				String rno = Rno.getText();
//				String tno = Tno.getText();
//				String ustyte = UseStyte.getText();
//				String date = Date.getText();
//				String day = (String) combox.getSelectedItem();
////				SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
//				String  D = getCurrenTime();
//				String Now[] = D.split("_");
//				String Pass[] = date.split("_");
//				JOptionPane jo1 =new JOptionPane();
//				JOptionPane.showMessageDialog(null,Integer.valueOf(Now[1])+"  "+Integer.valueOf(Pass[1]));
//				if (Integer.valueOf(Now[0]) > Integer.valueOf(Pass[0]))
//				{
//					JOptionPane jo = new JOptionPane();
//					jo.showMessageDialog(null, "1你输入的时间小于当前时间,你是要穿越回去吗?");
//				}
//				else
//				{
//					if (Integer.valueOf(Now[1]) > Integer.valueOf(Pass[1]))
//					{
//						JOptionPane jo = new JOptionPane();
//						jo.showMessageDialog(null, "2你输入的时间小于当前时间,你是要穿越回去吗?");
//					} else if (Integer.valueOf(Now[1]) == Integer.valueOf(Pass[1])&& Integer.valueOf(Now[2]) > Integer
//							.valueOf(Pass[2]))
//					{
//						JOptionPane jo = new JOptionPane();
//						jo.showMessageDialog(null, "3你输入的时间小于当前时间,你是要穿越回去吗?");
//					}
//				}
//		
//				try
//				{
//					
//					
//					
//					//扫描Ruse表,更新room表和Ruse表
//					
//					
//					Connection conn = createconnection();
//					java.sql.Statement sql = conn.createStatement();
//					String sql1 = "select * from ruse";
//					ResultSet rs = sql.executeQuery(sql1);
//					while(rs.next())
//					{
//						//如果当前借教室信息已过期,自动删除该借教室的信息,并且把教室信息插入到可借表中
//						String Juse[] = rs.getString(2).split("_");
//						
//						if(rs.getString(4).equals("1"))
//							if(Integer.valueOf(Juse[0])<Integer.valueOf(Now[0]))
//							{
//								sql.executeUpdate("insert into room values ('"+rs.getString(1)+"','"+rs.getString(1)+"',null,'1')");
//								sql.executeUpdate("delect from ruse where rno = '"+rs.getString(1)+"'");
//							}
//						if(Integer.valueOf(Juse[0])== Integer.valueOf(Now[0]) && Integer.valueOf(Juse[1])< Integer.valueOf(Now[1]))
//						{
//							sql.executeUpdate("insert into room values ('"+rs.getString(1)+"','"+rs.getString(1)+"',null,'1')");
//							sql.executeUpdate("delect from ruse where rno = '"+rs.getString(1)+"'");
//					
//						}
//						if(Integer.valueOf(Juse[0])== Integer.valueOf(Now[0]) && Integer.valueOf(Juse[1]) == Integer.valueOf(Now[1]) &&
//								Integer.valueOf(Juse[2])< Integer.valueOf(Now[2]))
//						{
//							sql.executeUpdate("insert into room values ('"+rs.getString(1)+"','"+rs.getString(1)+"',null,'1')");
//							sql.executeUpdate("delect from ruse where rno = '"+rs.getString(1)+"'");
//				
//						}
//							
//					}
//					String sql2 = "insert into ruse values('"+rno+"','"+tno+"','"+date+"',null,'"+day+"','"+ustyte+"','1')";
//					sql.executeUpdate(sql2);
					
//				} catch (ClassNotFoundException | SQLException e1)
//				{
//					JOptionPane jo = new JOptionPane();
//					jo.showMessageDialog(null, e1.getMessage());
//					// TODO Auto-generated catch block
////					e1.printStackTrace();
//				}
				
				
				
			}
		});
		OK.setIcon(null);
		contentPane.add(OK);
		
		JButton button_1 = new JButton("\u5230\u4E3B\u754C\u9762");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Room.this.dispose();
				MainWindow main = new MainWindow();
				main.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, button_1, 0, SpringLayout.NORTH, OK);
		sl_contentPane.putConstraint(SpringLayout.EAST, button_1, 0, SpringLayout.EAST, Rno);
		contentPane.add(button_1);
		
		table = new JTable();
		sl_contentPane.putConstraint(SpringLayout.NORTH, table, 8, SpringLayout.NORTH, Rno);
		sl_contentPane.putConstraint(SpringLayout.WEST, table, 0, SpringLayout.WEST, contentPane);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u6559\u5BA4\u53F7", "\u6559\u5BA4\u540D", "\u697C\u5C42", "\u662F\u5426\u53EF\u7528"
			}
		));
		table.setFont(new Font("华文中宋", Font.PLAIN, 15));
		contentPane.add(table);
		
		JLabel lblyyyymmdd = new JLabel("\u8BF7\u8F93\u5165\u8981\u501F\u7528\u65F6\u95F4\r\n\u683C\u5F0FYYYY_mm_DD");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblyyyymmdd, 16, SpringLayout.SOUTH, Rno);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblyyyymmdd, 0, SpringLayout.EAST, contentPane);
		contentPane.add(lblyyyymmdd);
		
		Date = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, Date, 181, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblyyyymmdd, -1, SpringLayout.NORTH, Date);
		sl_contentPane.putConstraint(SpringLayout.WEST, Date, 5, SpringLayout.WEST, Rno);
		sl_contentPane.putConstraint(SpringLayout.EAST, Date, 0, SpringLayout.EAST, Rno);
		Date.setFont(new Font("宋体", Font.PLAIN, 17));
		Date.setColumns(10);
		contentPane.add(Date);
		
	    combox = new JComboBox();
		combox.setModel(new DefaultComboBoxModel(new String[] {"", "\u4E0A\u5348", "\u4E0B\u5348", "\u665A\u4E0A"}));
		sl_contentPane.putConstraint(SpringLayout.WEST, combox, -1, SpringLayout.WEST, label);
		sl_contentPane.putConstraint(SpringLayout.EAST, combox, -23, SpringLayout.EAST, contentPane);
		contentPane.add(combox);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u5728\u4E0B\u9762\u9009\u62E9\u4E00\u5929\u4E2D\u7684\u5177\u4F53\u65F6\u95F4");
		sl_contentPane.putConstraint(SpringLayout.NORTH, combox, 21, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, combox, 65, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 29, SpringLayout.SOUTH, Date);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, Rno);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u4F60\u7684\u6559\u5E08\u53F7");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_1, 0, SpringLayout.NORTH, label);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_1, -129, SpringLayout.WEST, label);
		contentPane.add(label_1);
		
		Tno = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, Tno, 0, SpringLayout.NORTH, Rno);
		sl_contentPane.putConstraint(SpringLayout.WEST, Tno, -220, SpringLayout.WEST, Rno);
		sl_contentPane.putConstraint(SpringLayout.EAST, Tno, -70, SpringLayout.WEST, Rno);
		Tno.setFont(new Font("宋体", Font.PLAIN, 17));
		Tno.setColumns(10);
		contentPane.add(Tno);
		
		JLabel label_2 = new JLabel("\u7528\u9014");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_2, 8, SpringLayout.NORTH, lblyyyymmdd);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_2, -124, SpringLayout.WEST, lblyyyymmdd);
		contentPane.add(label_2);
		
		UseStyte = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, UseStyte, 0, SpringLayout.NORTH, Date);
		sl_contentPane.putConstraint(SpringLayout.WEST, UseStyte, -145, SpringLayout.EAST, Tno);
		sl_contentPane.putConstraint(SpringLayout.EAST, UseStyte, 0, SpringLayout.EAST, Tno);
		UseStyte.setFont(new Font("宋体", Font.PLAIN, 17));
		UseStyte.setColumns(10);
		contentPane.add(UseStyte);
		
//		AbstractTableModel tm;//声明一个类AbstractTableModel对象 
//		JTable jg_table;//声明一个类JTable对象 
//		//final Vector vect;//声明一个向量对象 
//		JScrollPane jsp;//声明一个滚动杠对象 
//		final String title[]={"教室号","教师名","楼层","是否可用"}; 
		
//		vect=new Vector();//实例化向量 
//		tm=new AbstractTableModel(){ 
//		public int getColumnCount(){ 
//		return title.length;}//取得表格列数 
//		public int getRowCount(){ 
//		return vect.size();}//取得表格行数 
//		public Object getValueAt(int row,int column){ 
//		if(!vect.isEmpty()) 
//		return 
//		((Vector)vect.elementAt(row)).elementAt(column); 
//		else 
//		return null;}//取得单元格中的属性值 
//		public String getColumnName(int column){ 
//		return title[column];}//设置表格列名 
//		public void setValueAt(Object value,int row,int column){} 
//		//数据模型不可编辑，该方法设置为空 
//		public Class getColumnClass(int c){ 
//		return getValueAt(0,c).getClass(); 
//		}//取得列所属对象类 
//		public boolean isCellEditable(int row,int column){ 
//		return false;}//设置单元格不可编辑，为缺省实现 
//		}; 
//		//2、定制表格： 
//		jg_table=new JTable(tm);//生成自己的数据模型 
//		jg_table.setToolTipText("显示全部查询结果");//设置帮助提示 
//		jg_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
//		//设置表格调整尺寸模式 
//		jg_table.setCellSelectionEnabled(false);//设置单元格选择方式 
//		jg_table.setShowVerticalLines(true);//设置是否显示单元格间的分割线 
//		jg_table.setShowHorizontalLines(true); 
//		jsp=new JScrollPane(jg_table);//给表格加上滚动杠 
	}
}
