//
//  AuthNetworkFactory.m
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 15/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import "AuthNetworkFactory.h"
#import "AuthAPI.h"
#import "FBGEAuthFirebase.h"

@implementation AuthNetworkFactory

+ (id<AuthNetwork>)getAuthNetwork:(GENetworkType)networkType{
    switch (networkType) {
        case GENetworkTypeAPI:
            return [[AuthAPI alloc] init];
            break;
        case GENetworkTypeFirebase:
            return [[FBGEAuthFirebase alloc] init];
            break;
        default:
            return [[AuthAPI alloc] init];
            break;
    }
}

@end
