import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import java.lang.Class;
import java.lang.reflect.*;

public class Klask extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener
{
	// Size of play area
	private JFrame frame;
	private int arenaWidth;
	private int arenaHeight;

	private boolean exiting = false;

	private ArrayList<Object> things = new ArrayList<Object>();

	private HashMap<String, Color> colours = new HashMap<>();

	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;
	private boolean shift = false;
	private boolean space = false;
	private boolean esc = false;
	private boolean enter = false;
	private boolean[] alphasPressed = new boolean[26];
	private final static int asciiAZOffset = 65;
	private final static int alphabetLength = 25;
	private boolean leftMouse = false;
	private boolean rightMouse = false;
	private int mouseX = 0;
	private int mouseY = 0;

	private BufferedImage buffer;
	private Graphics2D graphics;
	private Map<RenderingHints.Key, Object> renderingHints;
	private boolean rendered = false;
	private Image backgroundImage = null;

	public Klask(int width, int height)
	{
		this.init(width, height, true);
	}


	public Klask(int width, int height, boolean createWindow)
	{
		this.init(width, height, createWindow);
	}

	private void init(int width, int height, boolean createWindow)
	{
		if (createWindow)
		{
			this.frame = new JFrame();
			frame.setTitle("Let's Play!");
			frame.setSize(width, height);
			frame.setResizable(false);
			frame.setBackground(Color.BLACK);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setContentPane(this);
			frame.setVisible(true);
		}

		this.setSize(width, height);

		// Add standard colours.
		colours.put("BLACK", Color.BLACK);
		colours.put("BLUE", Color.BLUE);
		colours.put("CYAN", Color.CYAN);
		colours.put("DARKGREY", Color.DARK_GRAY);
		colours.put("GREY", Color.GRAY);
		colours.put("GREEN", Color.GREEN);
		colours.put("LIGHTGREY", Color.LIGHT_GRAY);
		colours.put("MAGENTA", Color.MAGENTA);
		colours.put("ORANGE", Color.ORANGE);
		colours.put("PINK", Color.PINK);
		colours.put("RED", Color.RED);
		colours.put("WHITE", Color.WHITE);
		colours.put("YELLOW", Color.YELLOW);

		// Setup graphics rendering hints for quality
		renderingHints = new HashMap<>();
		renderingHints.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		renderingHints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		renderingHints.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		renderingHints.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
		renderingHints.put(RenderingHints.KEY_FRACTIONALMETRICS,RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		renderingHints.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		renderingHints.put(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		renderingHints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);

		try {
			Class rh = Class.forName("java.awt.RenderingHints");
			RenderingHints.Key key = (RenderingHints.Key) rh.getField("KEY_RESOLUTION_VARIANT").get(null);
			Object value = rh.getField("VALUE_RESOLUTION_VARIANT_DPI_FIT").get(null);
			renderingHints.put(key, value);
		}
		catch (Exception e){}

		Thread t = new Thread(this);
		t.start();

		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		if (frame != null)
			frame.addKeyListener(this);
	}

	public void run() {
		try {
			while (!exiting) {
				this.repaint();
				Thread.sleep(10);
			}
		} catch (InterruptedException iex) {}

		if (frame != null)
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}

	public void setSize(int width, int height)
	{
		this.arenaWidth = width;
		this.arenaHeight = height;

		super.setSize(width,height);

		if (frame != null)
			frame.setSize(arenaWidth + frame.getInsets().left + frame.getInsets().right, arenaHeight + frame.getInsets().top + frame.getInsets().bottom);


	}


	public void setBackgroundImage(String filename)
	{
		Toolkit t=Toolkit.getDefaultToolkit();
		backgroundImage = t.getImage(filename);
	}


	public JPanel getPanel()
	{
		return this;
	}

	public void exit()
	{
		this.exiting = true;
	}

	public void paint (Graphics gr)
	{
		Graphics2D window = (Graphics2D) gr;

		if (!rendered)
		{
			this.setSize(arenaWidth, arenaHeight);

			// Create a buffer the same size of the window, which we can reuse from frame to frame to improve performance.
			buffer = new BufferedImage(arenaWidth, arenaHeight, BufferedImage.TYPE_INT_ARGB);
			graphics = buffer.createGraphics();
			graphics.setRenderingHints(renderingHints);

			// Remember that we've completed this initialisation, so that we don't do it again...
			rendered = true;
		}

		if (frame == null)
		{
			// Find the JFrame we have been added to, and attach a KeyListner
			frame = (JFrame) SwingUtilities.getWindowAncestor(this);

			if (frame != null)
				frame.addKeyListener(this);
		}

		window.setRenderingHints(renderingHints);

		synchronized (this)
		{
			if (!this.exiting)
			{
				graphics.clearRect(0,0, arenaWidth, arenaHeight);

				if (backgroundImage != null)
					graphics.drawImage(backgroundImage, 0, 0, arenaWidth, arenaHeight, 0, 0, backgroundImage.getWidth(null), backgroundImage.getHeight(null), null);

				for (Object o : things)
				{
					if (o instanceof Ball)
					{
						Ball b = (Ball) o;
						graphics.setColor(this.getColourFromString(b.getColour()));
						graphics.fillOval((int)(b.getXPosition() - b.getSize()/2), (int)(b.getYPosition() - b.getSize()/2), (int)b.getSize(), (int)b.getSize());
					}

					if (o instanceof Rectangle)
					{
						Rectangle r = (Rectangle) o;
						graphics.setColor(this.getColourFromString(r.getColour()));
						graphics.fillRect((int)r.getXPosition(), (int)r.getYPosition(), (int)r.getWidth(), (int)r.getHeight());
					}

					if (o instanceof Line)
					{
						Line l = (Line) o;
						graphics.setColor(this.getColourFromString(l.getColour()));
						graphics.setStroke(new BasicStroke((float)l.getWidth()));

						float sx = (float)l.getXStart();
						float sy = (float)l.getYStart();
						float ex = (float)l.getXEnd();
						float ey = (float)l.getYEnd();

						if (l.getArrowSize() > 0)
						{
							float arrowRatio = (float) (1.0 - ((l.getWidth() * l.getArrowSize()) / l.getLength()));
							ex = sx + ((ex - sx) * arrowRatio);
							ey = sy + ((ey - sy) * arrowRatio);
							graphics.fillPolygon(l.getArrowX(), l.getArrowY(), 3);
						}
						graphics.draw(new Line2D.Float(sx,sy,ex,ey));
					}

					if (o instanceof Text)
					{
						Text t = (Text) o;
						graphics.setFont(new Font("SansSerif", Font.BOLD, t.getSize()));
						graphics.setColor(this.getColourFromString(t.getColour()));
						graphics.drawString(t.getText(),(float)t.getXPosition(), (float)t.getYPosition());
					}
				}
			}

			window.drawImage(buffer, this.getInsets().left, this.getInsets().top, this);
		}
	}

	//
	// Shouldn't really handle colour this way, but the student's haven't been introduced
	// to constants properly yet, hmmm....
	//
	private Color getColourFromString(String col)
	{
		Color c = colours.get(col.toUpperCase());

		if (c == null && col.startsWith("#"))
		{
			int r = Integer.valueOf( col.substring( 1, 3 ), 16 );
			int g = Integer.valueOf( col.substring( 3, 5 ), 16 );
			int b = Integer.valueOf( col.substring( 5, 7 ), 16 );

			c = new Color(r,g,b);
			colours.put(col.toUpperCase(), c);
		}

		if (c == null)
			c = Color.WHITE;

		return c;
	}


	private void addThing(Object o, int layer)
	{
		boolean added = false;

		if (exiting)
			return;

		synchronized (this)
		{
			if (things.size() > 100000)
			{
				System.out.println("\n\n");
				System.out.println(" ********************************************************* ");
				System.out.println(" ***** Only 100000 Objects Supported per Game Arena! ***** ");
				System.out.println(" ********************************************************* ");
				System.out.println("\n");
				System.out.println("-- Joe\n\n");

				this.exit();
			}
			else
			{
				// Try to insert this object into the list.
				for (int i=0; i<things.size(); i++)
				{
					int l = 0;
					Object obj = things.get(i);

					if (obj instanceof Ball)
						l = ((Ball)obj).getLayer();

					if (obj instanceof Rectangle)
						l = ((Rectangle)obj).getLayer();

					if (obj instanceof Line)
						l = ((Line)obj).getLayer();

					if (obj instanceof Text)
						l = ((Text)obj).getLayer();

					if (layer < l)
					{
						things.add(i,o);
						added = true;
						break;
					}
				}

				// If there are no items in the list with an equivalent or higher layer, append this object to the end of the list.
				if (!added)
					things.add(o);
			}
		}
	}


	private void removeObject(Object o)
	{
		synchronized (this)
		{
			things.remove(o);
		}
	}

	public void addBall(Ball b)
	{
		this.addThing(b, b.getLayer());
	}

	public void addRectangle(Rectangle r)
	{
		this.addThing(r, r.getLayer());
	}


	public void addLine(Line l)
	{
		this.addThing(l, l.getLayer());
	}

	public void addText(Text t)
	{
		this.addThing(t, t.getLayer());
	}


	public void removeRectangle(Rectangle r)
	{
		this.removeObject(r);
	}

	public void removeBall(Ball b)
	{
		this.removeObject(b);
	}

	public void removeLine(Line l)
	{
		this.removeObject(l);
	}

	public void removeText(Text t)
	{
		this.removeObject(t);
	}

	public void clearGameArena() {
		synchronized(this) {
			things.clear();
		}
	}

	public void pause()
	{
		try { Thread.sleep(20); }
		catch (Exception e) {};
	}
	private boolean isAsciiAZ(int asciiVal)
	{
		if (asciiVal >= asciiAZOffset && asciiVal <= asciiAZOffset+alphabetLength)
			return true;
			
		return false;
	}

	public boolean letterPressed(char key)
	{
		if (Character.isLetter(key))
			if(isAsciiAZ((int) Character.toUpperCase(key)))
				return alphasPressed[(int) Character.toUpperCase(key) -asciiAZOffset];
		return false;
	}

 	public void keyPressed(KeyEvent e)
	{
		keyAction(e,true);
	}

	public void keyAction(KeyEvent e,boolean yn)
	{
		int code = e.getKeyCode();

		if (code == KeyEvent.VK_UP)
			up = yn;
		if (code == KeyEvent.VK_DOWN)
			down = yn;
		if (code == KeyEvent.VK_LEFT)
			left = yn;
		if (code == KeyEvent.VK_RIGHT)
			right = yn;
		if (code == KeyEvent.VK_SPACE)
			space = yn;
		if (code == KeyEvent.VK_SHIFT)
			shift = yn;
		if (code == KeyEvent.VK_ESCAPE)
			esc = yn;
		if (code == KeyEvent.VK_ENTER)
			enter = yn;
		//ASCII A-Z check
		if (isAsciiAZ(code))
			alphasPressed[code-asciiAZOffset] = yn;
	}

	public void keyReleased(KeyEvent e){
		keyAction(e,false);
	}


 	public void keyTyped(KeyEvent e)
	{
	}


	public void mousePressed(MouseEvent e)
	{
		if (e.getButton() == MouseEvent.BUTTON1)
			this.leftMouse = true;

		if (e.getButton() == MouseEvent.BUTTON3)
			this.rightMouse = true;
	}

	public void mouseReleased(MouseEvent e)
	{
		if (e.getButton() == MouseEvent.BUTTON1)
			this.leftMouse = false;

		if (e.getButton() == MouseEvent.BUTTON3)
			this.rightMouse = false;
	}

	public void mouseEntered(MouseEvent e)
	{
	}

	public void mouseExited(MouseEvent e)
	{
	}

	public void mouseClicked(MouseEvent e)
	{
	}

	public void mouseMoved(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public void mouseDragged(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public int getArenaWidth()
	{
		return arenaWidth;
	}

	public int getArenaHeight()
	{
		return arenaHeight;
	}

	public boolean upPressed()
	{
		return up;
	}

	public boolean downPressed()
	{
		return down;
	}

	public boolean leftPressed()
	{
		return left;
	}

	public boolean rightPressed()
	{
		return right;
	}


	public boolean spacePressed()
	{
		return space;
	}

	public boolean escPressed()
	{
		return esc;
	}

	public boolean enterPressed()
	{
		return enter;
	}


	public boolean shiftPressed()
	{
		return shift;
	}

	public boolean leftMousePressed()
	{
		return leftMouse;
	}


	public boolean rightMousePressed()
	{
		return rightMouse;
	}

	public int getMousePositionX()
	{
		return mouseX;
	}

	public int getMousePositionY()
	{
		return mouseY;
	}

}
