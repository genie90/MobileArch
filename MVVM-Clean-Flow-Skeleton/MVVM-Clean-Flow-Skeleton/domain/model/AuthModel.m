//
//  AuthModel.m
//  gobearmaterial
//
//  Created by Genie Truong on 8/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import "AuthModel.h"

@implementation AuthModel

- (instancetype)initWithApiModel:(AuthApiModel*)apiModel{
    self = [super init];
    if (self) {
        self.email = apiModel.email;
        self.phone = apiModel.phone;
        self.token = apiModel.token;
    }
    
    return self;
}

- (instancetype)initFromJson:(id)json{
    self = [super init];
    
    if (self) {
        for (NSString* key in json) {
            @try {
                [self setValue:[json valueForKey:key] forKey:key];
            }
            @catch (NSException *e) {
                NSLog(@"NSUnknownKeyException: %@", e);
            }
        }
    }
    
    return self;
}

- (NSString*)getJsonString{
    return [NSDictionary dictionaryWithObjectsAndKeys:self.phone,@"phone",self.token,@"token",self.email, @"email", nil];
}

@end
