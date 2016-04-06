import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

import org.eclipse.jface.text.hyperlink.HyperlinkManager.DETECTION_STRATEGY;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Updata extends JFrame
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
					Updata frame = new Updata();
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
	public Updata()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel label = new JLabel("\u7BA1\u7406\u5458\u7EF4\u62A4\u754C\u9762");
		label.setFont(new Font("宋体", Font.PLAIN, 23));
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 140, SpringLayout.WEST, contentPane);
		contentPane.add(label);
		
		final JRadioButton add = new JRadioButton("\u7528\u6237\u6DFB\u52A0");
		add.setFont(new Font("宋体", Font.PLAIN, 17));
		sl_contentPane.putConstraint(SpringLayout.NORTH, add, 31, SpringLayout.SOUTH, label);
		sl_contentPane.putConstraint(SpringLayout.WEST, add, 147, SpringLayout.WEST, contentPane);
		contentPane.add(add);
		
		final JRadioButton delete = new JRadioButton("\u7528\u6237\u5220\u9664");
		sl_contentPane.putConstraint(SpringLayout.NORTH, delete, 25, SpringLayout.SOUTH, add);
		sl_contentPane.putConstraint(SpringLayout.WEST, delete, 0, SpringLayout.WEST, add);
		delete.setFont(new Font("宋体", Font.PLAIN, 17));
		contentPane.add(delete);
		
		final JRadioButton updata = new JRadioButton("\u66F4\u65B0\u7A7A\u6559\u5BA4\u4FE1\u606F");
		sl_contentPane.putConstraint(SpringLayout.NORTH, updata, 24, SpringLayout.SOUTH, delete);
		sl_contentPane.putConstraint(SpringLayout.WEST, updata, 0, SpringLayout.WEST, add);
		updata.setFont(new Font("宋体", Font.PLAIN, 17));
		contentPane.add(updata);
		
		final JRadioButton radioButton = new JRadioButton("\u6559\u5B66\u4FE1\u606F\u7EF4\u62A4");
		sl_contentPane.putConstraint(SpringLayout.NORTH, radioButton, 30, SpringLayout.SOUTH, updata);
		sl_contentPane.putConstraint(SpringLayout.WEST, radioButton, 0, SpringLayout.WEST, add);
		radioButton.setFont(new Font("宋体", Font.PLAIN, 17));
		contentPane.add(radioButton);
		
		final ButtonGroup Item = new ButtonGroup();
		Item.add(add);
		Item.add(delete);
		Item.add(updata);
		Item.add(radioButton);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane jo = new JOptionPane();
				if(add.isSelected())
				{
					Updata.this.dispose();
//					nihao ni = new nihao();
					Sign_in signin = new Sign_in();
					signin.setVisible(true);
					
//					Add_user adduser = new Add_user();
//					adduser.setVisible(true);
				}
				else if(delete.isSelected())
				{
					Updata.this.dispose();
					Sign_in1 signin = new Sign_in1();
					signin.setVisible(true);
				}
				else if(updata.isSelected())
				{
					Updata.this.dispose();
					Sign_in2 signin = new Sign_in2();
					signin.setVisible(true);
				}
				else if(radioButton.isSelected())
				{
//					Updata.this.dispose();
					JOptionPane jo2 = new JOptionPane();
					jo.showMessageDialog(null, "该功能还没有开放");
				}
				else
				{
					JOptionPane jo1 = new JOptionPane();
					jo.showMessageDialog(null, "你没有选择需要的服务,请选择你需要的服务");
				}
				
//					jo.showMessageDialog(null, "用户天界功能让那个");
//				JOptionPane.showMessageDialog(null, );
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 78, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button, -38, SpringLayout.SOUTH, contentPane);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button_1, 0, SpringLayout.NORTH, button);
		sl_contentPane.putConstraint(SpringLayout.WEST, button_1, 136, SpringLayout.EAST, button);
		contentPane.add(button_1);
	}
}
