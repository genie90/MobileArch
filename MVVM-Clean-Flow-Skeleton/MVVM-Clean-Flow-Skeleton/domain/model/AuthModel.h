//
//  AuthModel.h
//  gobearmaterial
//
//  Created by Genie Truong on 8/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "AuthApiModel.h"

@interface AuthModel : NSObject

@property NSString *phone;
@property NSString *email;
@property NSString *token;

- (instancetype)initWithApiModel:(AuthApiModel*)apiModel;
- (instancetype)initFromJson:(id)json;

- (NSString*)getJsonString;

@end
