//
//  AuthNetworkFactory.h
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 15/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "GEDANWAuthNetwork.h"

NS_ASSUME_NONNULL_BEGIN

typedef NS_ENUM(NSUInteger, GENetworkType) {
    GENetworkTypeAPI,
    GENetworkTypeFirebase
};

@interface GEDANWAuthNetworkFactory : NSObject

+ (id<GEDANWAuthNetwork>)getAuthNetwork:(GENetworkType)networkType;

@end



NS_ASSUME_NONNULL_END
