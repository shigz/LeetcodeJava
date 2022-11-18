package shigz.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by 大史 on 2022/9/8
 */
public class BaseObject {

    private static final Logger logger = LoggerFactory.getLogger(BaseObject.class);
    private static final String DEFAULT_EMPTY = "";
    private static final String DEFAULT_SEPARATOR = ",";
    private static final String SEPARATOR_LINE_FEED = "\n";
    private static final String SEPARATOR_PATH = "/";
    private static final String DEFAULT_CHARSET = "UTF-8";

    protected static void debugLog(Object... contents) {
        logger.debug(joinValues(contents));
    }

    protected static void infoLog(Object... contents) {
        logger.info(joinValues(contents));
    }

    protected static void warnLog(Object... contents) {
        logger.warn(joinValues(contents));
    }

    protected static void errorLog(Object... contents) {
        logger.error(joinValues(contents));
    }

    protected static void errorLog(Throwable throwable, Object... contents) {
        logger.error(getErrorMsg(throwable, joinValues(contents)));
    }

    protected static String getErrorMsg(Throwable throwable, String msg) {
        if (throwable.getCause() != null) {
            return getErrorMsg(throwable.getCause(), joinValuesWith(SEPARATOR_LINE_FEED, msg, throwable));
        } else {
            return joinValuesWith(SEPARATOR_LINE_FEED, msg, throwable, mkString(throwable.getStackTrace()));
        }
    }

    protected static String mkString(Object[] values, String separator) {
        StringBuilder sb = new StringBuilder();
        for (Object value : values) {
            if (0 < sb.length()) {
                sb.append(separator);
            }
            if (null != value) {
                sb.append(value);
            }
        }
        return sb.toString();
    }

    protected static String mkString(int[] nums, String separator) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            if (0 < sb.length()) {
                sb.append(separator);
            }
            sb.append(num);
        }
        return sb.toString();
    }

    protected static String mkString(int[] nums) {
        return mkString(nums, DEFAULT_SEPARATOR);
    }

    protected static <T> String mkString(List<T> values, String separator) {
        StringBuilder sb = new StringBuilder();
        for (Object value : values) {
            if (0 < sb.length()) {
                sb.append(separator);
            }
            if (null != value) {
                sb.append(value);
            }
        }
        return sb.toString();
    }

    protected static <T> String mkString(List<T> values) {
        return mkString(values, DEFAULT_SEPARATOR);
    }

    protected static <T> String mkString(T[] values) {
        return mkString(values, DEFAULT_SEPARATOR);
    }

    protected static String joinValues(Object... contents) {
        StringBuilder sb = new StringBuilder();
        for (Object content : contents) {
            if (null != content) {
                sb.append(content);
            }
        }
        return sb.toString();
    }

    protected static String joinValuesWith(String separator, Object... values) {
        StringBuilder sb = new StringBuilder();
        for (Object content : values) {
            if (null != content) {
                if (0 < sb.length()) {
                    sb.append(separator);
                }
                sb.append(content);
            }
        }
        return sb.toString();
    }

}
