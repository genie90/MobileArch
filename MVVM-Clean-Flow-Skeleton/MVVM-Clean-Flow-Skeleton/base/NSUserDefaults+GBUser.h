//
//  NSUserDefaults+GBUser.h
//  gobearmaterial
//
//  Created by Genie Truong on 8/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "AuthModel.h"

@interface NSUserDefaults (GBUser)
// private method
- (AuthModel*)getGBUser;
- (void)setGBUser:(AuthModel*) authModel;
- (void)removeGBUser;

@end
