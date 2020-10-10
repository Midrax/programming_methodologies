
public class StringheVerticali 
{
	public StringheVerticali() {}
	public void stringheVerticali(String a, String b, String c)
	{
		int mid = Math.max(a.length(), b.length());
		int max = Math.max(mid, c.length());
		for (int n = 0; n < max; n++)
			a+=" ";
		for (int n = 0; n < max; n++)
			b+=" ";
		for (int n = 0; n < max; n++)
			c+=" ";
		for (int n = 0; n < max; n++)
			System.out.println(Character.toString(a.charAt(n))+Character.toString(b.charAt(n))+Character.toString(c.charAt(n)));
	}
}
