package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

//Вложеный класс выбирающий рандомную книгу
    public class RandomEl{
        ElementsCollection randomList;
        static String xPathListBook = ".//span[@data-test-id='tile-name']";
        static String xPathButton =".//button";

        public static SelenideElement RandomObj(String xPath) throws InterruptedException {
            RandomEl randomBook =new RandomEl();
            randomBook.clickRandomBook(xPath);
            return randomBook.clickRandomBook(xPath);
        }

        public SelenideElement clickRandomBook(String xPath) throws InterruptedException {
            Thread.sleep(500);
            randomList = $$(byXpath(xPath));//создание коллекции книг
            int randomElement = (int) (Math.random() * randomList.size());//рандомная переменна
            //xPathListBook = ".//span[@data-test-id='tile-name']";//Путь до названия
            System.out.println(randomList.get(randomElement).$(byXpath(xPathListBook)).getText());
            return randomList.get(randomElement);
        }

        //Получаем название книги, метод нужен для проверки книги в корзине
        public static String getBookName(SelenideElement selenideElement){
            return selenideElement.$(byXpath(xPathListBook)).getText();
        }

        public static SelenideElement getRandomButton(SelenideElement selenideElement) {
            return selenideElement.$(byXpath(xPathButton));
        }
    }
