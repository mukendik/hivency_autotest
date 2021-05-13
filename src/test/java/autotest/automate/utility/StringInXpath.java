package autotest.automate.utility;

public class StringInXpath {

	// Function to insert string
    public static String insertString(String originalString, String stringToBeInserted, int index)
    {
    	 // Create a new StringBuffer
        StringBuffer newString
            = new StringBuffer(originalString);
  
        // Insert the strings to be inserted
        // using insert() method
        newString.insert(index + 1, stringToBeInserted);
  
        // return the modified String
        return newString.toString();
    }
    
    public static String insertInSpanXpath(String toBeInserted) {
    	  String originalString = "//span[contains(text(),'')]";
    	  int index = 23;
    	return insertString(originalString,toBeInserted,index);	
    }
    
    public static String insertInDivXpath(String toBeInserted) {
	  String originalString = "//div[contains(text(),'')]";
	  int index = 22;
	return insertString(originalString,toBeInserted,index);	
}
    public static String insertInAnyXpath(String toBeInserted) {
  	  String originalString = "//*[contains(text(),'')]";
  	  int index = 20;
  	return insertString(originalString,toBeInserted,index);	
  }
}
