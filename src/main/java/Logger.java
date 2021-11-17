import java.util.logging.FileHandler;

public class Logger {
    private final static java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(Logger.class.getName());

    private static FileHandler logHandler;

    // set up writing to a log file (if not done already)
    private static void setupLog() {
        if(logHandler == null) {
            try {
                logHandler = new FileHandler("default.log", true);
                LOGGER.addHandler(logHandler);
            } catch (Exception e) {
                System.out.println("Exception thrown in Logger.");
                System.out.println(e.getMessage());
            }
        }
    }

    // output an error as severe
    public static void error(String message) {
        setupLog();
        LOGGER.severe(message);
    }

    // output an error of info
    public static void info(String message) {
        setupLog();
        LOGGER.info(message);
    }
}
