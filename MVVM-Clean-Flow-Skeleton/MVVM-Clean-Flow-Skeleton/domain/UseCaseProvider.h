//
//  AuthNetworkUseCaseProvider.h
//  gobearmaterial
//
//  Created by Genie Truong on 10/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import "AuthUseCase.h"

@interface UseCaseProvider : NSObject

-(id<AuthUseCase>) makeAuthUseCaseWithAPI;
-(id<AuthUseCase>) makeAuthUseCaseWithFirebase;

@end
