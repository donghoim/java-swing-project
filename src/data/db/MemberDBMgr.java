package data.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Member;

public class MemberDBMgr {

	Connection conn;

	public MemberDBMgr() {
		beginConnection();

	}

	public void beginConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "STARBUCKS";
		String password = "1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("����̹� ���� ����!! ");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� ���� ����!! ");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB ���� ���� �Ǵ� ��� ����");

			e.printStackTrace();
		}

	}

	public void endConnection() {
		try {
			conn.close();
			System.out.println("DB ���� ���� ");
		} catch (SQLException e) {
			System.out.println("DB ���� ���� ");
			e.printStackTrace();
		}
	}

	// ȸ�� ����� ��ü ����Ҽ� �ִ�
	public ArrayList<Member> getAllMembers() {
		ArrayList<Member> mbList = new ArrayList<>();

		if (conn != null) {
			try {
				Statement stmt = conn.createStatement();
				String sql = "select * from members";
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String login = rs.getString("login");
					String pw = rs.getString("pw");
					int gender = rs.getInt("gender");
					String email = rs.getString("email");
					String birth = rs.getString("birth");
					String phone = rs.getString("phone");
					Member mb = new Member(id, name, login, pw, gender, birth, email, phone);
					mbList.add(mb);
				}
				return mbList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("��ſ��� !! ");
		}

		return null;

	}

	// ȸ�� �Ѹ��� �߰� �Ҽ� �ִ�
	public boolean AddOneMember(Member mb) {
		if (conn != null && mb != null) {
			String sql = "insert into members values (" + "MEMBERS_SEQ.nextval,?,?,?,?,?,?,?)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mb.getLogin());
				pstmt.setString(2, mb.getPw());
				pstmt.setString(3, mb.getName());
				pstmt.setInt(4, mb.getGender());
				pstmt.setString(5, mb.getBirth());
				pstmt.setString(6, mb.getPhone());
				pstmt.setString(7, mb.getEmail());
				int r = pstmt.executeUpdate();
				if (r == 1) {
					System.out.println("ȸ������ ����");
					return true;
				} else {
					System.out.println("ȸ������ ����");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��ſ��� ! ");

		}
		return false;

	}// AddOneMember

	// ȸ�� ���� �� �� �ִ�

	// ȸ�� ������ ���� �� �� �ִ� ��! ������ȣ�� �ٲٸ� �ȵ�! �� �ٲ��� ����
	public boolean editOneMember(Member mb) {
		if (conn != null) {
			try {
//				String sql = "update members set name= "+mb.getName()+", login=,"+mb.getLogin()+""
//						+ " pw ="+mb.getPw()+", email = "+mb.getEmail()+", phone = "+mb.getPhone()+
//						" , birth ="+mb.getBirth()+" , gender =  where id = "+mb.getId()+"";
				String sql = "update members set name= ?, login= ?" + ", pw =?, email = ?, phone = ?"
						+ " , birth = ? , gender = ?  where id = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mb.getName());
				pstmt.setString(2, mb.getLogin());
				pstmt.setString(3, mb.getPw());
				pstmt.setString(4, mb.getEmail());
				pstmt.setString(5, mb.getPhone());
				pstmt.setString(6, mb.getBirth());
				pstmt.setInt(7, mb.getGender());
				pstmt.setInt(8, mb.getId());

				int r = pstmt.executeUpdate();
				if (r == 1) {
					System.out.println("ȸ�� ���� ���� ");
					return true;
				} else {
					System.out.println("ȸ�� ���� ����");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("����̹� ���� ����");
		}

		return false;

	}

	public boolean insertOneMember(Member mb) {
		if (conn != null && mb != null) {
			try {
//				String sql = "insert into members values(" + "MEMBER_SEQ.nextval, ?, ?, ?, ?, ?,  1000, sysdate)";
				String sql = "INSERT INTO MEMBERS VALUES (MEMBERS_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?)";
				;
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mb.getLogin()); // ù��° ����ǥ = id
				pstmt.setString(2, mb.getPw()); // �ι�° ����ǥ = pw
				pstmt.setString(3, mb.getName()); // ������ ����ǥ = name
				pstmt.setInt(4, mb.getGender()); // �׹�° ����ǥ = gender
				pstmt.setString(5, mb.getBirth()); // �ټ���° ����ǥ = birth
				pstmt.setString(6, mb.getPhone()); // �ټ���° ����ǥ = phone
				pstmt.setString(7, mb.getEmail()); // �ټ���° ����ǥ = email

				int r = pstmt.executeUpdate();
				if (r == 1) {
					System.out.println("pstmt ȸ�� ���� ����: " + mb.getLogin());
					return true;
				} else {
					System.out.println("pstmt ȸ�� ���� ����: " + mb.getLogin());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��� ����!");
		}
		return false;
	}

	public boolean insertOneMember1(Member mb) {
		if (conn != null && mb != null) {
			try {
				String sql = "INSERT INTO MEMBERS VALUES (MEMBERS_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?)";
				;
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mb.getLogin()); // ù��° ����ǥ = id
				pstmt.setString(2, mb.getPw()); // �ι�° ����ǥ = pw
				pstmt.setString(3, mb.getName()); // ������ ����ǥ = name
				pstmt.setInt(4, mb.getGender()); // �׹�° ����ǥ = gender
				pstmt.setString(5, mb.getBirth()); // �ټ���° ����ǥ = birth
				pstmt.setString(6, mb.getPhone()); // �ټ���° ����ǥ = phone
				pstmt.setString(7, mb.getEmail()); // �ټ���° ����ǥ = email

				int r = pstmt.executeUpdate();
				if (r == 1) {
					System.out.println("pstmt ȸ�� ���� ����: " + mb.getLogin());
					return true;
				} else {
					System.out.println("pstmt ȸ�� ���� ����: " + mb.getLogin());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��� ����!");
		}
		return false;
	}

	// ���� ȸ���� id�� login���� ���� �� �� �ִ�
	public boolean deleteOneMember(int id, String login) {
		if (conn != null) {
			String sql = "delete from members where id =? and login =?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				pstmt.setString(2, login);

				int r = pstmt.executeUpdate();
				if (r == 1) {
					System.out.println(login + "ȸ�� ���� ����");
					return true;
				} else {
					System.out.println(login + "ȸ�� ���� ����");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("��Ż��� Ȯ�� �ʿ�");
		}

		return false;

	}

	// �ű� ȸ�� �Ѹ��� �߰��� �� �ִ�.
	public boolean insertOneMember(String login, String pw, String name, int gender, String birth, String phone,
			String email) {
		if (conn != null) {
			try {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO MEMBERS VALUES (MEMBERS_SEQ.nextval, '" + login + "', '" + pw + "', '" + name
						+ "','" + gender + "', '" + birth + "', '" + phone + "','" + email + "')";
				int r = stmt.executeUpdate(sql);
				if (r == 1) {
					System.out.println("ȸ�� ���� ����: " + login);
					return true;
				} else {
					System.out.println("ȸ�� ���� ����: " + login);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("DB ��� ����!");
		}

		return false;
	}

	// ȸ�� �Ѹ� �����͸� ������ȣ�� ��ȸ�� �� �ִ�.
	// id => Ű ���� ��ȸ (����ũ �ϰų� <<PK>>)
	public Member getOneMemberById(int id) {
		if (this.conn != null) {
			try {
				Statement stmt = conn.createStatement();
				String sql = "select * from members where id = " + id;
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) { // ���ڵ��� 1����
					String login = rs.getString("login");
					String pw = rs.getString("pw");
					String name = rs.getString("name");
					String birth = rs.getString("birth");
					int gender = rs.getInt("gender");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					// ȸ�����ڵ� �ϳ��� ȸ�� ��ü�� �����Ǹ� ���� mapping
					Member mb = new Member(id, name, login, pw, gender, birth, email, phone);
					return mb;
				} else { // 0
					System.out.println(id + "��ȣ�� ȸ�� ���ڵ尡  ����!");
					return null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��� ����!");
		}
		return null;
	}

	// ȸ�� �Ѹ� �����͸� ���������� ��ȸ�� �� �ִ�.
	// login => �÷� ���� ��ȸ (unique key) <<UQ>>
	public Member getOneMemberByLogin(String login) {
		if (login == null || login.isEmpty()) {
			System.out.println("login �Է��� ����!");
			return null;
		}
		if (this.conn != null) {
			try {
				Statement stmt = conn.createStatement();
				String sql = "select * from members where " + "	login = '" + login + "'";

				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) { // ���ڵ��� 1����
					int id = rs.getInt("id");
					String pw = rs.getString("pw");
					String name = rs.getString("name");
					String birth = rs.getString("birth");
					int gender = rs.getInt("gender");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					// ȸ�����ڵ� �ϳ��� ȸ�� ��ü�� �����Ǹ� ���� mapping
					Member mb = new Member(id, name, login, pw, gender, birth, email, phone);
					return mb;
				} else { // 0
					System.out.println(login + "�������� ȸ�� ���ڵ尡  ����!");
					return null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��� ����!");
		}
		return null;
	}

	// Ư�� ȸ���� �����͸� �̸����� ��ȸ �� �� �ִ�.
	public Member getOneMemberFindId(String name) {
		if (name == null || name.isEmpty()) {
			System.out.println("���̵� ã�� �Է��� ����");
			return null;
		}
		if (this.conn != null) {
			try {
				Statement stmt = conn.createStatement();
				String sql = "select * from members ID WHERE NAME = '" + name + "'";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) { // ���ڵ��� 1����
					int id = rs.getInt("id");
					String login = rs.getString("login");
					String pw = rs.getString("pw");
					int gender = rs.getInt("gender");
					String birth = rs.getString("birth");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					// ȸ�����ڵ� �ϳ��� ȸ�� ��ü�� �����Ǹ� ���� mapping
					Member mb = new Member(id, name, login, pw, gender, birth, email, phone);
					System.out.println(name + "���� ���̵�  ����!");
					return mb;

				} else { // 0
					System.out.println(name + "���� ���̵�  ����!");
					return null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��� ����!");
		}
		return null;
	}

	// Ư�� ȸ���� �����͸� �̸����� ��ȸ �� �� �ִ�.
	public Member getOneMemberFindPw(String login) {
		if (login == null || login.isEmpty()) {
			System.out.println("���̵� ã�� �Է��� ����");
			return null;
		}
		if (this.conn != null) {
			try {
				Statement stmt = conn.createStatement();
				String sql = "select * from members ID WHERE LOGIN = '" + login + "'";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) { // ���ڵ��� 1����
					int id = rs.getInt("id");
//					String login = rs.getString("login");
					String pw = rs.getString("pw");
					String name = rs.getString("name");
					int gender = rs.getInt("gender");
					String birth = rs.getString("birth");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					// ȸ�����ڵ� �ϳ��� ȸ�� ��ü�� �����Ǹ� ���� mapping
					Member mb = new Member(id, name, login, pw, gender, birth, email, phone);
					System.out.println(login + "���� ��й�ȣ��  ����!");
					return mb;

				} else { // 0
					System.out.println(login + "���� ��й�ȣ��  ����!");
					return null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��� ����!");
		}
		return null;
	}

	public static final int LOGIN_SUCCESS = 1;
	public static final int LOGIN_NOT_FOUND = 2;
	public static final int LOGIN_PW_MISMATCH = 3;
	public static final int LOGIN_ERROR = 4;

	// ȸ���� ������ �� �ִ�. (�α��� ������, �н����� - ���ȣȭ)
	public int loginProcess(String login, String pw) {
		if (login == null || pw == null || login.isEmpty() || pw.isEmpty()) {
			System.out.println("�α��� ���� �Է� ����!");
			return LOGIN_ERROR;
		}
		if (conn != null) {
			Member mb = getOneMemberByLogin(login); // <<UQ>>
			if (mb != null) { // found
				if (pw.equals(mb.getPw())) {
					System.out.println("�α��� ��������");
					return LOGIN_SUCCESS;
				} else {
					System.out.println("�н����� ����ġ");
					return LOGIN_PW_MISMATCH;
				}
			} else {
				System.out.println("�α����� �̸��� Ʋ���ų� �̰���ȸ���Դϴ�.");
				return LOGIN_NOT_FOUND;
			}

		} else {
			System.out.println("DB ��� ����");
		}
		return LOGIN_ERROR;
	}

}
