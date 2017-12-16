//there is reason why we made this abtract here.
//to estabhlish a hierarchy of palya items, which is cleaner code
//if this want there then everything would directly become an instance of interface Item, which is muddled
//furthere, if you eanted to add a common functionality to all palya classes then you can add it here.This would've not been possible otherwise
public abstract class Palya implements MenuItem
{
	public abstract int getPrice();
	public abstract String getName();
	public abstract boolean isAvailable();
}
class BadnekaiPalya extends Palya 
{
	public BadnekaiPalya()
	{

	}
	@Override
	public int getPrice()
	{
		return 20;
	}
	@Override
	public String getName()
	{
		return "BadnekaiPalya";
	}
	@Override
	public boolean isAvailable()
	{
		return true;
	}
}
class HuralikaiPalya extends Palya 
{
	public HuralikaiPalya()
	{

	}
	@Override
	public int getPrice()
	{
		return 90;
	}
	@Override
	public String getName()
	{
		return "HuralikaiPalya";
	}
	@Override
	public boolean isAvailable()
	{
		return true;
	}
}
class AlugaddePalya extends Palya 
{
	public AlugaddePalya()
	{

	}
	@Override
	public int getPrice()
	{
		return 60;
	}
	@Override
	public String getName()
	{
		return "AlugaddePalya";
	}
	@Override
	public boolean isAvailable()
	{
		return true;
	}
}