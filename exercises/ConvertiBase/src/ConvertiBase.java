
public class ConvertiBase 
{
	public ConvertiBase() {}
	public void convertiBase(int a, int b) 
	{
		String c = "" + a;
		System.out.println(Integer.toString(Integer.parseInt(c, 10), b));
	}
}
