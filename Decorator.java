import java.util.ArrayList;
import java.util.HashMap;

class Decorator
{
	//private ArrayList<String> decoratorsAdded = new ArrayList<>();
	private String [] pkdecorators = {"Saasive","Karibevu","Arushina"}; 
	private HashMap<MenuItem,ArrayList<Integer>> decoratorsAdded;

	Decorator()
	{
		decoratorsAdded = new HashMap<>();
	}

	public void Decorate(MenuItem obj , ArrayList<Integer> choices)
	{
		if(decoratorsAdded.containsKey(obj))
		{
			decoratorsAdded.get(obj).addAll(choices);
		}
		else{
			decoratorsAdded.put(obj,choices);
		}
		
		
		System.out.println(decoratorsAdded.get(obj));
	}

	public ArrayList<String> getDecorators(MenuItem obj)
	{
		ArrayList<String> str = new ArrayList<>();
		//decoratorsAdded.get(obj);
		if(decoratorsAdded.containsKey(obj))
		{	
			ArrayList<Integer> choices = decoratorsAdded.get(obj);
			for(Integer c:choices)
			{
				str.add(pkdecorators[c-1]);
			}
		}
		return str;
	}
}