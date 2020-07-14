//
//  NetWorkUseCase.h
//  gobearmaterial
//
//  Created by Genie Truong on 9/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import "AuthUseCase.h"
#import "AuthAPI.h"

@interface AuthUseCaseImplForAPI : NSObject <AuthUseCase>
- (instancetype)initWithAPI: (AuthAPI*) authApi;
@end
