package eStore;
import java.sql.*;
public class MakeConnection 
{
	public static void main(String[] args) 
	{
	        try 
	        {
	          
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            Connection conn = null;
	            Statement stmt = null; 
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","goutham911");
	            System.out.println("\n Driver is connected Successfully");
	            stmt = conn.createStatement();
	            String sql = "Create table Account( customeID varchar(20), customerFName varchar(20),"
	            		+ "customerLName varchar(20),customerAddress varchar(200) )"; 
	            
	            stmt.executeUpdate(sql);
	            
	            
	            if(conn!=null)
		        	
		        	conn.close();
		       
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
	        
	}
}
