package ru.netology.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.LoginPageV1;
import ru.netology.data.LoginPageV2;
import ru.netology.data.LoginPageV3;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.DataHelper.*;

public class CallBack {
    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }
    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {
        var loginPage = new LoginPageV1();
        // можно заменить на var loginPage = open("http://localhost:9999", LoginPageV1.class);
        var authInfo = getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
 //...
    }
    @Test
    void shouldTransferMoneyBetweenOwnCardsV2() {
        var loginPage = new LoginPageV2();
        // можно заменить на var loginPage = open("http://localhost:9999", LoginPageV2.class);
        var authInfo = getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
// ...
    }
    @Test
    void shouldTransferMoneyBetweenOwnCardsV3() {
        var loginPage = open("http://localhost:9999", LoginPageV3.class);
        // но здесь обратное не сработает — FindBy только с PageFactory
        var authInfo = getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
 //...
    }
}
