package com.cngu.shades.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;

public class OrientationChangeReceiver extends BroadcastReceiver {

    private Context mContext;
    private OnOrientationChangeListener mListener;

    public OrientationChangeReceiver(Context context, OnOrientationChangeListener listener) {
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        if (listener == null) {
            throw new IllegalArgumentException("listener cannot be null");
        }

        mContext = context;
        mListener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_CONFIGURATION_CHANGED)) {
            Resources r = mContext.getResources();
            if(r.getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                mListener.onPortraitOrientation();
            }
            else {
                mListener.onLandscapeOrientation();
            }
        }
    }

    public interface OnOrientationChangeListener {
        void onPortraitOrientation();
        void onLandscapeOrientation();
    }
}