//
//  AppCoordinator.h
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 13/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import "GECOCoordinator.h"
#import <UIKit/UIKit.h>

@interface GECOAppCoordinator : NSObject<GECOCoordinator>

@property (strong, nonatomic) NSMutableDictionary *childCoordinators;

- (instancetype)initWithNavigationController: (UINavigationController*) navigationController;

@end
