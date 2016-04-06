import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.SQLException;


public class Add_user extends JFrame
{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
					Add_user frame = new Add_user();
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
	public Add_user()
	{
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel label = new JLabel("\u6DFB\u52A0\u7528\u6237\u754C\u9762");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 180, SpringLayout.WEST, contentPane);
		label.setFont(new Font("宋体", Font.PLAIN, 23));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_1, 98, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_1, 111, SpringLayout.WEST, contentPane);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_2, 50, SpringLayout.SOUTH, label_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_2, 0, SpringLayout.EAST, label_1);
		contentPane.add(label_2);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, label_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 46, SpringLayout.EAST, label_1);
		contentPane.add(textField);
		textField.setColumns(20);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField_1, 0, SpringLayout.SOUTH, label_2);
		textField_1.setColumns(20);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					Connection conn = nihao.createconnection();
					java.sql.Statement sql = conn.createStatement();
					int num = sql.executeUpdate("insert into myuser values('"+textField.getText()+"','"+textField_1.getText()+"')");
					if(num == 1)
					{
						JOptionPane jo = new JOptionPane();
						jo.showMessageDialog(null, "用户添加成功");
					}
					if(num == 0)
					{
						JOptionPane jo1 = new JOptionPane();
						jo1.showMessageDialog(null, "用户添加失败");
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
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 79, SpringLayout.SOUTH, label_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 75, SpringLayout.WEST, contentPane);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Add_user.this.dispose();
				MainWindow Main = new MainWindow();
				Main.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 120, SpringLayout.EAST, btnNewButton);
		contentPane.add(button);
	}

}
