package me.liaoheng.wallpaper.service;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.github.liaoheng.common.util.L;

import me.liaoheng.wallpaper.util.BingWallpaperUtils;
import me.liaoheng.wallpaper.util.LogDebugFileUtils;

/**
 * @author liaoheng
 * @version 2019-03-18 10:42
 */
public class BingWallpaperWorker extends Worker {
    private final String TAG = BingWallpaperWorker.class.getSimpleName();

    public BingWallpaperWorker(@NonNull Context appContext,
            @NonNull WorkerParameters workerParams) {
        super(appContext, workerParams);
    }

    @NonNull
    @Override
    public ListenableWorker.Result doWork() {
        L.alog().d(TAG, "action worker id : %s", getId());
        if (BingWallpaperUtils.isEnableLogProvider(getApplicationContext())) {
            LogDebugFileUtils.get()
                    .i(TAG, "action worker id : %s", getId());
        }
        BingWallpaperUtils.runningService(getApplicationContext(), TAG);
        return Result.success();
    }
}
