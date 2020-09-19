//
//  Network.h
//  gobearmaterial
//
//  Created by Genie Truong on 9/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import "GEDMUCAuthUseCase.h"
#import <Foundation/Foundation.h>

@interface GEDANWApiService : NSObject

- (void) postItemAtPath: (NSString* _Nonnull) path
             parameters:(nullable id)parameters
                headers:(nullable NSDictionary <NSString *, NSString *> *)headers
                success:(nullable void (^)(NSURLSessionDataTask * _Nullable task, id _Nullable responseObject))success
                failure:(nullable void (^)(NSURLSessionDataTask * _Nullable task, NSError * _Nullable error))failure;
@end
