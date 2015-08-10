package com.vision.app.cordova.utils;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.vision.app.test.LoginActivity;
public class Appoperate extends CordovaPlugin {
    
    CordovaInterface cordovaContext = null;
	public static final String TAG = "Appoperate";

	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		Log.d(TAG, "initialize() - cordova: " + cordova);
		this.cordovaContext = cordova;
		super.initialize(cordova, webView);
	}

	@Override
	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {
		Log.d(TAG, "execute() - action: " + action);
		if (action.equals("desktop")) { // action=appoperate
			String message = args.getString(0);
			if (cordovaContext != null) {
				Log.d(TAG, "execute() - startHome() ");
				startHome(cordovaContext.getActivity());
			}
			this.sendMsg(message, callbackContext);
			return true;
		} else if(action.equals("goto")){
            String message = args.getString(0);
            Intent intent = new Intent(cordovaContext.getActivity(), LoginActivity.class);
            cordovaContext.getActivity().startActivity(intent);
            return false;
        } else {
			callbackContext.error("IS Action not appoperate");
			return false;
		}
	}

	private void startHome(Activity context) {
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_HOME);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
		context.startActivity(intent);
	}

	private void sendMsg(String message, CallbackContext callbackContext) {
		if (message != null && message.length() > 0) {
			callbackContext.success(message);
		} else {
			callbackContext.error("Expected one non-empty string argument.");
		}
	}

}