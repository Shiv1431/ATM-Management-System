package dao;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class BankStatement {
	public void stateView(int id) throws SQLException {
		DefaultTableModel model = new DefaultTableModel();
		Additional additional = new Additional();
		JFrame frame = (JFrame)additional.Frame();
		DatabaseManagement manage = new DatabaseManagement();
		
		
		JLabel label = new JLabel("BANK STATEMENT");
		label.setBounds(0, 200, 575, 30);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		frame.add(label);
		
		@SuppressWarnings("serial")
		JTable table = new JTable(new DefaultTableModel()) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return true;
		    }
		};

		model = (DefaultTableModel)table.getModel();
		model.addColumn("ID");
		model.addColumn("DEPOSIT");
		model.addColumn("WITHDRAW");
		model.addColumn("BALANCE");
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		JScrollPane sc = new JScrollPane(table);
		sc.setBounds(50, 250, 500, 200);
		frame.add(sc);
		
		ResultSet rst = manage.stmt(id);
		int i=0;
		while(rst.next()) {
			model.addRow(new Object[0]);
			model.setValueAt(rst.getInt("TransID"), i, 0);
			if(rst.getString("state").equals("Deposit")) {
				model.setValueAt(rst.getString("Amount"), i, 1);
				model.setValueAt("-", i, 2);
			}
			else {
				model.setValueAt("-", i, 1);
				model.setValueAt(rst.getString("Amount"), i, 2);
			}
	        model.setValueAt(rst.getInt("Balance"), i, 3);
	        i++;
		}
	
		
		frame.setVisible(true);
	}
}