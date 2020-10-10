
public class ContaVocali 
{
	public ContaVocali() {}
	public void contaVocali(String z) 
	{
		String s = z.toLowerCase();
		int as = s.length()-s.replace("a", "").length();
		int es = s.length()-s.replace("e", "").length();
		int is = s.length()-s.replace("i", "").length();
		int os = s.length()-s.replace("o", "").length();
		int us = s.length()-s.replace("u", "").length();
		System.out.println("a="+as+" e="+es+" i="+is+" o="+os+" u="+us);
	}
}
