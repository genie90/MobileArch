//
//  AUGELoginViewModel.m
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 13/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import "AUGELoginViewModel.h"

@implementation AUGELoginViewModel

-(RACSignal*)doLogin{
    return [self.authUseCase doLoginWithEmail:self.email and:self.password];
}

@end
