//
//  AuthModel.m
//  gobearmaterial
//
//  Created by Genie Truong on 8/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import "AuthApiModel.h"

@implementation AuthApiModel

- (instancetype)initWith:(id)respond{
    self = [super init];
    
    if (self) {
        NSDictionary *data = [self getData:respond];
        
        for (NSString* key in data) {
            @try {
                [self setValue:[data valueForKey:key] forKey:key];
            }
            @catch (NSException *e) {
                NSLog(@"NSUnknownKeyException: %@", e);
            }
        }
    }
    return self;
}

@end
