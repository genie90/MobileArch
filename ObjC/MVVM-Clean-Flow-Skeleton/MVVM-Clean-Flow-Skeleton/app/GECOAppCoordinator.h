//
//  AppCoordinator.h
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 13/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "GECOAuthCoordinator.h"
#import "GECOHomeCoordinator.h"
#import "GECOProfileCoordinator.h"

@interface GECOAppCoordinator : NSObject

@property (strong, nonatomic) NSMutableDictionary *childCoordinators;

- (instancetype)initWithNavigationController: (UINavigationController*) navigationController;

- (void)showAuthFlow;
- (void)showDashboard;

@end
