//
//  AuthNetworkUseCaseProvider.m
//  gobearmaterial
//
//  Created by Genie Truong on 10/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "UseCaseProvider.h"
#import "AuthUseCaseImplForAPI.h"
#import "NTGENetworkProvider.h"

@interface UseCaseProvider()

@property NTGENetworkProvider* networkProvider;

@end

@implementation UseCaseProvider

- (instancetype)init
{
    self = [super init];
    if (self) {
        self.networkProvider = [[NTGENetworkProvider alloc] init];
    }
    return self;
}

- (id<AuthUseCase>)makeAuthUseCaseWithAPI {
    
    AuthAPI *authApi = [self.networkProvider makeAuthAPI];
    id<AuthUseCase> authUseCase = [[AuthUseCaseImplForAPI alloc] initWithAPI:authApi];
    
    return authUseCase;
}

- (id<AuthUseCase>)makeAuthUseCaseWithFirebase { 
    return nil;
}




@end
