import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.eclipse.ui.internal.ShowFastViewContribution;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.SQLException;


public class Delete_user extends JFrame
{

	private JPanel contentPane;
	private JTextField textField;

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
					Delete_user frame = new Delete_user();
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
	public Delete_user()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel label = new JLabel("\u5220\u9664\u7528\u6237\u754C\u9762");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 122, SpringLayout.WEST, contentPane);
		label.setFont(new Font("宋体", Font.PLAIN, 23));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u7C7B\u578B");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_1, 69, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_1, 49, SpringLayout.WEST, contentPane);
		label_1.setFont(new Font("宋体", Font.PLAIN, 17));
		contentPane.add(label_1);
		
		final JLabel Show = new JLabel("");
		Show.setFont(new Font("宋体", Font.PLAIN, 17));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, Show, -72, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, Show, 0, SpringLayout.EAST, label_1);
		contentPane.add(Show);
		
		final JRadioButton radioButton = new JRadioButton("\u5B66\u751F");
		radioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(radioButton.isSelected())
				{
					Show.setText("学号");
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, radioButton, 0, SpringLayout.NORTH, label_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, radioButton, 37, SpringLayout.EAST, label_1);
		contentPane.add(radioButton);
		
		final JRadioButton radioButton_1 = new JRadioButton("\u8001\u5E08");
		radioButton_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
//				;
				if(radioButton_1.isSelected())
					Show.setText("教师号");
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, radioButton_1, 18, SpringLayout.SOUTH, radioButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, radioButton_1, 0, SpringLayout.WEST, radioButton);
		contentPane.add(radioButton_1);
		
		final JRadioButton radioButton_2 = new JRadioButton("\u7BA1\u7406\u5458");
		radioButton_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(radioButton_2.isSelected())
					Show.setText("管理员名");
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, radioButton_2, 18, SpringLayout.SOUTH, radioButton_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, radioButton_2, 0, SpringLayout.WEST, radioButton);
		contentPane.add(radioButton_2);
		
		ButtonGroup Type = new ButtonGroup();
		Type.add(radioButton);
		Type.add(radioButton_1);
		Type.add(radioButton_2);
		
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 45, SpringLayout.SOUTH, radioButton_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 144, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, -149, SpringLayout.EAST, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					Connection conn = nihao.createconnection();
					String str =null;
					java.sql.Statement sql = conn.createStatement();
					switch (Show.getText())
					{
					case "学号":
						str = "delete from s where sno = '"
								+ textField.getText() + "'";
						break;
					case "教师号":
						str = "delete from t where tno = '"
								+ textField.getText() + "'";
						break;
					case "管理员名":
						str = "delete from myuser where uname = '"
								+ textField.getText() + "'";
						break;
					}
					int num = sql.executeUpdate(str);
					JOptionPane jo = new JOptionPane();
					if(num == 1)
					{
						jo.showMessageDialog(null, "删除用户成功");
					}
					if(num == 0)
					{
						jo.showMessageDialog(null, "用户删除失败");
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
		sl_contentPane.putConstraint(SpringLayout.WEST, btnDelete, 0, SpringLayout.WEST, label_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnDelete, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnDelete);
		
		JButton button = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Delete_user.this.dispose();
				MainWindow Main = new MainWindow();
				Main.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, btnDelete);
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 98, SpringLayout.EAST, btnDelete);
		contentPane.add(button);
	}
}
