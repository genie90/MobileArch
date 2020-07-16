//
//  AuthModel.h
//  gobearmaterial
//
//  Created by Genie Truong on 8/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "BaseApiModel.h"

@interface APGELoginApiModel : BaseApiModel

@property NSString *phone;
@property NSString *email;
@property NSString *token;

- (instancetype)initWith:(id)respond;

@end
