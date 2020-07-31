import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Gambler {
	
	private final int STAKE_PER_DAY = 100;
	private final int BETTING_AMOUNT = 1;
	private final int MAX_WINNING_AMOUNT = 150;
	private final int MIN_LOSING_AMOUNT = 50;
	private final int PLAYING_DAYS=30;
	int winningPercentage,loosingPercentage;
	List <Integer> Gamblers_Monthly_Profit_Loss_Collection = new ArrayList <Integer> ();
	
	public void gamblingSimulation() {
		int day;
		int  daily_Profit = 0, daily_Loss = 0;
		int counterWin = 0,counterLoss = 0,profitCounter = 0,lossCounter = 0;
		//Gambler play's for 30 days with daily limit of profit/loss=50%
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
			//System.out.println("On day: "+day+" Winning Time: "+counterWin);
			counterWin=0;
			//System.out.println("On day: "+day+" Lossing Time: "+counterLoss);
			counterLoss=0;
			Gamblers_Monthly_Profit_Loss_Collection.add(stakeAmount - STAKE_PER_DAY);
			//Calculating Daily Profit & Loss
			if (stakeAmount > STAKE_PER_DAY)
			{
				daily_Profit = daily_Profit + 50 ;
				profitCounter++;
				System.out.println("On day "+day+" Profit: "+daily_Profit);
			}
			else
			{
				daily_Loss = daily_Loss + 50 ;
				lossCounter++;
				System.out.println("On day "+day+" Loss: "+daily_Loss);
			}
			winningPercentage = profitCounter * 100 / PLAYING_DAYS;
			loosingPercentage = lossCounter * 100 / PLAYING_DAYS;
		}
		System.out.println("Monthly Profit & Lost (DayWise) : "+Gamblers_Monthly_Profit_Loss_Collection);
	}
	
	public void nextMonth() {
		
		if (winningPercentage > loosingPercentage)
		{
			Scanner sc = new Scanner (System.in);
			System.out.print("Wopuld you like to Continue ? \n If you want to play Press 1 / If you want to exit press 0 \n Enter Your Choice : ");
			int nextMonth = sc.nextInt();
			if (nextMonth == 1)
			{
				System.out.println("Welcome *** Let's Start Playing ");
			}
			else
			{
				System.out.println("Thank You For Playing *** Have a Good Day..! ");
			}
		}
		else
		{
			System.out.println("Thank You For Playing *** Have a Good Day..! ");
		}
	}
	
	public static void main(String[] args) {
		Gambler a = new Gambler ();
		a.gamblingSimulation();
		a.nextMonth();

	}

}
