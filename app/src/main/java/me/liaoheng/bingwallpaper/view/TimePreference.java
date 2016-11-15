package me.liaoheng.bingwallpaper.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.DialogPreference;
import android.support.annotation.NonNull;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TimePicker;
import org.joda.time.LocalTime;

/**
 * 设置时间选择框
 * @author liaoheng
 * @version 2016-09-20 14:15
 */
public class TimePreference extends DialogPreference {
    private TimePicker picker;
    private LocalTime  localTime;

    public TimePreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPositiveButtonText(context.getString(android.R.string.ok));
        setNegativeButtonText(context.getString(android.R.string.cancel));
    }

    @Override protected View onCreateDialogView() {
        picker = new TimePicker(getContext());
        picker.setIs24HourView(DateFormat.is24HourFormat(getContext()));
        return (picker);
    }

    @Override protected void onBindDialogView(@NonNull View v) {
        super.onBindDialogView(v);
        picker.setCurrentHour(localTime.getHourOfDay());
        picker.setCurrentMinute(localTime.getMinuteOfHour());
    }

    @Override protected void onDialogClosed(boolean positiveResult) {
        super.onDialogClosed(positiveResult);

        if (positiveResult) {
            localTime = new LocalTime(picker.getCurrentHour(), picker.getCurrentMinute());

            String time = localTime.toString("HH:mm");

            if (callChangeListener(localTime.toString())) {
                persistString(localTime.toString());
            }
            setSummary(time);
        }
    }

    @Override protected Object onGetDefaultValue(TypedArray a, int index) {
        return a.getString(index);
    }

    @Override protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        if (restoreValue) {
            if (defaultValue == null) {
                localTime = LocalTime.parse(getPersistedString("00:00:00.000"));
            } else {
                localTime = LocalTime.parse(getPersistedString(defaultValue.toString()));
            }
        } else {
            localTime = LocalTime.parse(defaultValue.toString());
        }
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    @Override public CharSequence getSummary() {
        if (localTime==null){
            return "";
        }
        return localTime.toString("HH:mm");
    }
}
