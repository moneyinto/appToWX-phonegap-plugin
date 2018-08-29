var APPTOWXPlugin = function () {};

APPTOWXPlugin.prototype.errorCallback = function (msg) {
  console.log('giz Callback Error: ' + msg)
}

APPTOWXPlugin.prototype.callNative = function (name, args, successCallback, errorCallback) {
    if (errorCallback) {
        cordova.exec(successCallback, errorCallback, 'APPTOWXPlugin', name, args)
    } else {
        cordova.exec(successCallback, this.errorCallback, 'APPTOWXPlugin', name, args)
    }
}

APPTOWXPlugin.prototype.go = function (userName, path, successCallback, errorCallback) {
    this.callNative('go', [userName, path], successCallback, errorCallback);
}

if (!window.APPTOWXPlugin) {
  window.APPTOWXPlugin = new APPTOWXPlugin();
}

module.exports = new APPTOWXPlugin()
