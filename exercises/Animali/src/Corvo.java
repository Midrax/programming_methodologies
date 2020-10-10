public class Corvo extends Uccello
{
	public Corvo() {}
	@Override
	void emettiVerso() 
	{
		System.out.println("Craa!");
	}

	@Override
	void getNumeroDiZampe() 
	{
		System.out.println(2);
	}
	@Override
	void getTaglia() 
	{
		System.out.println("Media");
	}
}
