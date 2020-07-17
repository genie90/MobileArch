//
//  AuthModel.h
//  gobearmaterial
//
//  Created by Genie Truong on 8/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "GEDANWBaseApiModel.h"

@interface GEDANWLoginApiModel : GEDANWBaseApiModel

@property NSString *phone;
@property NSString *email;
@property NSString *token;

- (instancetype)initWith:(id)respond;

@end
