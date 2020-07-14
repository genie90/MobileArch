//
//  NetworkProvider.m
//  gobearmaterial
//
//  Created by Genie Truong on 10/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "NTGENetworkProvider.h"

@interface NTGENetworkProvider()

@property NSString *const endpoint;

@end

@implementation NTGENetworkProvider

- (instancetype)init
{
    self = [super init];
    if (self) {
        self.endpoint = @"";
    }
    return self;
}

-(AuthAPI*) makeAuthAPI {
    ApiService *apiService = [[ApiService alloc] initWithEndpoint:self.endpoint];
    return [[AuthAPI alloc] initWithApiService:apiService];
}

@end
