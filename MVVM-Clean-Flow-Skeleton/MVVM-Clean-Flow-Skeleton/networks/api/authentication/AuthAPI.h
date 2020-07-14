//
//  UserNetwork.h
//  gobearmaterial
//
//  Created by Genie Truong on 9/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import "AuthUseCase.h"
#import "ApiService.h"
#import "AuthApiModel.h"

@interface AuthAPI : NSObject

-(nullable id)initWithApiService:(nonnull ApiService*) apiService;
-(nonnull RACSignal<AuthApiModel*>*) doLoginWithParams:(nullable id)params;

@end
