package com.moneyinto.plugins;

import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import java.lang.reflect.Method;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import org.json.JSONException;

public class APPTOWXPlugin extends CordovaPlugin {
    private static APPTOWXPlugin instance;
    private Context mContext;

    public APPTOWXPlugin() {
        instance = this;
    }

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        mContext = cordova.getActivity().getApplicationContext();
    }

    @Override
    public boolean execute(final String action, final CordovaArgs args, final CallbackContext callbackContext) throws JSONException {
        cordova.getThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Method method = APPTOWXPlugin.class.getDeclaredMethod(action, CordovaArgs.class, CallbackContext.class);
                    method.invoke(APPTOWXPlugin.this, args, callbackContext);
                } catch (Exception e) {
                    
                }
            }
        });
        return true;
    }

    void go(CordovaArgs args, CallbackContext callbackContext) throws JSONException, PackageManager.NameNotFoundException {
        ApplicationInfo info = mContext.getPackageManager().getApplicationInfo(mContext.getPackageName(), PackageManager.GET_META_DATA);
        String appId = info.metaData.getString("APPID"); // 填应用AppId
        String userName = info.metaData.getString("USERNAME");
        IWXAPI api = WXAPIFactory.createWXAPI(mContext, appId);
        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        req.userName = userName; // 填小程序原始id
        req.path = args.getString(0); 
        req.miniprogramType = WXLaunchMiniProgram.Req.MINIPTOGRAM_TYPE_RELEASE;// 可选打开 开发版，体验版和正式版
        api.sendReq(req);
        callbackContext.success();
    }
}