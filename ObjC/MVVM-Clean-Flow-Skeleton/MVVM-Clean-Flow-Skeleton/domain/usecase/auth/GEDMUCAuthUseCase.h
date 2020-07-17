//
//  AuthUseCaseImpl.h
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 15/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <ReactiveObjC-umbrella.h>

#import "GEDMUCAuthUseCase.h"
#import "GEDMMDLoginModel.h"
#import "GEDANWAuthNetwork.h"

NS_ASSUME_NONNULL_BEGIN

@interface GEDMUCAuthUseCase : NSObject

@property id<GEDANWAuthNetwork> authNetwork;

- (instancetype)initWithAuthNetwork: (id<GEDANWAuthNetwork>) authNet;

-(RACSignal<GEDMMDLoginModel*>*) doLoginWithEmail:(NSString*) email and:(NSString*) password;
-(RACSignal<GEDMMDLoginModel*>*) doRegisterWithEmail:(NSString*) email and:(NSString*) password;

-(void) saveAuthenticationParams;

@end

NS_ASSUME_NONNULL_END
