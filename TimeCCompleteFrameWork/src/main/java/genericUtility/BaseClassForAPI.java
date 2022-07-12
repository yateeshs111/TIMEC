package genericUtility;

import java.sql.SQLException;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseClassForAPI 
{
	public DataBaseUtility dlib = new DataBaseUtility();
	public JavaUtility jlib = new JavaUtility();
	public RestAssuredUtlity rlib = new RestAssuredUtlity();
	
	@BeforeSuite
	public void bsConfig() throws SQLException
	{
		dlib.connectToDB();
		Reporter.log("---db connection successful---",true);
	
		
		baseURI = "http://localhost";
		port = 8084;
	}
	
	
	
	@AfterSuite
	public void asConfig() throws SQLException
	{
		dlib.closeDB();
		Reporter.log("---db connection closed successfully---",true);
	}


}
