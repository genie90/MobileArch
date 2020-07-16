//
//  AuthModel.h
//  gobearmaterial
//
//  Created by Genie Truong on 8/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "APGELoginApiModel.h"

@interface DMGELoginModel : NSObject

@property NSString *phone;
@property NSString *email;
@property NSString *token;

- (instancetype)initWithApiModel:(APGELoginApiModel*)apiModel;
- (instancetype)initFromJson:(id)json;

- (id)getJsonString;

@end
