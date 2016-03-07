import java.util.Scanner;
public class Austin {
	
	public static void main(String[] args)
	{
	String test = "023 3 0100000 ";
	scan(test);
	String test2 = "       069 023 001 065 75 ";
	scan(test2);
	}

	public static void scan(String input)
	{
	String num = "Numbers:";
	int sum1 = 0;
	int prod1 = 1;
	String temp ="";

	for (int i=0; i<input.length(); i++)
	{
	if(Character.isDigit(input.charAt(i)))
	{
	temp= temp + input.charAt(i);

	}
	else 
	{
	int finalInt = Integer.parseInt(temp);
	num+= finalInt + " ";
	sum1+=finalInt;
	prod1*=finalInt;
	temp="";
	}

	}

	System.out.print(num + "Sum: " + sum1 + " Product: " + prod1);
	System.out.println();
	}
	}
