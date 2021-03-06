import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class IdentifierNotSetException extends Exception{
	private static final long serialVersionUID = 1L;

	public IdentifierNotSetException(String message){
		super(message);
	}
}

class DBHandler{

	protected static final String jdbcUrl = "";
	private Connection conn;
	protected String userName, password;

	private static DBHandler dbHandler;
	
	private DBHandler(){
		
	}
	
	public static DBHandler getDBHandler(){
		if(dbHandler == null){
			dbHandler = new DBHandler();
		}
		return dbHandler;
	}

	public boolean createConnection() throws SQLException, IdentifierNotSetException{
		if (jdbcUrl == null){
			throw new SQLException("JDBC URL can not be null!", "08001");
		}
		if (userName == null){
			throw new IdentifierNotSetException("User Name not set!");
		}
		if (password == null){
			throw new IdentifierNotSetException("Password not set!");
		}
		if (conn == null){
			try{
				conn = (Connection) DriverManager.getConnection(jdbcUrl, userName, password);
			}catch(SQLException sqlExcpt){
				throw sqlExcpt;
			}
		}
		return true;
	}
	
	public int login(String userName, String password){
		/*
		 * 0: Invalid
		 * 1: Professor
		 * 2: TA
		 * 3: Student
		 * */
		
		this.userName = userName;
		this.password = password;
		
		return 1;
	}

	protected void closeConnection(){
		if(conn != null) {
			try {
				conn.close();
			} catch(Throwable whatever) {}
		}
	}

	protected void closeStatement(Statement st){
		if(st != null) {
			try {
				st.close();
			} catch(Throwable whatever) {}
		}
	}

	protected void closeResultSet(ResultSet rs){
		if(rs != null) {
			try {
				rs.close();
			} catch(Throwable whatever) {}
		}
	}
}
