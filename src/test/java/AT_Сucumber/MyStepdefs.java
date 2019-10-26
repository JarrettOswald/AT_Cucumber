package AT_Сucumber;

import Pages.OzonSearchPage;
import Pages.RandomEl;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.ru.*;
import org.junit.Assert;
import static AT_Сucumber.Storage.STORAGE;
import static AT_Сucumber.Storage.Keys.TITLE;
import static Pages.OzonSearchPage.*;
import static Pages.RandomEl.RandomObj;
import static Pages.RandomEl.getRandomButton;

public class MyStepdefs {
    SelenideElement element;

    @Дано("^пользователь нажимает на кнопку 'Каталог'$")
    public void clickKatalog(){
        OzonSearchPage.katalog().click();
    }

    @Также("^в списке видов книг выбирает 'Компютеные технологии'$")
    public void вСпискеВидовКнигВыбираетКомпютеныеТехнологии() {
        kompyuterTehnologi().click();
    }

    @И("^выбирает чекбокс 'Бестселлеры'$")
    public void выбираетЧекбоксБестселлеры() {
        checkBoxBestSail().click();
    }

    @Также("^выбирает чекбокс 'Языки Програмирования'$")
    public void выбираетЧекбоксЯзыкиПрограмирования() {
        checkBoxLengerichProg().click();
    }

    @Также("^закрывает сообщение о куки$")
    public void закрываетСообщениеОКуки() {
        cookie().click();
    }


    @И("^добавляет рандомную книгу в корзину$")
    public void добавляетРандомнуюКнигуВКорзину() throws InterruptedException {

       element  = RandomObj(OzonSearchPage.xPathBookCollection());
       getRandomButton(element).click();
       STORAGE.put(TITLE,RandomEl.getBookName(element));
    }

    @И("^заходит в корзину$")
    public void заходитВКорзину() {
        OzonSearchPage.Trash().click();
    }

    @Тогда("^кнопка 'В корзину' исчезает$")
    public void кнопкаВКорзинуИсчезает() throws InterruptedException {

        Assert.assertTrue("Кнопка не исчезла", getRandomButton(element).has(Condition.exist));
    }

    @Когда("^пользователь заходит на страницу он кликает на геолокацию$")
    public void пользовательЗаходитНаСтраницуОнКликаетНаГеолокацию() {
        OzonSearchPage.geoLocation().click();
    }


    @И("^в поле 'Ваш город' пишет \"([^\"]*)\"$")
    public void вПолеВашГородПишет(String city) {
        OzonSearchPage.inputGeoLocation().sendKeys(city);
    }

    @И("^во всплывшем окне выбирвет лучший результат поиска$")
    public void воВсплывшемОкнеВыбирветЛучшийРезультатПоиска() throws InterruptedException {
        Thread.sleep(500);
        cityBestSearch().click();
    }

    @И("^навести курсуор на (Спортивные товары|Книги)$")
    public void навестиКурсуорНаСпортивныеТовары(String tabName) {
        switch (tabName) {
            case "Спортивные товары":
                sportProduct().hover();
                break;
            case "Книги":
                bookHover().hover();
                break;
            default:
                throw new IllegalArgumentException(tabName);
        }
    }

    @И("^выбрать 'Сноуборды и аксесуары'$")
    public void выбратьСноубордыИАксесуары() {
        OzonSearchPage.snowboardAndAccessories().click();
    }

    @И("^выбрать 'Сноуборды'$")
    public void выбратьСноуборды() {
        OzonSearchPage.snowboard().click();
    }

    @И("^ввести минмальную цену в (\\d+)$")
    public void ввестиМинмальнуюЦенуВ(int price) throws InterruptedException {
        Thread.sleep(2000);/*без этого слипа начинает до полного перехода в сноуборды цену вводить
        и по итогу никуда и не переходит*/
        minPrice().sendKeys("\b\b\b\b\b"+String.valueOf(price));
        minPrice().pressEnter();
    }

    @И("^выбирает рандомный сноуборд$")
    public void выбираетРандомныйСноуборд() throws InterruptedException {
        element = RandomObj(OzonSearchPage.xPathSmowBoard());
        getRandomButton(element).click();
        STORAGE.put(TITLE,RandomEl.getBookName(element));
    }

    @И("^выбрать уровень подготовки 'для прогрессирующих'$")
    public void выбратьУровеньПодготовкиДляПрогрессирующих() {
        OzonSearchPage.forProgessif().click();
    }

    @Ктомуже("^выбранная позиция и позиция в корзине должны совпадать$")
    public void выбраннаяПозицияИПозицияВКорзинеДолжныСовпадать() {
        Assert.assertTrue("Товары не совпадают",OzonSearchPage.nameElementInTresh().equals(STORAGE.get(TITLE)));
    }
}
