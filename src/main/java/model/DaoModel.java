package model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


/**
 * This DaoModel class creates 3 methods createTable(), inserts() 
   and getResultSet() to do the necesaary CRUD operation
 * @author Ajay Kumar Mukhi
 */
public class DaoModel {
    
	   
	   
	  //Method to check whether the table is exits
	   private boolean tableExists(Connection conn, String tableName) throws SQLException {
	    
		boolean tableExists = false;	    	
	    DatabaseMetaData dbmd = conn.getMetaData();	    
	    ResultSet rs = dbmd.getTables(null, null, tableName, null);

	    while(rs.next()){
	    	
		    String tName = rs.getString("TABLE_NAME");
		    //System.out.println(tName);
		    if(tName!=null && tName.equalsIgnoreCase(tableName)){
	    	     System.out.println("TABLE_NAME: " + tName);
	    	     tableExists= true;
	    	     break;
		    }
	   }
	    	    
        return tableExists;   
	    
	 }
	   
	
	//createTable() creates id field, an income field and a pep field 
	public void createTable() {
		
		System.out.println("Creating table now...");
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			String tableName="BOOK";
			
			if(tableExists(conn,tableName)){
			   System.out.println("Table already Exists");	
			}
			else{			
				
			    System.out.println("Creating table in given database...");
				String sqlCreate = "CREATE TABLE "+tableName 
			            +" (id integer primary key auto_increment,"
			            +"  book_id varchar(25) not null unique,"
			            +"  author varchar(50) not null,"
			            +"  title varchar(250) not null,"	
			            +"  genre varchar(25) not null,"
			            +"  price float not null,"
			            +"  publish_date date not null,"			            		            
			            +"  description text not null )";
	            Statement stmt = conn.createStatement();
	            stmt.executeUpdate(sqlCreate);
		  
		        System.out.println("Table "+tableName +" is created successfully.");		  
		   
		   
			}
			conn.close();		    
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		System.out.println("------------------------------------------------");	
	 }
	
	
	  
	//createTable() creates id field, an income field and a pep field 
		 public void createPartsTable(String tableName) {
				
				System.out.println("Creating Parts table now...");
				
				try {
					
					Connection conn = ConnectDB.getConnection();
					tableName="carParts";
					
					if(tableExists(conn,tableName)){
					   System.out.println("Table already Exists");	
					}
					else{			
						
					    System.out.println("Creating table in given database...");
						String sqlCreate = "CREATE TABLE "+tableName 
					            +" (id integer primary key auto_increment,"
					            +"  part_id varchar(25) not null unique,"
					            +"  part_name varchar(50) not null,"
                                                    +"  type varchar(50) not null," 
                                                    +"  description varchar(500) not null,"
                                                    +"  retail_price double(6,2) not null,"
					            +"  price double(6,2) not null,"
					            +"  color varchar(50) not null,"
					            +"  SKU varchar(50) not null,"
                                                    +"  stock varchar(50) not null,"
                                                    +"  quantitystock int(11) not null,"
                                                    +"  imageURL varchar(40) not null"
					            + ")";
			            Statement stmt = conn.createStatement();
			            stmt.executeUpdate(sqlCreate);
				  
				        System.out.println("Table "+tableName +" is created successfully.");		  
				   
				   
					}
					conn.close();		    
						
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
				System.out.println("------------------------------------------------");	
			 }
		 
	
		 
	//createTable() creates id field, an income field and a pep field 
		 public void createCarTable(String tableName) {
				
				System.out.println("Creating Parts table now...");
				
				try {
					
					Connection conn = ConnectDB.getConnection();
					tableName="car";
					
					if(tableExists(conn,tableName)){
					   System.out.println("Table already Exists");	
					}
					else{			
						
					    System.out.println("Creating table in given database...");
						String sqlCreate = "CREATE TABLE "+tableName 
					            +" (id integer primary key auto_increment,"
					            +"  product_id varchar(25) not null unique,"
					            +"  product_name varchar(50) not null,"
                                                    +"  model varchar(50) not null,"
                                                    +"  vin varchar(50) not null,"
					            +"  description varchar(500) not null,"
					            +"  display_under varchar(25) not null,"
                                                    +"  retail_price double(8,2) not null,"
					            +"  price double(8,2) not null,"
                                                    +"  engine varchar(50) not null,"
                                                    +"  body varchar(50) not null,"
                                                    +"  trans varchar(50) not null,"
					            +"  year varchar(50) not null,"
					            +"  interior varchar(50) not null,"
                                                    +"  exterior varchar(50) not null,"
                                                    +"  imageURL varchar(40) not null"
					            + ")";
			            Statement stmt = conn.createStatement();
			            stmt.executeUpdate(sqlCreate);
				  
				        System.out.println("Table "+tableName +" is created successfully.");		  
				   
				   
					}
					conn.close();		    
						
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
				System.out.println("------------------------------------------------");	
			 }
		 
	
			
		
		 
	//Inserts() takes arrayList of books to insert into the database  
	public void inserts(List<String> list) {
		
		System.out.println("Inserting the array of records into table now...");
		String tableName="BOOK";
	    try {
			String sqlInsert = "INSERT INTO "+tableName
			 +"  (book_id ,"
			 +"   author ,"
			 +"    title,"
			 +"    genre, "
	         +"    price,"
			 +"    publish_date,"
			 +"   description )"
			 +" VALUES(?, ?, ?, ?, ?, ?, ?)";
			
			Connection conn = ConnectDB.getConnection();
		    PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
		    
	    
			for(int i=0;i<list.size();i++){
				
				pstmt.setString(i+1, list.get(i));	    	
		    	
			   
		    }
			
			 pstmt.executeUpdate();	
		    
	   
			conn.close();
			
			
		  } catch(SQLIntegrityConstraintViolationException e){
			   System.out.println("Cannot insert duplicate Records...Unique key constraint");
		  }
		 
		  catch (SQLException e) {
			e.printStackTrace();
		  }
		 System.out.println("------------------------------------------------");		 
	 }
	 
	


	
	
		//Inserts() takes arrayList of Parts to insert into the database
		public void insertCars(List<String> list, String tableName) {
				
		System.out.println("Inserting the array of parts records into table now...");
				
			    try {
					String sqlInsert = "INSERT INTO "+tableName
					 +"  (product_id ,"
					 +"   product_name ,"
					 +"   model, "
                                         +"   vin,"
			                 +"   description, "
                                         +"   display_under,"
                                         +"   retail_price,"
			                 +"   price,"
                                         +"   engine,"
                                         +"   body,"
                                         +"   trans,"
                                         +"   year,"
                                         +"   interior,"
                                         +"   exterior,"
					 +"   imageURL"
			                 + ")"
					 +" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					
					Connection conn = ConnectDB.getConnection();
				    PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
				    
			    
					for(int i=0;i<list.size();i++){
						
						pstmt.setString(i+1, list.get(i));	    	
				    	
					   
				    }
					
					 pstmt.executeUpdate();	
				    
			   
					conn.close();
					
					
				  } catch(SQLIntegrityConstraintViolationException e){
					   System.out.println("Cannot insert duplicate Records...Unique key constraint");
				  }
				 
				  catch (SQLException e) {
					e.printStackTrace();
				  }
				 System.out.println("------------------------------------------------");		 
			 
		}
	

		//Inserts() takes arrayList of Parts to insert into the database
		public void insertCarParts(List<String> list, String tableName) {
				
		System.out.println("Inserting the array of parts records into table now...");
				
			    try {
					String sqlInsert = "INSERT INTO "+tableName
					 +"  (part_id ,"
					 +"   part_name ,"
					 +"   type,"
					 +"   description, "
                                         +"   retail_price,"
			                 +"   price,"
                                         +"   color,"
                                         +"   SKU,"
                                         +"   stock,"
                                         +"   quantityinstock,"
					 +"   imageURL"
			                 + ")"
					 +" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					
					Connection conn = ConnectDB.getConnection();
				    PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
				    
			    
					for(int i=0;i<list.size();i++){
						
						pstmt.setString(i+1, list.get(i));	    	
				    	
					   
				    }
					
					 pstmt.executeUpdate();	
				    
			   
					conn.close();
					
					
				  } catch(SQLIntegrityConstraintViolationException e){
					   System.out.println("Cannot insert duplicate Records...Unique key constraint");
				  }
				 
				  catch (SQLException e) {
					e.printStackTrace();
				  }
				 System.out.println("------------------------------------------------");		 
			 
		}
	

	
	
	
	
}
