import java.util.Arrays;

public class Filtro 
{
	private int[] a;
	public Filtro(int[] a)
	{
		this.a = a;
	}
	
	public int[] passaBasso(int n)
	{
		int c = 0;
		int[] b = new int[a.length];
		for (int i = 0; i<a.length; i++)
		{
			if (a[i]<=n)
				{
					b[c] = a[i];
					c++;
				}
		}
		b = Arrays.copyOf(b, c);
		return b;
	}
	
	public int[] passaAlto(int n)
	{
		int c = 0;
		int[] b = new int[a.length];
		for (int i = 0; i<a.length; i++)
		{
			if (a[i]>=n)
			{
				b[c] = a[i];
				c++;
			}
		}
		b = Arrays.copyOf(b, c);
		return b;
	}
	
	public int[] filtra(int n)
	{
		int c = 0;
		int[] b = new int[a.length];
		for (int i = 0; i<a.length; i++)
		{
			if (a[i]!=n)
				{
					b[c] = a[i];
					c++;
				}
		}
		b = Arrays.copyOf(b, c);
		return b;
	}
	
	public int[] filtra(int[] n)
	{
		for (int z = 0; z<n.length; z++)
			a = filtra(n[z]);
		return a;
	}
}
