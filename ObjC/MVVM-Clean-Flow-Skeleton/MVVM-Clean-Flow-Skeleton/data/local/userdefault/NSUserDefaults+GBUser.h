//
//  NSUserDefaults+GBUser.h
//  gobearmaterial
//
//  Created by Genie Truong on 8/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "GEDMMDLoginModel.h"

@interface NSUserDefaults (GBUser)
// private method
- (GEDMMDLoginModel*)getGBUser;
- (void)setGBUser:(GEDMMDLoginModel*) authModel;
- (void)removeGBUser;

@end
