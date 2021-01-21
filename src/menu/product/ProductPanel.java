package menu.product;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JPanel;

import data.Product;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Component;
import java.awt.Font;

public class ProductPanel extends JPanel
{
	Product pr;
	JLabel lbImage;
	JLabel lbName;
	JLabel lbPrice;
	public int prPanelPrice;
	
	
	/**
	 * Create the panel.
	 */
	public ProductPanel(Product pr)
	{
		
		this.pr = pr;
		Dimension d1 = new Dimension(200, 250);
		
		setBorder(new EmptyBorder(10,10,10,10));

		setLayout(new BorderLayout(0, 0));
		setOpaque(true);
		setBackground(Color.white);
		
		Dimension d2 = new Dimension(200, 50);
		
		
		lbImage = new JLabel("");

		lbImage.setSize(new Dimension(200, 150));
		lbImage.setOpaque(true);
		ImageIcon ic = new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\menu\\" + pr.getImagePath());
		Image scaled = ic.getImage().getScaledInstance(200, 150, Image.SCALE_FAST);
		
		ic.setImage(scaled);
		lbImage.setIcon(ic);
		lbImage.repaint();
		lbImage.setPreferredSize(new Dimension(200, 150));
		
		add(lbImage, BorderLayout.NORTH);
		
		lbName = new JLabel("");
		lbName.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		lbName.setPreferredSize(new Dimension(200, 50));
		lbName.setBackground(Color.LIGHT_GRAY);
		lbName.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbName.setOpaque(true);
		lbName.setHorizontalAlignment(SwingConstants.CENTER);
		lbName.setSize(d2);
		lbName.setText(pr.getName());
		add(lbName, BorderLayout.CENTER);
		
		lbPrice = new JLabel("");
		lbPrice.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		lbPrice.setBackground(Color.LIGHT_GRAY);
		lbPrice.setOpaque(true);
		lbPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lbPrice.setPreferredSize(d2);
		lbPrice.setText(""+pr.getPrice());
		this.prPanelPrice = pr.getPrice();
		add(lbPrice, BorderLayout.SOUTH);	
	}

}
