package me.liaoheng.wallpaper.util;

import android.content.Context;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

import me.liaoheng.wallpaper.model.Config;

/**
 * @author liaoheng
 * @version 2018-12-24 11:11
 */
public interface IUIHelper {
    void setWallpaper(Context context, @Constants.setWallpaperMode int mode, @NotNull Config config, File wallpaper)
            throws IOException;

    void register(Context context, BottomViewListener listener);

    void unregister(Context context);
}
