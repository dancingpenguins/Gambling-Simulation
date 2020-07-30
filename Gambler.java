import java.util.Random;

public class Gambler {
	
	private final int STAKE_PER_DAY = 100;
	private final int BETTING_AMOUNT = 1;
	private final int MAX_WINNING_AMOUNT = 150;
	private final int MIN_LOSING_AMOUNT = 50;
	private final int PLAYING_DAYS=20;

	
	public void gamblingSimulation() {
		int i;
		int stakeAmount = STAKE_PER_DAY;
		int  daily_Profit=0;
		int daily_Loss=0;
		for(i = 0;i <= PLAYING_DAYS; i++) {
			while (stakeAmount >= MIN_LOSING_AMOUNT && stakeAmount <= MAX_WINNING_AMOUNT)
			{
				Random rand=new Random();
				int num=rand.nextInt(2);
				if (num == 1)
				{
					stakeAmount = stakeAmount + BETTING_AMOUNT;
					daily_Profit = stakeAmount + daily_Profit;
				}
				else
				{
					stakeAmount=stakeAmount-BETTING_AMOUNT;
					daily_Loss = stakeAmount - daily_Loss;
				}
			}
			//System.out.println("You Has Reached to Your daily limit for Win/Loss: Your Amount =: "+stakeAmount);
		}
		System.out.println("At Day "+i+" Profit=: "+daily_Profit);
		System.out.println("At Day "+i+" Loss=: "+daily_Loss);
	}

	public static void main(String[] args) {
		Gambler a = new Gambler ();
		a.gamblingSimulation();

	}

}
