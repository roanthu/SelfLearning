package sort;

import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Logger;

public class DataGenerator {
    private static Logger logger = Logger.getLogger("DataGenerator");
    public static Random random = new SecureRandom();

    public static int[] genRandomIntArray(int size){
        int[] ret = new int[size];
        for(int i = 0; i < size; i++) {
            ret[i] = random.nextInt(100);
        }
        return ret;
    }

    public static void logArrayInt(int[] array){
        StringBuilder stringBuilder = new StringBuilder();
        for(int a : array){
            stringBuilder.append(a).append(";");
        }
        logger.info(stringBuilder.toString());
    }
}
