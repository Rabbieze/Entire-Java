
public class Ball 
{
	// The following instance variables define the
	// information needed to represent a Ball
	// Feel free to more instance variables if you think it will 
	// support your work... 
	
	private double xPosition;			// The X coordinate of this Ball
	private double yPosition;			// The Y coordinate of this Ball
	private double size;				// The diameter of this Ball
	private int layer;					// The layer of this ball is on.
	private String colour;				// The colour of this Ball


	public Ball(double x, double y, double diameter, String col)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.size = diameter;
		this.colour = col;
		this.layer = 0;
	}	

	public Ball(double x, double y, double diameter, String col, int layer)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.size = diameter;
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

	public double getSize()
	{
		return size;
	}

	public void setSize(double s)
	{
		size = s;
	}

	public int getLayer()
	{
		return layer;
	}

	public void setLayer(int l)
	{
		layer = l;
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

	public boolean collides(Ball b)
	{
		double dx = b.xPosition - xPosition;
		double dy = b.yPosition - yPosition;
		double distance = Math.sqrt(dx*dx+dy*dy);

		return distance < size/2 + b.size/2;
	}
}
