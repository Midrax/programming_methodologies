import java.util.Arrays;

public class ListaDiInteri 
{
	private int[] a;
	public ListaDiInteri(int[] a)
	{
		this.a = a;
	}
	
	public int getValueAtIndex(int i)
	{
		return a[i];
	}
	
	public int getIndexOfValue(int i)
	{
		int x = 0;
		for (int b = 0; b<a.length; b++)
			if (a[b] == i)
				x = b;
		return x;
	}
	
	public String toString()
	{
		return Arrays.toString(a);
	}
	
	public int length()
	{
		return a.length;
	}
	
	public boolean inside(int n)
	{
		boolean x = false;
		for (int b = 0; b<a.length; b++)
			if (a[b] == n)
				x = true;
		return x;
	}
	
	public void aggiungi(int n)
	{
		a = Arrays.copyOf(a, a.length+1);
		a[a.length-1] = n;
	}
	
	public void aggiungi(int n, int p)
	{
		int[] b = Arrays.copyOfRange(a, p, a.length);
		a =  Arrays.copyOf(a, p+1);
		a[p] = n;
		for (int i = 0; i<b.length; i++)
			aggiungi(b[i]);
	}
	
	public void elimina(int n)
	{
		int v = getIndexOfValue(n);
		int[] b = Arrays.copyOfRange(a, v+1, a.length);
		a =  Arrays.copyOf(a, v);
		for (int i = 0; i<b.length; i++)
			aggiungi(b[i]);
	}
	
	public void eliminaPosizione(int v)
	{
		int[] b = Arrays.copyOfRange(a, v+1, a.length);
		a =  Arrays.copyOf(a, v);
		for (int i = 0; i<b.length; i++)
			aggiungi(b[i]);
	}
}
