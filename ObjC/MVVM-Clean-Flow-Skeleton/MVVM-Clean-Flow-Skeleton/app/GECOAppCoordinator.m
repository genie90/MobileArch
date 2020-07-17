//
//  AppCoordinator.m
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 13/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "GECOAppCoordinator.h"
#import "GECOAuthCoordinator.h"

@interface GECOAppCoordinator()

@property UINavigationController *mainNavigationController;

@end

#import "GEUIAULoginViewController.h"
#import "GEUIAURegisterViewController.h"
#import "GEDMUCUseCaseProvider.h"
#import "GEDANWAuthNetworkFactory.h"

@implementation GECOAppCoordinator

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
//        [self showAuthFlow];
        [self showDashboard];
    }
}

- (void)showDashboard{
    NSMutableArray *tabItems = [[NSMutableArray alloc] initWithCapacity:2];


    UITabBarController *tabBarController = [[UITabBarController alloc] init];
    [tabBarController setViewControllers:tabItems];

    [self.mainNavigationController showViewController:tabBarController sender:self.mainNavigationController];
    
    UIViewController *term1 = [[UIViewController alloc] init];
    [tabItems addObject:term1];



    GEUIAURegisterViewController *registerViewController = [[GEUIAURegisterViewController alloc] initWithNibName:@"GEUIAURegisterViewController" bundle:nil];
    [registerViewController setTabBarItem:[[UITabBarItem alloc] initWithTitle:@"Profile" image:nil tag:1]];
    [tabItems addObject:registerViewController];
    
    [tabBarController setViewControllers:tabItems];
    
    GEUIAULoginViewController *loginViewController = [[GEUIAULoginViewController alloc] initWithNibName:@"GEUIAULoginViewController" bundle:nil];
    GEDMUCAuthUseCase *useCase = [GEDMUCUseCaseProvider makeAuthUseCase];
    useCase.authNetwork = [GEDANWAuthNetworkFactory getAuthNetwork:GENetworkTypeAPI];
    [loginViewController setLoginUseCase:useCase];
    [loginViewController setTabBarItem:[[UITabBarItem alloc] initWithTitle:@"Home" image:nil tag:0]];
    
     [tabItems addObject:loginViewController];

    [tabBarController setViewControllers:tabItems];
    

}

- (void)showAuthFlow{
    
    GECOAuthCoordinator *authCoordinator = [[GECOAuthCoordinator alloc] initWithNavigationController:self.mainNavigationController];
    [authCoordinator start];
    
    [self.childCoordinators setObject:authCoordinator forKey:NSStringFromClass(GECOAuthCoordinator.class)];
}

@end
