package features;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;

public class GraphQLScript {
	public static void main(String args[])
	{
		
		//	MUTATION
		
		String response = given().log().all().header("Content-Type","application/json")
				.body("{\"query\":\"mutation($lname:String!, $ltype:String!, $ldimen:String!,$ename:String!,$eairdate:String!,$episode: String!)\\n{\\n  createLocation(location: {name: $lname , type:$ltype , dimension:$ldimen} )\\n  {\\n    id\\n  }\\n  createEpisode(episode: {name:$ename, air_date:$eairdate, episode:$episode})\\n  {\\n    id\\n  }\\n\\n}\",\"variables\":{\"lname\":\"Australia\",\"ltype\":\"Southzone\",\"ldimen\":\"534\",\"ename\":\"ONe Piece\",\"eairdate\":\"20 oct 1999\",\"episode\":\"1808\"}}")
				.when().post("https://rahulshettyacademy.com/gq/graphql")
				.then().extract().response().toString();
		
		System.out.println(response);
		JsonPath js = new JsonPath(response);
	}
}
