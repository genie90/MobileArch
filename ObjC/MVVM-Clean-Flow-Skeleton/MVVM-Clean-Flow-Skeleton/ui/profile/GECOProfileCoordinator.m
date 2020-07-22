//
//  GECOProfileCoordinator.m
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 17/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import "GECOProfileCoordinator.h"
#import "GEUIPRProfileViewController.h"

@interface GECOProfileCoordinator()

@property (strong, nonatomic) GEUIPRProfileViewController *profileViewController;

@end

@implementation GECOProfileCoordinator

- (instancetype)init
{
    self = [super init];
    if (self) {
        self.profileViewController = [[GEUIPRProfileViewController alloc] initWithNibName:@"GEUIPRProfileViewController" bundle:nil];
    }
    return self;
}

- (id)getRootViewController {
    return self.profileViewController;
}

@end
