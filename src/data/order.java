package data;

import java.util.Date;

public class order {
	private int id; // ������ȣ <pk>
	private String orderNumber; //  �ֹ� ��ȣ  ���Ƿ� �ຸ��~
	private String memberLogin; // �ֹ���  <pk> -> <fk>
	private String productName; // �ֹ� ��ǰ �̸�  <pk> -> <fk>
	private int quantity; // ����
	private int totalPrice; // �Ѱ���
	private Date orderedTime; // �ֹ� �ð�
	private int orderStatus;// �ֹ�����
	
	public static final int ORDER_REQUEST =1;
	public static final int ORDER_PREPARE =2;
	public static final int ORDER_FINISHED =3;
	@Override
	public String toString() {
		return "order [id=" + id + ", orderNumber=" + orderNumber + ", memberLogin=" + memberLogin + ", productName="
				+ productName + ", quantity=" + quantity + ", totalPrice=" + totalPrice + ", orderedTime=" + orderedTime
				+ ", orderStatus=" + orderStatus + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getMemberLogin() {
		return memberLogin;
	}
	public void setMemberLogin(String memberLogin) {
		this.memberLogin = memberLogin;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getOrderedTime() {
		return orderedTime;
	}
	public void setOrderedTime(Date orderedTime) {
		this.orderedTime = orderedTime;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public order() {
		// TODO Auto-generated constructor stub
	}
	public order(int id, String orderNumber, String memberLogin, String productName, int quantity, int totalPrice,
			Date orderedTime, int orderStatus) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.memberLogin = memberLogin;
		this.productName = productName;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderedTime = orderedTime;
		this.orderStatus = orderStatus;
	}
	
	
	
	
	
	
	
	
}

	