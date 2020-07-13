//
//  AppCoordinator.h
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 13/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import "GECoordinator.h"
#import <UIKit/UIKit.h>

@interface GEAppCoordinator : NSObject<GECoordinator>

@property (strong, nonatomic) NSMutableDictionary *childCoordinators;

- (instancetype)initWithNavigationController: (UINavigationController*) navigationController;

@end
