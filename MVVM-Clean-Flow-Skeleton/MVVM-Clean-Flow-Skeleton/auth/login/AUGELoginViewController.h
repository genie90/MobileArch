//
//  LoginViewController.h
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 13/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "AUGELoginDelegate.h"
#import "AuthUseCase.h"

@interface AUGELoginViewController : UIViewController

@property (weak, nonatomic) id<AUGELoginDelegate> delegate;

-(void) setLoginUseCase:(AuthUseCase *) authUseCase;

@end
