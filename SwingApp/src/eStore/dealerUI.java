package eStore;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class dealerUI extends JPanel {
	private JTextField textid;
	private JTextField textItem;
	private JTextField textQty;
	private JTextField textPrice;
	private JTextField textDiscount;
	private JTextField textExpDate;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public dealerUI() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ItemId");
		lblNewLabel.setBounds(45, 85, 90, 31);
		add(lblNewLabel);
		
		textid = new JTextField();
		textid.setBounds(170, 89, 193, 22);
		add(textid);
		textid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Item Name");
		lblNewLabel_1.setBounds(45, 163, 90, 16);
		add(lblNewLabel_1);
		
		textItem = new JTextField();
		textItem.setBounds(170, 160, 193, 22);
		add(textItem);
		textItem.setColumns(10);
		
		textQty = new JTextField();
		textQty.setBounds(170, 303, 193, 22);
		add(textQty);
		textQty.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Description");
		lblNewLabel_2.setBounds(45, 232, 90, 16);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Qty");
		lblNewLabel_3.setBounds(45, 306, 56, 16);
		add(lblNewLabel_3);
		
		JTextArea textDescription = new JTextArea();
		textDescription.setBounds(170, 210, 193, 66);
		add(textDescription);
		
		JLabel lblNewLabel_4 = new JLabel("Price");
		lblNewLabel_4.setBounds(45, 377, 56, 16);
		add(lblNewLabel_4);
		
		textPrice = new JTextField();
		textPrice.setBounds(170, 374, 193, 22);
		add(textPrice);
		textPrice.setColumns(10);
		
		JLabel lblDiscount = new JLabel("Discount");
		lblDiscount.setBounds(48, 448, 56, 16);
		add(lblDiscount);
		
		textDiscount = new JTextField();
		textDiscount.setBounds(170, 445, 193, 22);
		add(textDiscount);
		textDiscount.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Exp. Date");
		lblNewLabel_5.setBounds(48, 520, 56, 16);
		add(lblNewLabel_5);
		
		textExpDate = new JTextField();
		textExpDate.setBounds(170, 517, 193, 22);
		add(textExpDate);
		textExpDate.setColumns(10);
		
		JButton btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Store stockobj =  new Store(); 
				stockobj.idItem = textid.getText();
				stockobj.itemName = textItem.getText();
				stockobj.itemDescription = textDescription.getText(); 
				
			}
		});
		btnUpload.setBounds(170, 595, 97, 25);
		add(btnUpload);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(290, 595, 97, 25);
		add(btnClose);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(55, 0, 489, 666);
		add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(556, 40, 383, 574);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}
}
