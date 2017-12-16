import java.util.Scanner;
import java.util.ArrayList;
interface MenuItem
{
	public int getPrice();
	public String getName();
	public boolean isAvailable();
}
class MealBuilder
{
	ArrayList<MenuItem> palyaItems=new ArrayList<>();
	ArrayList<MenuItem> kosambriItems=new ArrayList<>();	
	String[] items={"Palya","Kosambri"};
	MealBuilder()
	{
		palyaItems.add(new BadnekaiPalya());
		palyaItems.add(new AlugaddePalya());
		palyaItems.add(new HuralikaiPalya());
		kosambriItems.add(new SoutekaiKosambri());
		kosambriItems.add(new CarrotKosambri());
	}
	ArrayList<MenuItem> returnPalyaItems()
	{
		return palyaItems;
	}
	ArrayList<MenuItem> returnKosambriItems()
	{
		return kosambriItems;
	}
	String[] getItems()
	{
		return items;
	}
	ArrayList<MenuItem> fetchTypesOfItems(String choice)
	{
		switch(choice)
		{
			case "Palya":
				return palyaItems;
			case "Kosambri":
				return kosambriItems;
			default:
				return palyaItems;
		}
	}

}
class OrderUndertaker
{
	ArrayList<MenuItem> ordered=new ArrayList<>();
	ArrayList<ArrayList<MenuItem>> menu=new ArrayList<>();
	MealBuilder mb;
	Iterator iterator;
	static Decorator decorator;
	OrderUndertaker()
	{
		mb=new MealBuilder();
	}
	String[] getItems()
	{	
		return mb.getItems();
	}
	ArrayList<MenuItem> fetchTypesOfItems(String choice)
	{

		return mb.fetchTypesOfItems(choice); 
	}
	void addItem(MenuItem m)
	{
		ordered.add(m);
	}

	private MenuItem getItemAt(int index)
	{
		return ordered.get(index);
	}

	String getNameOfItemAt(int index)
	{
		return getItemAt(index).getName();
	}

	void iterate(int choice)
	{
		switch(choice)
		{
			case 1:
				iterator = new Iterator();
				break;
			case 2:
				iterator = new IterateBasedOnItem();
				break;
			case 3:
				iterator = new IterateBasedOnNames();
				break;
			case 4:
				iterator = new IterateBasedOnPrices();
				break;
			default:
				iterator = new Iterator();
				break;
		}

		iterator.Iterate(ordered);
	}

	void decorate(int choiceOfItem, ArrayList<Integer> choices)
	{	
		//System.out.println("Decorated with something");
		MenuItem obj = getItemAt(choiceOfItem);
		System.out.println(obj.getName());
		if(decorator==null)
			decorator = new Decorator();
		decorator.Decorate(obj,choices);
		//getDecorators(obj);
	}

	static ArrayList<String> getDecorators(MenuItem obj)
	{	
		if(decorator != null)
		{
			return decorator.getDecorators(obj);
		}
		else
			return null;
	}
}
public class BaleEleOota
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		OrderUndertaker biller=new OrderUndertaker();	
		System.out.println();
		System.out.println("Welcome To BaleEleOota.Today's Items:");
		System.out.println();
		String[] todaysitems=biller.getItems();

		boolean checkingOut=true;
		do
		{
			
			System.out.println("\n1.Add items\n2.Checkout Bill\n3.Decorate items\n4.Order Done!");
			int chForCheckingOut=in.nextInt();
			switch(chForCheckingOut)
			{
				case 1:
					for(int i=0;i<todaysitems.length;i++)
					{
						System.out.println((i+1)+")"+todaysitems[i]);
					}
					System.out.println("Enter choice");
					int chForItemsList=in.nextInt();
					ArrayList<MenuItem> li=biller.fetchTypesOfItems(todaysitems[chForItemsList-1]);
					System.out.println("\nItem\t\t\tPrice");
					for(int i=0;i<li.size();i++)
					{
						MenuItem mi=li.get(i);
						System.out.println((i+1)+":"+mi.getName()+"\t\t"+mi.getPrice());
					}
					System.out.println("\nchoose an option\n");
					int chForChoosingItem=in.nextInt();
					biller.addItem(li.get(chForChoosingItem-1));

					break;
				case 2:
					
					System.out.println("Iterator Choice:");
					System.out.println("1. Normal Iteration");
					System.out.println("2. Iterate Based on Items");
					System.out.println("3. Iterate by sorting based on names");
					System.out.println("4. Iterate by sorting based on prices");
					int choice = in.nextInt();
					biller.iterate(choice);

					//checkingOut=false;
					//add all your iterators here. Atleast three strategies if possible
					//decorator we have to do something.
					//also that admin class where we have set boolean isAvailable to false.
					//biller.displayOptions();
					break;

				case 3:
					System.out.println("Items you have ordered are:");
					biller.iterate(1);
					System.out.println("---------------------------------------------------------------------------------------------");
				
					System.out.print("Enter the number of the item that you want to decorate:");
					int choiceOfItem = in.nextInt();

					String nameOfItem = biller.getNameOfItemAt(choiceOfItem-1);
					
						System.out.println("Available Decorations:");
						System.out.println("");
						System.out.println("For "+nameOfItem+" :");
						ArrayList<Integer> choiceOfDecorator = new ArrayList<>();
						int ch;
					do
					{	
						if(choiceOfDecorator.size()>0)
							System.out.println("Add more to "+nameOfItem+" Or if not required press 4:");
						if(nameOfItem.equals("BadnekaiPalya") || nameOfItem.equals("HuralikaiPalya") || nameOfItem.equals("AlugaddePalya") || nameOfItem.equals("SoutekaiKosambri") || nameOfItem.equals("CarrotKosambri"))
						{
							System.out.println("1. Saasive");
							System.out.println("2. Karibevu");
							System.out.println("3. Arushina");
							System.out.println("4. Finish");
						}
						System.out.println("---------------------------------------------------------------------------------------------");
						System.out.println("Enter your choice:");
						ch = in.nextInt();
						
						if(ch>0 && ch<4)
						{
							choiceOfDecorator.add(ch);
						}

					}while(ch>0 && ch<4);
					

					biller.decorate(choiceOfItem-1 , choiceOfDecorator);

					//checkingOut=false;
					break;

				case 4:
					checkingOut = false;
					break;
			}
		}
		while(checkingOut);

	}
}