//
//  UserNetwork.m
//  gobearmaterial
//
//  Created by Genie Truong on 9/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <ReactiveObjC/RACSignal.h>
#import "GEDANWAuthAPI.h"
#import "GEDANWApiService.h"

@interface GEDANWAuthAPI()

@property GEDANWApiService* authApiService;


@end

@implementation GEDANWAuthAPI

NSString *const AUTH_PATH = @"customers/login";

- (instancetype)init
{
    self = [super init];
    if (self) {
        self.authApiService = [[GEDANWApiService alloc] init];
    }
    return self;
}

-(void) doLoginWithParams:(nullable id)params
                  success:(nullable void (^)(NSURLSessionDataTask *task, id _Nullable responseObject))success
                  failure:(nullable void (^)(NSURLSessionDataTask * _Nullable task, NSError *error))failure
{
    [self.authApiService postItemAtPath:AUTH_PATH parameters:params headers:nil success:success failure:failure];
}

- (void)doRegisterWithParams:(nullable id)params success:(nullable void (^)(NSURLSessionDataTask *, id _Nullable))success failure:(nullable void (^)(NSURLSessionDataTask * _Nullable, NSError *))failure {
    
    // Do register with API here
    return;
}


@end
