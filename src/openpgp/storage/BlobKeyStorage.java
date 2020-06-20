package openpgp.storage;

import java.sql.*;
import java.io.*;

import com.didisoft.pgp.storage.IKeyStoreStorage;

/**
 * Illustrates how to implement custom KeyStore storage that 
 * persists the KeyStore contents into a database BLOB field.
 * 
 *  --
 *  -- Sample database table structure
 *  --
 *  CREATE TABLE keys(storage BLOB);
 * 
 * 
 * @author DidiSoft Inc Eood
 *
 */
public class BlobKeyStorage implements IKeyStoreStorage {

	static String url = "jdbc:oracle:thin:@localhost:1521:javaDemo";
	  static String username = "username";
	  static String password = "welcome";
	  
	  public InputStream getInputStream() throws IOException {
		  try {
		    Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection conn = DriverManager.getConnection(url, username, password);
	
		    String sql = "SELECT storage FROM keys";
		    PreparedStatement stmt = conn.prepareStatement(sql);
		    ResultSet resultSet = stmt.executeQuery();
		    while (resultSet.next()) {
		      InputStream is = resultSet.getBinaryStream(1);
			  return is;
		    }
		  } catch (SQLException e) {
			  throw new IOException(e.getMessage());
		  } catch (ClassNotFoundException e) {
			  throw new IOException(e.getMessage());
		  }
		  
		  return null;
	  }
	  
	  public void store(InputStream data, int length) throws IOException {
		  try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection conn = DriverManager.getConnection(url, username, password);
		    conn.setAutoCommit(false);
	
		    String sql = "SELECT storage FROM keys";
		    PreparedStatement stmt = conn.prepareStatement(sql);
		    ResultSet resultSet = stmt.executeQuery();
		    
		    if (resultSet.next()) {
			    sql = "UPDATE keys SET storage = ?";
			    PreparedStatement stmt2 = conn.prepareStatement(sql);
			    stmt2.setBinaryStream(1, data, length);
			    stmt2.execute();		    	
		    } else {
			    sql = "INSERT INTO keys (storage) VALUES (?)";
			    PreparedStatement stmt2 = conn.prepareStatement(sql);
			    stmt2.setBinaryStream(1, data, length);
			    stmt2.execute();
		    }
	
		    conn.commit();
		    conn.close();
		  } catch (SQLException e) {
			  throw new IOException(e.getMessage());
		  } catch (ClassNotFoundException e) {
			  throw new IOException(e.getMessage());
		  }
	  }
}
