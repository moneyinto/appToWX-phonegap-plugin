# appToWX-phonegap-plugin
App 跳转至微信启动小程序


### 安装插件命令
```
cordova plugin add https://github.com/moneyinto/appToWX-phonegap-plugin.git --variable APPID=APPID --variable USERNAME=USERNAME
```

***注意：这里的APPID不是小程序的APPID，而是微信开放平台的APPID！USERNAME就是小程序的原始ID，可以在登录小程序的平台找到！***


### 在安装插件前，我们需要做一些准备工作：

- 在开发平台创建移动移用（审核大概需要3-7天）

![](http://7sbq8w.com1.z0.glb.clouddn.com/O8R%29A7QXHB6C~3QWNVKFYGW.png)

- 关联小程序

![](http://7sbq8w.com1.z0.glb.clouddn.com/0VSMJ2K%60%7DU%294DRCGKMDWSRJ.png)

- 在移动应用可以看到查看，点击进去可以看到相关信息

![](http://7sbq8w.com1.z0.glb.clouddn.com/8N1ET0R%7B9%5DP%605@SGV_AM@BX.png)


### 通过下面代码完成APP跳转至微信小程序

```
APPTOWXPlugin.go('pages/index/index'); // 参数为小程序的路径
```

### 关于三个变量的说明，可以自己在插件的做相应的修改，没有写配置的地方

```
/** 
    Android
 */
// MINIPTOGRAM_TYPE_RELEASE 正式版

// MINIPROGRAM_TYPE_TEST 开发版

// MINIPROGRAM_TYPE_PREVIEW 体验版

/** 
    src/android/APPTOWXPlugin.java 
*/
req.miniprogramType = WXLaunchMiniProgram.Req.MINIPTOGRAM_TYPE_RELEASE;

/** 
    Ios 
*/
// WXMiniProgramTypeRelease 正式版

// WXMiniProgramTypeTest 开发版

// WXMiniProgramTypePreview 体验版

/** 
    src/ios/APPTOWXPlugin.m 
*/
launchMiniProgramReq.miniProgramType = WXMiniProgramTypeRelease;
```