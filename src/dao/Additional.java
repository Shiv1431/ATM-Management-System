package dao;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Additional {
	public Component Frame() {
		JFrame frame = new JFrame();
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.CYAN);
		
		
		JLabel atm = new JLabel("ATM");
		atm.setBounds(0, 30, 600, 120);
		atm.setHorizontalAlignment(JLabel.CENTER);
		atm.setFont(new Font("Times New Roman", Font.BOLD, 100));
		JLabel mansys = new JLabel("MANAGEMENT SYSTEM");
		mansys.setBounds(0, 140, 600, 30);
		mansys.setHorizontalAlignment(JLabel.CENTER);
		mansys.setFont(new Font("Times New Roman", Font.BOLD, 30));
		frame.add(mansys);
		frame.add(atm);
		return frame;
	}
}