package com.motor.service.servicemotor.data.remote.user;

import com.motor.service.servicemotor.base.annotation.UserScope;

import dagger.Subcomponent;

/**
 * Created by ikun on 28/12/17.
 */

@UserScope
@Subcomponent(
        modules = {
                UserModule.class
        }
)
public interface UserComponent {

//    IntroActivityComponent plus(IntroActivityModule activityModule);
//
//    MainActivityComponent plus(MainActivityModule activityModule);
//
//    MainComponent plus(MainModule mainModule);
//
//    EditProfileActivityComponent plus(EditProfileActivityModule activityModule);
//
//    SettingActivityComponent plus(SettingActivityModule activityModule);
//
//    BriefActivityComponent plus(BriefActivityModule activityModule);
//
//    SkillActivityComponent plus(SkillActivityModule activityModule);
//
//    PrestasiActivityComponent plus(PrestasiActivityModule activityModule);
//
//    PengalamanActivityComponent plus(PengalamanActivityModule activityModule);
//
//    SkillComponent plus(SkillModule module);
//
//    LocationComponent plus(LocationModule locationModule);
//
//    AddLocationActivityComponent plus(AddLocationActivityModule activityModule);
//
//    PaymentDetailActivityComponent plus(PaymentDetailActivityModule activityModule);
//
//    VerificationActivityComponent plus(VerificationActivityModule activityModule);
//
//    ReviewsActivityComponent plus(ReviewsActivityModule activityModule);
//
//    MapActivityComponent plus(MapActivityModule mapActivityModule);
//    WalletActivityComponent plus (WalletActivityModule walletActivityModule);
}
