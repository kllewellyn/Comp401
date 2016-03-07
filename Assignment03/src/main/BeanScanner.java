package main;

public class BeanScanner implements BeanInterface{
	
	private String input;
	
	public BeanScanner(String s)
	{
		setBean(s);
		getBean();
	}
	
	public void setBean(String s)
	{
		input = s;
		
		String temp = "";
		int p = 0;
		
		for (int k = 0; k < input.length(); k += p)
		{
			if (input.charAt(k) == '"')
			{
				temp += input.substring(k, k+1);
				p++;
			}
			if (input.charAt(k) == '{')
			{
				Start begin = new Start(input.substring(k, k+1));
				System.out.println(begin);
				p++;
			}
			if (input.charAt(k) == '}')
			{
				End end1 = new End(input.substring(k, k+1));
				System.out.println(end1);
				p++;
			}
			if (input.charAt(k) == ' ')
			{
				if (Character.isDigit(temp.charAt(0)))
				{
					Number num = new Number(temp);
					System.out.println(num);
					p++;
				}
				if (Character.isLetter(temp.charAt(0)))
				{
					Word word1 = new Word(temp);
					System.out.println(word1);
					p++;
				}
				if (temp.charAt(0) == '"')
				{
					Quote quotes = new Quote(temp);
					System.out.println(quotes);
					p++;
				}
				else
					p++;
			}
			if (Character.isDigit(input.charAt(k))){
					temp += s.substring(k, k+1);
					p++;
			}
			if (input.charAt(k) == '+')
			{
				Plus plus = new Plus(input.substring(k, k+1));
				System.out.println(plus);
				p++;
			}
			if (input.charAt(k) == '-')
			{
				Minus minus = new Minus(input.substring(k, k+1));
				System.out.println(minus);
				p++;
			}
				
		}	
	}
	
	public String getBean()
	{
		return input;
	}
	
}
