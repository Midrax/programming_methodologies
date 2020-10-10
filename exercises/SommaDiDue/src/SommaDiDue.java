
public class SommaDiDue 
{
	public SommaDiDue() {}
	public void sommaDiDue(int a, int b, int c) 
	{
		String l = "";
		for (int i=0; i<c; i++)
		{	
			b = a + b;
			a = b - a;
			l += b+", ";
		}
		System.out.println(a+", "+b+", "+l.substring(0, l.length()-2));
	}

}
