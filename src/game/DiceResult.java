package game;
/*
 * A compact OO-way of storing the eyes of the two dices. Is mainly a storage class, but also has some utility functions. 
 */
public class DiceResult
{
	private int[] dice;
	
	public DiceResult(int[] result){
		dice = result;
	}
	public int getDice(int n){
		
		try
		{
			return dice[n];
		}
		catch(IndexOutOfBoundsException e)
		{
			throw new IndexOutOfBoundsException("Could not reach the correct element(dice array):\n" + e.getMessage());
		}
	
		
	}
	public int getSum(){
		
		int sumOfDice = 0;
		
		for(int i=0; i < dice.length; i++){
			sumOfDice += dice[i];
		}
		
		return sumOfDice;
	}
}

