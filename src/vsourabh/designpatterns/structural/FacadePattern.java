package vsourabh.designpatterns.structural;

import java.sql.Connection;

/**
 * @author Sourabh
 * 
 * Structural design pattern 
 * 
 * Provide a unified interface to a set of interfaces in a subsystem. 
 * Facade Pattern defines a higher-level interface that makes the 
 * subsystem easier to use. It hides the complexities of the system and 
 * provides an interface to the client using which the client can access 
 * the system
 *
 */

//Sub-system code to connect to mySql DB
class MySqlDbConnectHelper {
	
	public static Connection getMySqlDBConnection(){
		System.out.println("get mySQL DB connection using connection parameters");
		return null;
	}
	
	public void generateMySqlPDFReport(String tableName, Connection con){
		System.out.println("get data from table and generate pdf report");
	}
	
	public void generateMySqlHTMLReport(String tableName, Connection con){
		System.out.println("get data from table and generate pdf report");
	}
}

//Sub-system code to connect to Oracle DB
class OracleDbConnectHelper {

	public static Connection getOracleDBConnection(){
		System.out.println("get Oracle DB connection using connection parameters");
		return null;
	}
	
	public void generateOraclePDFReport(String tableName, Connection con){
		System.out.println("get data from table and generate pdf report");
	}
	
	public void generateOracleHTMLReport(String tableName, Connection con){
		System.out.println("get data from table and generate pdf report");
	}
}

//Facade class to connect DB based on types
class HelperFacade {
	
	public static void generateReport(DBTypes dbType, ReportTypes reportType, String tableName) {
		
		Connection con = null;
		switch (dbType) {
		case MYSQL: 
			con = MySqlDbConnectHelper.getMySqlDBConnection();
			MySqlDbConnectHelper mySqlHelper = new MySqlDbConnectHelper();
			switch(reportType) {
			case HTML:
				mySqlHelper.generateMySqlHTMLReport(tableName, con);
				break;
			case PDF:
				mySqlHelper.generateMySqlPDFReport(tableName, con);
				break;
			}
			break;

		case ORACLE: 
			con = OracleDbConnectHelper.getOracleDBConnection();
			OracleDbConnectHelper oracleHelper = new OracleDbConnectHelper();
			switch(reportType) {
			case HTML:
				oracleHelper.generateOracleHTMLReport(tableName, con);
				break;
			case PDF:
				oracleHelper.generateOraclePDFReport(tableName, con);
				break;
			}
			break;
		}
	}
	
	// enum with constructor and values
	public static enum DBTypes {
		
		MYSQL("mySql"),ORACLE("oracle");
		
		public final String value;
		DBTypes(String value) {
			this.value = value;
		}
	}
	
	public static enum ReportTypes{
		HTML,PDF;
	}
}

public class FacadePattern {

	public static void main(String[] args) {
		String tableName="Employee";
		

		System.out.println("*********************Without Facade**************************");
		//generating MySql HTML report and Oracle PDF report without using Facade
		Connection con = MySqlDbConnectHelper.getMySqlDBConnection();
		MySqlDbConnectHelper mySqlHelper = new MySqlDbConnectHelper();
		mySqlHelper.generateMySqlHTMLReport(tableName, con);
		
		Connection con1 = OracleDbConnectHelper.getOracleDBConnection();
		OracleDbConnectHelper oracleHelper = new OracleDbConnectHelper();
		oracleHelper.generateOraclePDFReport(tableName, con1);
		
		System.out.println("\n*********************With Facade****************************");
		//generating MySql HTML report and Oracle PDF report using Facade
		HelperFacade.generateReport(HelperFacade.DBTypes.MYSQL, HelperFacade.ReportTypes.HTML, tableName);
		HelperFacade.generateReport(HelperFacade.DBTypes.ORACLE, HelperFacade.ReportTypes.PDF, tableName);
	}

}
