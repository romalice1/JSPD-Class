
import java.awt.*;	// import the AWT graphic classes
import java.util.*;	// import the utility classes
import java.applet.*;	// import the Applet graphic classes
import javax.swing.*;	// import the Swing classes

/**
 *  FiveMeths is an Applet that draws using methods in the Graphics class.
 *  
 *  @author Your Name
 *
 */

public class FiveMethsGC extends Applet
{
static int counter = 0;

public void init()
{
	setBackground(Color.yellow);
	counter++;
	System.out.println("In init() " + counter);
}

public void finalize()
{
	counter--;
	System.out.println("In finalize() now " + counter);
}


public void start()
{
	System.out.println("In start()");
}

public void paint(Graphics g)
{
	System.out.println("In paint()");
	g.drawString("In Paint", 20, 30);
}

public void stop()
{
	System.out.println("In stop()");
}

public void destroy()
{
	System.out.println("In destroy()");
}

}
