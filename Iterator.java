import java.util.ArrayList;
class Iterator
{
	//OrderUndertaker out;
	Iterator()
	{
		//out = new OrderUndertaker();
	}

	void Iterate(ArrayList<MenuItem> order)
	{
		for(MenuItem item:order)
		{
			System.out.println(item.getName()+"------------------>"+item.getPrice());
			ArrayList<String> decorators = OrderUndertaker.getDecorators(item);
			if(decorators!=null && !decorators.isEmpty())
				System.out.println(decorators);
			else
				System.out.println("No decorators");
		}
	}
}

class IterateBasedOnItem extends Iterator
{	
	private ArrayList<MenuItem> palyas = new ArrayList<>();
	private ArrayList<MenuItem> kosambris = new ArrayList<>();
	//private ArrayList<MenuItem> palya = new ArrayList<>();

	IterateBasedOnItem()
	{
		super();
	}

	@Override
	void Iterate(ArrayList<MenuItem> order)
	{	
		String itemType;

		for(MenuItem item:order)
		{	
			itemType = item.getClass().getName();
			System.out.println("------------------"+itemType+"------------------");
			if(itemType.equals("BadnekaiPalya") || itemType.equals("AlugaddePalya") || itemType.equals("HuralikaiPalya"))
			{
				palyas.add(item);
			}
			else
			{
				if(itemType.equals("SoutekaiKosambri") || itemType.equals("CarrotKosambri"))
				{
					kosambris.add(item);
				}
			}
		}

		System.out.println("All Palya items");
		super.Iterate(palyas);

		System.out.println("All Kosambri items");
		super.Iterate(kosambris);

	}
}

class IterateBasedOnNames extends Iterator
{
	SortWithNames sort;
	IterateBasedOnNames()
	{
		super();
		sort = new SortWithNames();
	}

	@Override
	void Iterate(ArrayList<MenuItem> order)
	{
		sort.sort(order);
		super.Iterate(order);
	}
}

class IterateBasedOnPrices extends Iterator
{
	SortWithPrices sort;
	IterateBasedOnPrices()
	{
		super();
		sort = new SortWithPrices();
	}

	@Override
	void Iterate(ArrayList<MenuItem> order)
	{
		System.out.println("BASED ON PRICES:...........");
		sort.sort(order);
		super.Iterate(order);
	}
}