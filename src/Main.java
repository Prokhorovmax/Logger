import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Logger logger = new Logger("Log.txt");
        logger.deleteLog();
        logger.log("HELLO!", Level.NOTICE);

        int a = 14;
        int b = -10;
        int sum = a + b;

        logger.log("SUM WRITTEN TO C", Level.DEBUG);
        logger.log("a = " + a, Level.STATUS);
        logger.log("b = " + b, Level.STATUS);
        logger.log("sum = " + sum, Level.STATUS);
        logger.log("just a string without tag");
        logger.log("EVERYTHING IS OK", Level.NOTICE);
        logger.log("TIME TO END THIS", Level.WARNING);

        List<Level> list = new ArrayList<>();
        list.add(Level.DEBUG);
        list.add(Level.NOTICE);
        logger.filterLog("Filtered log.txt", list);

    }
}
