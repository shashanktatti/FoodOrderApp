import java.util.*;
interface BillSortStrategy
{
	public void sort(ArrayList<MenuItem> al);
}
class SortWithNames implements BillSortStrategy
{	
	public SortWithNames()
	{
		System.out.println("--------------Obj------------");
	}

	public void sort(ArrayList<MenuItem> al)
	{
		int n=al.size();
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				String s1=al.get(i).getName();
				String s2=al.get(j).getName();
				int k=s1.compareTo(s2);
				System.out.println("g or l or eq "+k);
				// switch(k)
				// {
				// 	case 0:
				// 		break;
				// 	case (<0):
				// 		break;
				// 	case (>0):
				// 		Collections.swap(al,i,j);
				// 		break;
				// 	default:
				// 		break;	
				// }
				if(k>0)
				{
					Collections.swap(al,i,j);
				}
			}
		}
		System.out.println(al);
	}
}
public class SortWithPrices implements BillSortStrategy
{
	public void sort(ArrayList<MenuItem> al)
	{
		int n=al.size();
		for(int i=0;i<n-1;i++)
		{
			int i1=al.get(i).getPrice();
			for(int j=i+1;j<n;j++)
			{
				int i2=al.get(j).getPrice();
				System.out.println(i1+"  ----------  "+i2);
				if(i1>i2)
				{
					Collections.swap(al,i,j);
				}
				else continue;
			}
		}
	}
}