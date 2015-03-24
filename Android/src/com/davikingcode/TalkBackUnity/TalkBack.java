package com.davikingcode.TalkBackUnity;

import android.os.Bundle;
import android.view.accessibility.AccessibilityManager;

import com.unity3d.player.UnityPlayerActivity;

public class TalkBack extends UnityPlayerActivity {
	
	static AccessibilityManager am;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		
		am = (AccessibilityManager)getSystemService(ACCESSIBILITY_SERVICE);
	}
	
	static public boolean _Detect() {
		
		if (am.isEnabled())
			return am.isTouchExplorationEnabled();
		
		return false;
	}

}
