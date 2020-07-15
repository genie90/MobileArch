//
//  AuthUseCaseImpl.m
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 15/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import "AuthUseCase.h"
#import "AuthNetworkFactory.h"

@implementation AuthUseCase

- (RACSignal<DMGELoginModel *> *)doLoginWithEmail:(NSString *)email and:(NSString *)password {
    NSDictionary *parameters = @{@"email": email, @"password": password};
    RACSignal<DMGELoginModel*>* loginSignal = [RACSignal createSignal:^RACDisposable * _Nullable(id<RACSubscriber>  _Nonnull subscriber) {
        
        [[AuthNetworkFactory getAuthNetwork:GENetworkTypeAPI] doLoginWithParams:parameters success:^(NSURLSessionDataTask *task, id  _Nullable responseObject) {
            
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
    return nil;
}


- (void)saveAuthenticationParams {
    // Saving something here
}


@end
