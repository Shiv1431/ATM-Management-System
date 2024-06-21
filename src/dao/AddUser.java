package dao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddUser {
	
	JTextField pinField, atmField;
	Random random = new Random();
	
	public void addView() throws SQLException {
		Additional additional = new Additional();
		JFrame frame = (JFrame) additional.Frame();
		Font txt = new Font("Tahoma", Font.BOLD, 20);		
		
		JLabel name = new JLabel("Name : ");
		name.setBounds(50, 200, 100, 25);
		name.setFont(txt);
		JTextField nmField = new JTextField();
		nmField.setBounds(50, 230, 500, 30);
		nmField.setFont(txt);
		frame.add(nmField);
		frame.add(name);
		
		JLabel atmno = new JLabel("ATM Card Number : ");
		atmno.setBounds(50, 300, 500, 25);
		atmno.setFont(txt);
		atmField = new JTextField();
		atmField.setBounds(50, 330, 500, 30);
		atmField.setFont(txt);
		//atmField.setEditable(false);
		frame.add(atmField);
		frame.add(atmno);
		
		JLabel atmpin = new JLabel("ATM Card PIN : ");
		atmpin.setBounds(50, 400, 500, 25);
		atmpin.setFont(txt);
		pinField = new JTextField();
		pinField.setBounds(50, 430, 200, 30);
		pinField.setFont(txt);
		frame.add(pinField);
		frame.add(atmpin);
		
		JLabel bal = new JLabel("BALANCE : ");
		bal.setBounds(350, 400, 500, 25);
		bal.setFont(txt);
		JTextField balField = new JTextField();
		balField.setBounds(350, 430, 200, 30);
		balField.setFont(txt);
		frame.add(balField);
		frame.add(bal);
		
		//auto();
	
		JButton sbmt = new JButton("SUBMIT");
		sbmt.setBounds(310, 500, 200, 50);
		sbmt.setFont(txt);
		frame.add(sbmt);
		sbmt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nmField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Name cannot be empty","Warning",JOptionPane.WARNING_MESSAGE);
				}
				if(atmField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"CardNumber cannot be empty","Warning",JOptionPane.WARNING_MESSAGE);
				}
				if(pinField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Pin cannot be empty","Warning",JOptionPane.WARNING_MESSAGE);
				}
				if(!nmField.getText().equals("")) {
					if(balField.getText().equals(""))
						balField.setText("0");
					try {
						new DatabaseManagement().adding(atmField.getText(), pinField.getText(), nmField.getText(), balField.getText());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					new SuccessMessage().detailView(atmField.getText(), pinField.getText());
					balField.setText("");
					nmField.setText("");
					atmField.setText("");
					pinField.setText("");
					//auto();
				}
			}
		});
		JButton rst = new JButton("RESET");
		rst.setBounds(80, 500, 200, 50);
		rst.setFont(txt);
		frame.add(rst);
		rst.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				balField.setText("");
				nmField.setText("");
				atmField.setText("");
				pinField.setText("");
			}
		});
		
		frame.setVisible(true);
	}
	
//	public void auto() {
//		String s = "";
//		for(int i=0; i<16; i++) {
//			s += random.nextInt(9 - 0 + 1) + 0;
//		}
//		atmField.setText(s);
//		s = "";
//		for(int i=0; i<4; i++) {
//			s += random.nextInt(9 - 0 + 1) + 0;
//		}
//		pinField.setText(s);
//	}
}