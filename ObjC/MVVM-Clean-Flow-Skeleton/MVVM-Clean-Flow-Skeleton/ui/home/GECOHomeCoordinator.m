//
//  GECOHomeCoordinator.m
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 17/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//
#import <UIKit/UIKit.h>
#import "GECOHomeCoordinator.h"
#import "GEUIHOHomeViewController.h"

@interface GECOHomeCoordinator()

@property (strong, nonatomic) GEUIHOHomeViewController *homeViewController;

@end

@implementation GECOHomeCoordinator

- (instancetype)init
{
    self = [super init];
    if (self) {
        [self setupHome];
        
        [NSObject cancelPreviousPerformRequestsWithTarget:self selector:@selector(showLogin) object:nil];
        [self performSelector:@selector(showLogin) withObject:nil afterDelay:3.0];
    }
    return self;
}

-(void)setupHome{
    self.homeViewController = [[GEUIHOHomeViewController alloc] initWithNibName:@"GEUIHOHomeViewController" bundle:nil];
}

- (id)getRootViewController {
    return self.homeViewController;
}

- (void)showLogin{
    [self.delegate openAuthFlow];    
}

@end
