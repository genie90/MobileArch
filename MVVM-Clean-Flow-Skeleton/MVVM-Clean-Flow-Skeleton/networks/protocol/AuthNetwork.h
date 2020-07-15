//
//  AuthNetwork.h
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 15/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#ifndef AuthNetwork_h
#define AuthNetwork_h

@protocol AuthNetwork

-(void) doLoginWithParams:(nullable id)params
                  success:(nullable void (^)(NSURLSessionDataTask *task, id _Nullable responseObject))success
                  failure:(nullable void (^)(NSURLSessionDataTask * _Nullable task, NSError *error))failure;

-(void) doRegisterWithParams:(nullable id)params
                     success:(nullable void (^)(NSURLSessionDataTask *task, id _Nullable responseObject))success
                     failure:(nullable void (^)(NSURLSessionDataTask * _Nullable task, NSError *error))failure;

@end

#endif /* AuthNetwork_h */
