import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.logging.Logger;


public class TestRunner {
    static final Logger logger = Logger.getLogger(TestRunner.class.getName());

    public static void main(String [] args){
        Result result = JUnitCore.runClasses(BuscaMinasTest.class);

        for (Failure failure : result.getFailures()){
            logger.warning (failure.toString());
        }
    }
}
