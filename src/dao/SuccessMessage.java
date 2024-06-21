package dao;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SuccessMessage {
	public void successView(int id) throws SQLException {
		HomeScreen home = new HomeScreen();
		Additional additional = new Additional();
		JFrame frame =(JFrame) additional.Frame();

		JLabel sucss = new JLabel("TRANSACTION SUCCESS.");
		sucss.setBounds(0, 280, 600, 50);
		sucss.setHorizontalAlignment(JLabel.CENTER);
		sucss.setFont(new Font("Tahoma", Font.BOLD, 25));
		frame.add(sucss);
		
		home.homeView(id);
		frame.setVisible(true);
	}
	
	public void detailView(String num, String pin) {
		Additional additional = new Additional();
		JFrame frame =(JFrame) additional.Frame();
		
		JLabel sucss = new JLabel("NOTE THE DETAILS AND SEND TO CUSTOMER!!!");
		sucss.setBounds(0, 200, 600, 50);
		sucss.setHorizontalAlignment(JLabel.CENTER);
		sucss.setFont(new Font("Tahoma", Font.BOLD, 25));
		frame.add(sucss);
		JTextField number = new JTextField("CARD NUMBER : " + num);
		number.setBounds(0, 300, 600, 50);
		number.setEditable(false);
		number.setHorizontalAlignment(JLabel.CENTER);
		number.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.add(number);
		JTextField pinno = new JTextField("DEFAULT PIN : " + pin);
		pinno.setBounds(0, 400, 600, 50);
		pinno.setHorizontalAlignment(JLabel.CENTER);
		pinno.setEditable(false);
		pinno.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.add(pinno);
	
		frame.setVisible(true);
	}
}