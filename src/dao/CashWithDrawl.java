package dao;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CashWithDrawl {
	public void quickView(int id) throws SQLException {
		
		Operations operation = new Operations();
		
		Font txt = new Font("Tahoma", Font.BOLD, 25);
		Additional additional = new Additional();
		JFrame frame = (JFrame)additional.Frame();
		JLabel one = new JLabel("< 100");
		one.setBounds(30, 250, 200, 30);
		one.setFont(txt);
		JLabel five = new JLabel("500 >");
		five.setBounds(350, 250, 200, 30);
		five.setHorizontalAlignment(JLabel.RIGHT);
		five.setFont(txt);
		JLabel ten = new JLabel("< 1000");
		ten.setBounds(30, 350, 200, 30);
		ten.setFont(txt);
		JLabel twenty = new JLabel("2000 >");
		twenty.setBounds(350, 350, 200, 30);
		twenty.setHorizontalAlignment(JLabel.RIGHT);
		twenty.setFont(txt);
		JLabel fifty = new JLabel("< 5000");
		fifty.setBounds(30, 450, 250, 30);
		fifty.setFont(txt);
		JLabel hundred = new JLabel("10000 >");
		hundred.setBounds(350, 450, 200, 30);
		hundred.setHorizontalAlignment(JLabel.RIGHT);
		hundred.setFont(txt);
		frame.add(one);
		frame.add(five);
		frame.add(ten);
		frame.add(twenty);
		frame.add(fifty);
		frame.add(hundred);
		frame.setVisible(true);
		
		one.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) { 
				operation.withdrawal(100, id);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		five.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) { 
				operation.withdrawal(500, id);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		ten.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) { 
				operation.withdrawal(1000, id);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		twenty.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) { 
				operation.withdrawal(2000, id);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		fifty.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) { 
				operation.withdrawal(5000, id);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		hundred.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) { 
				operation.withdrawal(10000, id);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
	}
}