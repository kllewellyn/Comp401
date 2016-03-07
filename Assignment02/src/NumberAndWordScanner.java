import java.util.Scanner;


public class NumberAndWordScanner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter string: ");
		String input = scanner.nextLine();
		
		//Will terminate the program if '.' encountered
		while(input.charAt(0) != '.'){
			Bean.setInput(input);
			System.out.println("Enter string: ");
			input = scanner.nextLine();
		}
	}
	
	public static void Scan(String s){

		String finalString = "";
		String temp = "";
		for (int k = 0; k < s.length(); k++){
		
			 if (k == s.length() - 1){
				 finalString += temp;
				 System.out.println(finalString);
				 finalString = "";
				 temp = "";
			 }
			 
			 else if (Character.isDigit(s.charAt(k))){
				if (finalString == ""){
					finalString = "Number: ";
				}
				else if((temp == "" && s.charAt(k) != '0') || temp != ""){
					temp += s.substring(k, k+1);
				}
			}
			
			else if (s.charAt(k) == '"' && finalString == ""){
					finalString = "Quoted word: ";
			}
			
			else if(Character.isLetter(s.charAt(k)) && s.charAt(k) != '"');{
				if (finalString == ""){
					finalString = "Word: ";
					temp += s.substring(k, k+1);
				}
				else{
				temp += s.substring(k, k+1);
				}
			}

			 if ((s.charAt(k) == ' ')){
				finalString += temp;
				System.out.println(finalString);
				finalString = "";
				temp = "";
			 }
			}
	}
}
