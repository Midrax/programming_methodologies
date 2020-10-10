
public class Palindromo 
{
	public Palindromo() {}
	public void palindromo(String dritto)
	{
		String rovescio = "";
	    for (int i=dritto.length()-1; i>=0; i--)
	    	rovescio += dritto.charAt(i);
	    if (dritto.equals(rovescio))
	    	System.out.println("La stringa è palindroma");
	    else
	    	System.out.println("La stringa non è palindroma");
	}
}
