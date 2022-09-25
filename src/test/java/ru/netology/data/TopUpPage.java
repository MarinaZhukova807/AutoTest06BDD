package ru.netology.data;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TopUpPage {
    private SelenideElement sum = $("[data-test-id='amount'] input");
    private SelenideElement from = $("[data-test-id='from'] input");
    private SelenideElement heading1 = $("[data-test-id='dashboard']");
    private SelenideElement heading2 = $("div#root h1");
    private SelenideElement transferButton  = $("[data-test-id='action-transfer'] span");
    private SelenideElement errorNotification = $(".notification__content");

    public TopUpPage(){
        heading1.shouldBe(visible);
        heading2.shouldBe(visible);
    }

    public TopUpPage moneyTransfer(int amount, String cardNumber) {
        sum.setValue(String.valueOf(amount));
        from.setValue(cardNumber);
        transferButton.click();
        return new TopUpPage();
    }

    public void shouldAppearErrorNotification() {
        errorNotification.shouldBe(visible);
    }
}
