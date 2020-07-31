import java.util.Random;

public class Gambler {
	//Constants
	private final int STAKE_PER_DAY = 100;
	private final int BETTING_AMOUNT = 1;
	private final int MAX_WINNING_AMOUNT = 150;
	private final int MIN_LOSING_AMOUNT = 50;
	private final int PLAYING_DAYS=20;
	

	//Calculating proft & loss after 20 Days
	public void gamblingSimulation() {
		int day;
		int dailyProfit=0;
		int dailyLoss=0;		
		
		for(day = 0;day <= PLAYING_DAYS; day++) {
			int stakeAmount = STAKE_PER_DAY;
			while (stakeAmount > MIN_LOSING_AMOUNT && stakeAmount < MAX_WINNING_AMOUNT)
			{
				Random rand=new Random();
				int num=rand.nextInt(2);
				if (num == 1)
				{
					stakeAmount = stakeAmount + BETTING_AMOUNT;
				}
				else
				{
					stakeAmount = stakeAmount - BETTING_AMOUNT;
				}
			}
			System.out.println("You Has Reached to Your daily limit for Win/Loss: Your Amount =: "+stakeAmount);
			if (stakeAmount > STAKE_PER_DAY)
			{
				dailyProfit = dailyProfit + 50 ;
			}
			else
			{
				dailyLoss = dailyLoss + 50 ;
			}
		}
		System.out.println("At Day "+day+" Profit=: "+dailyProfit);
		System.out.println("At Day "+day+" Loss=: "+dailyLoss);
	}

	public static void main(String[] args) {
		Gambler a = new Gambler ();
		a.gamblingSimulation();

	}

}
