#import "APPTOWXPlugin.h"

@implementation APPTOWXPlugin

- (void)pluginInitialize
{
    [super pluginInitialize];
    NSString* appid = [[self.commandDelegate settings] objectForKey:@"appid"];
    [WXApi registerApp: appid];
}

- (void)go:(CDVInvokedUrlCommand*)command
{
    NSString* username = [[self.commandDelegate settings] objectForKey:@"username"];
    NSString *path = [command.arguments objectAtIndex:0];
    WXLaunchMiniProgramReq *launchMiniProgramReq = [WXLaunchMiniProgramReq object];
    launchMiniProgramReq.userName = username;  //拉起的小程序的username
    if (path != nil) {
        launchMiniProgramReq.path = path;    //拉起小程序页面的可带参路径，不填默认拉起小程序首页
    }
    launchMiniProgramReq.miniProgramType = WXMiniProgramTypeRelease; //拉起小程序的类型
    [WXApi sendReq:launchMiniProgramReq];
}

@end