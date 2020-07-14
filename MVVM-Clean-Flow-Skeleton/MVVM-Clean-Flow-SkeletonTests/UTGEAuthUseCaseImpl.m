//
//  UTGEAuthUseCaseImpl.m
//  MVVM-Clean-Flow-SkeletonTests
//
//  Created by Genie Truong on 14/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import "UTGEAuthUseCaseImpl.h"

@implementation UTGEAuthUseCaseImpl

- (RACSignal<AuthModel *> *)doLoginWithEmail:(NSString *)email and:(NSString *)password {
    return [RACSignal createSignal:^RACDisposable * _Nullable(id<RACSubscriber>  _Nonnull subscriber) {
        [subscriber sendNext:@"OK"];
        return nil;
    }];
}

- (RACSignal<AuthModel *> *)doRegisterWithEmail:(NSString *)email and:(NSString *)password {
    return [RACSignal createSignal:^RACDisposable * _Nullable(id<RACSubscriber>  _Nonnull subscriber) {
        
        return nil;
    }];
}

@end
