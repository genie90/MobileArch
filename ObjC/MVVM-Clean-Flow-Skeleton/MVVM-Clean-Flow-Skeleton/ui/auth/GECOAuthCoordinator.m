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

@property (strong, nonatomic) GEUIAULoginViewController *loginViewController;

@end

@implementation GECOAuthCoordinator

- (instancetype)init
{
    self = [super init];
    if (self) {
        [self showLogin];
    }
    return self;
}

- (id)getRootViewController {
    return self.loginViewController;
}


- (void)showLogin{
    self.loginViewController = [[GEUIAULoginViewController alloc] initWithNibName:@"GEUIAULoginViewController" bundle:nil];
    self.loginViewController.delegate = self;
    GEDMUCAuthUseCase *useCase = [GEDMUCUseCaseProvider makeAuthUseCase];
    useCase.authNetwork = [GEDANWAuthNetworkFactory getAuthNetwork:GENetworkTypeAPI];
    [self.loginViewController setLoginUseCase:useCase];
}

- (void)showRegister{
    GEUIAURegisterViewController *registerViewController = [[GEUIAURegisterViewController alloc] initWithNibName:@"GEUIAURegisterViewController" bundle:nil];
    [self.loginViewController showViewController:registerViewController sender:self.loginViewController];
}

- (void)loginDidSuccess {
    NSLog(@"GENIE success");
    [self.delegate didAuthen];
    return;
}

- (void)registerDidClick {
    [self showRegister];
}

@end
