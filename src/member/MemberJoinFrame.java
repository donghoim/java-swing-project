package member;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import data.Member;
import data.db.MemberDBMgr;
import ui.main.MainFrame;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MemberJoinFrame extends JFrame {
	private JTextField txtId;
	private JPasswordField pfPassword;
	private JPasswordField pfPasswordCheck;
	private JTextField txtName;
	private JTextField txtMonth;
	private JTextField txtDay;
	private JTextField txtPhone2;
	private JTextField txtPhone3;
	private JTextField txtmail;
	private JTextField txtComboTomail;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	JComboBox comboMail;
	JLabel lbPwMessage;
	JLabel lbPwCheckMessage;
	JButton btnNext;
	JButton btnIdCheck;

	MemberDBMgr mgr;

	public MemberJoinFrame() {
		setResizable(false);
		setTitle("\uC2A4\uD0C0\uBC85\uC2A4 \uD68C\uC6D0\uAC00\uC785 \uC2DC\uC2A4\uD15C");

		mgr = new MemberDBMgr();
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 725, 700);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\logo\\\uB85C\uACE0(150x150).png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 21, 695, 150);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("ȸ�������� �����̸�, ���� ��� ���񽺸� �̿��Ͻ� �� �ֽ��ϴ�. (ȸ�������� �� 14�� �̻���� �����մϴ�.)");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(66, 200, 586, 15);
		getContentPane().add(label_1);

		JLabel label_2 = new JLabel("��Ÿ������ ���񽺸� �̿��ϱ� ���ؼ��� �Ʒ��� �׸��� ��� �Է��ϼž� �մϴ�.");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(106, 181, 506, 15);
		getContentPane().add(label_2);

		JLabel label_3 = new JLabel("* �������� �Է�");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("����", Font.PLAIN, 12));
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(12, 235, 682, 15);
		getContentPane().add(label_3);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 261, 695, 345);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lbId = new JLabel("���̵�");
		lbId.setFont(new Font("����", Font.PLAIN, 12));
		lbId.setHorizontalAlignment(SwingConstants.TRAILING);
		lbId.setBounds(12, 24, 103, 15);
		panel.add(lbId);

		JLabel lbPw = new JLabel("��й�ȣ");
		lbPw.setFont(new Font("����", Font.PLAIN, 12));
		lbPw.setHorizontalAlignment(SwingConstants.TRAILING);
		lbPw.setBounds(12, 63, 103, 15);
		panel.add(lbPw);

		JLabel lbPwCheck = new JLabel("��й�ȣ ��Ȯ��");
		lbPwCheck.setFont(new Font("����", Font.PLAIN, 12));
		lbPwCheck.setHorizontalAlignment(SwingConstants.TRAILING);
		lbPwCheck.setBounds(12, 101, 103, 15);
		panel.add(lbPwCheck);

		JLabel lbName = new JLabel("�̸�");
		lbName.setFont(new Font("����", Font.PLAIN, 12));
		lbName.setHorizontalAlignment(SwingConstants.TRAILING);
		lbName.setBounds(12, 143, 103, 15);
		panel.add(lbName);

		JLabel lbGender = new JLabel("����");
		lbGender.setFont(new Font("����", Font.PLAIN, 12));
		lbGender.setHorizontalAlignment(SwingConstants.TRAILING);
		lbGender.setBounds(12, 186, 103, 15);
		panel.add(lbGender);

		JLabel lbPhone = new JLabel("�ڵ�����ȣ");
		lbPhone.setFont(new Font("����", Font.PLAIN, 12));
		lbPhone.setHorizontalAlignment(SwingConstants.TRAILING);
		lbPhone.setBounds(12, 271, 103, 15);
		panel.add(lbPhone);

		JLabel lbBirth = new JLabel("�������");
		lbBirth.setFont(new Font("����", Font.PLAIN, 12));
		lbBirth.setHorizontalAlignment(SwingConstants.TRAILING);
		lbBirth.setBounds(12, 227, 103, 15);
		panel.add(lbBirth);

		JLabel lbEmail = new JLabel("�̸���");
		lbEmail.setFont(new Font("����", Font.PLAIN, 12));
		lbEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lbEmail.setBounds(12, 310, 103, 15);
		panel.add(lbEmail);

		txtId = new JTextField();
		txtId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtId.setForeground(Color.BLACK);
				txtId.setBackground(Color.YELLOW);
				String login = txtId.getText();
				if (login.equals("ID�� �Է��ϼ���!"))
					txtId.setText("");

			}

			@Override
			public void focusLost(FocusEvent e) {
				txtId.setBackground(Color.WHITE);
				txtId.setForeground(Color.LIGHT_GRAY);
				String login = txtId.getText();
				if (login.isEmpty()) {
					txtId.setText("ID�� �Է��ϼ���!");
				}
			}
		});
		txtId.setFont(new Font("����", Font.PLAIN, 12));
		txtId.setBounds(127, 21, 142, 21);
		panel.add(txtId);
		txtId.setColumns(10);

		pfPassword = new JPasswordField();
		pfPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pfPassword.setBackground(Color.ORANGE);
			}

			@Override
			public void focusLost(FocusEvent e) {
				pfPassword.setBackground(Color.WHITE);
			}
		});
		pfPassword.setFont(new Font("����", Font.PLAIN, 12));
		pfPassword.setBounds(127, 60, 142, 21);
		panel.add(pfPassword);

		pfPasswordCheck = new JPasswordField();
		pfPasswordCheck.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pfPasswordCheck.setBackground(Color.ORANGE);
				String pw1 = new String(pfPasswordCheck.getPassword());
				System.out.println("ù��° ��ȣ: " + pw1);
				if (pw1.isEmpty() && pw1.length() < 4) {
					lbPwMessage.setForeground(Color.RED);
					lbPwMessage.setText("�н����带 �ٽ� Ȯ�����ּ���");
					pfPasswordCheck.requestFocusInWindow();
					// ��Ŀ�� �̵� ��û..
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				pfPasswordCheck.setBackground(Color.WHITE);
				String pw1 = new String(pfPasswordCheck.getPassword());
				String pw2 = new String(pfPasswordCheck.getPassword());
				System.out.println("�ι�° ��ȣ: " + pw2);
				if (pw2.isEmpty()) {
					lbPwCheckMessage.setForeground(Color.RED);
					lbPwCheckMessage.setText("�н����带 �ٽ� Ȯ�����ּ���");
				} else { // �ΰ� ���� ��...
					if (pw2.equals(pw1)) {
						System.out.println("��밡���� ��й�ȣ�Դϴ�.");
						lbPwCheckMessage.setForeground(Color.BLUE);
						lbPwCheckMessage.setText("��밡���� ��й�ȣ�Դϴ�.");
						lbPwMessage.setText("");
						// ���� ��ư Ȱ��ȭ! �̤�

						checkJoinAvailable();

					} else {
						System.out.println("��ȣ�� ����ġ�մϴ�.");
						lbPwCheckMessage.setForeground(Color.RED);
						lbPwCheckMessage.setText("��ȣ�� ����ġ�մϴ�.");
						pfPassword.requestFocusInWindow();
					}
				}
			}
		});
		pfPasswordCheck.setFont(new Font("����", Font.PLAIN, 12));
		pfPasswordCheck.setBounds(127, 98, 142, 21);
		panel.add(pfPasswordCheck);

		txtName = new JTextField();
		txtName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtName.setForeground(Color.BLACK);
				txtName.setBackground(Color.ORANGE);
				String name = txtName.getText();
				if (name.equals("�Ǹ��� �Է� �ϼ���!"))
					txtName.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				txtName.setBackground(Color.WHITE);
				txtName.setForeground(Color.LIGHT_GRAY);
				String name = txtName.getText();
				if (name.isEmpty()) {
					txtName.setText("�Ǹ��� �Է� �ϼ���!");
				}
			}
		});
		txtName.setFont(new Font("����", Font.PLAIN, 12));
		txtName.setColumns(10);
		txtName.setBounds(127, 140, 142, 21);
		panel.add(txtName);

		JRadioButton rdBtnMale = new JRadioButton("����");
		rdBtnMale.setFont(new Font("����", Font.PLAIN, 12));
		buttonGroup.add(rdBtnMale);
		rdBtnMale.setSelected(true);
		rdBtnMale.setBounds(123, 182, 49, 23);
		panel.add(rdBtnMale);

		JRadioButton rdBtnFemale = new JRadioButton("����");
		rdBtnFemale.setFont(new Font("����", Font.PLAIN, 12));
		buttonGroup.add(rdBtnFemale);
		rdBtnFemale.setBounds(183, 182, 49, 23);
		panel.add(rdBtnFemale);

		JComboBox comboYear = new JComboBox();
		comboYear.setModel(new DefaultComboBoxModel(new String[] { "1980", "1981", "1982", "1983", "1984", "1985",
				"1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998",
				"1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011",
				"2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));
		comboYear.setSelectedIndex(12);
		comboYear.setFont(new Font("����", Font.PLAIN, 12));
		comboYear.setBounds(127, 224, 105, 21);
		panel.add(comboYear);

		JLabel lblNewLabel = new JLabel("\uB144");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 12));
		lblNewLabel.setBounds(244, 227, 12, 15);
		panel.add(lblNewLabel);

		txtMonth = new JTextField();
		txtMonth.setFont(new Font("����", Font.PLAIN, 12));
		txtMonth.setBounds(268, 224, 116, 21);
		txtMonth.setHorizontalAlignment(JTextField.CENTER);
		panel.add(txtMonth);
		txtMonth.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\uC6D4");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(396, 227, 12, 15);
		panel.add(lblNewLabel_1);

		txtDay = new JTextField();
		txtDay.setHorizontalAlignment(JTextField.CENTER);
		txtDay.setFont(new Font("����", Font.PLAIN, 12));
		txtDay.setColumns(10);
		txtDay.setBounds(420, 224, 116, 21);
		panel.add(txtDay);

		JLabel lblNewLabel_2 = new JLabel("\uC77C");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(548, 227, 12, 15);
		panel.add(lblNewLabel_2);

		JComboBox comboPhone = new JComboBox();
		comboPhone.setFont(new Font("����", Font.PLAIN, 12));
		comboPhone.setModel(new DefaultComboBoxModel(new String[] { "010", "011", "017", "018", "019", "070" }));
		comboPhone.setBounds(127, 268, 105, 21);
		panel.add(comboPhone);

		JLabel lblNewLabel_3 = new JLabel("-");
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(244, 271, 6, 15);
		panel.add(lblNewLabel_3);

		txtPhone2 = new JTextField();
		txtPhone2.setHorizontalAlignment(JTextField.CENTER);
		txtPhone2.setFont(new Font("����", Font.PLAIN, 12));
		txtPhone2.setBounds(262, 268, 116, 21);
		panel.add(txtPhone2);
		txtPhone2.setColumns(10);

		JLabel label_4 = new JLabel("-");
		label_4.setFont(new Font("����", Font.PLAIN, 12));
		label_4.setBounds(390, 271, 6, 15);
		panel.add(label_4);

		txtPhone3 = new JTextField();
		txtPhone3.setHorizontalAlignment(JTextField.CENTER);
		txtPhone3.setFont(new Font("����", Font.PLAIN, 12));
		txtPhone3.setBounds(408, 268, 116, 21);
		panel.add(txtPhone3);
		txtPhone3.setColumns(10);

		txtmail = new JTextField();
		txtmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtmail.setFont(new Font("����", Font.PLAIN, 12));
		txtmail.setBounds(127, 307, 116, 21);
		panel.add(txtmail);
		txtmail.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("@");
		lblNewLabel_4.setFont(new Font("����", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(254, 310, 12, 15);
		panel.add(lblNewLabel_4);

		txtComboTomail = new JTextField();
		txtComboTomail.setHorizontalAlignment(SwingConstants.CENTER);
		txtComboTomail.setFont(new Font("����", Font.PLAIN, 12));
		txtComboTomail.setBounds(278, 307, 116, 21);
		panel.add(txtComboTomail);
		txtComboTomail.setColumns(10);

		comboMail = new JComboBox();
		comboMail.setFont(new Font("����", Font.PLAIN, 12));
		comboMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtComboTomail.setText(comboMail.getSelectedItem().toString());
			}
		});
		comboMail.setModel(new DefaultComboBoxModel(new String[] { "\uC9C1\uC811\uC785\uB825", "naver.com",
				"hanmail.net", "nate.com", "yahoo.com", "gmail.com", "hotmail.com" }));
		comboMail.setBounds(408, 307, 116, 21);
		panel.add(comboMail);

		lbPwMessage = new JLabel("4�� �̻����� �־��ּ���");
		lbPwMessage.setFont(new Font("����", Font.PLAIN, 12));
		lbPwMessage.setBounds(281, 63, 389, 15);
		panel.add(lbPwMessage);

		btnIdCheck = new JButton("�ߺ�Ȯ��");
		btnIdCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String targetLogin = txtId.getText();
				if (targetLogin.isEmpty() || targetLogin == null) {
					System.out.println("���̵� �ٽ� �Է��ϼ���");
				} else {
					Member mb = mgr.getOneMemberByLogin(targetLogin);
					if (mb == null) {// ���� ���̵� �ϰ�� ��� ����
						JOptionPane.showMessageDialog(null, "��밡���� ���̵��Դϴ�.");
						bLoginDup = false;
					} else { // �̹� ������ ����
						System.out.println("�ߺ��� ���̵� �ֽ��ϴ�.");
						JOptionPane.showMessageDialog(null, "�ߺ��� ���̵� �ֽ��ϴ�.");
						bLoginDup = true;
					}
				}
			}
		});
		btnIdCheck.setFont(new Font("����", Font.PLAIN, 12));
		btnIdCheck.setBackground(Color.WHITE);
		btnIdCheck.setBounds(281, 20, 97, 23);
		panel.add(btnIdCheck);

		lbPwCheckMessage = new JLabel("��й�ȣ�� �ѹ� �� �Է����ּ���.");
		lbPwCheckMessage.setBackground(Color.WHITE);
		lbPwCheckMessage.setFont(new Font("����", Font.PLAIN, 12));
		lbPwCheckMessage.setBounds(281, 101, 389, 15);
		panel.add(lbPwCheckMessage);

		JButton btnCancel = new JButton("����ϱ�");
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MainFrame frm = new MainFrame();
				frm.setVisible(true);
			}
		});
		btnCancel.setFont(new Font("����", Font.PLAIN, 12));
		btnCancel.setBackground(new Color(0, 102, 51));
		btnCancel.setBounds(168, 621, 178, 30);
		getContentPane().add(btnCancel);

		btnNext = new JButton("�����ܰ�");
		btnNext.setForeground(new Color(255, 255, 255));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ȸ������ DB ���...");
				// �Է� ������ ����
				String login = txtId.getText();
				String pw = new String(pfPassword.getPassword());
				String name = txtName.getText();
				int gender = rdBtnFemale.isSelected() ? Member.GENDER_FEMALE : Member.GENDER_MALE;
				String birth = comboYear.getSelectedItem() + txtMonth.getText() + txtDay.getText();
				String phone = (String)comboPhone.getSelectedItem() + txtPhone2.getText() + txtPhone3.getText();
				String email = txtmail.getText() + "@" + txtComboTomail.getText();

				// DB ����
				Member mb = new Member(name, login, pw, gender, birth, email, phone);
				boolean b = mgr.insertOneMember(mb);
				if (b) {
					JOptionPane.showMessageDialog(null, "�����մϴ�, ȸ�����Կ� �����ϼ̽��ϴ�.");
				} else {
					JOptionPane.showMessageDialog(null, "�����մϴ�, ȸ�����Կ� �����ϼ̽��ϴ�.");
				}

				dispose();
				MainFrame frm = new MainFrame();
				frm.setVisible(true);
			}
		});
		btnNext.setFont(new Font("����", Font.PLAIN, 12));
		btnNext.setBackground(new Color(0, 102, 51));
		btnNext.setBounds(378, 621, 178, 30);
		getContentPane().add(btnNext);

	}

	private boolean bLoginDup; // false �ߺ��ƴ�..

	protected void checkJoinAvailable() {
		// ����, �ߺ�.. ����. ����.. üũ..
		// ����.. validation + ����?
		String pw1 = new String(pfPassword.getPassword());
		String pw2 = new String(pfPasswordCheck.getPassword());

		if (!txtId.getText().isEmpty() && !txtName.getText().isEmpty()
				&& (!pw1.isEmpty() && !pw2.isEmpty() && pw1.equals(pw2)) && this.bLoginDup == false) {
			btnNext.setEnabled(false);
		} else {
			btnNext.setEnabled(true);
		}

	}
}
