package dao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class CheckPin {
	public void pinView(String cardNum) {
		Additional additional = new Additional();
		JFrame frame = (JFrame)additional.Frame();
		Font txt = new Font("Tahoma", Font.BOLD, 20);
		HomeScreen home = new HomeScreen();
		AdminUser admin = new AdminUser();
		
		JLabel pswd = new JLabel("ENTER YOUR PIN");
		pswd.setBounds(50, 270, 250, 20);
		pswd.setFont(txt);
		JPasswordField pswdField = new JPasswordField();
		//pswdFiled.setEchoChar((char)0);
		pswdField.setEchoChar('*');
		pswdField.setBounds(50, 300, 500, 35);
		pswdField.setFont(txt);
		frame.add(pswdField);
		frame.add(pswd);
	
		JButton cont = new JButton("ENTER");
		cont.setBounds(200, 400, 200, 50);
		cont.setFont(new Font("Tahoma", Font.BOLD, 25));
		frame.add(cont);
		cont.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DatabaseManagement dbms = new DatabaseManagement();
					ResultSet rst = dbms.check(cardNum, new String(pswdField.getPassword()));
					if(rst.next()) {
						if(rst.getString("CardNumber").equals("admin")) {
							admin.adminView();
							frame.dispose();
						}
						else {
							home.homeView(rst.getInt("ID"));
							frame.dispose();
						}
					}
					else {
						FailedTransaction fail = new FailedTransaction();
						fail.failView("WRONG PIN!!!");
						frame.dispose();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		frame.setVisible(true);
	}
}