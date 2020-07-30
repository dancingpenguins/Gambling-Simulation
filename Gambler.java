import java.util.Random;

public class Gambler {
	//Constants
	private final int STAKE_PER_DAY = 100;
	private final int BETTING_AMOUNT = 1;
	private final int MAX_WINNING_AMOUNT = 150;
	private final int MIN_LOSING_AMOUNT = 50;
	
	/*Restriction for player if he reaches Max.Winning amount i.e 150 or he reaches Max. losing amount i.e 50 then stop playing & 	terminates the program*/
	public void gamblingSimulation() {
		int stakeAmount = STAKE_PER_DAY;
		
		while (stakeAmount >= MIN_LOSING_AMOUNT && stakeAmount <= MAX_WINNING_AMOUNT)
		{
			Random rand=new Random();
			int num=rand.nextInt(2);
			if (num == 1)
			{
				stakeAmount=stakeAmount+BETTING_AMOUNT;
			}
			else
			{
				stakeAmount=stakeAmount-BETTING_AMOUNT;
			}
		}
		System.out.println("You Has Reached to Your Max Win/Loss: Your Amount =: "+stakeAmount);
	}

	public static void main(String[] args) {
		//Calling a method via Constructor
		Gambler a = new Gambler();
		a.gamblingSimulation();

	}

}
