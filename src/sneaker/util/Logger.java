package sneaker.util;

import java.util.logging.Level;

public class Logger {
    private java.util.logging.Logger logger;
    private Level level = Level.ALL;

    public Logger(String name, Level lv) {
        logger = java.util.logging.Logger.getLogger(name);
        level = lv;
        logger.setLevel(lv);
    }

    public void log(Object... text) {
        StringBuilder builder = new StringBuilder();
        String separator = "";
        for (Object t : text) {
            builder.append(separator);
            builder.append(t);
            separator = " ";
        }
        logger.log(level, builder.toString());
    }
}
