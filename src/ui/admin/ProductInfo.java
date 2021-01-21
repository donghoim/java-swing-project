package ui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import data.Member;
import data.Product;
import data.db.ProductDBMgr;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ProductInfo extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtImagePath;
	private JTextField txtPrice;
	private JTextField txtRegDate;
	private final ButtonGroup btnHotIceGruop = new ButtonGroup();
	private JTable pdTable;
	JComboBox comboCatgory;
	JRadioButton rdHot;
	JRadioButton rdIce;
	private JTextField txtID;
	ProductDBMgr mgr ;
	ProductInfo PInfo;
	JLabel lbImage;
	private JTextField txtSearch;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ProductInfo frame = new ProductInfo();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
	public ProductInfo() {
		this.PInfo =PInfo;
		this.mgr= new ProductDBMgr();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("\uC0C1\uD488\uAD00\uB9AC");
		setBounds(100, 100, 926, 734);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.7);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JPanel pnMain = new JPanel();
		pnMain.setBackground(new Color(0, 101, 70));
		splitPane.setLeftComponent(pnMain);
		pnMain.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC0C1\uD488 \uB9AC\uC2A4\uD2B8");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("HY�߰��", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 165, 49);
		pnMain.add(lblNewLabel);
		
		JButton btnProductList = new JButton("\uC0C1\uD488 \uC804\uCCB4 \uB9AC\uC2A4\uD2B8");
		btnProductList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtSearch.setText("");
				showSearchProduct("");
			}
		});
		btnProductList.setFont(new Font("����", Font.PLAIN, 12));
		btnProductList.setBounds(446, 24, 125, 23);
		pnMain.add(btnProductList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(36, 69, 541, 553);
		pnMain.add(scrollPane);
		
		pdTable = new JTable();
		pdTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				 {"���� ��ȣ", "��ǰ��", "ī�װ�", "�������ϰ��", "����", "HOT/ICE" ,"�����"};
				
				int selRow = pdTable.getSelectedRow();
			
				
				if(pdTable.getValueAt(selRow, 2).toString().equalsIgnoreCase("coffee")) {
					comboCatgory.setSelectedIndex(0);
				}else if (pdTable.getValueAt(selRow, 2).toString().equals("Beverage")) {
					comboCatgory.setSelectedIndex(1);
				}else if(pdTable.getValueAt(selRow, 2).toString().equals("Salad")){
					comboCatgory.setSelectedIndex(2);
				}else {
					comboCatgory.setSelectedIndex(3);
				}
				
				int id = (int) pdTable.getValueAt(selRow, 0);
				String name = (String) pdTable.getValueAt(selRow, 1);
				
				String imagePath = (String) pdTable.getValueAt(selRow, 3);
				int price =Integer.parseInt(pdTable.getValueAt(selRow, 4).toString());
				
				
				if( pdTable.getValueAt(selRow, 5).toString() == "HOT") rdHot.setSelected(true);
				else rdIce.setSelected(true);
//				Date regDate =(Date) pdTable.getValueAt(selRow, 6);
				
				
				txtID.setText(String.valueOf(id));
				txtName.setText(name);
				txtImagePath.setText(imagePath);
				lbImage.setIcon(new ImageIcon( "C:\\dev2020\\java_ws\\Starbucks\\images\\menu\\"+ imagePath));
				txtPrice.setText(String.valueOf(price));
				Date regDate = (Date) pdTable.getValueAt(selRow,6);
				String DayStr = regDate.toString();
				txtRegDate.setText(DayStr);
//				
				
				
//				comboCatgory.getSelectedIndex()pdTable.getValueAt(selRow, 2); // comboBox
			}
		});
		scrollPane.setViewportView(pdTable);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String target = txtSearch.getText();
				showSearchProduct(target);
			}
		});
		txtSearch.setBounds(189, 24, 186, 25);
		pnMain.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnclear = new JButton("");
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSearch.setText("");
//				showAllProduct();
				showSearchProduct("");
			}
		});
		btnclear.setToolTipText("\uD14D\uC2A4\uD2B8 \uC9C0\uC6B0\uAE30");
		btnclear.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\icons\\bin.png"));
		btnclear.setBounds(387, 25, 47, 23);
		pnMain.add(btnclear);
		
		JPanel pnSub = new JPanel();
		pnSub.setBackground(new Color(255, 255, 255));
		splitPane.setRightComponent(pnSub);
		pnSub.setLayout(null);
		
		lbImage = new JLabel("");
		
		lbImage.setHorizontalAlignment(SwingConstants.CENTER);
		lbImage.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\logo\\\uB85C\uACE0(150x150).png"));
		lbImage.setBackground(new Color(0, 255, 0));
		lbImage.setBounds(12, 20, 245, 220);
		pnSub.add(lbImage);
		
		JLabel lbID = new JLabel("\uAD00\uB9AC \uBC88\uD638");
		lbID.setHorizontalAlignment(SwingConstants.CENTER);
		lbID.setFont(new Font("����", Font.BOLD, 13));
		lbID.setBounds(12, 266, 105, 18);
		pnSub.add(lbID);
		
		JLabel label = new JLabel("\uC0C1\uD488\uBA85");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("����", Font.BOLD, 13));
		label.setBounds(12, 314, 105, 18);
		pnSub.add(label);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(129, 311, 128, 21);
		pnSub.add(txtName);
		
		JLabel label_1 = new JLabel("\uCE74\uD14C\uACE0\uB9AC");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("����", Font.BOLD, 13));
		label_1.setBounds(12, 360, 105, 18);
		pnSub.add(label_1);
		
		JLabel label_2 = new JLabel("\uC0AC\uC9C4\uD30C\uC77C\uACBD\uB85C");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("����", Font.BOLD, 13));
		label_2.setBounds(12, 405, 105, 18);
		pnSub.add(label_2);
		
		txtImagePath = new JTextField();
		txtImagePath.setColumns(10);
		txtImagePath.setBounds(129, 404, 105, 21);
		pnSub.add(txtImagePath);
		
		JLabel label_3 = new JLabel("\uAC00\uACA9");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("����", Font.BOLD, 13));
		label_3.setBounds(12, 457, 105, 18);
		pnSub.add(label_3);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(129, 454, 128, 21);
		pnSub.add(txtPrice);
		
		JLabel label_4 = new JLabel("\uC720\uBB34");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("����", Font.BOLD, 13));
		label_4.setBounds(12, 504, 105, 18);
		pnSub.add(label_4);
		
		JButton btnNewButton = new JButton("\uC0C1\uD488 \uCD94\uAC00");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				int id = Integer.parseInt(txtID.getText());
				String name = txtName.getText();
				String category= (String) comboCatgory.getSelectedItem();
				String imagePath = txtImagePath.getText().substring(41);
				int price = Integer.parseInt(txtPrice.getText());
				int hot = rdHot.isSelected()?1:2;
				
				Product pd = new Product(name, category, imagePath, price, hot);
				
				
				
				if(mgr.addNewOneProduct(pd) == true) {
					JOptionPane.showMessageDialog(null, name+"�߰� ����!!");
				}else {
					JOptionPane.showMessageDialog(null, name+"�߰� ����!!");
				}
				
				
			}

			
		});
		btnNewButton.setBounds(23, 584, 108, 23);
		pnSub.add(btnNewButton);
		
		JButton button = new JButton("\uBAA9\uB85D \uBE44\uC6B0\uAE30");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtID.setText("");
				txtName.setText("");
				txtImagePath.setText("");
				comboCatgory.setSelectedIndex(1);
				btnHotIceGruop.clearSelection();
				txtPrice.setText("");
				txtRegDate.setText("");
				lbImage.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\logo\\�ΰ�(150x150).png"));
				
			}
		});
		button.setBounds(143, 584, 114, 23);
		pnSub.add(button);
		
		JButton button_1 = new JButton("\uC0C1\uD488 \uC218\uC815");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtID.getText());
				String name = txtName.getText();
				String category= (String) comboCatgory.getSelectedItem();
				String imagePath = txtImagePath.getText();
				int price = Integer.parseInt(txtPrice.getText());
				int hot = rdHot.isSelected()?1:2;
				String date = txtRegDate.getText();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date regDay = null;
				try {
					regDay = sdf.parse(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
				
				Product pd = new Product(id, name, category, imagePath, price, hot, regDay);
				boolean b =mgr.editOneProduct(pd);
				if(b) {
					JOptionPane.showMessageDialog(null,name+"���� ����!!");	
					}else {
						JOptionPane.showMessageDialog(null,name+"���� ����!!");	
					}
				
			}
		});
		button_1.setBounds(23, 629, 108, 23);
		pnSub.add(button_1);
		
		JButton button_2 = new JButton("\uC0C1\uD488 \uC0AD\uC81C");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id =Integer.parseInt(txtID.getText());
				String name =txtName.getText();
				int r =mgr.deleteOneProdcut(id,name);
				if (r == 1) {
					JOptionPane.showMessageDialog(null, name+"��ǰ ���� ����");
				}else {
					JOptionPane.showMessageDialog(null, name+"ȸ�� ���� ����");
				}
			}
		});
		button_2.setBounds(144, 629, 113, 23);
		pnSub.add(button_2);
		
		JLabel label_5 = new JLabel("\uCD9C\uC2DC\uC77C");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("����", Font.BOLD, 13));
		label_5.setBounds(12, 541, 105, 18);
		pnSub.add(label_5);
		
		txtRegDate = new JTextField();
		txtRegDate.setEditable(false);
		txtRegDate.setColumns(10);
		txtRegDate.setBounds(129, 538, 128, 21);
		pnSub.add(txtRegDate);
		
		rdHot = new JRadioButton("HOT");
		btnHotIceGruop.add(rdHot);
		rdHot.setBounds(129, 500, 62, 23);
		pnSub.add(rdHot);
		
		rdIce = new JRadioButton("ICE");
		btnHotIceGruop.add(rdIce);
		rdIce.setBounds(195, 500, 53, 23);
		pnSub.add(rdIce);
		
		comboCatgory = new JComboBox();
		comboCatgory.setModel(new DefaultComboBoxModel(new String[] {"Coffee", "Beverage", "Salad", "Dessert"}));
		comboCatgory.setSelectedIndex(0);
		comboCatgory.setBounds(129, 357, 128, 21);
		pnSub.add(comboCatgory);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(129, 265, 128, 21);
		pnSub.add(txtID);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String currentDirectoryPath 
				= "./images";
			JFileChooser openDlg = new JFileChooser(currentDirectoryPath);
			int r = openDlg.showOpenDialog(PInfo);
			if( r == JFileChooser.APPROVE_OPTION ) {
				File selImgFile 
					= openDlg.getSelectedFile();
				txtImagePath.setText(selImgFile.getPath());
				lbImage.setIcon(new ImageIcon(selImgFile.getPath()));
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\icons\\folder.png"));
		btnNewButton_1.setBounds(235, 403, 22, 23);
		pnSub.add(btnNewButton_1);
		
		
	}
	public void showSearchProduct(String target) {
		final String [] columnNames = {"���� ��ȣ", "��ǰ��", "ī�װ�", "�������ϰ��", "����", "HOT/ICE" ,"�����"};
		
		//DB 
		ProductDBMgr pdMgr = new ProductDBMgr();
		ArrayList<Product> pdList =pdMgr.getAllProducts();
		Object[][] data = new Object[pdList.size()][columnNames.length];
		
		for (int i = 0; i < pdList.size(); i++) {
			Product pd = pdList.get(i);
				data[i][0] = pd.getId();
				data[i][1] = pd.getName();
				data[i][2] = pd.getCategory();
				data[i][3] = pd.getImagePath();
				data[i][4] = pd.getPrice();
				data[i][5] = pd.getHot() == 1 ? "HOT":"ICE";
				data[i][6] = pd.getRegDay();
				
			}
		
		
		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
		pdTable.setModel(dtm);
		
	
		

		TableRowSorter<TableModel> trs=new TableRowSorter<TableModel>(pdTable.getModel());

		pdTable.setRowSorter(trs);

		trs.setRowFilter(RowFilter.regexFilter(target));
		
	}
	public void searchProduct(String target) {
	      TableRowSorter<TableModel> trs=new TableRowSorter<TableModel>( pdTable.getModel());

	      pdTable.setRowSorter(trs);

	      trs.setRowFilter(RowFilter.regexFilter(target));
	   }


	protected void showAllProduct() {
		String [] columnNames = {"���� ��ȣ", "��ǰ��", "ī�װ�", "�������ϰ��", "����", "HOT/ICE" ,"�����"};
		ProductDBMgr pdMgr = new ProductDBMgr();
		ArrayList<Product> pdList = pdMgr.getAllProducts();
		Object[][] data = new Object[pdList.size()][columnNames.length];
		
		for (int i = 0; i < pdList.size(); i++) {
		Product pd = pdList.get(i);
			data[i][0] = pd.getId();
			data[i][1] = pd.getName();
			data[i][2] = pd.getCategory();
			data[i][3] = pd.getImagePath();
			data[i][4] = pd.getPrice();
			data[i][5] = pd.getHot() == 1 ? "HOT":"ICE";
			data[i][6] = pd.getRegDay();
			
		}
		
		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
		pdTable.setModel(dtm);
	}
}
