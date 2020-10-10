public class Segmento 
{
	private Punto a;
	private Punto b;
	public Segmento(Punto a, Punto b) 
	{
		this.a = a;
		this.b = b;
	}
	public void getLenght() 
	{
		double ax = a.getX();
		double bx = b.getX();
		double ay = a.getY();
		double by = b.getY();
		double az = a.getZ();
		double bz = b.getZ();
		double l = Math.sqrt(Math.pow((ax-bx),2)+Math.pow((ay-by),2)+Math.pow((az-bz),2));
		System.out.print(l);
	}
}
