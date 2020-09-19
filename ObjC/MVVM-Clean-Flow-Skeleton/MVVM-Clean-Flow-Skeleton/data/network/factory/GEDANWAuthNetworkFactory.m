//
//  AuthNetworkFactory.m
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 15/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import "GEDANWAuthNetworkFactory.h"
#import "GEDANWAuthAPI.h"
#import "GEDANWAuthFirebase.h"

@implementation GEDANWAuthNetworkFactory

+ (id<GEDANWAuthNetwork>)getAuthNetwork:(GENetworkType)networkType{
    switch (networkType) {
        case GENetworkTypeAPI:
            return [[GEDANWAuthAPI alloc] init];
            break;
        case GENetworkTypeFirebase:
            return [[GEDANWAuthFirebase alloc] init];
            break;
        default:
            return [[GEDANWAuthAPI alloc] init];
            break;
    }
}

@end
