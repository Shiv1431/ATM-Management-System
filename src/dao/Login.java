package dao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends Additional{
	public static void main(String[] args) throws InterruptedException, SQLException {
		Login login = new Login();
		login.loginView();
	}
	public void loginView() {
		Additional additional = new Additional();
		JFrame frame = (JFrame)additional.Frame();
		Font txt = new Font("Tahoma", Font.BOLD, 20);
		CheckPin pin = new CheckPin();
		
		JLabel card = new JLabel("ENTER YOUR CARD NUMBER");
		card.setBounds(50, 270, 300, 20);
		card.setFont(txt);
		JTextField cardNumber = new JTextField();
		cardNumber.setBounds(50, 300, 500, 35);
		cardNumber.setFont(txt);
		frame.add(cardNumber);
		frame.add(card);
		
		JButton admin = new JButton("ADMIN LOGIN");
		admin.setBounds(370, 500, 180, 30);
		admin.setHorizontalAlignment(JLabel.RIGHT);
		admin.setFont(txt);
		frame.add(admin);
		admin.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) { 
				pin.pinView("admin");
				frame.dispose();
			}
		});
		
		JButton cont = new JButton("CONTINUE");
		cont.setBounds(200, 400, 200, 50);
		cont.setFont(new Font("Tahoma", Font.BOLD, 25));
		frame.add(cont);
		cont.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cardNumber.getText().length() == 16) {
					pin.pinView(cardNumber.getText());
					frame.dispose();
				}
				else {
					FailedTransaction fail = new FailedTransaction();
					fail.failView("WRONG CARD NUMBER!!!");
					frame.dispose();
				}
			}
			
		});

		frame.setVisible(true);
	}
}