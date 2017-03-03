

public class GumballMachine implements IGumballMachine
{
 
	State soldOutState;
	State noMoneyState;
	State hasMoneyState;
	State soldState;
	
 
	State state = soldOutState;
	int count = 0;
	boolean slotAvailability=false;
    double totalMoney=0;    
    int slotCount=0;
	public GumballMachine(int numberGumballs) {
		soldOutState = new SoldOutState(this);
		noMoneyState = new NoMoneyState(this);
		hasMoneyState = new HasMoneyState(this);
		soldState = new SoldState(this);

		this.count = numberGumballs;
 		if (numberGumballs > 0) {
			state = noMoneyState;
		} 
	}
 
	public void insertQuarter() {
	    totalMoney = totalMoney + 0.25;
		state.insertMoney();
	}
 
	public void ejectQuarter() {
		state.ejectMoney();
	}
	public void insertNickle()
	{
	    totalMoney = totalMoney + 0.05;
	    state.insertMoney();
	}
	public void insertDime()
	{
	    totalMoney = totalMoney + 0.10;	    
	    state.insertMoney();
	}
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}
	public boolean isGumballInSlot()
	{
	    if(slotCount>=1)
	    {
	   return true;
	   }
	   return false;
	}
	public void takeGumballFromSlot()
	{   
	  if(slotCount>=1)
	    {
	    slotCount=0;
	   }        
	}  
	void setState(State state) {
		this.state = state;
	}
 
	void releaseBall() {
		
		
			count = count - 1;
			totalMoney = totalMoney-0.50;
			System.out.println("A gumball comes rolling out the slot...");
			System.out.println("Your total change is: " + totalMoney + " Please collect it.");
			totalMoney=0;
			takeGumballFromSlot();
			
	}
 
	int getCount() {
		return count;
	}
 
	void refill(int count) {
		this.count = count;
		state = noMoneyState;
	}

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoMoneyState() {
        return noMoneyState;
    }

    public State getHasQuarterState() {
        return hasMoneyState;
    }

    public State getSoldState() {
        return soldState;
    }
 
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}
}
