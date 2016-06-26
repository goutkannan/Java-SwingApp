package eStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import eStore.Customer;

public class dbutilities 
{
	static Connection connection;
	
	public int updateCustomerDetails(Customer cobj) 
	{

		String insertIntoCustomerReservationQuery = "INSERT INTO account VALUES "
				+ "(?, ?,?, ?,?, ?,?, ?,?,?, ?);";
		try {
			PreparedStatement pst = connection.prepareStatement(insertIntoCustomerReservationQuery);
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
	public static ResultSet getStoreList()
	{
		
		ResultSet rs =null; 
		try {
			String query="select itemName,itemDescription,stock,price,discount from storelist";
			PreparedStatement pst = connection.prepareStatement(query);
			rs=pst.executeQuery();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return rs;
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