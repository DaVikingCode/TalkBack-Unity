using UnityEngine;
using System.Collections;

public class Test : MonoBehaviour {

	bool talkBackActivated = false;

	void Start () {

		talkBackActivated = TalkBack.Detect();

		InvokeRepeating("CheckTalkBack", 1, 1);
	}

	void CheckTalkBack() {

		Debug.Log ("ici");

		talkBackActivated = TalkBack.Detect();
	}
	
	void OnGUI() {

		GUI.Label(new Rect(10, Screen.height - 40, 500, 50), "TalkBack activated: " + talkBackActivated.ToString());

	}
}
