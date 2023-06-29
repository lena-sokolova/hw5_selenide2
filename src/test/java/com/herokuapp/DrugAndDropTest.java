package com.herokuapp;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;


public class DrugAndDropTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void checkMoveRectangleDrugAndDrop() {
        // - Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // - Перенесите прямоугольник А на место В
        $("#column-a").dragAndDrop(to("#column-b"));
        // - Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void checkMoveRectangleActions() {

        open("https://the-internet.herokuapp.com/drag_and_drop");
        // - В Selenide есть команда $(element).dragAndDrop($(to-element)),
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
        // - проверьте работает ли тест, если использовать её вместо actions()
        // - тест не работает с этой командой (на сайте баг)
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
    }
}
