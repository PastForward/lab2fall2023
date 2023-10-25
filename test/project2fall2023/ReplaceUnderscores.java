package project2fall2023;

/**
 *  Mimics @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
 *  for junit 4 and replaces underscores in test method names with spaces
 * @author Aron Kabai-Tokes
 */
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;


public class ReplaceUnderscores extends BlockJUnit4ClassRunner {
    
    public ReplaceUnderscores(Class<?> klass) throws InitializationError {
        super(klass);
    }
    
    @Override
    protected String testName(FrameworkMethod method) {
        String methodName = method.getName();
        String displayName = methodName.replaceAll("_", " "); // Replace underscores with spaces
        return displayName;
    }

    @Override
    public void run(RunNotifier notifier) {
        super.run(notifier);
    }


}
