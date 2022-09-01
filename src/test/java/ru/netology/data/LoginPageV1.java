package ru.netology.data;

import static com.codeborne.selenide.Selenide.$;
import ru.netology.data.DataHelper.*;

public class LoginPageV1 {
    public VerificationPage validLogin(AuthInfo info) {
        $("[data-test-id=login] input").setValue(info.getLogin());
        $("[data-test-id=password] input").setValue(info.getPassword());
        $("[data-test-id=action-login]").click();
        return new VerificationPage();
    }
}
