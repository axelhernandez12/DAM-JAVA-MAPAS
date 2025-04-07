package Principal;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;
import org.jxmapviewer.viewer.WaypointRenderer;


public class Marco extends JFrame 
{
	private JPanel contentPane;

	
	private JXMapKit visorMapasKit;

	private BufferedImage imagen;
	public Marco() throws IOException 
	{
	  imagen = ImageIO.read(new File("./coche.png"));
	  JLabel icono = new JLabel(new ImageIcon(imagen));
	  
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		visorMapasKit = new JXMapKit();
		setContentPane(visorMapasKit);
		visorMapasKit.setAddressLocation(new GeoPosition(40.4022203,-3.706059));
		visorMapasKit.setZoom(1);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		//setContentPane(contentPane);
		Set<Waypoint> waypoints = new HashSet<Waypoint>();
		Waypoint a =  new DefaultWaypoint(40.4025863,-3.7061154);
		Waypoint b =  new DefaultWaypoint(40.4022203,-3.706059);
		waypoints.add(a);
		waypoints.add(b);
		WaypointPainter<Waypoint> painter = new WaypointPainter<Waypoint>();
		painter.setWaypoints(waypoints);
		
		painter.setRenderer(
		new WaypointRenderer<Waypoint>() 
		{
			@Override
		public void paintWaypoint(Graphics2D g, JXMapViewer map, Waypoint wp)
			{
				Point2D point = map.getTileFactory().geoToPixel(wp.getPosition(),map.getZoom());
				int x = (int) point.getX();
				int y = (int) point.getY();
				g.setColor(new Color(255,0,0));
				g.drawLine(x-10,y-10,x+10,y+10);
				g.drawLine(x-10,y+10,x+10,y-10);
				
				
				g.drawImage(imagen, x-10, y-10, 20, 20, null);
				
			//g.drawLine(-5, 5, 5, -5);
				//g.draw3DRect(-100,-100,60,60,true);
								//System.out.println("El primero");
				
			}
			
			
		});
		
		
		visorMapasKit.getMainMap().setOverlayPainter(painter);
		visorMapasKit.setAddressLocationShown(true);
		visorMapasKit.setDataProviderCreditShown(true);
		//visorMapasKit.getMainMap().setOverlayPainter(painter);
	}
	
	/*public void addWaypoint() 
	{
	    //create a Set of waypoints
	    Set<Waypoint> waypoints = new HashSet<Waypoint>();
	    waypoints.add(new Waypoint(41.881944,-87.627778));
	    waypoints.add(new Waypoint(40.716667,-74));
	    
	    //crate a WaypointPainter to draw the points
	    WaypointPainter painter = new WaypointPainter();
	    painter.setWaypoints(waypoints);
	    visorMapasKit.getMainMap().setOverlayPainter(painter);
	}*/
	// Note the call to jXMapKit1.getMainMap(). JXMapKit is actually 
	// a wrapper for two instances of the JXMapViewer; 
	// one for the main map and one for the mini map. 
	// You can get access to those instances with the getMainMap() and getMiniMap() methods.
}
