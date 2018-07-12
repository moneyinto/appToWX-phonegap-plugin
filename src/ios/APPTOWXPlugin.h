#import <Cordova/CDVPlugin.h>
#import "WXApi.h"
#import "WXApiObject.h"

@interface APPTOWXPlugin : CDVPlugin<WXApiDelegate>

@property (nonatomic, strong) NSString *username;

@end