public class TestPuntoSegmento 
{
	public static void main(String[] args) 
	{
		Punto a = new Punto(1, 3, 8);
		Punto b = new Punto(4, 4, 7);
		Segmento s = new Segmento(a, b);
		s.getLenght();
	}

}
