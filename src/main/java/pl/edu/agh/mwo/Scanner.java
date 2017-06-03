package pl.edu.agh.mwo;
//Test zmian
public class Scanner {

	String textToScan;

	public Scanner(String textInitialValue) {
		textToScan = textInitialValue;
	}
	private boolean isTextEmpty() {
		if (this.textToScan.length() == 0){ return true; }
		return false;
	}
	private void checkOmmitedChars(){
		String whiteChars = "[ \t\n]";
		String parentheses = "[()]";
		String commentBegin = "%";
		String commentEnd = "\n";
		//String textToScan.substring(0, 1) = textToScan.substring(0, 1);
		
		while(textToScan)//zrobiæ pêtla która przejdzie wszystkie znaki
		
		/*while (textToScan.substring(0, 1).matches(whiteChars)) { textToScan = textToScan.substring(1);}//this.deleteOmmitedChars();}
		if (textToScan.substring(0, 1).matches(commentBegin)) {
			while (!textToScan.substring(0, 1).matches(commentEnd)) {
				System.out.println(textToScan);
				textToScan = textToScan.substring(1);}//this.deleteOmmitedChars();}
		}*/

	}
	private void deleteOmmitedChars() {
		// TODO Auto-generated method stub
	}
	
	public String get() {
		String result = "";
		String whiteChars = "[ \t\n]";
		String parentheses = "[()]";
		

		if(this.isTextEmpty()){return result;}
		else{
				this.checkOmmitedChars();
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