import java.util.Random;

public class GamblingUC1 {
	int stakeAmount=100;
	int betAmount=1,i=1;
	int maxWinningAmount=200;
	
	public void gamblingSimulation() {
		while (i <= maxWinningAmount)
		{
			if (stakeAmount > 0 && stakeAmount<= maxWinningAmount)
			{
				Random rand=new Random();
				int num=rand.nextInt(2);
				if (num == 1)
				{
					stakeAmount=stakeAmount+betAmount;
				}
				else
				{
					stakeAmount=stakeAmount-betAmount;
				}
				
			}
			i++;
			System.out.println(stakeAmount);
			
		}

	}
	


	public static void main(String[] args) {
		GamblingUC1 a=new GamblingUC1();
		a.gamblingSimulation();

	}

}
