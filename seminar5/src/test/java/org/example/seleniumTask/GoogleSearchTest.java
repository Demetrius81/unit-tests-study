package org.example.seleniumTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

class GoogleSearchTest {

    public static void main(String[] args) {
        // Установите путь к драйверу браузера Chrome
//        System.setProperty("webdriver.chrome.driver", "путь_к_драйверу/chromedriver");
        //скачать веб драйвер
        //https://sites.google.com/chromium.org/driver/
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");

        // Опциональные настройки браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Максимизация окна браузера

        // Инициализация WebDriver
        WebDriver driver = new ChromeDriver(options);

        // Открытие главной страницы Google
        driver.get("https://www.google.com");

        // Находим элемент поисковой строки и вводим текст "Selenium"
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");

        // Нажимаем кнопку "Поиск в Google"
        searchBox.submit();

        // Ожидание появления результатов поиска
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".rc")));

        // Поиск ссылки на официальный сайт Selenium
        WebElement officialLink = driver.findElement(By.partialLinkText("Selenium"));

        // Проверка, что ссылка действительно присутствует среди результатов поиска
        if (officialLink != null) {
            System.out.println("Ссылка на официальный сайт Selenium найдена.");
        } else {
            System.out.println("Ссылка на официальный сайт Selenium не найдена.");
        }

        // Завершение сеанса браузера
        driver.quit();
    }
}