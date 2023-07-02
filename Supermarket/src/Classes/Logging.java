package Classes;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
/**
 * @apiNote класс Обертка для логирования
 */
public class Logging {
    public Logger logger;
    private FileHandler info;
    private SimpleFormatter sFormat;

    public Logging(String myClassName,String fileName) throws SecurityException, IOException {
        this.logger = Logger.getLogger(myClassName);
        this.info = new FileHandler(fileName);
        info.setEncoding("UTF-8");
        logger.addHandler(info);
        sFormat = new SimpleFormatter();
        info.setFormatter(sFormat);
    }

/**
 * @apiNote Добавляем в лог файл сообщение из переменной text
 * @param text
 */
    public void setInfoLog(String text)
    {
        logger.info(text);
    }

}
