package com.davikingcode.TalkBackUnity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;

import com.unity3d.player.UnityPlayerActivity;

public class TalkBack extends UnityPlayerActivity {
	
	static AccessibilityManager am;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		
		am = (AccessibilityManager)getSystemService(ACCESSIBILITY_SERVICE);
		
		View myView = findViewById(android.R.id.content);
		
		myView.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS);
		
		myView.setAccessibilityDelegate(new AccessibilityDelegate () {
			
			@Override
			public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
				super.onInitializeAccessibilityNodeInfo(host, info);
			}
			
		    @Override
		    public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
		        super.onPopulateAccessibilityEvent(host, event);

		        if (event.getEventType() == AccessibilityEvent.TYPE_TOUCH_INTERACTION_START || event.getEventType() == AccessibilityEvent.TYPE_GESTURE_DETECTION_START) {
		        	Log.d("TalkBack", "TYPE_TOUCH_INTERACTION_START");
		            event.setContentDescription("test");
		        }
		    }
		});
		
		Log.d("TalkBack", "here");
	}
	
	static public boolean _IsEnabled() {
		
		if (am.isEnabled())
			return am.isTouchExplorationEnabled();
		
		return false;
	}

}
