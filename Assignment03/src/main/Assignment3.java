package main;


import java.util.Scanner;

public class Assignment3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter string: ");
		String input = scanner.nextLine();
		
		//Will terminate the program if '.' encountered
		while(input.charAt(0) != '.'){
			BeanScanner token = new BeanScanner(input);
			System.out.println(token);
			System.out.println("Enter string: ");
			input = scanner.nextLine();
		}
		
		
	}
	

}
