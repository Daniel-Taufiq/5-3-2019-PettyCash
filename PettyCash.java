public class PettyCash
{
	// put and take money out
	// mutable class
	private int balance;

	public PettyCash()
	{
		this.balance = 0;
	}

	// "synchronized" needs aadditional behavior to work
	public synchronized void add(int amount)
	{
		if(amount < 0)
		{
			throw new IllegalArgumentException(getClass().getName() +
				"add method: cannot have less than 0 " + amount);
		}

		this.balance = this.balance + amount;
		print("add  ", amount);
	}

	// "synchronized" needs aadditional behavior to work
	public synchronized void take(int amount)
	{
		if(amount < 0)
		{
			throw new IllegalArgumentException(getClass().getName() +
			"take method: cannot have less than 0 " + amount);
		}

		this.balance = this.balance - amount;
		print("take ", amount);
	}

	public synchronized void testAndTake(int amount)
	{// if asking for more than balance, don't take anything
		if(amount <= getBalance())	// change method in spender method for testAndTake, call it
		{
			take(amount);
		}
	}

	private void print(String action, int data)
	{
		if(getBalance() < 0)
		{
			System.out.println("Balance is negative: " + this.balance);
			throw new RuntimeException(getClass().getName() +
					"balance is negative " + data);
			//print("Balance is negative: " + this.balance);
		}
		else
		{
			System.out.println(action + ": " + data + " balance is " + getBalance());
			//print(action + ": " + amount + "balance is " + getBalance()));
		}
	}

	public synchronized int getBalance() { return this.balance; }

	//public static void main(String[] args)
	//{
	//	PettyCash cash;
	//	cash = new PettyCash();
	//	cash.add(10);
	//	cash.take(5);
	//}

}