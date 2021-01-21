package ui.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import data.db.MemberDBMgr;
import ui.admin.adminLoginDialog;
import ui.admin.adminMain;
import ui.find.IdOrPwFindFrame;
import member.MemberJoinFrame;
import member.MemberShipFrame;
import menu.main.MainMenuFrame;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField passwordField;
	JLabel lbLoginMessage;
	public static String Login ="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setResizable(false);
		setTitle("��Ÿ���� ���� �ֹ� ���α׷�");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\User\\Desktop\\\uC2A4\uD0C0\uBC85\uC2A4\\\uB85C\uACE0(50x50).jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 250, 821, 536);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new EmptyBorder(0, 0, 0, 0));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(
				new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\logo\\\uB85C\uACE0(250x250).png"));
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);

		txtLogin = new JTextField();
		txtLogin.setFont(new Font("����", Font.PLAIN, 12));
		txtLogin.setBounds(86, 120, 205, 21);
		panel.add(txtLogin);
		
		txtLogin.setColumns(10);

		JLabel lbLoginId = new JLabel("���̵�");
		lbLoginId.setFont(new Font("����", Font.PLAIN, 12));
		lbLoginId.setHorizontalAlignment(SwingConstants.RIGHT);
		lbLoginId.setBounds(12, 123, 57, 15);
		panel.add(lbLoginId);

		JLabel lbLoginPw = new JLabel("��й�ȣ");
		lbLoginPw.setFont(new Font("����", Font.PLAIN, 12));
		lbLoginPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lbLoginPw.setBounds(12, 166, 57, 15);
		panel.add(lbLoginPw);

		JButton btnLogin = new JButton("\uB85C\uADF8\uC778");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = txtLogin.getText();
	            String pw = new String(passwordField.getPassword());
	            MemberDBMgr mgr = new MemberDBMgr();
	            int r = mgr.loginProcess(login, pw);
	            switch (r) {
	            case MemberDBMgr.LOGIN_SUCCESS:
	               lbLoginMessage.setText("�α��ο� �����ϼ̽��ϴ�.");
	               lbLoginMessage.setForeground(Color.black);
	               JOptionPane.showMessageDialog(null, "�α��ο� �����ϼ̽��ϴ�.");
	               Login = txtLogin.getText();
	               MainMenuFrame menuFrm = new MainMenuFrame();
	               menuFrm.setVisible(true);

	               break;

	            case MemberDBMgr.LOGIN_NOT_FOUND:
	               lbLoginMessage.setText("ȸ���� ������ ã�� �� �����ϴ�.");
	               lbLoginMessage.setForeground(Color.red);
	               JOptionPane.showMessageDialog(null, "ȸ���� ������ ã�� �� �����ϴ�.");
	               break;

	            case MemberDBMgr.LOGIN_PW_MISMATCH:
	               lbLoginMessage.setText("�α��� Ȥ�� ��й�ȣ�� Ʋ���̽��ϴ�.");
	               lbLoginMessage.setForeground(Color.red);
	               JOptionPane.showMessageDialog(null, "�α��� Ȥ�� ��й�ȣ�� Ʋ���̽��ϴ�.");
	               break;

	            case MemberDBMgr.LOGIN_ERROR:
	               lbLoginMessage.setText("�������� �ʴ� �����Դϴ�.");
	               lbLoginMessage.setForeground(Color.red);
	               JOptionPane.showMessageDialog(null, "�������� �ʴ� �����Դϴ�.");
	               break;

	            }
			}
		});
		btnLogin.setFont(new Font("����", Font.PLAIN, 12));
		btnLogin.setBackground(new Color(0, 102, 51));
		btnLogin.setBounds(303, 120, 87, 61);
		panel.add(btnLogin);

		JLabel lblNewLabel_2 = new JLabel("���ѹα����� ���� ���ִ� Ŀ��, ��Ÿ������ ȸ���� �ǽø�");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(29, 240, 344, 15);
		panel.add(lblNewLabel_2);

		JLabel label_1 = new JLabel("��Ÿ������ �پ��� ���񽺿� ������ ������ �� �ֽ��ϴ�.");
		label_1.setFont(new Font("����", Font.PLAIN, 12));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(29, 259, 344, 15);
		panel.add(label_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 219, 378, 2);
		panel.add(separator_1);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("����", Font.PLAIN, 12));
		passwordField.setBounds(86, 163, 205, 21);
		panel.add(passwordField);

		lbLoginMessage = new JLabel("");
		lbLoginMessage.setFont(new Font("����", Font.PLAIN, 12));
		lbLoginMessage.setBounds(86, 194, 270, 15);
		panel.add(lbLoginMessage);

		JLabel lblNewLabel_3 = new JLabel("���� ��Ÿ������ ȸ���� �ƴϽŰ���?");
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(86, 306, 304, 15);
		panel.add(lblNewLabel_3);

		JButton btnNewButton = new JButton("ȸ�������ϱ�");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberShipFrame frm = new MemberShipFrame();
				frm.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("����", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(0, 102, 51));
		btnNewButton.setBounds(86, 345, 304, 23);
		panel.add(btnNewButton);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\icons\\login(62x62).png"));
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(12, 306, 62, 62);
		panel.add(lblNewLabel_4);

		JLabel label_2 = new JLabel("��Ÿ���� ȸ������ Ư���� ������ ��������!");
		label_2.setFont(new Font("����", Font.PLAIN, 12));
		label_2.setForeground(new Color(0, 102, 51));
		label_2.setBounds(86, 325, 304, 15);
		panel.add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\icons\\search.png"));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(12, 394, 62, 62);
		panel.add(label_3);

		JButton button = new JButton("���̵� / ��й�ȣ ã��");
		button.setForeground(new Color(255, 255, 255));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdOrPwFindFrame frm = new IdOrPwFindFrame();
				frm.setVisible(true);

			}
		});
		button.setFont(new Font("����", Font.PLAIN, 12));
		button.setBackground(new Color(0, 102, 51));
		button.setBounds(86, 433, 304, 23);
		panel.add(button);

		JLabel label_4 = new JLabel("������ ���� ������ ���� ã�� �� �ֽ��ϴ�.");
		label_4.setFont(new Font("����", Font.PLAIN, 12));
		label_4.setForeground(new Color(0, 102, 51));
		label_4.setBounds(86, 413, 304, 15);
		panel.add(label_4);

		JLabel label_5 = new JLabel("���̵� / ��й�ȣ�� �����̳���?");
		label_5.setFont(new Font("����", Font.PLAIN, 12));
		label_5.setBounds(86, 394, 304, 15);
		panel.add(label_5);

		JLabel lblNewLabel_5 = new JLabel("\uBC18\uAC11\uC2B5\uB2C8\uB2E4.");
		lblNewLabel_5.setForeground(new Color(0, 102, 51));
		lblNewLabel_5.setFont(new Font("����", Font.BOLD, 20));
		lblNewLabel_5.setBounds(29, 20, 275, 24);
		panel.add(lblNewLabel_5);

		JLabel label_6 = new JLabel("��Ÿ�����Դϴ�.");
		label_6.setForeground(new Color(0, 102, 51));
		label_6.setFont(new Font("����", Font.BOLD, 20));
		label_6.setBounds(29, 43, 361, 24);
		panel.add(label_6);

		JLabel label_7 = new JLabel("���� �̿��� ���� �α��� ���ֽñ� �ٶ��ϴ�.");
		label_7.setFont(new Font("����", Font.PLAIN, 13));
		label_7.setBounds(29, 86, 284, 16);
		panel.add(label_7);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 10, 0, 463);
		panel.add(separator);
		
		JButton btnAdmin = new JButton("admin");
		btnAdmin.setFont(new Font("����", Font.PLAIN, 12));
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminLoginDialog ad = new adminLoginDialog();
				ad.setVisible(true);
				
			}
		});
		btnAdmin.setForeground(new Color(255, 255, 255));
		btnAdmin.setBackground(new Color(0, 121, 51));
		btnAdmin.setBounds(308, 20, 82, 23);
		panel.add(btnAdmin);
	}
}
