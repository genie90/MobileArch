//
//  Network.m
//  gobearmaterial
//
//  Created by Genie Truong on 9/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "ApiService.h"
#import <ReactiveObjC/RACSignal.h>
#import <ReactiveObjC/ReactiveObjC.h>
#import <AFNetworking/AFNetworking-umbrella.h>

@interface ApiService()

@property NSString* endpoint;

@end

@implementation ApiService

-(instancetype) init
{
    self = [super init];
    if (self) {
        self.endpoint = @"";
    }
    return self;
}

- (void) postItemAtPath: (NSString*) path
             parameters:(nullable id)parameters
                headers:(nullable NSDictionary <NSString *, NSString *> *)headers
                success:(nullable void (^)(NSURLSessionDataTask *task, id _Nullable responseObject))success
                failure:(nullable void (^)(NSURLSessionDataTask * _Nullable task, NSError *error))failure

{
    NSString *URLString = [NSString stringWithFormat:@"%@/%@", self.endpoint, path];
    AFHTTPSessionManager *manager = [AFHTTPSessionManager manager];
    manager.requestSerializer = [AFJSONRequestSerializer serializer];
    manager.responseSerializer = [AFJSONResponseSerializer serializer];
    
    [manager POST:URLString parameters:parameters headers:headers progress:nil success:success failure:failure];
}

@end
