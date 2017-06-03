package pl.edu.agh.mwo;
//Test zmian
public class Scanner {

	String textToScan;

	public Scanner(String textInitialValue) {
		textToScan = textInitialValue;
	}

	public String get() {
		String result = "";
		String whiteChars = "[ \t\n]";
		String parentheses = "[()]";
		String commentBegin = "%";
		String commentEnd = "\n";
		boolean initialStringCheckOK = false;
		while (!initialStringCheckOK) {
			if (textToScan.length() == 0) {
				return result;
			} else if (textToScan.substring(0, 1).matches(whiteChars)) {
				textToScan = textToScan.substring(1);
			} else if (textToScan.substring(0, 1).matches(commentBegin)) {
				while (!textToScan.substring(0, 1).matches(commentEnd)) {
					textToScan = textToScan.substring(1);
				}
			} else {
				initialStringCheckOK = true;
			}
		}

		if (textToScan.length() > 0 && textToScan.substring(0, 1).matches(parentheses)) {
			result = textToScan.substring(0, 1);
			textToScan = textToScan.substring(1);
		}
		while (textToScan.length() > 0 && !textToScan.substring(0, 1).matches(whiteChars) && !textToScan.substring(0, 1).matches(parentheses)) {
			result += textToScan.substring(0, 1);
			textToScan = textToScan.substring(1);
		}
		return result.toLowerCase();
	}
}