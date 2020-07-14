//
//  Network.h
//  gobearmaterial
//
//  Created by Genie Truong on 9/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import "AuthUseCase.h"
#import <Foundation/Foundation.h>

@interface ApiService : NSObject

-(instancetype) initWithEndpoint: (NSString*) endpoint;

-(nonnull RACSignal*) postItemAtPath: (nonnull NSString*) path
                  parameters:(nullable id)parameters
                     headers:(nullable NSDictionary <NSString *, NSString *> *)headers;
@end
