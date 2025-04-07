package Principal;

public class Aparcamiento 
{
	private long pk;
	private String nombre;
	private String descripcion;
	private double latitud;
	private double longitud;
	
	
	public Aparcamiento(long pk, String nombre, String descripcion, double latitud, double longitud) 
	{
		super();
		this.pk = pk;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.latitud = latitud;
		this.longitud = longitud;
	}
	public Aparcamiento(String pk, String nombre, String descripcion, String  latitud, String longitud) 
	{
		super();
		this.pk = Long.parseLong(pk);
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.latitud = Double.parseDouble(latitud);
		this.longitud = Double.parseDouble(longitud);
	}
	


	public double getLatitud() {
		return latitud;
	}


	public double getLongitud() {
		return longitud;
	}


	@Override
	public String toString() {
		return  pk + " " + nombre+ " " + descripcion;
	}
	
	
	
	
}
