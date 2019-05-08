package lzw;

import java.util.Scanner;
import java.util.Vector;
import java.io.*;
import java.util.Formatter;


public class Test 
{
	public static void main(String[] args) throws IOException
	{
		Scanner input = new Scanner(new File("input.txt"));
		Formatter output = new Formatter(new File("inputtags.txt"));		

		String data = input.nextLine();


		algorithm lzw = new algorithm();

		Vector<Tag> tags = lzw.compress(data);
		for(Tag i : tags)
		{
			output.format("%d ", i.getPosition());
		}
		output.close();
		input.close();
		
		input = new Scanner(new File("outputtags.txt"));
		output = new Formatter(new File("output.txt"));
		
		Vector<Tag> decomptags = new Vector<Tag>();
		while(input.hasNextInt())
		{
			int x = input.nextInt();
			decomptags.add(new Tag(x));
			
		}
		
		
		String original = lzw.decompress(decomptags);
		output.format("%s", original);	
		output.close();
		input.close();
		
	}
}
