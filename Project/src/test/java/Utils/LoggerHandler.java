package Utils;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.LoggerFactory;

import Pages.Testcase3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;

public class LoggerHandler {

    static Logger logger = Logger.getLogger(LoggerHandler.class);
    static {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String currentTime = dateFormat.format(new Date());
        System.setProperty("currenttime", currentTime);
    }
    public static void main(String[] args) {
        initLog4j();
    }

    public static void initLog4j() {
        // Define the log file directory
        String logDirectory = "logs";

        // Check if the directory exists, and create it if not
        File directory = new File(logDirectory);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Log directory created: " + logDirectory);
            } else {
                System.err.println("Failed to create log directory: " + logDirectory);
            }
        }

        // Initialize Log4j
        PropertyConfigurator.configure("src/main/resources/log4j.properties");    
    }
}

