public class Spender implements Runnable
{
	private PettyCash pettyCash;

	public Spender(PettyCash pettyCash)
	{
		if(pettyCash == null)
		{
			throw new IllegalArgumentException(getClass().getName() +
				"constructor: pettyCash cannot reference a null object " + pettyCash);
		}
		this.pettyCash = pettyCash;
	}

	public void run()
	{
		boolean done;
		int amount;
		done = false;
		while(!done)
		{
			try
			{
				amount = this.pettyCash.getBalance();	// get balance sand store in local variable, then sleep for awhile because it might change while sleeping
				Thread.sleep(500);
				amount = (3 * amount) / 4;

				if(amount != 0)	// cant take out if money is equal than 0 amount
				{
					this.pettyCash.testAndTake(amount);
				}

			}
			catch(InterruptedException ie)
			{
				done = true;
			}
		}
	}
}