package eStore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import eStore.Employee;
import javax.swing.ImageIcon;

import org.omg.CORBA.portable.InputStream;

import eStore.MakeConnection;
import eStore.Customer;

public class dbutilities 
{
	static Connection connection =null;
	
	public void updateEmployeeDetails(Employee empObj){
		String insertIntoEmployeeQuery = "INSERT INTO employee VALUES "
				+ "(?, ?,?, ?);";
		try{
			PreparedStatement pst = DbInit.conn.prepareStatement(insertIntoEmployeeQuery);
			pst.setString(1,empObj.employeeID);
			pst.setString(2,empObj.emplyeeName);
			pst.setString(3,empObj.employeePrivilege);
			pst.setString(4,empObj.password);
			pst.executeUpdate();
		}
		catch (SQLIntegrityConstraintViolationException  e) 
		{	
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<Store> enterStoreListValues(){
		
		List<Store> storeList = new ArrayList<Store>();
		
		Store one_store = new Store();
		one_store.dealerName = "John";
		one_store.discount=10;
		String p = Paths.get(".").toAbsolutePath().normalize().toString()+ "\\src\\eStore\\cofffemate.jpg" ;
		
		one_store.icon_filename=p;
		one_store.idItem="item_001";
		one_store.inStock=true;
		one_store.isnew=true;
		one_store.itemDescription="Description of Item 001";
		one_store.itemName="Item Name 001";
		one_store.price=(float) 4.99;
		one_store.selected=false;
		one_store.stock=8;
		
		

		Store two_store = new Store();
		two_store.dealerName = "Red";
		two_store.discount=20;
		p = Paths.get(".").toAbsolutePath().normalize().toString()+ "\\src\\eStore\\cookies.jpg" ;
		two_store.icon_filename=p;
		two_store.idItem="item_002";
		two_store.inStock=true;
		two_store.isnew=true;
		two_store.itemDescription="Description of Item 002";
		two_store.itemName="Item Name 002";
		two_store.price=(float) 2.99;
		two_store.selected=false;
		two_store.stock=7;
		
		
		Store three_store = new Store();
		three_store.dealerName = "Snow";
		three_store.discount=10;
		p = Paths.get(".").toAbsolutePath().normalize().toString()+ "\\src\\eStore\\peanuts.jpg" ;
		three_store.icon_filename=p;
		three_store.idItem="item_003";
		three_store.inStock=true;
		three_store.isnew=true;
		three_store.itemDescription="Description of Item 003";
		three_store.itemName="Item Name 003";
		three_store.price=(float) 12.99;
		three_store.selected=false;
		three_store.stock=10;
		
		
		Store four_store = new Store();
		four_store.dealerName = "Ned";
		four_store.discount=10;
		p = Paths.get(".").toAbsolutePath().normalize().toString()+ "\\src\\eStore\\oreo.jpg" ;
		four_store.icon_filename=p;
		four_store.idItem="item_004";
		four_store.inStock=false;
		four_store.isnew=true;
		four_store.itemDescription="Description of Item 004";
		four_store.itemName="Item Name 004";
		four_store.price=(float) 12.99;
		four_store.selected=true;
		four_store.stock=0;
		
//		Store five_store = new Store();

		
		storeList.add(one_store);
		storeList.add(two_store);
		storeList.add(three_store);
		storeList.add(four_store);
		for(Store stores : storeList){
			updateStoreListDetails(stores);
		}
		
		
		return null;
		
	}
	
	public int updateCustomerDetails(Customer cobj) 
	{

		String insertIntoCustomerReservationQuery = "INSERT INTO account VALUES "
				+ "(?, ?,?, ?,?, ?,?, ?,?,?, ?);";
		try {
			PreparedStatement pst = DbInit.conn.prepareStatement(insertIntoCustomerReservationQuery);
			pst.setString(1,cobj.custID);
			pst.setString(2,cobj.custFName);
			pst.setString(3,cobj.custLName);
			pst.setString(4,cobj.custAddress);
			pst.setString(5,cobj.custState);
			pst.setInt(6,cobj.custZip);
			pst.setString(7,cobj.nameonCard);
			pst.setDouble(8,cobj.cardNumber);
			pst.setInt(9, cobj.cvv);
			pst.setString(10,cobj.exp);
			pst.setString(11,cobj.custPswd);
			
			pst.executeUpdate();
			return 1;
		}
		catch (SQLIntegrityConstraintViolationException  e) 
		{	
			return 2;
		
		}
		catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static void updateStoreListDetails(Store storeObj){
		String insertIntoEmployeeQuery = "INSERT INTO storelist VALUES "
				+ "(?,?,?,?,?,?,?,?,?);";
		try{
			PreparedStatement pst = DbInit.conn.prepareStatement(insertIntoEmployeeQuery);
			pst.setString(1,storeObj.idItem);
			pst.setString(2,storeObj.itemName);
			pst.setString(3,storeObj.itemDescription);
			pst.setInt(4,storeObj.stock);
			pst.setFloat(5,storeObj.price);
			pst.setFloat(6,storeObj.discount);
			pst.setString(7,storeObj.dealerName);
			pst.setBoolean(8,storeObj.isnew);
			File filename = new File(""+storeObj.icon_filename);
			try {
				FileInputStream fis = new FileInputStream(filename);
				pst.setBinaryStream(9,fis, (int)(filename.length()));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			pst.executeUpdate();
		}
		catch (SQLIntegrityConstraintViolationException  e) 
		{	
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public static ArrayList<Store> getStoreList()
	{
		
		 
		try {
			String query="select itemName,itemDescription,icon,stock,price,discount from storelist";
			PreparedStatement pst = DbInit.conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			ArrayList<Store> data = new ArrayList<Store>();
		
			
				while(rs.next())
				{
					Store p = new Store();
					p.itemName = rs.getString("itemName"); 
					p.itemDescription = rs.getString("itemDescription");
					p.icon = rs.getBytes("icon");
					p.stock = rs.getInt("stock");
					p.price = rs.getInt("price");
					p.discount = rs.getFloat("discount");
					p.selected = false; 
					p.selectedQty = 1;
					data.add(p);
				
					byte[] img = rs.getBytes("icon");
					ImageIcon image = new ImageIcon(img); 
					
				}
			
				return data; 
			}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
		
		
	}
	

	public static String validatepwd(String id)
	{
		 
		try {
			String query="select password from account where customerID="+"'"+id+"'";
			PreparedStatement pst = DbInit.conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
				return rs.getString("password");
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
		
	}
	


	public static Connection getDafaultConnection() 
	{
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
	        
	     
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","goutham911");
        //   System.out.println("\n Driver is connected Successfully");
   
		}
		catch (SQLException ex) {
	    
    	  	System.out.println("SQLException: " + ex.getMessage());
    	    System.out.println("SQLState: " + ex.getSQLState());
    	    System.out.println("VendorError: " + ex.getErrorCode());

    	}
		catch (Exception ex) 
		{
			ex.printStackTrace();
    	
		}
		 return connection;
		
	}
		
}