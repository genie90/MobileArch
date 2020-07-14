//
//  Network.m
//  gobearmaterial
//
//  Created by Genie Truong on 9/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "ApiService.h"
#import <ReactiveObjC/RACSignal.h>
#import <ReactiveObjC/ReactiveObjC.h>
#import <AFNetworking/AFNetworking-umbrella.h>

@interface ApiService()
@property NSString* endpoint;

@end

@implementation ApiService

-(instancetype) initWithEndpoint: (NSString*) endpoint
{
    self = [super init];
    if (self) {
        self.endpoint = endpoint;
    }
    return self;
}

- (RACSignal*) postItemAtPath: (NSString*) path
             parameters:(nullable id)parameters
                headers:(nullable NSDictionary <NSString *, NSString *> *)headers
{
    NSString *URLString = [NSString stringWithFormat:@"%@/%@", self.endpoint, path];
    AFHTTPSessionManager *manager = [AFHTTPSessionManager manager];
    manager.requestSerializer = [AFJSONRequestSerializer serializer];
    manager.responseSerializer = [AFJSONResponseSerializer serializer];
    
    RACSignal *signal = [RACSignal createSignal:^RACDisposable * _Nullable(id<RACSubscriber>  _Nonnull subscriber) {
        [manager POST:URLString
           parameters:parameters
              headers:headers
             progress:nil
              success:^(NSURLSessionTask *task, id responseObject) {
            [subscriber sendNext:responseObject];
            [subscriber sendCompleted];
        } failure:^(NSURLSessionTask *operation, NSError *error) {
            [subscriber sendError:error];
        }];
        return nil;
    }];
    
    return signal;
}

@end
