package endToEndScenarios;

import org.testng.annotations.Test;

import genericUtility.BaseClassForAPI;
import genericUtility.EndPointsUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import projectUtility.ProjectUtility;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class CreateProjectAndVerifyInDB extends BaseClassForAPI
{
	@Test
	public void CreateProject() throws SQLException
	{
		//Step 1: create project using post()
				ProjectUtility plib = new ProjectUtility("Yateesh", "RMG-"+jlib.getRandomNum(), "Created", 20);
				
				Response resp = given()
								.body(plib)
								.contentType(ContentType.JSON)
								.when()
								.post(EndPointsUtility.CreateProject);
				
				
				//step 2: capture the project id from response
				String proId = rlib.getJSONData(resp, "projectId");
				System.out.println(proId);
				
				//Step 3: use it in get request
				given()
				  .pathParam("pid", proId)
				.when()
				  .get(EndPointsUtility.GetSingleProject)
				.then().log().all();
				
				
				//Step 4: verify it in database
				String query = "select * from project";
				String data = dlib.executeQueryAndReturnData(query, 1, proId);
				System.out.println(data);
				
}
}
