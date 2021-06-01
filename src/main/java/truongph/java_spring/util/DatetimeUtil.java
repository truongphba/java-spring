package truongph.java_spring.util;

import java.text.SimpleDateFormat;

public class DatetimeUtil {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static String convertLongToString(long createdAt){
        return dateFormat.format(createdAt);
    }
}
