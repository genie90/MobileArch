//
//  AppCoordinator.m
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 13/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "GECOAppCoordinator.h"

@interface GECOAppCoordinator()<GECOAuthCoordinatorDelegate, GECOHomeCoordinatorDelegate>

@property UINavigationController *mainNavigationController;

@end

@implementation GECOAppCoordinator

- (instancetype)initWithNavigationController: (UINavigationController*) navigationController
{
    self = [super init];
    if (self) {
        self.mainNavigationController = navigationController;
        self.childCoordinators = [[NSMutableDictionary alloc] init];
        [self start];
    }
    return self;
}

- (void)start {
    bool isLogin = false;
    
    if (isLogin) {
        [self showDashboard];
    } else {
        [self showAuthFlow:[[GECOAuthCoordinator alloc] init]];
    }
}

- (void)showDashboard{
    NSMutableArray *tabItems = [[NSMutableArray alloc] initWithCapacity:2];

    GECOHomeCoordinator *homeCoor = [[GECOHomeCoordinator alloc] init];
    [tabItems addObject:[homeCoor getRootViewController]];
    homeCoor.delegate = self;
    
    GECOProfileCoordinator *profCoor = [[GECOProfileCoordinator alloc] init];
    [tabItems addObject:[profCoor getRootViewController]];

    UITabBarController *tabBarController = [[UITabBarController alloc] init];
    [tabBarController setViewControllers:tabItems];

    [self.mainNavigationController showViewController:tabBarController sender:self.mainNavigationController];
    
    [self.childCoordinators setObject:tabBarController forKey:@"Tab"]; // temp


}

- (void)showAuthFlow:(GECOAuthCoordinator*) authCoordinator{
    authCoordinator.delegate = self;
    UIViewController *authRoot = [authCoordinator getRootViewController];
    [self.mainNavigationController showViewController:authRoot sender:self.mainNavigationController];
    [self.childCoordinators setObject:authCoordinator forKey:NSStringFromClass(GECOAuthCoordinator.class)];
}

- (void)didAuthen {
    [self.childCoordinators removeObjectForKey:NSStringFromClass(GECOAuthCoordinator.class)];
    [self showDashboard];
}

- (void)openAuthFlow {
    [self showAuthFlow:[[GECOAuthCoordinator alloc] init]];
}

@end
