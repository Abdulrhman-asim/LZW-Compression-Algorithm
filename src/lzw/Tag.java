	package lzw;

public class Tag
{
	private int position;
	public Tag()
	{
		position = 0;
		
	}
	public Tag(int p)
	{
		position = p;
	}
	public void setPosition(int p)
	{
		position = p;
	}
	
	public int getPosition()
	{
		return position;
	}

	public String toString()
	{
		String taag = "";
		taag += "<" + position +  ">";
		return taag;
	}
}
