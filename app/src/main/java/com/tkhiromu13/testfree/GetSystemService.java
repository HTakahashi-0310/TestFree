package com.tkhiromu13.testfree;

import android.app.Activity;
import android.content.Context;
import android.os.PowerManager;

public class GetSystemService extends Activity {

    PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
    public boolean isScreenOn = pm.isInteractive();

}

