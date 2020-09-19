//
//  AuthModel.h
//  gobearmaterial
//
//  Created by Genie Truong on 8/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "GEDANWLoginApiModel.h"

@interface GEDMMDLoginModel : NSObject

@property NSString *phone;
@property NSString *email;
@property NSString *token;

- (instancetype)initWithApiModel:(GEDANWLoginApiModel*)apiModel;
- (instancetype)initFromJson:(id)json;

- (id)getJsonString;

@end
