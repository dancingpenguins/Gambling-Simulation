import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Gambler {
	
	private final int STAKE_PER_DAY = 100;
	private final int BETTING_AMOUNT = 1;
	private final int MAX_WINNING_AMOUNT = 150;
	private final int MIN_LOSING_AMOUNT = 50;
	private final int PLAYING_DAYS = 30;
	
	List <Integer> dailyGambelingAmount = new ArrayList <Integer> ();
	List <Integer> winningBets = new ArrayList <Integer> ();
	List <Integer> lossingBets = new ArrayList <Integer> ();

	public void gamblingSimulation() {
		int day;
		int  dailyProfit = 0;
		int dailyLoss = 0;
		int winCounter = 0,lossCounter = 0;
		
		for(day = 1;day <= PLAYING_DAYS; day++) {
			int stakeAmount = STAKE_PER_DAY;
			while (stakeAmount > MIN_LOSING_AMOUNT && stakeAmount < MAX_WINNING_AMOUNT)
			{
				Random rand = new Random();
				int num = rand.nextInt(2);
				if (num == 1)
				{
					stakeAmount = stakeAmount + BETTING_AMOUNT;
					winCounter++;
				}
				else
				{
					stakeAmount = stakeAmount - BETTING_AMOUNT;
					lossCounter++;
				}				
			}
			winningBets.add(winCounter);
			//System.out.println("On day: "+day+" Winning Time: "+counterWin);
			winCounter = 0;
			lossingBets.add(lossCounter);
			//System.out.println("On day: "+day+" Lossing Time: "+counterLoss);
			lossCounter = 0;
			dailyGambelingAmount.add(stakeAmount - STAKE_PER_DAY);
			//System.out.println("You Has Reached to Your daily limit for Win/Loss: Your Amount =: "+stakeAmount);
			if (stakeAmount > STAKE_PER_DAY)
			{
				dailyProfit = dailyProfit + 50 ;
				//System.out.println("On day "+day+" Profit: "+daily_Profit);
			}
			else
			{
				dailyLoss = dailyLoss + 50 ;
				//System.out.println("On day "+day+" Loss: "+daily_Loss);
			}
		}
		System.out.println("Monthly Profit & Lost (DayWise) : "+dailyGambelingAmount);
		System.out.println("Winning Times"+winningBets);
		System.out.println("Lossing Times"+lossingBets);
	}
	
	public void luckiestDay() {
		int luckyDay = Collections.max(winningBets);
		int position = winningBets.indexOf(luckyDay);
		/*int localCounter1 = 0;
		int maxValue = 0;
		int position = 0;
		for (Integer result:Gamblers_winning_Luck)
		{
			if(maxValue < result)
			{
				maxValue = result;
				position = localCounter1;
			}
			localCounter1++;
		}*/	
		System.out.println("Luckiest Day for Gambler is Day: "+position);
	}
	
	public void unluckiestDay() {
		int unluckyDay = Collections.max(lossingBets);
		int position = lossingBets.indexOf(unluckyDay);
		
		/*int localCounter2 = 0;
		int maxValue = 0;
		int position = 0;
		for (Integer result:Gamblers_Lossing_Luck)
		{
			if(maxValue < result)
			{
				maxValue = result;
				position = localCounter2;
			}
			localCounter2++;
		}*/
		System.out.println("Unluckiest Day for Gambler is Day: "+position);		
		
	}

	public static void main(String[] args) {
		Gambler a = new Gambler ();
		a.gamblingSimulation();
		a.luckiestDay();
		a.unluckiestDay();

	}

}
