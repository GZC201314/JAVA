import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import org.eclipse.ui.testing.TestableObject;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Updata_room extends JFrame
{

	private JPanel contentPane;

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
					Updata_room frame = new Updata_room();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Updata_room()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		sl_contentPane.putConstraint(SpringLayout.WEST, textArea, -261, SpringLayout.EAST, contentPane);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 17));
		textArea.setRows(10);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textArea, 88, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textArea, 262, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textArea, -10, SpringLayout.EAST, contentPane);
		textArea.setText("\u7531\u4E8E\u672C\u4EBA\u80FD\u529B\u6709\u9650\u65E0\u6CD5\u505A\u5230,\u81EA\u52A8\r\n\u66F4\u65B0\u7A7A\u6559\u5BA4\u4FE1\u606F,\u6240\u4EE5\u9700\u8981\u7BA1\u7406\u5458\r\n\u624B\u52A8\u66F4\u65B0,\u5EFA\u8BAE\u7BA1\u7406\u5458\u6BCF\u5929\u66F4\u65B0\u4E00\r\n\u6B21,\u786E\u4FDD\u4FE1\u606F\u7684\u53CA\u65F6\u6027.");
//		textArea.setAutoscrolls();
//		textArea.setBackground(new Color(125));
		textArea.setEditable(false);
		contentPane.add(textArea);
		
		JLabel label = new JLabel("\u53CB\u60C5\u63D0\u793A");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label, -35, SpringLayout.NORTH, textArea);
		sl_contentPane.putConstraint(SpringLayout.EAST, label, -95, SpringLayout.EAST, contentPane);
		contentPane.add(label);
		
		JButton button = new JButton("\u66F4\u65B0\u4FE1\u606F");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try
				{
//				
//				计算现在的年月日时间
//				String date = nihao.getCurrenTime();
					String date[] = nihao.getCurrenTime().split("_");
					int Nyear = Integer.valueOf(date[0]);
					int Nmouth = Integer.valueOf(date[1]);
					int Nday = Integer.valueOf(date[2]);
					int Nhour = Integer.valueOf(date[3]);
					
					
//				检索数据库,找到数据库中的教室使用的信息
					Connection conn = nihao.createconnection();
					java.sql.Statement sql = conn.createStatement();
					ResultSet rs = sql.executeQuery("select * from ruse");
					while(rs.next())
					{
						String rno = rs.getString(1);
						char[] floor = rno.toCharArray();
						char Floor =
						0;
						for (char c : floor)
						{
							if(c>'0' && c<'9')
								Floor = c;
						}
						String Udate[] = rs.getString(3).split("_");
						int Uyear = Integer.valueOf(Udate[0]);
						int Umonth = Integer.valueOf(Udate[1]);
						int Uday = Integer.valueOf(Udate[2]);
						String Uhour = rs.getString(5);
						if(Nyear > Uyear)
						{
							 sql.executeUpdate("insert into room values(rno='"+rno+"',rname='"+rno+"',floor = '"+Floor+"',empty = '1'");
							 sql.executeUpdate("delete from ruse where rno='"+rno+"'");
//							if(insertrow ==1 && deleterom)
						}
						if(Nyear == Uyear && Nmouth > Umonth)
						{
							 sql.executeUpdate("insert into room values(rno='"+rno+"',rname='"+rno+"',floor = '"+Floor+"',empty = '1'");
							 sql.executeUpdate("delete from ruse where rno='"+rno+"'");
							
						}
						if(Nyear == Uyear && Nmouth == Umonth && Nday > Uday)
						{
							 sql.executeUpdate("insert into room values(rno='"+rno+"',rname='"+rno+"',floor = '"+Floor+"',empty = '1'");
							 sql.executeUpdate("delete from ruse where rno='"+rno+"'");
						}
						if(Nyear == Uyear && Nmouth == Umonth && Nday == Uday)
						{
							if("上午".equals(Uhour)&&Nhour>12)
							{
								 sql.executeUpdate("insert into room values(rno='"+rno+"',rname='"+rno+"',floor = '"+Floor+"',empty = '1'");
								 sql.executeUpdate("delete from ruse where rno='"+rno+"'");
							}
							if("下午".equals(Uhour)&& Nhour>18)
							{
								 sql.executeUpdate("insert into room values(rno='"+rno+"',rname='"+rno+"',floor = '"+Floor+"',empty = '1'");
								 sql.executeUpdate("delete from ruse where rno='"+rno+"'");
							}
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
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 27, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button, -22, SpringLayout.SOUTH, contentPane);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Updata_room.this.dispose();
				MainWindow Main = new MainWindow();
				Main.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, button_1, 0, SpringLayout.NORTH, button);
		sl_contentPane.putConstraint(SpringLayout.EAST, button_1, -114, SpringLayout.EAST, contentPane);
		contentPane.add(button_1);
	}
}
