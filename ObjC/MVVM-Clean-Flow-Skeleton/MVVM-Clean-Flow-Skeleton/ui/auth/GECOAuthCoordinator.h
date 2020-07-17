//
//  GEAuthCoordinator.h
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 13/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import "GECOCoordinator.h"
#import "GEUIAULoginViewController.h"
#import "GEUIAURegisterViewController.h"

@interface GECOAuthCoordinator : NSObject<GECOCoordinator, GEUIAULoginDelegate>

- (instancetype)initWithNavigationController:(UINavigationController*)naviController;

@end
