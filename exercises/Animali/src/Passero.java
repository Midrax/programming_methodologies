public class Passero extends Uccello
{
	public Passero() {}
	@Override
	void emettiVerso() 
	{
		System.out.println("Cip!");
	}

	@Override
	void getNumeroDiZampe() 
	{
		System.out.println(2);
	}
	@Override
	void getTaglia() 
	{
		System.out.println("Piccola");
	}
}
