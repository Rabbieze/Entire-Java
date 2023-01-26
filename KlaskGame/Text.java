
public class Text
{
	// The following instance variables define the
	// information needed to represent a line.
	// Feel free to more instance variables if you think it will 
	// support your work... 
	
	private double xPosition;			// The X coordinate of the start of this text 
	private double yPosition;			// The Y coordinate of the start of this text 
	private int size;					// The font size of this text 
	private final int layer;					// The layer this text is drawn on
	private String text;				// The actual text to display
	private String colour;				// The colour of this text

	public double getXPosition()
	{
		return xPosition;
	}

	public double getYPosition()
	{
		return yPosition;
	}


	public int getSize()
	{
		return size;
	}

	public void setSize(int size)
	{
		this.size = size;
	}

	public String getColour()
	{
		return colour;
	}


	public String getText()
	{
		return text;
	}

	public int getLayer()
	{
		return layer;
	}


	public Text(String text, int size, double x, double y, String col, int layer)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.size = size;
		this.text = text;
		this.colour = col;
		this.layer = layer;
	}	

	public Text(String text, int size, double x, double y, String col)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.size = size;
		this.text = text;
		this.colour = col;
		this.layer = 0;
	}	

	public void setText(String text)
	{
		this.text = text;
	}

	public void setColour(String colour)
	{
		this.colour = colour;
	}


	public void setXPosition(double x)
	{
		this.xPosition = x;
	}

	public void setYPosition(double y)
	{
		this.yPosition = y;
	}

}
