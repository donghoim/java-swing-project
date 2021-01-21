package ui.find;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Member;
import data.db.MemberDBMgr;
import ui.main.MainFrame;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class IdFindDialog extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IdFindDialog dialog = new IdFindDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	JPanel pnCenter;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtCode;
	private JTextField txtId;
	private JTextField txtPwCode;

	MemberDBMgr mgr;
	private JTextField txtPhone2;
	private JTextField txtPwPhone2;
	private JTextField txtPwPhone3;

	public IdFindDialog() {

		mgr = new MemberDBMgr();

		setTitle("��Ÿ���� ���̵�/��й�ȣ ã�� �ý���");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 102, 51));
		menuBar.setBounds(0, 0, 434, 25);
		getContentPane().add(menuBar);

		JButton btnFindId = new JButton("���̵� ã��");
		btnFindId.setFont(new Font("����", Font.PLAIN, 12));
		btnFindId.setBackground(Color.WHITE);
		btnFindId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) pnCenter.getLayout();
				c.show(pnCenter, "id");

			}
		});
		menuBar.add(btnFindId);

		JButton btnFindPw = new JButton("��й�ȣ ã��");
		btnFindPw.setFont(new Font("����", Font.PLAIN, 12));
		btnFindPw.setBackground(Color.WHITE);
		btnFindPw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) pnCenter.getLayout();
				c.show(pnCenter, "pw");
			}
		});
		menuBar.add(btnFindPw);

		pnCenter = new JPanel();
		pnCenter.setBounds(0, 20, 434, 241);
		getContentPane().add(pnCenter);
		pnCenter.setLayout(new CardLayout(0, 0));

		JPanel pnIdFind = new JPanel();
		pnIdFind.setBackground(Color.WHITE);
		pnCenter.add(pnIdFind, "id");
		pnIdFind.setLayout(null);

		JLabel lbName = new JLabel("�̸�");
		lbName.setFont(new Font("����", Font.PLAIN, 12));
		lbName.setHorizontalAlignment(SwingConstants.LEFT);
		lbName.setBounds(12, 104, 72, 15);
		pnIdFind.add(lbName);

		JLabel lbPhone = new JLabel("�ڵ�����ȣ");
		lbPhone.setFont(new Font("����", Font.PLAIN, 12));
		lbPhone.setHorizontalAlignment(SwingConstants.LEFT);
		lbPhone.setBounds(12, 135, 72, 15);
		pnIdFind.add(lbPhone);

		txtName = new JTextField();
		txtName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtName.getText().equals("")) {
					txtName.setText("");
				} else {
					txtName.selectAll();
				}
			}
		});
		txtName.setFont(new Font("����", Font.PLAIN, 12));
		txtName.setBounds(96, 101, 198, 21);
		pnIdFind.add(txtName);
		txtName.setColumns(10);

		JComboBox comboPhone = new JComboBox();
		comboPhone.setBackground(new Color(255, 255, 255));
		comboPhone.setFont(new Font("����", Font.PLAIN, 12));
		comboPhone.setModel(new DefaultComboBoxModel(new String[] { "010", "011", "017", "018", "019", "070" }));
		comboPhone.setBounds(96, 132, 52, 21);
		pnIdFind.add(comboPhone);

		JLabel lblNewLabel = new JLabel("-");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(160, 135, 6, 15);
		pnIdFind.add(lblNewLabel);

		txtPhone = new JTextField();
		txtPhone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPhone.getText().equals("")) {
					txtPhone.setText("");
				} else {
					txtPhone.selectAll();
				}
			}
		});
		txtPhone.setFont(new Font("����", Font.PLAIN, 12));
		txtPhone.setBounds(178, 132, 52, 21);
		pnIdFind.add(txtPhone);
		txtPhone.setColumns(10);

		JButton btnCode = new JButton("������ȣ");
		btnCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Random ran = new Random();
				int n = ran.nextInt(900000) + 100000;
				String varCode = String.valueOf(n);

				if (txtName.getText().isEmpty() && txtPhone.getText().isEmpty() && txtPhone2.getText().isEmpty()) {
					System.out.println("��ϵ��� ���� ��ȣ�Դϴ�.");
					JOptionPane.showMessageDialog(null, "��ϵ��� ���� ��ȣ�Դϴ�.");
				} else {
					System.out.println("������ȣ�� '" + varCode + "' �Դϴ�.");
					JOptionPane.showMessageDialog(null, "������ȣ�� '" + varCode + "' �Դϴ�.");
				}
			}
		});
		btnCode.setBackground(new Color(255, 255, 255));
		btnCode.setFont(new Font("����", Font.PLAIN, 12));
		btnCode.setBounds(334, 131, 88, 23);
		pnIdFind.add(btnCode);

		txtCode = new JTextField();
//		txtCode.setEnabled(false);
		txtCode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtCode.getText().equals("������ȣ 6�ڸ� �Է��ϱ�")) {
					txtCode.setText("");
					txtCode.setForeground(Color.black);
				} else {
					txtCode.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtCode.getText().equals("")) {
					txtCode.setText("������ȣ 6�ڸ� �Է��ϱ�");
					txtCode.setForeground(Color.LIGHT_GRAY);
				} else {
					txtCode.selectAll();
				}
			}
		});
		txtCode.setForeground(Color.LIGHT_GRAY);
		txtCode.setFont(new Font("����", Font.PLAIN, 12));
		txtCode.setText("������ȣ 6�ڸ� �Է��ϱ�");
		txtCode.setBounds(96, 163, 198, 21);
		pnIdFind.add(txtCode);
		txtCode.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("��Ÿ���� ��� ���̵� ã��");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(0, 102, 51));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(12, 10, 410, 15);
		pnIdFind.add(lblNewLabel_1);

		JLabel label = new JLabel("���������� ����� �ڵ�����ȣ�� �Է��� �ڵ�����ȣ�� ���ƾ�");
		label.setFont(new Font("����", Font.PLAIN, 12));
		label.setBounds(12, 35, 410, 15);
		pnIdFind.add(label);

		JLabel label_1 = new JLabel("������ȣ�� ���� �� �ֽ��ϴ�.");
		label_1.setFont(new Font("����", Font.PLAIN, 12));
		label_1.setBounds(12, 54, 410, 15);
		pnIdFind.add(label_1);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 102, 51));
		separator.setBounds(12, 79, 410, 2);
		pnIdFind.add(separator);

		JButton btnCancel = new JButton("���");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainFrame frm = new MainFrame();
				frm.setVisible(true);
			}
		});
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setBackground(new Color(0, 102, 51));
		btnCancel.setFont(new Font("����", Font.PLAIN, 12));
		btnCancel.setBounds(351, 208, 71, 23);
		pnIdFind.add(btnCancel);

		JButton btnIdFind = new JButton("���̵� ã��");
		btnIdFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtName != null || !txtName.getText().isEmpty() || !txtPhone.getText().isEmpty()
						|| !txtPhone2.getText().isEmpty()) {
					System.out.println("ȸ������ DB ���...");
					// �Է� ������ ����
					String name = txtName.getText();
					System.out.println("�Է��Ͻ� �̸��� " + name);
					// DB ����
					// Member mb = new Member(name, phone);
					Member b = mgr.getOneMemberFindId(name);
					if (b != null) {
						JOptionPane.showMessageDialog(null, (name + "���� ���̵�� " + b.getLogin() + "�Դϴ�."));
					} else {
						JOptionPane.showMessageDialog(null, name + "���� ���̵�� ã�� �� �����ϴ�.");
					}
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "������ �Է����ּ���");
				}
			}
		});
		btnIdFind.setForeground(new Color(255, 255, 255));
		btnIdFind.setBackground(new Color(0, 102, 51));
		btnIdFind.setFont(new Font("����", Font.PLAIN, 12));
		btnIdFind.setBounds(223, 208, 116, 23);
		pnIdFind.add(btnIdFind);

		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(0, 102, 51));
		separator_3.setBounds(12, 196, 410, 2);
		pnIdFind.add(separator_3);

		txtPhone2 = new JTextField();
		txtPhone2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPhone.getText().equals("")) {
					txtPhone.setText("");
				} else {
					txtPhone.selectAll();
				}
			}
		});
		txtPhone2.setFont(new Font("����", Font.PLAIN, 12));
		txtPhone2.setColumns(10);
		txtPhone2.setBounds(260, 132, 52, 21);
		pnIdFind.add(txtPhone2);

		JLabel label_5 = new JLabel("-");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(242, 135, 6, 15);
		pnIdFind.add(label_5);

		JPanel pnPwFind = new JPanel();
		pnPwFind.setBackground(new Color(255, 255, 255));
		pnCenter.add(pnPwFind, "pw");
		pnPwFind.setLayout(null);

		JLabel label_2 = new JLabel("��Ÿ���� ��� ��й�ȣ ã��");
		label_2.setForeground(new Color(0, 102, 51));
		label_2.setFont(new Font("����", Font.PLAIN, 12));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(12, 10, 410, 15);
		pnPwFind.add(label_2);

		JLabel label_3 = new JLabel("���������� ����� �ڵ�����ȣ�� �Է��� �ڵ�����ȣ�� ���ƾ�");
		label_3.setFont(new Font("����", Font.PLAIN, 12));
		label_3.setBounds(12, 35, 410, 15);
		pnPwFind.add(label_3);

		JLabel label_4 = new JLabel("������ȣ�� ���� �� �ֽ��ϴ�.");
		label_4.setFont(new Font("����", Font.PLAIN, 12));
		label_4.setBounds(12, 54, 410, 15);
		pnPwFind.add(label_4);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 102, 51));
		separator_1.setBounds(12, 79, 410, 2);
		pnPwFind.add(separator_1);

		JLabel lbId = new JLabel("���̵�");
		lbId.setHorizontalAlignment(SwingConstants.LEFT);
		lbId.setFont(new Font("����", Font.PLAIN, 12));
		lbId.setBounds(12, 104, 72, 15);
		pnPwFind.add(lbId);

		JLabel lbPhone2 = new JLabel("�ڵ�����ȣ");
		lbPhone2.setHorizontalAlignment(SwingConstants.LEFT);
		lbPhone2.setFont(new Font("����", Font.PLAIN, 12));
		lbPhone2.setBounds(12, 135, 72, 15);
		pnPwFind.add(lbPhone2);

		JComboBox comboPwPhone = new JComboBox();
		comboPwPhone.setModel(new DefaultComboBoxModel(new String[] { "010", "011", "017", "018", "019", "070" }));
		comboPwPhone.setFont(new Font("����", Font.PLAIN, 12));
		comboPwPhone.setBackground(Color.WHITE);
		comboPwPhone.setBounds(96, 132, 52, 21);
		pnPwFind.add(comboPwPhone);

		txtId = new JTextField();
		txtId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtId.getText().equals("")) {
					txtId.setText("");
				} else {
					txtId.selectAll();
				}
			}
		});
		txtId.setFont(new Font("����", Font.PLAIN, 12));
		txtId.setColumns(10);
		txtId.setBounds(96, 101, 198, 21);
		pnPwFind.add(txtId);

		JLabel label_7 = new JLabel("-");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(160, 135, 6, 15);
		pnPwFind.add(label_7);

		txtPwCode = new JTextField();
		txtPwCode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPwCode.getText().equals("")) {
					txtPwCode.setText("");
				} else {
					txtPwCode.selectAll();
				}
			}

		});
		txtPwCode.setText("������ȣ 6�ڸ� �Է��ϱ�");
		txtPwCode.setForeground(Color.LIGHT_GRAY);
		txtPwCode.setFont(new Font("����", Font.PLAIN, 12));
		txtPwCode.setColumns(10);
		txtPwCode.setBounds(96, 163, 198, 21);
		pnPwFind.add(txtPwCode);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 102, 51));
		separator_2.setBounds(12, 196, 410, 2);
		pnPwFind.add(separator_2);

		JButton btnPwFind = new JButton("��й�ȣ ã��");
		btnPwFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtId != null || !txtId.getText().isEmpty() || !txtPwPhone2.getText().isEmpty()
						|| !txtPwPhone3.getText().isEmpty()) {
					// �Է� ������ ����
					String login = txtId.getText();
					System.out.println("�Է��Ͻ� �̸��� " + login);
					// DB ����
					// Member mb = new Member(name, phone);
					Member b = mgr.getOneMemberFindPw(login);
					if (b != null) {
						JOptionPane.showMessageDialog(null, (login + "���� ��й�ȣ�� " + b.getPw() + "�Դϴ�."));
					} else {
						JOptionPane.showMessageDialog(null, login + "���� ���̵�� ã�� �� �����ϴ�.");
					}
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "������ �Է����ּ���");
				}
			}
		});
		btnPwFind.setForeground(Color.WHITE);
		btnPwFind.setFont(new Font("����", Font.PLAIN, 12));
		btnPwFind.setBackground(new Color(0, 102, 51));
		btnPwFind.setBounds(223, 208, 116, 23);
		pnPwFind.add(btnPwFind);

		JButton btnPwCancel = new JButton("���");
		btnPwCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainFrame frm = new MainFrame();
				frm.setVisible(true);
			}
		});
		btnPwCancel.setForeground(Color.WHITE);
		btnPwCancel.setFont(new Font("����", Font.PLAIN, 12));
		btnPwCancel.setBackground(new Color(0, 102, 51));
		btnPwCancel.setBounds(351, 208, 71, 23);
		pnPwFind.add(btnPwCancel);

		txtPwPhone2 = new JTextField();
		txtPwPhone2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPwPhone2.getText().equals("")) {
					txtPwPhone2.setText("");
				} else {
					txtPwPhone2.selectAll();
				}

			}
		});
		txtPwPhone2.setFont(new Font("����", Font.PLAIN, 12));
		txtPwPhone2.setColumns(10);
		txtPwPhone2.setBounds(178, 132, 52, 21);
		pnPwFind.add(txtPwPhone2);

		JLabel label_6 = new JLabel("-");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(242, 135, 6, 15);
		pnPwFind.add(label_6);

		txtPwPhone3 = new JTextField();
		txtPwPhone3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPwPhone3.getText().equals("")) {
					txtPwPhone3.setText("");
				} else {
					txtPwPhone3.selectAll();
				}
			}
		});
		txtPwPhone3.setFont(new Font("����", Font.PLAIN, 12));
		txtPwPhone3.setColumns(10);
		txtPwPhone3.setBounds(260, 132, 52, 21);
		pnPwFind.add(txtPwPhone3);

		JButton btnPwCode = new JButton("\uC778\uC99D\uBC88\uD638");
		btnPwCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random ran = new Random();
				int n = ran.nextInt(900000) + 100000;
				String varCode = String.valueOf(n);

				if (txtId.getText().isEmpty() && txtPwPhone2.getText().isEmpty() && txtPwPhone3.getText().isEmpty()) {
					System.out.println("��ϵ��� ���� ��ȣ�Դϴ�.");
					JOptionPane.showMessageDialog(null, "��ϵ��� ���� ��ȣ�Դϴ�.");
				} else {
					System.out.println("������ȣ�� '" + varCode + "' �Դϴ�.");
					JOptionPane.showMessageDialog(null, "������ȣ�� '" + varCode + "' �Դϴ�.");
				}
			}
		});

		btnPwCode.setFont(new Font("����", Font.PLAIN, 12));
		btnPwCode.setBackground(Color.WHITE);
		btnPwCode.setBounds(334, 131, 88, 23);
		pnPwFind.add(btnPwCode);
	}
}
