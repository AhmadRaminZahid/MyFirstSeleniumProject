package Utilities;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtils {

    private static Logger logger = LogManager.getLogger(LoggerUtils.class.getName());

    //    Create static methods for Logger
    public static void info(String message){
        logger.info(message);
    }

    public static void warn(String message){
        logger.warn(message);
    }

    public static void error(String message){
        logger.error(message);
    }

    public static void fatal(String message){
        logger.fatal(message);
    }

}
