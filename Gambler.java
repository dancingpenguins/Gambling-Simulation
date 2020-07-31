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
	private final int PLAYING_DAYS=30;
	
	List <Integer> Gamblers_Monthly_Profit_Loss_Collection = new ArrayList <Integer> ();
	List <Integer> Gamblers_winning_Luck = new ArrayList <Integer> ();
	List <Integer> Gamblers_Lossing_Luck = new ArrayList <Integer> ();

	public void gamblingSimulation() {
		int day;
		int  daily_Profit = 0;
		int daily_Loss = 0;
		int counterWin = 0,counterLoss = 0;
		
		for(day = 1;day <= PLAYING_DAYS; day++) {
			int stakeAmount = STAKE_PER_DAY;
			while (stakeAmount >= MIN_LOSING_AMOUNT && stakeAmount <= MAX_WINNING_AMOUNT)
			{
				Random rand=new Random();
				int num=rand.nextInt(2);
				if (num == 1)
				{
					stakeAmount = stakeAmount + BETTING_AMOUNT;
					counterWin++;
				}
				else
				{
					stakeAmount = stakeAmount - BETTING_AMOUNT;
					counterLoss++;
				}				
			}
			Gamblers_winning_Luck.add(counterWin);
			//System.out.println("On day: "+day+" Winning Time: "+counterWin);
			counterWin=0;
			Gamblers_Lossing_Luck.add(counterLoss);
			//System.out.println("On day: "+day+" Lossing Time: "+counterLoss);
			counterLoss=0;
			Gamblers_Monthly_Profit_Loss_Collection.add(stakeAmount - STAKE_PER_DAY);
			//System.out.println("You Has Reached to Your daily limit for Win/Loss: Your Amount =: "+stakeAmount);
			if (stakeAmount > STAKE_PER_DAY)
			{
				daily_Profit = daily_Profit + 50 ;
				//System.out.println("On day "+day+" Profit: "+daily_Profit);
			}
			else
			{
				daily_Loss = daily_Loss + 50 ;
				//System.out.println("On day "+day+" Loss: "+daily_Loss);
			}
		}
		System.out.println("Monthly Profit & Lost (DayWise) : "+Gamblers_Monthly_Profit_Loss_Collection);
		System.out.println("Winning Times"+Gamblers_winning_Luck);
		System.out.println("Lossing Times"+Gamblers_Lossing_Luck);
	}
	
	public void luckiestDay() {
		int luckyDay = Collections.max(Gamblers_winning_Luck);
		int position = Gamblers_winning_Luck.indexOf(luckyDay);
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
		int unluckyDay = Collections.max(Gamblers_Lossing_Luck);
		int position = Gamblers_Lossing_Luck.indexOf(unluckyDay);
		
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
