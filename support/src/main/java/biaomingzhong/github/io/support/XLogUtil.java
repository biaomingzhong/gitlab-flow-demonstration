package biaomingzhong.github.io.support;

import java.util.Hashtable;
import android.util.Log;

/**
 * Created by quinlanzhong on 2017/11/23.
 */

public class XLogUtil {
    private final static String TAG = "[LogUtil]";
    private final static int LOG_LEVEL = Log.VERBOSE;

    private static boolean sLogFlag = false;
    private static Hashtable<String, Logger> sLoggerTable = new Hashtable<>();

    public static void setDebugMode(boolean logFlags) {
        sLogFlag = logFlags;
    }

    /**
     * @return
     */
    public static Logger log() {
        return log("");
    }

    /**
     */
    @SuppressWarnings("unused")
    private static Logger log(String className) {
        Logger classLogger = sLoggerTable.get(className);
        if (classLogger == null) {
            classLogger = new Logger(className);
            sLoggerTable.put(className, classLogger);
        }
        return classLogger;

    }


    public static class Logger {
        private String mClassName;
        private static XLogUtil log;

        private Logger(String name) {
            mClassName = name;

        }


        /**
         * Get The Current Function Name
         */
        private String getFunctionName() {
            StackTraceElement[] sts = Thread.currentThread().getStackTrace();
            if (sts == null) {
                return null;
            }
            for (StackTraceElement st : sts) {
                if (st.isNativeMethod()) {
                    continue;
                }
                if (st.getClassName().equals(Thread.class.getName())) {
                    continue;
                }
                if (st.getClassName().equals(this.getClass().getName())) {
                    continue;
                }
                return mClassName + "[ " + Thread.currentThread().getName() + ": "
                    + st.getFileName() + ":" + st.getLineNumber() + " "
                    + st.getMethodName() + " ]";
            }
            return null;
        }

        /**
         * The Log Level:i
         *
         * @param str
         */
        public void i(Object str) {
            if (sLogFlag) {
                if (LOG_LEVEL <= Log.INFO) {
                    String name = getFunctionName();
                    if (name != null) {
                        Log.i(TAG, name + " - " + str);
                    } else {
                        Log.i(TAG, str.toString());
                    }
                }
            }

        }

        /**
         * The Log Level:d
         *
         * @param str
         */
        public void d(Object str) {
            if (sLogFlag) {
                if (LOG_LEVEL <= Log.DEBUG) {
                    String name = getFunctionName();
                    if (name != null) {
                        Log.d(TAG, name + " - " + str);
                    } else {
                        Log.d(TAG, str.toString());
                    }
                }
            }
        }

        /**
         * The Log Level:d
         *
         * @param str
         */
        public void d(String tag, Object str) {
            if (sLogFlag) {
                if (LOG_LEVEL <= Log.DEBUG) {
                    String name = getFunctionName();
                    if (name != null) {
                        Log.d(tag, name + " - " + str);
                    } else {
                        Log.d(tag, str.toString());
                    }
                }
            }
        }

        /**
         * The Log Level:V
         *
         * @param str
         */
        public void v(Object str) {
            if (sLogFlag) {
                if (LOG_LEVEL <= Log.VERBOSE) {
                    String name = getFunctionName();
                    if (name != null) {
                        Log.v(TAG, name + " - " + str);
                    } else {
                        Log.v(TAG, str.toString());
                    }
                }
            }
        }

        /**
         * The Log Level:w
         *
         * @param str
         */
        public void w(Object str) {
            if (sLogFlag) {
                if (LOG_LEVEL <= Log.WARN) {
                    String name = getFunctionName();
                    if (name != null) {
                        Log.w(TAG, name + " - " + str);
                    } else {
                        Log.w(TAG, str.toString());
                    }
                }
            }
        }

        /**
         * The Log Level:e
         *
         * @param str
         */
        public void e(Object str) {
            if (sLogFlag) {
                if (LOG_LEVEL <= Log.ERROR) {
                    String name = getFunctionName();
                    if (name != null) {
                        Log.e(TAG, name + " - " + str);
                    } else {
                        Log.e(TAG, str.toString());
                    }
                }
            }
        }

        /**
         * The Log Level:e
         *
         * @param ex
         */
        public void e(Exception ex) {
            if (sLogFlag) {
                if (LOG_LEVEL <= Log.ERROR) {
                    Log.e(TAG, "error", ex);
                }
            }
        }

        public void e(Throwable e) {
            if (sLogFlag) {
                if (LOG_LEVEL <= Log.ERROR) {
                    Log.e(TAG, "error", e);
                }
            }
        }

        /**
         * The Log Level:e
         *
         * @param log
         * @param tr
         */
        public void e(String log, Throwable tr) {
            if (sLogFlag) {
                String line = getFunctionName();
                Log.e(TAG, "{Thread:" + Thread.currentThread().getName() + "}"
                    + "[" + mClassName + line + ":] " + log + "\n", tr);
            }
        }
    }


}
