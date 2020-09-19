//
//  AuthNetworkUseCaseProvider.m
//  gobearmaterial
//
//  Created by Genie Truong on 10/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "GEDMUCUseCaseProvider.h"
#import "GEDMUCAuthUseCase.h"

@interface GEDMUCUseCaseProvider()


@end

@implementation GEDMUCUseCaseProvider

+ (GEDMUCAuthUseCase*)makeAuthUseCase {
    GEDMUCAuthUseCase* authUseCase = [[GEDMUCAuthUseCase alloc] init];
    return authUseCase;
}




@end
