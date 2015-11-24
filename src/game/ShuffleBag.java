package game;

import java.util.Random;

public class ShuffleBag<T> {
	T[] values;
	int currentPos;
	Random rng = new Random(System.currentTimeMillis());
	public ShuffleBag(T[] values)
	{
		this.values = values;
		Reset();
	}
	public int elementsLeft()
	{
		return currentPos;
	}
	public void Reset()
	{
		currentPos = values.length-1;
	}
	
	private void swapToEnd(int index)
	{
		T tmpValue = values[index];
		values[index] = values[currentPos];
		values[currentPos] = tmpValue;
		//Removed the used index out of scope. 
		--currentPos;
	}
	public T getNext() throws Exception
	{
		if(currentPos==-1)
		{
			throw new Exception("Shuffle bag has run out of free elements. If this is intended call reset before getting the next variable.");
		}
		//+1 due to the last index being exclusive
		int index = rng.nextInt(currentPos+1);
		T value = values[index];
		swapToEnd(index);
		return value;		
	}
	public static void main(String[] args) {
		ShuffleBag<Integer> bag = new ShuffleBag<Integer>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8 , 9, 9 ,9});
		try{
			while(true)
			{
				System.out.println(bag.getNext());
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
