package de.doe;

public class TestUtils {
	
	public static String getMultilineString(String... strings) {
		StringBuilder resultBuilder = new StringBuilder();
		for (String s : strings) {
			resultBuilder.append(s).append(System.lineSeparator());
		}
		return resultBuilder.toString();
	}
	
}
