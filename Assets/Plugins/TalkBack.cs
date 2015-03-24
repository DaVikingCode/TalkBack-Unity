using UnityEngine;
using System.Collections;
using System.Runtime.InteropServices;

public class TalkBack {

	#if UNITY_ANDROID
		static AndroidJavaClass androidClass;
	#endif

	static public bool Detect() {

		#if UNITY_ANDROID && !UNITY_EDITOR
			
			if (androidClass == null) {
				AndroidJNI.AttachCurrentThread();
				androidClass = new AndroidJavaClass("com.davikingcode.TalkBackUnity.TalkBack");
			}
			
			return androidClass.CallStatic<bool>("_Detect");

		#else
			return false;
		#endif
	}
}
