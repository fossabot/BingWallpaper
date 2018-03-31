package me.liaoheng.wallpaper.util;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author liaoheng
 * @version 2016-09-20 11:28
 */
public interface Constants {

    String PROJECT_NAME = "BingWallpaper";

    String DISK_CACHE_DIR = "imgCache";
    String HTTP_CACHE_DIR = "httpCache";
    int IMAGE_DISK_CACHE_SIZE = 100 * 1024 * 1024; // 100MB
    int HTTP_DISK_CACHE_SIZE = 5 * 1024 * 1024;  // 5MB

    String BASE_URL = "https://www.bing.com";

    String CHINA_URL = "https://cn.bing.com/HPImageArchive.aspx?format=js&idx=%s&n=%s";
    String GLOBAL_URL = "https://global.bing.com/HPImageArchive.aspx?format=js&idx=%s&n=%s";

    /**
     * 0. both , 1. home , 2. lock
     */
    @IntDef(value = {
            EXTRA_SET_WALLPAPER_MODE_BOTH,
            EXTRA_SET_WALLPAPER_MODE_HOME,
            EXTRA_SET_WALLPAPER_MODE_LOCK,
    })
    @Retention(RetentionPolicy.SOURCE)
    @interface setWallpaperMode {}

    int EXTRA_SET_WALLPAPER_MODE_BOTH = 0;
    int EXTRA_SET_WALLPAPER_MODE_HOME = 1;
    int EXTRA_SET_WALLPAPER_MODE_LOCK = 1 << 1;

}
