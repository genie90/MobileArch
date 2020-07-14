//
//  AUGELoginViewModel.m
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 13/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import "AUGELoginViewModel.h"
#import "NSUserDefaults+GBUser.h"

@implementation AUGELoginViewModel

-(RACSignal<AuthModel*>*)doLogin{
    return [self.authUseCase doLoginWithEmail:self.email and:self.password];
}

-(void)saveLoginInfo:(AuthModel*) authModel{
    [[NSUserDefaults standardUserDefaults] setGBUser:authModel];
}

-(RACSignal*)emailValid{
    return [RACObserve(self, email) map:^id _Nullable(id  _Nullable email) {
        NSString *emailRegex = @"[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
        NSPredicate *emailTest = [NSPredicate predicateWithFormat:@"SELF MATCHES %@", emailRegex];
        return [NSNumber numberWithBool:[emailTest evaluateWithObject:email]];
    }];
}

-(RACSignal*)passwordValid{
    return [RACObserve(self, password) map:^id _Nullable(id  _Nullable password) {
        return [NSNumber numberWithBool:([password length] >= 6)];
    }];
}

-(RACSignal*)loginEnable{
    return [RACSignal combineLatest:@[[self emailValid], [self passwordValid]] reduce:^id(NSNumber *emailValid, NSNumber *passwordValid){
        return @([emailValid boolValue] && [passwordValid boolValue]);
    }];
}


@end
