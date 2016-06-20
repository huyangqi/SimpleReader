package com.myzony.zonynovelreader.Common;

import android.app.Application;
import android.os.Build;
import android.util.Log;

import com.myzony.zonynovelreader.NovelCore.NovelCore;
import com.myzony.zonynovelreader.NovelCore.Plug_00ksw;
import com.myzony.zonynovelreader.R;
import com.myzony.zonynovelreader.bean.NovelInfo;

/**
 * Created by mo199 on 2016/5/27.
 */
public class AppContext extends Application {
    public static String TAG = "Novel";
    /**
     * 页面条目大小
     */
    public static int PAGE_SIZE = 10;
    private int currentTheme;

    /**
     * 返回当前的小说源对象
     * @return 小说源对象。
     */
    public static NovelCore getPlug() {
        return plug;
    }

    /**
     * 设置小说源。
     * @param plug 实例化的NovelCore子类。
     */
    public static void setPlug(NovelCore plug) {
        AppContext.plug = plug;
    }

    private static NovelCore plug;

    private static AppContext appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        setDefaultTheme();
        appContext = this;
        // 初始化小说源对象
        plug = new Plug_00ksw();
    }

    // 获得APPContext实例
    public static AppContext getInstance() {
        return appContext;
    }
    // 获得当前主题
    public int getCurrentTheme() {
        return currentTheme;
    }
    // 设置默认主题
    public void setDefaultTheme() {
        currentTheme = R.style.AppBaseTheme;
    }
    // 输出日志信息
    public static void log(String message) {
        Log.d(TAG, message);
    }

    public static boolean isMethodsCompat(int versionCode) {
        int currentVersion = Build.VERSION.SDK_INT;
        return currentVersion > versionCode;
    }
}