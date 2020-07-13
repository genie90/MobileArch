//
//  AppCoordinator.m
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 13/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "GEAppCoordinator.h"
#import "AUGEAuthCoordinator.h"

@interface GEAppCoordinator()

@property UINavigationController *mainNavigationController;

@end


@implementation GEAppCoordinator

- (instancetype)initWithNavigationController: (UINavigationController*) navigationController
{
    self = [super init];
    if (self) {
        self.mainNavigationController = navigationController;
        self.childCoordinators = [[NSMutableDictionary alloc] init];
    }
    return self;
}

- (void)start {
    bool isLogin = false;
    
    if (isLogin) {
        [self showDashboard];
    } else {
        [self showAuthFlow];
    }
}

- (void)showDashboard{
    return;
}

- (void)showAuthFlow{
    
    AUGEAuthCoordinator *authCoordinator = [[AUGEAuthCoordinator alloc] initWithNavigationController:self.mainNavigationController];
    [authCoordinator start];
    
    [self.childCoordinators setObject:authCoordinator forKey:NSStringFromClass(AUGEAuthCoordinator.class)];
}

@end
