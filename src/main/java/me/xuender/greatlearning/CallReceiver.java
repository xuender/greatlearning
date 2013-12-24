/**
 * 
 */
package me.xuender.greatlearning;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.MediaController.MediaPlayerControl;

/**
 * 来电监听
 * 
 * @author ender
 * 
 */
public class CallReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		TelephonyManager tm = (TelephonyManager) context
				.getSystemService(Service.TELEPHONY_SERVICE);
		MediaPlayerControl mediaPlayerControl = MainActivity.getInstance();
		switch (tm.getCallState()) {
		case TelephonyManager.CALL_STATE_RINGING:
			mediaPlayerControl.pause();
			break;
		case TelephonyManager.CALL_STATE_IDLE:
			if (mediaPlayerControl.isPlaying()) {
				mediaPlayerControl.start();
			}
		}
	}
}
