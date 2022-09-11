package ru.netology.data;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class TopUpPage {
    private SelenideElement sum = $("[data-test-id='amount'] input");
    private SelenideElement from = $("[data-test-id='from'] input");

    private SelenideElement topUp = $("[data-test-id='action-transfer']");


    public DashboardPage cardReplenishmentFirst(DataHelper.CardNumberSecond cardNumberSecond, String amount) {
        sum.setValue(amount);
        from.setValue(cardNumberSecond.getNumberSecondCard());
        topUp.click();
        return new DashboardPage();
    }

    public DashboardPage cardReplenishmentSecond(DataHelper.CardNumberFirst cardNumberFirst, String amount) {
        sum.setValue(amount);
        from.setValue(cardNumberFirst.getNumberFirstCard());
        topUp.click();
        return new DashboardPage();
    }
}
