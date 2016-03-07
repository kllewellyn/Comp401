/**
 * Author: Kaylee Llewellyn
 */
import java.util.Scanner;

public class NumberScanner{
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter string: ");
		String input = scanner.nextLine();
		
		//Will terminate the program if '.' encountered
		while(input.charAt(0) != '.'){
			Scan(input);
			System.out.println("Enter string: ");
			input = scanner.nextLine();
		}
	}
	
	public static void Scan(String s){
		String numbers = "";
		int sum = 0;
		int product = 1;
		String strnumber = "";
		int num = 0;
		
		for (int k = 0; k < s.length(); k++){
			if (Character.isDigit(s.charAt(k))){
				if (k == s.length() - 1){
					strnumber += Integer.parseInt(s.substring(k, k+1));
					numbers += strnumber + " ";
					num = Integer.parseInt(strnumber);
					sum += num;
					product = product * num;
					strnumber = "";
				}
				else if((strnumber == "" && s.charAt(k) != '0')){
					strnumber 
					+= Integer.parseInt(s.substring(k, k+1));
				}
				else if (strnumber != "")
					strnumber += Integer.parseInt(s.substring(k, k+1));
			}
			
			else if (s.charAt(k) == ' ' && strnumber != ""){
				numbers += strnumber + " ";
				num = Integer.parseInt(strnumber);
				sum += num;
				product = product * num;
				strnumber = "";	
			}
			
			//Continues to run program even when illegal character entered
			//Separates string into two numbers separated at the illegal character
			else if (!Character.isDigit(s.charAt(k)))
			{
				numbers += strnumber + " ";
				num = Integer.parseInt(strnumber);
				sum += num;
				product = product * num;
				strnumber = "";
				System.out.println("Error: Illegal character has been input ");
			}
		}
		System.out.println("Numbers: " + numbers + " " + "Sum: " + sum + " Product: " + product);	
	}
}
