//
//  GEAuthCoordinator.m
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 13/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "GECOAuthCoordinator.h"
#import "GEDMUCUseCaseProvider.h"
#import "GEDANWAuthNetworkFactory.h"

@interface GECOAuthCoordinator()

@property (strong, nonatomic) UINavigationController *mainNaviController;

@property (strong, nonatomic) UIViewController *rootViewController;


@property GEDMUCUseCaseProvider* useCaseProvider;

@end

@implementation GECOAuthCoordinator

- (instancetype)initWithNavigationController:(UINavigationController*)naviController
{
    self = [super init];
    if (self) {
        self.mainNaviController = naviController;
        self.useCaseProvider = [[GEDMUCUseCaseProvider alloc] init];
    }
    return self;
}

- (void)start {
    [self showLogin];
}

- (id)getRootViewController {
    return self.rootViewController;
}


- (void)showLogin{
    GEUIAULoginViewController *loginViewController = [[GEUIAULoginViewController alloc] initWithNibName:@"GEUIAULoginViewController" bundle:nil];
    loginViewController.delegate = self;
    GEDMUCAuthUseCase *useCase = [GEDMUCUseCaseProvider makeAuthUseCase];
    useCase.authNetwork = [GEDANWAuthNetworkFactory getAuthNetwork:GENetworkTypeAPI];
    [loginViewController setLoginUseCase:useCase];
    
    [self.mainNaviController showViewController:loginViewController sender:self.mainNaviController];
}

- (void)showRegister{
    GEUIAURegisterViewController *registerViewController = [[GEUIAURegisterViewController alloc] initWithNibName:@"GEUIAURegisterViewController" bundle:nil];
    [self.mainNaviController showViewController:registerViewController sender:self.mainNaviController];
}

- (void)loginDidSuccess {
    NSLog(@"GENIE success");
    return;
}

- (void)registerDidClick {
    [self showRegister];
}

@end
