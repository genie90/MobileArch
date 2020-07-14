//
//  GEAuthCoordinator.m
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 13/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "AUGEAuthCoordinator.h"
#import "UseCaseProvider.h"

@interface AUGEAuthCoordinator()

@property (strong, nonatomic) UINavigationController *mainNaviController;

@property UseCaseProvider* useCaseProvider;

@end

@implementation AUGEAuthCoordinator

- (instancetype)initWithNavigationController:(UINavigationController*)naviController
{
    self = [super init];
    if (self) {
        self.mainNaviController = naviController;
        self.useCaseProvider = [[UseCaseProvider alloc] init];
    }
    return self;
}

- (void)start {
    [self showLogin];
}

- (void)showLogin{
    AUGELoginViewController *loginViewController = [[AUGELoginViewController alloc] initWithNibName:@"AUGELoginViewController" bundle:nil];
    loginViewController.delegate = self;
    [loginViewController setLoginUseCase:[self.useCaseProvider makeAuthUseCaseWithAPI]];
    
    [self.mainNaviController showViewController:loginViewController sender:self.mainNaviController];
}

- (void)showRegister{
    AUGERegisterViewController *registerViewController = [[AUGERegisterViewController alloc] initWithNibName:@"AUGERegisterViewController" bundle:nil];
    [self.mainNaviController showViewController:registerViewController sender:self.mainNaviController];
}

- (void)loginDidSuccess {
    return;
}

- (void)registerDidClick {
    [self showRegister];
}

@end
