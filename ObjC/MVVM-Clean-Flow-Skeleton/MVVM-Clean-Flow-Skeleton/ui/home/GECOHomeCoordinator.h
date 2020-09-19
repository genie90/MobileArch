//
//  GECOHomeCoordinator.h
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 17/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "GECOCoordinator.h"
#import "GECOHomeCoordinatorDelegate.h"

NS_ASSUME_NONNULL_BEGIN

@interface GECOHomeCoordinator : NSObject<GECOCoordinator>

@property (weak, nonatomic) id<GECOHomeCoordinatorDelegate> delegate;

@end

NS_ASSUME_NONNULL_END
