package DataDrivenTesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromJson {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		//Parse the Json physical file into java object using Json
		//Parser class
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(new FileReader("./configData/CommonData.json"));
		
    //convert the java object into JSON object
		JSONObject obj1=(JSONObject)obj;
		
	//Read the data using get() by passing method
		System.out.println(obj1.get("Browser"));
		System.out.println(obj1.get("Url"));
		System.out.println(obj1.get("Username"));
		System.out.println(obj1.get("Password"));
		String Browser = obj1.get("Browser").toString();
		/*WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("Url");
		*/
	}

}
