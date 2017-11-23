package biaomingzhong.github.io.support;

import java.util.Locale;

/**
 * Created by quinlanzhong on 2017/11/23.
 */

public class XTextUtil {

    public static String format(String format, Object... value) {
        return String.format(Locale.getDefault(), format, value);
    }

}
