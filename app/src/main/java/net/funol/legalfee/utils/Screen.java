package net.funol.legalfee.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Window;

import java.lang.reflect.Field;

/**
 * @author Gordon
 * @since 2016/3/1
 * do(屏幕工具类)
 */
public class Screen {

    private Screen(){

    }

    public static DisplayMetrics getDisplayMetrics(Context context){
        return context.getResources().getDisplayMetrics();
    }

    /**
     * 获取屏幕像素密度
     * @param context 上下文
     * @return
     */
    public static float getDensity(Context context) {
        return getDisplayMetrics(context).density;
    }

    /**
     * 获取屏幕像素宽度
     * @return
     */
    public static int getWidthPixels(Context context) {
        return getDisplayMetrics(context).widthPixels;
    }

    /**
     * 获取屏幕像素高度
     * @return
     */
    public static int getHeightPixels(Context context) {
        return getDisplayMetrics(context).heightPixels;
    }

    /**
     * 利用反射获取系统状态栏高度
     * @param context 上下文
     * @return
     */
    public static int getStatusBarHeightByReflaction(Context context){
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, sbar = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            sbar = context.getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sbar;
    }

    /**
     * 获取屏幕的状态栏像素高度<p>
     * 有时获取不到,使用反射机制获取状态栏高度getStatusBarHeightByReflaction(context)
     * @param activity Activity
     * @return
     */
    public static int getStatusBarHeight(Activity activity){
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        return frame.top;
    }

    /**
     * 获取屏幕的标题栏像素高度
     * @param activity Activity
     * @return
     */
    public static int getTitleBarHeight(Activity activity){
        int contentTop = activity.getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
        //statusBarHeight是上面所求的状态栏的高度
        int titleBarHeight = contentTop - getStatusBarHeight(activity);
        return titleBarHeight;
    }

    /**
     * 获取屏幕内容部分像素高度
     * @param activity Activity
     * @return
     */
    public static int getContentHeight(Activity activity){
        return activity.getWindow().findViewById(Window.ID_ANDROID_CONTENT).getHeight();
    }
}
