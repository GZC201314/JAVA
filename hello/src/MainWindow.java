import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.Color;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;


public class MainWindow extends JFrame
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
					MainWindow frame = new MainWindow();
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
	public MainWindow()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 425);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("\u6559\u52A1\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 184, SpringLayout.WEST, contentPane);
		lblNewLabel.setFont(new Font("华文新魏", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JList list = new JList();
		sl_contentPane.putConstraint(SpringLayout.NORTH, list, 134, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, list, 142, SpringLayout.WEST, contentPane);
		contentPane.add(list);
		
		final JTree tree = new JTree();
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
//			public void valueChanged(TreeSelectionEvent e)
//			{
//			}
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
				if(node.isLeaf())
				{
					String Item = (String) node.getUserObject();
//					JOptionPane po = new JOptionPane();
//					po.showMessageDialog(null, Item);
					if("申请空教室".equals(Item))
					{
						MainWindow.this.dispose();
						Room room = new Room();
						room.setVisible(true);
					}
					if("查询课程".equals(Item))
					{
						MainWindow.this.dispose();
						Course cour = new Course();
						cour.setVisible(true);
					}
					if("查看学生信息".equals(Item))
					{
						MainWindow.this.dispose();
						Student stu = new Student();
						stu.setVisible(true);
					}
					if("查看个人信息".equals(Item))
					{
						MainWindow.this.dispose();
						Teacher tea = new Teacher();
						tea.setVisible(true);
					}
					if("修改个人信息".equals(Item))
					{
						MainWindow.this.dispose();
						Modify mod = new Modify();
						mod.setVisible(true);
					}
					if("我要上自习".equals(Item))
					{
						MainWindow.this.dispose();
						Studyself self = new Studyself();
						self.setVisible(true);
					}
					if("我要去上课".equals(Item))
					{
						MainWindow.this.dispose();
						Study stud = new Study();
						stud.setVisible(true);
					}
					if("个人信息修改".equals(Item))
					{
						MainWindow.this.dispose();
						S_modify mod1 =new S_modify();
						mod1.setVisible(true);
					}
					if("个人信息查询".equals(Item))
					{
						MainWindow.this.dispose();
						Select sel = new Select();
						sel.setVisible(true);
					}
					if("系统维护".equals(Item))
					{
						MainWindow.this.dispose();
						
						Updata up = new Updata();
						up.setVisible(true);
//						JOptionPane jo = new JOptionPane();
//						jo.showMessageDialog(null, "能力不够,该功能暂时还未开启!");
					}
					if("权限管理".equals(Item))
					{
						MainWindow.this.dispose();
						JOptionPane jo = new JOptionPane();
						jo.showMessageDialog(null, "能力不够,该功能暂时还未开启!");
					}
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, tree, 67, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, tree, 15, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, tree, -92, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, tree, -6, SpringLayout.WEST, list);
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("\u6559\u5B66\u670D\u52A1") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("\u6559\u5E08");
						node_1.add(new DefaultMutableTreeNode("\u7533\u8BF7\u7A7A\u6559\u5BA4"));
						node_1.add(new DefaultMutableTreeNode("\u67E5\u8BE2\u8BFE\u7A0B"));
						node_1.add(new DefaultMutableTreeNode("\u67E5\u770B\u5B66\u751F\u4FE1\u606F"));
						node_1.add(new DefaultMutableTreeNode("\u67E5\u770B\u4E2A\u4EBA\u4FE1\u606F"));
						node_1.add(new DefaultMutableTreeNode("\u4FEE\u6539\u4E2A\u4EBA\u4FE1\u606F"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("\u5B66\u751F");
						node_1.add(new DefaultMutableTreeNode("\u6211\u8981\u4E0A\u81EA\u4E60"));
						node_1.add(new DefaultMutableTreeNode("\u6211\u8981\u53BB\u4E0A\u8BFE"));
						node_1.add(new DefaultMutableTreeNode("\u4E2A\u4EBA\u4FE1\u606F\u4FEE\u6539"));
						node_1.add(new DefaultMutableTreeNode("\u4E2A\u4EBA\u4FE1\u606F\u67E5\u8BE2"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("\u7BA1\u7406\u5458");
						node_1.add(new DefaultMutableTreeNode("\u7CFB\u7EDF\u7EF4\u62A4"));
						node_1.add(new DefaultMutableTreeNode("\u6743\u9650\u7BA1\u7406"));
					add(node_1);
				}
			}
		));
		contentPane.add(tree);
	}
}
