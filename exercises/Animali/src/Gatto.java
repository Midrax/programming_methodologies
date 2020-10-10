
public class Gatto extends Felino
{
	public Gatto() {}
	@Override
	void emettiVerso() 
	{
		System.out.println("Miao!");
	}

	@Override
	void getNumeroDiZampe() 
	{
		System.out.println(4);
	}
	@Override
	void getTaglia() 
	{
		System.out.println("Piccola");
	}
}
