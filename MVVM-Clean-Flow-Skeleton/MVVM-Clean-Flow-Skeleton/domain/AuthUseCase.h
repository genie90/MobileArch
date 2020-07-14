//
//  AuthUsecase.h
//  gobearmaterial
//
//  Created by Genie Truong on 9/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//
#import <ReactiveObjC/RACSignal.h>
#import <ReactiveObjC/ReactiveObjC.h>
#import "AuthModel.h"

@protocol AuthUseCase

-(RACSignal<AuthModel*>*) doLoginWithEmail:(NSString*) email and:(NSString*) password;
-(RACSignal<AuthModel*>*) doRegisterWithEmail:(NSString*) email and:(NSString*) password;

@end
