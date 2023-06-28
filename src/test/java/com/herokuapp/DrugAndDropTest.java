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
    void checkMoveRectangle() {
        // - Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        sleep(4000);
        // - Перенесите прямоугольник А на место В
        $("#column-a").dragAndDrop(to("#column-b"));
        // - Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

        // - В Selenide есть команда $(element).dragAndDrop($(to-element)),
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
        // - проверьте работает ли тест, если использовать её вместо actions()
        // - тест не работает с этой командой
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
