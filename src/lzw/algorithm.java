package lzw;

import java.util.Vector;

import lzw.Tag;

public class algorithm
{
	private Vector<String> dictionary;

	public algorithm() 
	{
		dictionary = new Vector<String>();

	}
	
	public void builddic() 
	{
		dictionary.clear();
		
		for(int i=0;i<128;i++)
		{
			dictionary.add((char)i+"");
		}
	}
	public Vector<Tag> compress(String data)
	{
		Vector<Tag> tags = new Vector<Tag>();
		builddic();
		String current = "";
		for(int i = 0; i < data.length(); ++i)
		{
			current += data.charAt(i);
			

			if(!dictionary.contains(current))
			{
				dictionary.add(current);
				Tag t = new Tag();	
				t.setPosition(dictionary.indexOf(current.substring(0, current.length()-1)));
				tags.add(t);
				i--;
				current="";
				
			}

			else if (i == data.length() - 1)
			{
				Tag t = new Tag();
				t.setPosition(dictionary.indexOf(current));
				tags.add(t);
			}
		

		}

		return tags;
	}

	public String decompress(Vector<Tag> tags)
	{
		builddic();
		String data = ""; 
		String temp = "";
		String cur = "";
		for(Tag i : tags)
		{
			int k = i.getPosition();
			
			if(k<dictionary.size())
			{
				cur = dictionary.get(k);
				data += cur;
				if(!dictionary.contains(temp+cur.charAt(0)))
				{
					dictionary.add(temp+cur.charAt(0));
				}
				temp = cur;
			}
			else
			{
				cur = temp + temp.charAt(0);
				data +=cur;
				dictionary.add(cur);
				temp = cur;
			}
		}
		return data;
	}



}
