//
//  AUGELoginViewModel.h
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 13/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <ReactiveObjC-umbrella.h>
#import "GEDMUCAuthUseCase.h"

NS_ASSUME_NONNULL_BEGIN

@interface GEUIAULoginViewModel : NSObject

@property (strong, nonatomic) NSString *email;
@property (strong, nonatomic) NSString *password;
@property (strong, nonatomic) GEDMUCAuthUseCase *authUseCase;

-(RACSignal*)doLogin;
-(RACSignal*)emailValid;
-(RACSignal*)passwordValid;
-(RACSignal*)loginEnable;

-(void)saveLoginInfo:(GEDMMDLoginModel*) authModel;

@end

NS_ASSUME_NONNULL_END
