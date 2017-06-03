package pl.edu.agh.mwo;
//Test zmian
public class Scanner {

	String text;

	public Scanner(String init) {
		text = init;
	}

	public String get() {
		String result = "";
		String whiteChars = "[ \t\n]";
		String parentheses = "[()]";
		String commentBegin = "%";
		String commentEnd = "\n";
		boolean ok = false;
		while (!ok) {
			if (text.length() == 0) {
				return result;
			} else if (text.substring(0, 1).matches(whiteChars)) {
				text = text.substring(1);
			} else if (text.substring(0, 1).matches(commentBegin)) {
				while (!text.substring(0, 1).matches(commentEnd)) {
					text = text.substring(1);
				}
			} else {
				ok = true;
			}
		}

		if (text.length() > 0 && text.substring(0, 1).matches(parentheses)) {
			result = text.substring(0, 1);
			text = text.substring(1);
		}
		while (text.length() > 0 && !text.substring(0, 1).matches(whiteChars) && !text.substring(0, 1).matches(parentheses)) {
			result += text.substring(0, 1);
			text = text.substring(1);
		}
		return result.toLowerCase();
	}
}