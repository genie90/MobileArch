//
//  NetworkProvider.h
//  gobearmaterial
//
//  Created by Genie Truong on 10/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import "AuthAPI.h"

@interface NTGENetworkProvider : NSObject

-(AuthAPI*) makeAuthAPI;

@end
