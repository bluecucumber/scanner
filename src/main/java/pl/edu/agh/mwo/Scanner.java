package pl.edu.agh.mwo;
//Test zmian
public class Scanner {

	String textToScan;

	public Scanner(String textInitialValue) {
		textToScan = textInitialValue;
	}
	private boolean isTextEmpty() {
		return (this.textToScan.length() == 0);
	}
	private void checkOmmitedChars(){
		String whiteChars = "[ \t\n]";
		String commentBegin = "%";
		String commentEnd = "\n";		

		while (textToScan.length() > 0 && textToScan.substring(0, 1).matches(whiteChars)) { 
			textToScan = textToScan.substring(1);//this.deleteOmmitedChars();}
			if (textToScan.length() > 0 && textToScan.substring(0, 1).matches(commentBegin)) {
				do  {
					textToScan = textToScan.substring(1);}//this.deleteOmmitedChars();}
				while (!textToScan.substring(0, 1).matches(commentEnd));
			}
		}
	}
	private void deleteOmmitedChars() {
		// TODO Auto-generated method stub
	}
	
	public String get() {
		String result = "";
		String whiteChars = "[ \t\n]";
		String parentheses = "[()]";
		
		while(!isTextEmpty()){
			this.checkOmmitedChars();
			
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