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
    [self bindView];
}

- (void)bindView{
    RAC(self.viewmodel, email) = self.emailTextField.rac_textSignal;
    RAC(self.viewmodel, password) = self.passwordTextField.rac_textSignal;
    RAC(self.loginBtn, enabled) = [self.viewmodel loginEnable];
}

- (IBAction)showRegister:(id)sender {
    [self.delegate registerDidClick];
}

- (IBAction)doLogin:(id)sender {
    @weakify(self);
    [[self.viewmodel doLogin] subscribeNext:^(DMGELoginModel* _Nullable authModel) {
        @strongify(self);
        [self loginSuccess:authModel];
    } error:^(NSError * _Nullable error) {
        
    }];
}

- (void) loginSuccess:(DMGELoginModel* _Nullable) authModel{
    [self.viewmodel saveLoginInfo:authModel];
    [self.delegate loginDidSuccess];
}

-(void) setLoginUseCase:(id<AuthUseCase>) authUseCase{
    self.viewmodel.authUseCase = authUseCase;
}
@end
