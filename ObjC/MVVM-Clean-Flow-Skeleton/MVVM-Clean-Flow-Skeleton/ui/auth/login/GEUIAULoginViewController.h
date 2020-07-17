//
//  LoginViewController.h
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 13/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "GEUIAULoginDelegate.h"
#import "GEDMUCAuthUseCase.h"

@interface GEUIAULoginViewController : UIViewController

@property (weak, nonatomic) id<GEUIAULoginDelegate> delegate;

-(void) setLoginUseCase:(GEDMUCAuthUseCase *) authUseCase;

@end
