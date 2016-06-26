package eStore;

import java.awt.BorderLayout;
import eStore.dbutilities;
import net.proteanit.sql.DbUtils;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class homePage extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homePage frame = new homePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public homePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1046, 757);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane); 	
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(102, 57, 899, 640);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JTextArea txtrInstructionsToShop = new JTextArea();
		txtrInstructionsToShop.setBackground(new Color(0, 139, 139));
		txtrInstructionsToShop.setForeground(new Color(255, 255, 255));
		txtrInstructionsToShop.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtrInstructionsToShop.setText("Instructions to shop: 1. Add Products to Cart ----> 2. Check out Cart ----> 3.Make Payment");
		txtrInstructionsToShop.setBounds(31, 23, 835, 32);
		panel.add(txtrInstructionsToShop);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 68, 825, 496);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		dbutilities.getDafaultConnection();
		table.setModel(DbUtils.resultSetToTableModel(dbutilities.getStoreList()));
		
		JLabel lblNewLabel = new JLabel("Welcome to Food Store");
		lblNewLabel.setBounds(53, 13, 238, 49);
		contentPane.add(lblNewLabel);
	}
}
