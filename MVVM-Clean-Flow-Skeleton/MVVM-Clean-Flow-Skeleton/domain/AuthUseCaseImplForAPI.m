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

- (RACSignal<AuthModel *> *)doLoginWithEmail:(NSString *)email and:(NSString *)password {
    NSDictionary *parameters = @{@"email": email, @"password": password};
    RACSignal<AuthModel*>* loginSignal = [RACSignal createSignal:^RACDisposable * _Nullable(id<RACSubscriber>  _Nonnull subscriber) {
        
        [[self.authApi doLoginWithParams:parameters] subscribeNext:^(AuthApiModel * _Nullable respond) {
            
            AuthApiModel *apiModel = [[AuthApiModel alloc] initWith:respond];
            [subscriber sendNext:[[AuthModel alloc] initWithApiModel:apiModel]];
        } error:^(NSError * _Nullable error) {
            [subscriber sendError:error];
        }];
        
        return nil;
    }];
    
    return loginSignal;
}

- (RACSignal<AuthModel *> *)doRegisterWithEmail:(NSString *)email and:(NSString *)password {
    NSDictionary *parameters = @{@"email": email, @"password": password};
    RACSignal<AuthModel*>* registerSignal = [RACSignal createSignal:^RACDisposable * _Nullable(id<RACSubscriber>  _Nonnull subscriber) {
        [[self.authApi doLoginWithParams:parameters] subscribeNext:^(AuthApiModel * _Nullable respond) {
            
//            AuthApiModel *apiModel = [[AuthApiModel alloc] initWith:respond];
//            [subscriber sendNext:[[AuthModel alloc] initWithApiModel:apiModel]];
            
        } error:^(NSError * _Nullable error) {
            [subscriber sendError:error];
        }];
        
        return nil;
    }];
    
    return registerSignal;

}


@end
