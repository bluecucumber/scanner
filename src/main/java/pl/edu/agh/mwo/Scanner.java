package pl.edu.agh.mwo;
//Test zmian
public class Scanner {

	String textToScan;
	private final String whiteChars = "[ \t\n]";
	private final String commentBegin = "%";
	private final String commentEnd = "\n";
	private final String parentheses = "[()]";
	
	public Scanner(String textInitialValue) {
		textToScan = textInitialValue;
	}
	private boolean isTextEmpty() {
		return (this.textToScan.length() == 0);
	}
	private void deleteNotTokenChars() {
		while(!isTextEmpty() && (isAWhiteChar() || isAComment())) {
			while(!isTextEmpty() && isAWhiteChar()) { deleteChar(); }
			while(!isTextEmpty() && isAComment()) { deleteComment(); }
		}
	}
	private boolean isAWhiteChar() {
		return textToScan.substring(0, 1).matches(whiteChars);
	}
	private boolean isAComment() {
		return textToScan.substring(0, 1).matches(commentBegin);
	}
	private void deleteChar() {
		textToScan = textToScan.substring(1);
	}
	private void deleteComment() {
		do  { deleteChar(); }
		while (isTextEmpty() || !textToScan.substring(0, 1).matches(commentEnd));
	}
	private boolean isAParenthesis(){
		return !isTextEmpty() && textToScan.substring(0, 1).matches(parentheses);
	}
	private boolean isAToken(){
		return !isTextEmpty() && !isAWhiteChar() && !isAParenthesis();
	}
	public String getToken() {
		String result = "";
		
		while(!isTextEmpty()){
			deleteNotTokenChars();
			
			if (isAParenthesis()) {
				result = textToScan.substring(0, 1);
				deleteChar();
			}
			else {
				while (isAToken()) {
					result += textToScan.substring(0, 1);
					deleteChar();
				}
			}
			return result.toLowerCase();
		}
		return "";
	}
}