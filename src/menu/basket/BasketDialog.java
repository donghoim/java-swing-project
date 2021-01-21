package menu.basket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Product;
import menu.basket.components.OrderCount;
import menu.main.MainMenuFrame;
import menu.main.components.BasketContainer;
import menu.product.ProductPanel;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BasketDialog extends JDialog
{

	MainMenuFrame frm;
	BasketDialog dlg;
	ProductPanel pp;
	JLabel lbTemperature;
	JPanel panel;
	JLabel lbPrName;
	JButton btnNewButton;
	public 	Product pr;
	public OrderCount pnAmount;
	
		/**
	 * Create the dialog.
	 */
	public BasketDialog(MainMenuFrame frm, Product pr)
	{
		super(frm, true);
		this.frm = frm;
		this.pr = pr;
		dlg = this;
		
		
		setTitle("\uC218\uB7C9 \uC815\uD558\uAE30");
		getContentPane().setPreferredSize(new Dimension(140, 400));
		
		setBounds(100, 100, 400, 150);
		getContentPane().setLayout(new BorderLayout());
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 50));
		panel.setOpaque(true);
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		lbPrName = new JLabel();
		lbPrName.setFont(new Font("����", Font.PLAIN, 12));
		lbPrName.setPreferredSize(new Dimension(350, 50));
		lbPrName.setOpaque(true);
		lbPrName.setText(pr.getName());
		lbPrName.setHorizontalAlignment(SwingConstants.CENTER);
		lbPrName.setBackground(Color.WHITE);
		panel.add(lbPrName, BorderLayout.CENTER);
		
		btnNewButton = new JButton("\uC8FC\uBB38\uD558\uAE30");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 102, 51));
		btnNewButton.setFont(new Font("����", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener()
		{
			
			// ��ǰ Ŭ���� �ߴ� ���̾�α׿��� OK��ư Ȱ��ȭ 
			public void actionPerformed(ActionEvent e)
			{
				Product temp_pr = pr;
				Integer amount = Integer.valueOf(pnAmount.txtVal.getText());
				
				
				boolean b = frm.pnBasket.addProductToBasket(temp_pr, amount);
				if (b == false)
					System.out.println("BasketDialog ok �߰� ����");
				else
					System.out.println("BasketDialog ok �߰� ����");
				
				BasketContainer.updateTotalPrice(frm);
				frm.pnBasket.repaint();
				frm.pnBasket.revalidate();
				dlg.dispose();
			}
		});
		panel.add(btnNewButton, BorderLayout.EAST);
		
		// �ٸ� Ŭ������ ������ JPanel�� �޴°� �ƴ϶� OrderCount�� �޴��� ĳ���� �ؾ���
		pnAmount = new OrderCount(frm, pr);
		
		
		
		getContentPane().add(pnAmount, BorderLayout.CENTER);
		
		lbTemperature = new JLabel("");
			
		if (pr.getHot() == 1)
			lbTemperature.setText("HOT");
		if (pr.getHot() == 2)
			lbTemperature.setText("ICE");
		lbTemperature.setFont(new Font("Arial", Font.BOLD, 30));
		lbTemperature.setHorizontalAlignment(SwingConstants.CENTER);
		lbTemperature.setOpaque(true);
		lbTemperature.setBackground(Color.WHITE);
		lbTemperature.setPreferredSize(new Dimension(100, 80));
		getContentPane().add(lbTemperature, BorderLayout.WEST);
	}

}