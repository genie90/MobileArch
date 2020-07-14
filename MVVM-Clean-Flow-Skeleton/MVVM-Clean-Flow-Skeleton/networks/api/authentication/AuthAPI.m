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


NSString *const AUTH_PATH = @"customers/login";

@interface AuthAPI()

@property ApiService* authApiService;


@end

@implementation AuthAPI

- (id)initWithApiService:(ApiService*) apiService
{
    self = [super init];
    if (self) {
        self.authApiService = apiService;
    }
    return self;
}

-(nonnull RACSignal<AuthApiModel*>*) doLoginWithParams:(nullable id)params {
    return [self.authApiService postItemAtPath:AUTH_PATH parameters:params headers:nil];
}

@end
