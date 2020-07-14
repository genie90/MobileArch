//
//  UTGELoginViewModel.m
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 14/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <XCTest/XCTest.h>
#import "AUGELoginViewModel.h"
#import "UTGEAuthUseCaseImpl.h"
#import "NSUserDefaults+GBUser.h"

@interface UTGELoginViewModel : XCTestCase


@property AUGELoginViewModel* viewmodel;
@end

@implementation UTGELoginViewModel

- (void)setUp {
    // Put setup code here. This method is called before the invocation of each test method in the class.
    self.viewmodel = [[AUGELoginViewModel alloc] init];
    
    self.viewmodel.authUseCase = [[UTGEAuthUseCaseImpl alloc] init];
    
}

- (void)tearDown {
    // Put teardown code here. This method is called after the invocation of each test method in the class.
}

- (void)testLoginSignal {
    // This is an example of a functional test case.
    // Use XCTAssert and related functions to verify your tests produce the correct results.
    [[self.viewmodel doLogin] subscribeNext:^(id  _Nullable x) {
        assert([x isEqual:@"OK"]);
    } error:^(NSError * _Nullable error) {
        assert(error == nil);
    }];
    
}

- (void)testSaveInfo {
    // This is an example of a functional test case.
    // Use XCTAssert and related functions to verify your tests produce the correct results.
    
    DMGELoginModel *authModel = [[DMGELoginModel alloc] init];
    authModel.email = @"email";
    authModel.phone = @"123123123";
    authModel.token = @"asdfghjkl";
    
    [self.viewmodel saveLoginInfo:authModel];
    DMGELoginModel *resultAuthModel = [[NSUserDefaults standardUserDefaults] getGBUser];
    assert([resultAuthModel.email isEqual:authModel.email]);
    assert([resultAuthModel.phone isEqual:authModel.phone]);
    assert([resultAuthModel.token isEqual:authModel.token]);
}

- (void)testPerformanceExample {
    // This is an example of a performance test case.
    [self measureBlock:^{
        // Put the code you want to measure the time of here.
    }];
}

@end
