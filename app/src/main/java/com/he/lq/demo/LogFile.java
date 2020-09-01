package com.he.lq.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.util.Log;

import com.baidu.android.imsdk.upload.action.IMTrack;


public class LogFile {

    private static final String TAG = "LogFile";
    private static LogFile mInstance = null;
    private Context mContext;
    
    public static synchronized LogFile getInstance(Context context) {
        
        if (mInstance == null) {
            mInstance = new LogFile(context);
        }
        return mInstance;
    }
    
    public LogFile(Context context) {
        mContext = context;
    }
    
    public void writeByte(byte[] bdata) {
        FileOutputStream fos = null;
        try {
            fos = mContext.openFileOutput(fileName() + ".log", Context.MODE_APPEND);
            if (fos != null) {
                fos.write(bdata);
            }
        } catch (Exception e) {
            Log.e(TAG, "Exception ", e);
        } finally {
            try {
                if ( fos != null ) {
                    fos.close();
                }
            } catch (IOException e) {
                Log.e(TAG, "Exception ", e);
            }
        }
    }

    /**
     * 以小时为单位命名文件
     * @return
     */
    public static String fileName() {
        SimpleDateFormat formatter =  new    SimpleDateFormat    ("yyyyMMddHH");
        Date curDate    =   new    Date(System.currentTimeMillis());
        String    str    =    formatter.format(curDate);
        return str;
    }


}