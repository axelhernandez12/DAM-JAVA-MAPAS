package Principal;

import java.awt.EventQueue;

public class Main 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Marco frame = new Marco();
					frame.setVisible(true);
				} catch (Exception e) {e.printStackTrace();}
			}
		});
	}
}