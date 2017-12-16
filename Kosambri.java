public abstract class Kosambri implements MenuItem
{
	public abstract int getPrice();
	public abstract String getName();
	public abstract boolean isAvailable();
}
class SoutekaiKosambri extends Kosambri 
{
	public SoutekaiKosambri()
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
		return "SoutekaiKosambri";
	}
	@Override
	public boolean isAvailable()
	{
		return true;
	}
}
class CarrotKosambri extends Kosambri 
{
	public CarrotKosambri()
	{

	}
	@Override
	public int getPrice()
	{
		return 120;
	}
	@Override
	public String getName()
	{
		return "CarrotKosambri";
	}
	@Override
	public boolean isAvailable()
	{
		return true;
	}
}