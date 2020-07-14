//
//  LoginViewController.m
//  MVVM-Clean-Flow-Skeleton
//
//  Created by Genie Truong on 13/7/20.
//  Copyright © 2020 Genie Truong. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "AUGELoginViewController.h"
#import <ReactiveObjC-umbrella.h>
#import <UIButton+RACCommandSupport.h>
#import "AUGELoginViewModel.h"

@interface AUGELoginViewController()

@property AUGELoginViewModel *viewmodel;
@property (weak, nonatomic) IBOutlet UITextField *emailTextField;
@property (weak, nonatomic) IBOutlet UIButton *registerBtn;
@property (weak, nonatomic) IBOutlet UITextField *passwordTextField;
@property (weak, nonatomic) IBOutlet UIButton *loginBtn;

@end

@implementation AUGELoginViewController

- (instancetype)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        self.viewmodel = [[AUGELoginViewModel alloc] init];
    }
    return self;
}

- (void)viewDidLoad{
    [super viewDidLoad];
    [self emailAndPasswordValidation];
}

- (void)emailAndPasswordValidation{
    
    RAC(self.viewmodel, email) = self.emailTextField.rac_textSignal;
    RAC(self.viewmodel, password) = self.passwordTextField.rac_textSignal;

    
//    RACSignal *validEmailSignal = [self.emailTextField.rac_textSignal map:^id(NSString *email){
//        self.viewmodel.email = email;
//        NSString *emailRegex = @"[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
//        NSPredicate *emailTest = [NSPredicate predicateWithFormat:@"SELF MATCHES %@", emailRegex];
//        return [NSNumber numberWithBool:[emailTest evaluateWithObject:email]];
//    }];
//
//    RACSignal *validPasswordSignal = [self.passwordTextField.rac_textSignal map:^id(NSString *password){
//        self.viewmodel.password = password;
//        return [NSNumber numberWithBool:(password.length >= 6)];
//    }];
//
//    RAC(self.loginBtn, enabled) = [RACSignal combineLatest:@[validEmailSignal, validPasswordSignal] reduce:^id(NSNumber *emailValid, NSNumber *passwordValid){
//        return @([emailValid boolValue] && [passwordValid boolValue]);
//    }];
}

- (IBAction)showRegister:(id)sender {
    [self.delegate registerDidClick];
}

- (IBAction)doLogin:(id)sender {
    [[self.viewmodel doLogin] subscribeNext:^(id  _Nullable x) {
        if (x) {
            [self.delegate loginDidSuccess];
        }
    }];
}

-(void) setLoginUseCase:(id<AuthUseCase>) authUseCase{
    self.viewmodel.authUseCase = authUseCase;
}
@end
