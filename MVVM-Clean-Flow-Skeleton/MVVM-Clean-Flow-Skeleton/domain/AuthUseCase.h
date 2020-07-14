//
//  AuthUsecase.h
//  gobearmaterial
//
//  Created by Genie Truong on 9/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//
#import <ReactiveObjC/RACSignal.h>
#import <ReactiveObjC/ReactiveObjC.h>
#import "DMGELoginModel.h"

@protocol AuthUseCase

-(RACSignal<DMGELoginModel*>*) doLoginWithEmail:(NSString*) email and:(NSString*) password;
-(RACSignal<DMGELoginModel*>*) doRegisterWithEmail:(NSString*) email and:(NSString*) password;

@end
