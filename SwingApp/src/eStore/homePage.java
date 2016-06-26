package eStore;

import java.awt.BorderLayout;
import eStore.dbutilities;
import eStore.Customer;
import net.proteanit.sql.DbUtils;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Component;

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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 40, 825, 524);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		dbutilities.getDafaultConnection();
		ResultSet rs = dbutilities.getStoreList();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		ArrayList<Store> data = new ArrayList<Store>();
		
		try {
			if(rs.next())
			{
				Store p = new Store();
				p.itemName = rs.getString(0);
				p.itemDescription = rs.getString(1);
				p.icon = rs.getBytes(2);
				p.stock = rs.getInt(3);
				p.price = rs.getInt(4);
				p.discount = rs.getFloat(5);
				data.add(p);
			
				byte[] img = rs.getBytes("icon");
				ImageIcon image = new ImageIcon(img); 
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] cols= {"Product Name","Description","icon","stock","Price","Discount" };
		Object[][] rows = new Object[data.size()][6];
		for(int i=0;i<data.size();i++)
		{
			rows[i][0] = data.get(i).getItemName();
			rows[i][1] = data.get(i).getItemDescription();
			if(data.get(i).getIcon() !=null)
			{
				ImageIcon image =  new ImageIcon(new ImageIcon(data.get(i).getIcon()).getImage().getScaledInstance(150, 120,Image.SCALE_SMOOTH) );
				rows[i][2] = image;
			}
			
			rows[i][3] = data.get(i).getStock();
			rows[i][4] = data.get(i).getPrice();
			rows[i][5] = data.get(i).getDiscount(); 
			
		}
		tableModel tm = new tableModel(rows, cols);
		table.setModel(tm);
		table.setRowHeight(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		
		
		
		
		
		
	
		
		
		JLabel lblNewLabel = new JLabel("Welcome to Food Store");
		lblNewLabel.setBounds(12, -5, 238, 49);
		contentPane.add(lblNewLabel);
		
		JTextArea txtrInstructionsToShop = new JTextArea();
		txtrInstructionsToShop.setBounds(166, 8, 835, 32);
		contentPane.add(txtrInstructionsToShop);
		txtrInstructionsToShop.setBackground(new Color(0, 139, 139));
		txtrInstructionsToShop.setForeground(new Color(255, 255, 255));
		txtrInstructionsToShop.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtrInstructionsToShop.setText("Instructions to shop: 1. Add Products to Cart ----> 2. Check out Cart ----> 3.Make Payment");
	}
}


