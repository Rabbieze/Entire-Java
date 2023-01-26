
public class Rectangle 
{
	// The following instance variables define the
	// information needed to represent a Rectangle
	// Feel free to more instance variables if you think it will 
	// support your work... 
	
	private double xPosition;			// The X coordinate of this Rectangle
	private double yPosition;			// The Y coordinate of this Rectangle
	private double width;				// The width of this Rectangle
	private double height;				// The height of this Rectangle
	private int layer;				// The layer this Rectangle is on.
	private String colour;				// The colour of this Rectangle

										// Permissable colours are:
	public Rectangle(double x, double y, double w, double h, String col)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.width = w;
		this.height = h;
		this.colour = col;
		this.layer = 0;
	}	
									

	public Rectangle(double x, double y, double w, double h, String col, int layer)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.width = w;
		this.height = h;
		this.colour = col;
		this.layer = layer;
	}	

	public double getXPosition()
	{
		return xPosition;
	}


	public double getYPosition()
	{
		return yPosition;
	}


	public void setXPosition(double x)
	{
		this.xPosition = x;
	}


	public void setYPosition(double y)
	{
		this.yPosition = y;
	}

	public double getWidth()
	{
		return width;
	}

	public void setWidth(double w)
	{
		width = w;
	}


	public double getHeight()
	{
		return height;
	}


	public void setHeight(double h)
	{
		height = h;
	}


	public int getLayer()
	{
		return layer;
	}

	public String getColour()
	{
		return colour;
	}

	public void setColour(String c)
	{
		colour = c;
	}

	public void move(double dx, double dy)
	{
		xPosition += dx;
		yPosition += dy;
	}

	public boolean collides(Rectangle r)
	{
		return (xPosition + width > r.xPosition && xPosition < r.xPosition + r.width) && (yPosition + height > r.yPosition && yPosition < r.yPosition + r.height);
	}
}
