package com.dd.lpb.utils;

import android.util.Log;
import com.dd.lpb.BuildConfig;

public final class L {

    public static String LOG_TAG = "com.dd.lpb";

    /**
     * <p><b>ERROR:</b> This level of logging should be used when something fatal has happened, i.e. something that
     * will have user-visible consequences and won't be recoverable without explicitly deleting some data, uninstalling
     * applications, wiping the data partitions or reflashing the entire phone (or worse). Issues that justify some
     * logging at the ERROR level are typically good candidates to be reported to a statistics-gathering server.</p>
     * <p/>
     * <p><b>This level is always logged.</b></p>
     */
    public static void e(String message, Throwable cause) {
        Log.e(LOG_TAG, "[" + message + "]", cause);
    }

    /**
     * @see #e(String, Throwable)
     */
    public static void e(String msg) {
        Throwable t = new Throwable();
        StackTraceElement[] elements = t.getStackTrace();

        String callerClassName = elements[1].getFileName();
        Log.e(LOG_TAG, "[" + callerClassName + "] " + msg);
    }

    /**
     * <p><b>WARNING:</b> This level of logging should used when something serious and unexpected happened, i.e.
     * something that will have user-visible consequences but is likely to be recoverable without data loss by
     * performing some explicit action, ranging from waiting or restarting an app all the way to re-downloading a
     * new version of an application or rebooting the device. Issues that justify some logging at the WARNING
     * level might also be considered for reporting to a statistics-gathering server.</p>
     * <p/>
     * <p><b>This level is always logged.</b></p>
     */
    public static void w(String message, Throwable cause) {
        Log.w(LOG_TAG, "[" + message + "]", cause);
    }

    /**
     * @see #w(String, Throwable)
     */
    public static void w(String msg) {
        Throwable t = new Throwable();
        StackTraceElement[] elements = t.getStackTrace();

        String callerClassName = elements[1].getFileName();
        Log.w(LOG_TAG, "[" + callerClassName + "] " + msg);
    }

    /**
     * <p><b>INFORMATIVE:</b> This level of logging should used be to note that something interesting to most
     * people happened, i.e. when a situation is detected that is likely to have widespread impact, though isn't
     * necessarily an error. Such a condition should only be logged by a module that reasonably believes that it
     * is the most authoritative in that domain (to avoid duplicate logging by non-authoritative components).</p>
     * <p/>
     * <p><b>This level is always logged.</b></p>
     */
    public static void i(String message, Throwable cause) {
        Log.i(LOG_TAG, "[" + message + "]", cause);
    }

    /**
     * @see #i(String, Throwable)
     */
    public static void i(String msg) {
        Throwable t = new Throwable();
        StackTraceElement[] elements = t.getStackTrace();

        String callerClassName = elements[1].getFileName();
        Log.i(LOG_TAG, "[" + callerClassName + "] " + msg);
    }

    /**
     * <p><b>DEBUG:</b> This level of logging should be used to further note what is happening on the device that
     * could be relevant to investigate and debug unexpected behaviors. You should log only what is needed to gather
     * enough information about what is going on about your component. If your debug logs are dominating the log then
     * you probably should be using verbose logging.</p>
     * <p/>
     * <p><b>This level is NOT logged in release build.</b></p>
     */
    public static void d(String msg, Throwable cause) {
        if (BuildConfig.DEBUG) {
            Log.d(LOG_TAG, msg, cause);
        }
    }

    /**
     * @see #d(String, Throwable)
     */
    public static void d(String msg) {
        if (BuildConfig.DEBUG) {
            Throwable t = new Throwable();
            StackTraceElement[] elements = t.getStackTrace();

            String callerClassName = elements[1].getFileName();
            Log.d(LOG_TAG, "[" + callerClassName + "] " + msg);
        }
    }

    /**
     * <p><b>VERBOSE:</b> This level of logging should be used for everything else.</p>
     * <p/>
     * <p><b>This level is NOT logged in release build.</b></p>
     */
    public static void v(String msg, Throwable cause) {
        if (BuildConfig.DEBUG) {
            Log.v(LOG_TAG, msg, cause);
        }
    }

    /**
     * @see #v(String, Throwable)
     */
    public static void v(String msg) {
        if (BuildConfig.DEBUG) {
            Throwable t = new Throwable();
            StackTraceElement[] elements = t.getStackTrace();

            String callerClassName = elements[1].getFileName();
            Log.v(LOG_TAG, "[" + callerClassName + "] " + msg);
        }
    }
}
