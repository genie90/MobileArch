//
//  UserNetwork.h
//  gobearmaterial
//
//  Created by Genie Truong on 9/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import "ApiService.h"

@interface AuthAPI : NSObject

-(nullable id)initWithApiService:(nonnull ApiService*) apiService;
-(void) doLoginWithParams:(nullable id)params
                  success:(nullable void (^)(NSURLSessionDataTask *task, id _Nullable responseObject))success
                  failure:(nullable void (^)(NSURLSessionDataTask * _Nullable task, NSError *error))failure;

@end
