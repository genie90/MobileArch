//
//  GBUser.m
//  gobearmaterial
//
//  Created by Genie Truong on 8/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "NSUserDefaults+GBUser.h"


@implementation NSUserDefaults(GBUser)

-(DMGELoginModel*)getGBUser{
    NSLog(@"private method");
    DMGELoginModel *model = [[DMGELoginModel alloc] initFromJson:[self valueForKey:@"gb_user"]];
    return model;
}


-(void)setGBUser:(DMGELoginModel*) authModel{
    
    NSString *userJson = [authModel getJsonString];
    [self setValue:userJson forKey:@"gb_user"];
}

-(void)removeGBUser{
    [self removeObjectForKey:@"gb_user"];
}

@end
