package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class OzonSearchPage {

        public static final String URL = "https://www.ozon.ru/";

        public static String xPathBookCollection(){
            return  "//div[@class = 'tile m-default m-border']";
        }

        public static String xPathSmowBoard(){
            return "//div[@data-index]/a";
        }


        String xPathBookCollection = "//div[@class = 'tile m-default m-border']";

        //Кнопка закрытия сообщение о куки
        public static SelenideElement cookie(){
            String ClassName = "close";
            return  $(byClassName(ClassName));
        }

        //кнопка "Каталог"
        public static SelenideElement katalog() {
            String ClassName = "//header//button[@type='button']";
            return $(byXpath(ClassName));
        }

        //кнопка "Книги"
        public static SelenideElement bookHover(){
            String xPath = "//div[@class='_0b5627']//a[6]";
            return $(byXpath(xPath));
        }

        // кнопка "Компютеные технологии"
        public static SelenideElement kompyuterTehnologi(){
            String xPath = "//a[@href='/category/kompyuternye-tehnologii-40020/']";
            return $(byXpath(xPath));
        }

        // чекбокс "Бестселлеры"
        public static SelenideElement checkBoxBestSail() {
            String xPath = "//div[@data-test-id='filter-block-isbest']//span";
            return $(byXpath(xPath));
        }

        // чекбокс "Языки програмирования"
        public static SelenideElement checkBoxLengerichProg(){
            String xPath = "//span[contains(text(),'Языки программирования')]";
            return  $(byXpath(xPath));
        }

        //Переходим в корзину
        public static SelenideElement Trash(){
            String xPath = "//a[@href='/cart']";
            return $(byXpath(xPath));
        }

        public static String nameElementInTresh(){
            String xPath = "//a[@class='title']/span";//Путь до названия книги в корзине
            return $(byXpath(xPath)).getText();
        }

         public static SelenideElement geoLocation(){
             String xPath = "//div[@role]//button";//Путь до геолокации
             return $(byXpath(xPath));
         }

         public static SelenideElement inputGeoLocation(){
             String xPath = "//div[@class='modal-content']//input";//Путь до поля ввода
             return $(byXpath(xPath));
         }

         public static SelenideElement cityBestSearch(){
             String xPath = "//div[@class='modal-content']//a";//Путь до первого в списке города
             return $(byXpath(xPath));
         }

         public static SelenideElement sportProduct(){
              String xPath = "//a[@href='/category/sport-i-otdyh-11000/']/span";//Путь спортивных таваров
              return $(byXpath(xPath));
         }

         public static SelenideElement snowboardAndAccessories(){
              String xPath = "//a[@href='/category/snoubordy-i-aksessuary-11158/']";//Путь Сноуборды и ассесуары
              return $(byXpath(xPath));
         }

         public static SelenideElement snowboard(){
              String xPath = "//main//a[@href='/category/snoubordy-11159/']";//Путь Сноуборды
              return $(byXpath(xPath));
         }

         public static SelenideElement minPrice(){
               String xPath = "//input[@data-test-id='range-filter-from-input']";//Путь минимальная цена
               return $(byXpath(xPath));
         }
         public static SelenideElement forProgessif(){
               String xPath = "//div[@data-test-id='filter-block-targetgroup']//span";//Путь Для прогруссирующих
               return $(byXpath(xPath));
         }





}
