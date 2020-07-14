//
//  NetworkUseCase.m
//  gobearmaterial
//
//  Created by Genie Truong on 9/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "AuthUseCaseImplForAPI.h"

@interface AuthUseCaseImplForAPI()

@property AuthAPI* authApi;

@end

@implementation AuthUseCaseImplForAPI

- (instancetype)initWithAPI: (AuthAPI*) authApi
{
    self = [super init];
    if (self) {
        self.authApi = authApi;
    }
    return self;
}

- (RACSignal<DMGELoginModel *> *)doLoginWithEmail:(NSString *)email and:(NSString *)password {
    NSDictionary *parameters = @{@"email": email, @"password": password};
    RACSignal<DMGELoginModel*>* loginSignal = [RACSignal createSignal:^RACDisposable * _Nullable(id<RACSubscriber>  _Nonnull subscriber) {
        
        [self.authApi doLoginWithParams:parameters success:^(NSURLSessionDataTask *task, id  _Nullable responseObject) {
            
            APGELoginApiModel *apiModel = [[APGELoginApiModel alloc] initWith:responseObject];
            [subscriber sendNext:[[DMGELoginModel alloc] initWithApiModel:apiModel]];
            
        } failure:^(NSURLSessionDataTask * _Nullable task, NSError *error) {
            [subscriber sendError:error];
        }];
        
        return nil;
    }];
    
    return loginSignal;
}

- (RACSignal<DMGELoginModel *> *)doRegisterWithEmail:(NSString *)email and:(NSString *)password {
    NSDictionary *parameters = @{@"email": email, @"password": password};
    
    return nil;

}


@end
