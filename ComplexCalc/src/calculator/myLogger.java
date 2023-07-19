import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class myLogger {

    public Logger logger;
    private FileHandler info;
    private SimpleFormatter sFormat;

    public myLogger(String fileName) throws SecurityException, IOException{
        this.logger = Logger.getLogger("Calc");
        this.info = new FileHandler(fileName);
        info.setEncoding("UTF-8");
        logger.addHandler(info);
        sFormat = new SimpleFormatter();
        info.setFormatter(sFormat);
    }

    /**
     * @apiNote Добавляем в лог файл сообщение из переменной line
     * @param line
     */
     public void log(String line) {
        System.out.println(line);
         logger.info(line);
    }
}
