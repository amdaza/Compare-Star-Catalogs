package parser.logger;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class MyLogger {  
  
    private static FileHandler fileTxt;  
    private static SimpleFormatter formatterTxt;  
  
    static public void setUp() {  
        // Create Logger  
        Logger logger = Logger.getLogger("");  
        logger.setLevel(Level.INFO);  
        try {  
            fileTxt = new FileHandler("D:\\mylog.txt",true);  
        } catch (Exception ex) {  
            throw new RuntimeException("Error al inicializar el logger. "+ex.getLocalizedMessage());  
        }   
  
        // Create txt Formatter  
        formatterTxt = new SimpleFormatter();  
        fileTxt.setFormatter(formatterTxt);  
        logger.addHandler(fileTxt);  
  
    }  
  
}  