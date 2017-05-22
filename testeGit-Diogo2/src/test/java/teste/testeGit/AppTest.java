package teste.testeGit;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
	@author: Diogo
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testNeimi )
    {
        super( testNeimi );
    }

	public void qualquerCoisaTest(){
		assertTrue(true);
	}	
	
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
	
	public void testApp2()
    {
        assertTrue( 2==2 );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
	

}
