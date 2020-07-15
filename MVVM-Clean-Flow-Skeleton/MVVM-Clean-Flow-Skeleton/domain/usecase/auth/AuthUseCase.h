//
//  AuthUseCaseImpl.h
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 15/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <ReactiveObjC-umbrella.h>

#import "AuthUseCase.h"
#import "DMGELoginModel.h"

NS_ASSUME_NONNULL_BEGIN

@interface AuthUseCase : NSObject

-(RACSignal<DMGELoginModel*>*) doLoginWithEmail:(NSString*) email and:(NSString*) password;
-(RACSignal<DMGELoginModel*>*) doRegisterWithEmail:(NSString*) email and:(NSString*) password;

-(void) saveAuthenticationParams;

@end

NS_ASSUME_NONNULL_END
