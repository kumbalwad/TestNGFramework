package config;

import org.testng.annotations.DataProvider;

import base.FrameworkBase;

public class UserData extends FrameworkBase {

	@DataProvider(name = "magentoUser")
	public static String[][] dataProvider() {

		String data[][] = { { "harrypotter@gmail.com", "Harry@1234" }, { "harry@gmail.com", "Harry@1234" } };

		return data;
	}
}
