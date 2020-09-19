//
//  AuthUseCaseImpl.m
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 15/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import "GEDMUCAuthUseCase.h"

@implementation GEDMUCAuthUseCase

- (instancetype)initWithAuthNetwork: (id<GEDANWAuthNetwork>) authNet
{
    self = [super init];
    if (self) {
        self.authNetwork = authNet;
    }
    return self;
}

- (RACSignal<GEDMMDLoginModel *> *)doLoginWithEmail:(NSString *)email and:(NSString *)password {
    NSDictionary *parameters = @{@"email": email, @"password": password};
    RACSignal<GEDMMDLoginModel*>* loginSignal = [RACSignal createSignal:^RACDisposable * _Nullable(id<RACSubscriber>  _Nonnull subscriber) {
        
        [self.authNetwork doLoginWithParams:parameters success:^(NSURLSessionDataTask *task, id  _Nullable responseObject) {
            
            GEDANWLoginApiModel *apiModel = [[GEDANWLoginApiModel alloc] initWith:responseObject];
            [subscriber sendNext:[[GEDMMDLoginModel alloc] initWithApiModel:apiModel]];
            
        } failure:^(NSURLSessionDataTask * _Nullable task, NSError *error) {
            [subscriber sendError:error];
        }];
        
        return nil;
    }];
    
    return loginSignal;
}

- (RACSignal<GEDMMDLoginModel *> *)doRegisterWithEmail:(NSString *)email and:(NSString *)password {
    return nil;
}


- (void)saveAuthenticationParams {
    // Saving something here
}


@end
