import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GumballMachineTest.
 *
 * Sagar Mane
 */
public class GumballMachineTest
{
    private GumballMachine gumballM1;

    /**
     * Default constructor for test class GumballMachineTest
     */
    public GumballMachineTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        gumballM1 = new GumballMachine(5);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void NoCoins()
    {
        System.out.println("-----Test with no coins-----");
        gumballM1.turnCrank();
        assertEquals(false, gumballM1.isGumballInSlot());
    }

    @Test
    public void MachineOutOfGumballs()
    {
        System.out.println("-----MachineOutOfGumballs-----");
        for(int i=1;i<=11;i++)
        {
          gumballM1.insertQuarter();
          gumballM1.insertQuarter();
          gumballM1.turnCrank();
          gumballM1.takeGumballFromSlot();
        }
        assertEquals(0,gumballM1.getCount());
        
    }

    @Test
    public void NotEnoughMoney()
    {
        System.out.println("-----NotEnoughMoney and Turn Crank-----");
        gumballM1.insertQuarter();
        gumballM1.insertDime();
        gumballM1.turnCrank();
        assertEquals(false, gumballM1.isGumballInSlot());
    }
    @Test
    public void TakingTwoGumballs()
    {
        System.out.println("-----Taking two gumballs-----");
        gumballM1.insertQuarter();
        gumballM1.insertQuarter();
        gumballM1.turnCrank();
        gumballM1.insertQuarter();
        gumballM1.insertQuarter();
        gumballM1.turnCrank();
        assertEquals(true, gumballM1.isGumballInSlot());
        gumballM1.takeGumballFromSlot();
        assertEquals(false, gumballM1.isGumballInSlot());
    }
    @Test
    public void MoneyGreaterThanFiftyCents()
    {
        System.out.println("-----Money more than fifty cents-----");
          gumballM1.insertQuarter();
          gumballM1.insertQuarter();
          gumballM1.insertQuarter();
          gumballM1.turnCrank();
          assertEquals(true, gumballM1.isGumballInSlot());
          gumballM1.takeGumballFromSlot();
          assertEquals(false, gumballM1.isGumballInSlot());
    }
    @Test
    public void ReleaseballWithoutcoins()
    {
        System.out.println("-----ReleaseWithoutcoins-----");
        gumballM1.releaseBall();
        assertEquals(false, gumballM1.isGumballInSlot());
    }
    
}



