//
//  NSUserDefaults+GBUser.h
//  gobearmaterial
//
//  Created by Genie Truong on 8/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "DMGELoginModel.h"

@interface NSUserDefaults (GBUser)
// private method
- (DMGELoginModel*)getGBUser;
- (void)setGBUser:(DMGELoginModel*) authModel;
- (void)removeGBUser;

@end
