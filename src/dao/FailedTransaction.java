package dao;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FailedTransaction {
	public void failView(String s) {
		Additional additional = new Additional();
		JFrame frame =(JFrame) additional.Frame();
		

		JLabel fail = new JLabel("YOUR TRANSACTIONS FAILED!!!");
		fail.setBounds(0, 280, 600, 50);
		fail.setHorizontalAlignment(JLabel.CENTER);
		fail.setFont(new Font("Tahoma", Font.BOLD, 25));
		JLabel st = new JLabel(s);
		st.setBounds(0, 320, 600, 50);
		st.setHorizontalAlignment(JLabel.CENTER);
		st.setFont(new Font("Tahoma", Font.BOLD, 25));
		frame.add(st);
		frame.add(fail);
	
		
		frame.setVisible(true);
	}
}