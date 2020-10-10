
public class Divisori 
{
	public Divisori() {}
	public void divisori(int n)
	{
		String l = "";
		for (int i = 1; i < n; i++)
			if (n % i == 0)
				l += i+", ";
		System.out.println(l.substring(0, l.length()-2));
	}
}
