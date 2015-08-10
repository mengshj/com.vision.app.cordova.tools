//
//  CDVLogin.m
//  邻聚
//
//  Created by ZhouTong on 15/6/19.
//
//

#import "CDVLogin.h"

@implementation CDVLogin





-(void)login_ios:(CDVInvokedUrlCommand*)command
{
    NSLog(@"login_ios");
    
    
    
    NSDictionary* deviceProperties =[[NSDictionary alloc]initWithObjectsAndKeys:@"123" ,@"aaa", nil];
    
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:deviceProperties];
    
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}




@end
