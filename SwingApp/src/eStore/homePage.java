package eStore;

import java.awt.BorderLayout;
import eStore.dbutilities;
import eStore.Customer;
import net.proteanit.sql.DbUtils;

import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Component;

import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class homepage extends JFrame {
	

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public  void showtable()
	{
		//dbutilities.getDafaultConnection();
		ArrayList<Store> data = new ArrayList<Store>();		
		data = dbutilities.getStoreList();
		//table.setModel(DbUtils.resultSetToTableModel(rs));
		
		String[] cols= {"Product Name","Description","icon","stock","Price","Discount","Qty","selected" };
		Object[][] rows = new Object[data.size()][8];
		for(int i=0;i < data.size();i++)
		{
			rows[i][0] = data.get(i).getItemName();
			rows[i][1] = data.get(i).getItemDescription();
			if(data.get(i).getIcon() !=null)
			{
				ImageIcon image =  new ImageIcon(new ImageIcon(data.get(i).getIcon() ).getImage().getScaledInstance(150, 120,Image.SCALE_DEFAULT) );
				rows[i][2] = image;
			}
			
			rows[i][3] = data.get(i).getStock();
			rows[i][4] = data.get(i).getPrice();
			rows[i][5] = data.get(i).getDiscount();
		
			rows[i][6] = data.get(i).isSelected();
			rows[i][7] = data.get(1).getSelectedQty();
			
			
		}
		tableModel tm = new tableModel(rows, cols);
		table.setModel(tm);
		table.setRowHeight(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
	    TableColumn tc = table.getColumnModel().getColumn(6);   
	    tc.setCellEditor(table.getDefaultEditor(Boolean.class));   
	    tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));  
	    //tc.setHeaderRenderer(new CheckBoxHeader(new MyItemListener()));   
	}
	/**
	 * Create the frame.
	 */
	public homepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1182, 884);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane); 	
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(32, 109, 1132, 715);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 13, 858, 659);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(Color.WHITE);
			
	
		
		
		JLabel lblNewLabel = new JLabel("Welcome to Food Store");
		lblNewLabel.setBounds(30, 23, 238, 49);
		contentPane.add(lblNewLabel);
		
		JTextArea txtrInstructionsToShop = new JTextArea();
		txtrInstructionsToShop.setBounds(265, 50, 835, 32);
		contentPane.add(txtrInstructionsToShop);
		txtrInstructionsToShop.setBackground(new Color(0, 139, 139));
		txtrInstructionsToShop.setForeground(new Color(255, 255, 255));
		txtrInstructionsToShop.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtrInstructionsToShop.setText("Instructions to shop: 1. Add Products to Cart ----> 2. Check out Cart ----> 3.Make Payment");
		JButton btnCheckout = new JButton("checkout");
		btnCheckout.setBounds(929, 162, 97, 25);
		panel.add(btnCheckout);
		btnCheckout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Orders> myList = new ArrayList<Orders>();
	                for ( int i=0; i< table.getRowCount();i++)
	                {
	                    Boolean chked = Boolean.valueOf(table.getValueAt(i, 6).toString());
	                            String dataCol1 = table.getValueAt(i, 0).toString();
	                            String dataCol2 = table.getValueAt(i, 7).toString();
	                        
	                            if (chked) 
	                            {
		                            // System.out.println("Value" + dataCol1 + dataCol2);
		                            Orders p= new Orders();
		                            p.idProduct = dataCol1;
		                            p.qty = dataCol2;
		                            p.price = table.getValueAt(i, 4).toString();
		                            myList.add(p);
	                            }
	                }

			}
		});
		showtable();
	}
	class MyItemListener implements ItemListener   
	  {   
	    public void itemStateChanged(ItemEvent e) {   
	      Object source = e.getSource();   
	      if (source instanceof AbstractButton == false) return;   
	      boolean checked = e.getStateChange() == ItemEvent.SELECTED;   
	      for(int x = 0, y = table.getRowCount(); x < y; x++)   
	      {   
	        table.setValueAt(new Boolean(checked),x,0);   
	      }   
	    }   
	  }   
class CheckBoxHeader extends JCheckBox implements TableCellRenderer, MouseListener 
{   
  protected CheckBoxHeader rendererComponent;   
  protected int column;   
  protected boolean mousePressed = false;   
  public CheckBoxHeader(ItemListener itemListener) {   
    rendererComponent = this;   
    rendererComponent.addItemListener(itemListener);   
  }   
  public Component getTableCellRendererComponent(   
      JTable table, Object value,   
      boolean isSelected, boolean hasFocus, int row, int column) {   
    if (table != null) {   
      JTableHeader header = table.getTableHeader();   
      if (header != null) {   
        rendererComponent.setForeground(header.getForeground());   
        rendererComponent.setBackground(header.getBackground());   
        rendererComponent.setFont(header.getFont());   
        header.addMouseListener(rendererComponent);   
      }   
    }   
    setColumn(column);   
    rendererComponent.setText("Check All");   
    setBorder(UIManager.getBorder("TableHeader.cellBorder"));   
    return rendererComponent;   
  }   
  protected void setColumn(int column) {   
    this.column = column;   
  }   
  public int getColumn() {   
    return column;   
  }   
  protected void handleClickEvent(MouseEvent e) {   
    if (mousePressed) {   
      mousePressed=false;   
      JTableHeader header = (JTableHeader)(e.getSource());   
      JTable tableView = header.getTable();   
      TableColumnModel columnModel = tableView.getColumnModel();   
      int viewColumn = columnModel.getColumnIndexAtX(e.getX());   
      int column = tableView.convertColumnIndexToModel(viewColumn);   
     
      if (viewColumn == this.column && e.getClickCount() == 1 && column != -1) {   
        doClick();   
      }   
    }   
  }   
  public void mouseClicked(MouseEvent e) {   
    handleClickEvent(e);   
    ((JTableHeader)e.getSource()).repaint();   
  }   
  public void mousePressed(MouseEvent e) {   
    mousePressed = true;   
  }   
  public void mouseReleased(MouseEvent e) {   
  }   
  public void mouseEntered(MouseEvent e) {   
  }   
  public void mouseExited(MouseEvent e) {   
  }   
}
class CheckBoxCell extends JCheckBox   
    implements TableCellRenderer, MouseListener {   
  protected CheckBoxCell rendererComponent;   
  protected int column;   
  protected boolean mousePressed = false;   
  public CheckBoxCell(ItemListener itemListener) {   
    rendererComponent = this;   
    rendererComponent.addItemListener(itemListener);   
  }   
  public Component getTableCellRendererComponent(   
      JTable table, Object value,   
      boolean isSelected, boolean hasFocus, int row, int column) {   
    if (table != null) {   
      JTableHeader header = table.getTableHeader();   
      if (header != null) {   
        rendererComponent.setForeground(header.getForeground());   
        rendererComponent.setBackground(header.getBackground());   
        rendererComponent.setFont(header.getFont());   
        header.addMouseListener(rendererComponent);   
      }   
    }   
    setColumn(column);   
    setBorder(UIManager.getBorder("TableHeader.cellBorder"));   
    return rendererComponent;   
  }   
  protected void setColumn(int column) {   
    this.column = column;   
  }   
  public int getColumn() {   
    return column;   
  }   
  protected void handleClickEvent(MouseEvent e) {   
    if (mousePressed) {   
      mousePressed=false;   
      JTableHeader header = (JTableHeader)(e.getSource());   
      JTable tableView = header.getTable();   
      TableColumnModel columnModel = tableView.getColumnModel();   
      int viewColumn = columnModel.getColumnIndexAtX(e.getX());   
      int column = tableView.convertColumnIndexToModel(viewColumn);   
     
      if (viewColumn == this.column && e.getClickCount() == 1 && column != -1) {   
        doClick();   
      }   
    }   
  }   
  public void mouseClicked(MouseEvent e) {   
    handleClickEvent(e);   
    ((JTableHeader)e.getSource()).repaint();   
  }   
  public void mousePressed(MouseEvent e) {   
    mousePressed = true;   
  }   
  public void mouseReleased(MouseEvent e) {   
  }   
  public void mouseEntered(MouseEvent e) {   
  }   
  public void mouseExited(MouseEvent e) {   
  }   
} 
}
