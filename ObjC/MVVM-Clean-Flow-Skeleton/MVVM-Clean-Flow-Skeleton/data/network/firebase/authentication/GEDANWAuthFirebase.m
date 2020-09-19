//
//  FBGEAuthFirebase.m
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 14/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import "GEDANWAuthFirebase.h"
#import "GEDANWFirebaseService.h"

@implementation GEDANWAuthFirebase

GEDANWFirebaseService *_service;

- (instancetype)init
{
    self = [super init];
    if (self) {
        _service = [[GEDANWFirebaseService alloc] init];
    }
    return self;
}

- (void)doLoginWithParams:(nullable id)params success:(nullable void (^)(NSURLSessionDataTask *, id _Nullable))success failure:(nullable void (^)(NSURLSessionDataTask * _Nullable, NSError *))failure {
    
    //Firebase Login here
    return;
}

- (void)doRegisterWithParams:(nullable id)params success:(nullable void (^)(NSURLSessionDataTask *, id _Nullable))success failure:(nullable void (^)(NSURLSessionDataTask * _Nullable, NSError *))failure {
    
    // Firebase register here
    return;
}

@end
