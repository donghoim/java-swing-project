package ui.payment;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Member;
import data.Product;
import data.db.MemberDBMgr;
import data.db.ProductDBMgr;
import menu.basket.BasketPanel;
import menu.main.MainMenuFrame;
import menu.main.components.BasketContainer;
import ui.main.MainFrame;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MainMoney extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstCardNo;
	private JPasswordField pfSecond;
	private JPasswordField pfThird;
	private JTextField txtLast;
	JLabel lbCardImage;
	JPanel panel_2;
	JButton btnAccept;
	MainFrame fr;
	MemberDBMgr mgr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMoney frame = new MainMoney();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	JComboBox comboBox;
	
	public MainMoney() {
		this.mgr = new MemberDBMgr();
		this.fr = new MainFrame();
		setTitle("\uC2E0\uC6A9\uCE74\uB4DC \uACB0\uC81C\uD654\uBA74");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2020\\java_ws\\TProject\\images\\icon_card.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 0, 0, 0));
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(255, 255, 255),
				new Color(0, 0, 0), new Color(255, 255, 255)));
		panel_1.setBounds(12, 177, 557, 346);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(6, 2, 0, 0));

		JLabel lbName = new JLabel("\uACB0\uC81C\uC790 \uC131\uBA85");
		lbName.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\FamilyCafeteria\\icons\\control_play_blue.png"));
		panel_1.add(lbName);
		Member mb = mgr.getOneMemberByLogin(MainFrame.Login);

		JLabel lbNameIn = new JLabel("");
		String name = mb.getName();
		lbNameIn.setText(name);
		lbNameIn.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lbNameIn);

		JLabel lbCardComp = new JLabel("\uCE74\uB4DC\uC0AC\uB97C \uC120\uD0DD\uD574\uC8FC\uC138\uC694");
		lbCardComp.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\icons\\control_play_blue.png"));
		panel_1.add(lbCardComp);

		comboBox = new JComboBox();
		comboBox.setBackground(UIManager.getColor("text"));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uAD6D\uBBFC", "\uBE44\uC528", "\uC6B0\uB9AC", "\uD558\uB098", "\uD558\uB098(\uAD6C)\uC678\uD658", "\uC2E0\uD55C", "\uB18D\uD611", "\uAE30\uC5C5"}));
		comboBox.setSelectedIndex(0);
		
		
		panel_1.add(comboBox);

		JLabel lbCardNo = new JLabel("\uCE74\uB4DC \uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		lbCardNo.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\icons\\control_play_blue.png"));
		panel_1.add(lbCardNo);

		panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("text"));
		panel_1.add(panel_2);

		txtFirstCardNo = new JTextField();
		txtFirstCardNo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtFirstCardNo.setForeground(Color.BLACK);
				txtFirstCardNo.setBackground(Color.YELLOW);
			}

			@Override
			public void focusLost(FocusEvent e) {
				txtFirstCardNo.setBackground(Color.WHITE);
				txtFirstCardNo.setForeground(Color.BLACK);
			}
		});
		txtFirstCardNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				showCardImg(txtFirstCardNo);
			}
		});
		panel_2.add(txtFirstCardNo);
		txtFirstCardNo.setColumns(4);

		pfSecond = new JPasswordField();
		pfSecond.setColumns(4);
		pfSecond.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pfSecond.setForeground(Color.BLACK);
				pfSecond.setBackground(Color.YELLOW);
			}

			@Override
			public void focusLost(FocusEvent e) {
				pfSecond.setBackground(Color.WHITE);
				pfSecond.setForeground(Color.BLACK);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("-");
		panel_2.add(lblNewLabel_1);
		panel_2.add(pfSecond);

		pfThird = new JPasswordField();
		pfThird.setColumns(4);
		pfThird.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pfThird.setForeground(Color.BLACK);
				pfThird.setBackground(Color.YELLOW);
			}

			@Override
			public void focusLost(FocusEvent e) {
				pfThird.setBackground(Color.WHITE);
				pfThird.setForeground(Color.BLACK);
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("-");
		panel_2.add(lblNewLabel_2);
		panel_2.add(pfThird);

		txtLast = new JTextField();
		txtLast.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtLast.setForeground(Color.BLACK);
				txtLast.setBackground(Color.YELLOW);
			}

			@Override
			public void focusLost(FocusEvent e) {
				txtLast.setBackground(Color.WHITE);
				txtLast.setForeground(Color.BLACK);
			}
		});
		
		JLabel label = new JLabel("-");
		panel_2.add(label);
		panel_2.add(txtLast);
		txtLast.setColumns(4);

		lbCardImage = new JLabel("");
		lbCardImage.setSize(350, 400);
		panel_2.add(lbCardImage);
//	      showCardImg(txtFirstCardNo);

		JLabel lbPhone = new JLabel("\uC5F0\uB77D\uCC98 ( - \uC5C6\uC774 \uC785\uB825\uD574\uC8FC\uC138\uC694)");
		lbPhone.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\icons\\control_play_blue.png"));
		panel_1.add(lbPhone);

		mb =mgr.getOneMemberByLogin(MainFrame.Login);
	     String phone = mb.getPhone();
	     JLabel lbPhoneNo = new JLabel(phone);
		lbPhoneNo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lbPhoneNo);

		JLabel lbEmail = new JLabel("\uC774\uBA54\uC77C");
		lbEmail.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\icons\\control_play_blue.png"));
		panel_1.add(lbEmail);

		String email = mb.getEmail();
		JLabel lbEmail2 = new JLabel(email);
		lbEmail2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lbEmail2);

		JLabel lbTotalPrice = new JLabel("\uCD1D \uACB0\uC81C\uAE08\uC561");
		lbTotalPrice.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\FamilyCafeteria\\icons\\control_play_blue.png"));
		panel_1.add(lbTotalPrice);

		JLabel lbTotalMoney = new JLabel("");
		lbTotalMoney.setHorizontalAlignment(SwingConstants.CENTER);

		int totalPrice = 0;
		ArrayList<BasketPanel> odList = BasketContainer.bkList;
		for (int i = 0; i < odList.size(); i++) {
			int OnePdtotalPrice = Integer.parseInt(odList.get(i).pnOC.txtVal.getText());
			int productPrice = odList.get(i).product.getPrice();
			int onePdtotalPrice = productPrice * OnePdtotalPrice;
//	         pro

			totalPrice += onePdtotalPrice;
		}
		lbTotalMoney.setText(String.valueOf(totalPrice) + "��");

//	      BasketPanel bp = new BasketPanel(frm, pr, amount);

		panel_1.add(lbTotalMoney);

		btnAccept = new JButton("\uACB0\uC81C\uC694\uCCAD");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lbNameIn.getText().isEmpty() && !txtFirstCardNo.getText().isEmpty() && !txtLast.getText().isEmpty()
						&& !lbPhoneNo.getText().isEmpty() && !lbEmail2.getText().isEmpty()) {
					AgreementMoney mny = new AgreementMoney();
					mny.setVisible(true);
					btnAccept.setEnabled(true);
					dispose();
				} else {
					btnAccept.setEnabled(false);
				}

			}
		});
		btnAccept.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\icons\\control_play_blue.png"));
		btnAccept.setBounds(144, 533, 120, 23);
		panel.add(btnAccept);

		JButton btnClose = new JButton("\uB2EB\uAE30");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\icons\\control_play_blue.png"));
		btnClose.setBounds(316, 533, 97, 23);
		panel.add(btnClose);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\logo\\\uB85C\uACE0(150x150).png"));
		lblNewLabel.setBounds(12, 10, 557, 157);
		panel.add(lblNewLabel);
	}
	
	public void showCardImg(JTextField txtFirstCardNo) {
		if (txtFirstCardNo != null) {
			if (txtFirstCardNo.getText().equals("9420") || txtFirstCardNo.getText().equals("9421")
					|| txtFirstCardNo.getText().equals("9430")) { // bc
				ImageIcon ic = new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\card\\bc.png");
				lbCardImage.setIcon(ic);
				lbCardImage.repaint();
			}
			if (txtFirstCardNo.getText().equals("9409")) { // �Ե�
				ImageIcon ic = new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\card\\lt.jpg");
				lbCardImage.setIcon(ic);
				lbCardImage.repaint();
			}
			if (txtFirstCardNo.getText().equals("9410")) { // �Ｚī��
				ImageIcon ic = new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\card\\ss.PNG");
				lbCardImage.setIcon(ic);
				lbCardImage.repaint();
			}
			if (txtFirstCardNo.getText().equals("9407")) { // ����
				ImageIcon ic = new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\card\\soo.jpg");
				lbCardImage.setIcon(ic);
				lbCardImage.repaint();
			}
			if (txtFirstCardNo.getText().equals("9420")) { // ����
				ImageIcon ic = new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\card\\sh.jpg");
				lbCardImage.setIcon(ic);
				lbCardImage.repaint();
			}
			if (txtFirstCardNo.getText().equals("9411") || txtFirstCardNo.getText().equals("9441")
					|| txtFirstCardNo.getText().equals("9463")) { // ����
				ImageIcon ic = new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\card\\nh.png");
				lbCardImage.setIcon(ic);
				lbCardImage.repaint();
			}
			if (txtFirstCardNo.getText().equals("9436") || txtFirstCardNo.getText().equals("9445")
					|| txtFirstCardNo.getText().equals("9490")) { // kb
				ImageIcon ic = new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\card\\kb.png");
				lbCardImage.setIcon(ic);
				lbCardImage.repaint();
			}
			if (txtFirstCardNo.getText().equals("9425") || txtFirstCardNo.getText().equals("9445")) { // �츮
				ImageIcon ic = new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\card\\wr.png");
				lbCardImage.setIcon(ic);
				lbCardImage.repaint();
			}
			if (txtFirstCardNo.getText().equals("9400")) { // ��Ƽ
				ImageIcon ic = new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\card\\ct.png");
				lbCardImage.setIcon(ic);
				lbCardImage.repaint();
			}
			if (txtFirstCardNo.getText().equals("9490")) { // ����
				ImageIcon ic = new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\card\\hd.jpg");
				lbCardImage.setIcon(ic);
				lbCardImage.repaint();
			}
		} else {
			lbCardImage.setText("");
		}

	}
}