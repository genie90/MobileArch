//
//  AuthNetworkUseCaseProvider.m
//  gobearmaterial
//
//  Created by Genie Truong on 10/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "UseCaseProvider.h"
#import "AuthUseCase.h"

@interface UseCaseProvider()


@end

@implementation UseCaseProvider

- (AuthUseCase*)makeAuthUseCaseWithAPI {
    AuthUseCase* authUseCase = [[AuthUseCase alloc] init];
    return authUseCase;
}

- (AuthUseCase*)makeAuthUseCaseWithFirebase { 
    return nil;
}




@end
