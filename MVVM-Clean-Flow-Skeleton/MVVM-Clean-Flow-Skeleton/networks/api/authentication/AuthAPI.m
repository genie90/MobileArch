//
//  UserNetwork.m
//  gobearmaterial
//
//  Created by Genie Truong on 9/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <ReactiveObjC/RACSignal.h>
#import "AuthAPI.h"

@interface AuthAPI()

@property ApiService* authApiService;


@end

@implementation AuthAPI

NSString *const AUTH_PATH = @"customers/login";

- (id)initWithApiService:(ApiService*) apiService
{
    self = [super init];
    if (self) {
        self.authApiService = apiService;
    }
    return self;
}

-(void) doLoginWithParams:(nullable id)params
                  success:(nullable void (^)(NSURLSessionDataTask *task, id _Nullable responseObject))success
                  failure:(nullable void (^)(NSURLSessionDataTask * _Nullable task, NSError *error))failure
{
    [self.authApiService postItemAtPath:AUTH_PATH parameters:params headers:nil success:success failure:failure];
}

@end
