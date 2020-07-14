//
//  AUGELoginViewModel.h
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 13/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <ReactiveObjC-umbrella.h>
#import "AuthUseCase.h"

NS_ASSUME_NONNULL_BEGIN

@interface AUGELoginViewModel : NSObject

@property (strong, nonatomic) NSString *email;
@property (strong, nonatomic) NSString *password;
@property (strong, nonatomic) id<AuthUseCase> authUseCase;

-(RACSignal*)doLogin;
-(RACSignal*)emailValid;
-(RACSignal*)passwordValid;
-(RACSignal*)loginEnable;

-(void)saveLoginInfo:(AuthModel*) authModel;

@end

NS_ASSUME_NONNULL_END
