import static org.junit.Assert.*;
import org.junit.Test;


public class TestFlik {
    @Test
    public void testFlik() {
        int a = 1;
        int b = 1;

        assertTrue(Flik.isSameNumber(a, b));

        int a2 = 1;
        int b2 =2 ;

        assertTrue(Flik.isSameNumber(a2, b2)== false);



    }


}
