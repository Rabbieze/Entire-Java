
public class Line 
{
	// The following instance variables define the
	// information needed to represent a line.
	// Feel free to more instance variables if you think it will 
	// support your work... 
	
	private double xStart;						// The X coordinate of the start of this line 
	private double yStart;						// The Y coordinate of the start of this line 
	private double xEnd;						// The X coordinate of the end of this line 
	private double yEnd;						// The Y coordinate of the end of this line
	private double width;						// The thickness of the line
	private double arrowSize;					// Size of the arrowhead on this line
	private int[] arrowX = new int[3];			// Optinal coordinates of an arrowhead on this line (x)
	private int[] arrowY = new int[3];			// Optinal coordinates of an arrowhead on this line (y)

	private int layer;							// The layer this line is drawn on
	private String colour = "WHITE";			// The colour of this line

	public double getXStart()
	{
		return xStart;
	}

	public double getXEnd()
	{
		return xEnd;
	}


	public double getYStart()
	{
		return yStart;
	}


	public double getYEnd()
	{
		return yEnd;
	}

	public double getArrowSize()
	{
		return arrowSize;
	}


	public void setArrowSize(double size)
	{
		arrowSize = size;
		this.recalculateArrowhead();
	}

	public double getLength()
	{
		double lx = xEnd - xStart;
		double ly = yEnd - yStart;
		
		return Math.sqrt(lx*lx + ly*ly);
	}

	public void setLinePosition(double x1, double y1, double x2, double y2)
	{
		this.xStart = x1;
		this.xEnd = x2;
		this.yStart = y1;
		this.yEnd = y2;

		this.recalculateArrowhead();
	}


	public void setWidth(double width)
	{
		this.width = width;
		this.recalculateArrowhead();
	}


	public double getWidth()
	{
		return width;
	}

	public String getColour()
	{
		return colour;
	}

	public int getLayer()
	{
		return layer;
	}

	public int[] getArrowX()
	{
		return arrowX;
	}

	public int[] getArrowY()
	{
		return arrowY;
	}

	public Line(double x1, double y1, double x2, double y2, double thickness, String col, int lay)
	{
		width = thickness;
		colour = col;
		layer = lay;
		arrowSize = 0;
		this.setLinePosition(x1, y1, x2, y2);
	}	

	public Line(double x1, double y1, double x2, double y2, double thickness, String col)
	{
		width = thickness;
		colour = col;
		layer = 0;
		arrowSize = 0;
		this.setLinePosition(x1, y1, x2, y2);
	}
	
	private void recalculateArrowhead()
	{
		// Calculate component distances and length
		double lx = xEnd - xStart;
		double ly = yEnd - yStart;
		double length = this.getLength();

		// Calculate normalized vector of this line.
		double dx = lx / length;
		double dy = ly / length;

		// Calculate the line thickness as a proportion of the length
		double arrowSize = width * this.getArrowSize();
		double arrowRatio = 1.0 - (arrowSize / length);

		// Update arrowHead cooridnates
		arrowX[0] = (int) xEnd;
		arrowX[1] = (int) ((xStart + lx * arrowRatio) - dy * arrowSize);
		arrowX[2] = (int) ((xStart + lx * arrowRatio) + dy * arrowSize);

		arrowY[0] = (int) yEnd;
		arrowY[1] = (int) ((yStart + ly * arrowRatio) + dx * arrowSize);
		arrowY[2] = (int) ((yStart + ly * arrowRatio) - dx * arrowSize);
	}
}
