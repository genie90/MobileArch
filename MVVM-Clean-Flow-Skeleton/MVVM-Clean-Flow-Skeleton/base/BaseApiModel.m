//
//  BaseApiModel.m
//  gobearmaterial
//
//  Created by Genie Truong on 8/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import "BaseApiModel.h"

@implementation BaseApiModel
-(NSDictionary*)getData:(id) responseObject{
    if ([responseObject isKindOfClass:[NSDictionary class]]) {
        NSDictionary *results = responseObject;

        return [results objectForKey:@"data"];
    }
    return nil;
}

@end
