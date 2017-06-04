package pl.edu.agh.mwo;
//Test zmian
public class Scanner {

	String textToScan;
	private final String whiteChars = "[ \t\n]";
	private final String commentBegin = "%";
	private final String commentEnd = "\n";	

	public Scanner(String textInitialValue) {
		textToScan = textInitialValue;
	}
	private boolean isTextEmpty() {
		return (this.textToScan.length() == 0);
	}
	private void deleteNotTokenChars() {
		while(!isTextEmpty() && (isAWhiteChar() || isAComment())) {
			while(!isTextEmpty() && isAWhiteChar()) { deleteWhiteChar(); }
			while(!isTextEmpty() && isAComment()) { deleteComment(); }
		}
	}
	private boolean isAWhiteChar() {
		return textToScan.substring(0, 1).matches(whiteChars);
	}
	private boolean isAComment() {
		return textToScan.substring(0, 1).matches(commentBegin);
	}
	private void deleteWhiteChar() {
		textToScan = textToScan.substring(1);
	}
	private void deleteComment() {
		do  {
			textToScan = textToScan.substring(1);}
		while (isTextEmpty() || !textToScan.substring(0, 1).matches(commentEnd));
	}
	public String get() {
		String result = "";
		String parentheses = "[()]";
		
		while(!isTextEmpty()){
			deleteNotTokenChars();
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
		
		return "";

	}


}