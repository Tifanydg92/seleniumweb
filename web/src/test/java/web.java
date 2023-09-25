import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class web {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/estef/AquaProjects/web/driver/chrome.exe");

        WebDriver driver = new ChromeDriver();

        // Caso de prueba 1
        driver.get("https://www.innocv.com/");
        driver.findElement(By.linkText("Contacto")).click();
        String phoneNumber = driver.findElement(By.className("phone")).getText().replace("+34", "").trim();
        driver.findElement(By.linkText("Aviso legal")).click();
        String phoneNumberInLegal = driver.findElement(By.className("phone")).getText().replace("+34", "").trim();
        if (phoneNumber.equals(phoneNumberInLegal)) {
            System.out.println("Caso de prueba 1: El número de teléfono es el mismo.");
        } else {
            System.out.println("Caso de prueba 1: El número de teléfono es diferente.");
        }

        // Caso de prueba 2
        driver.get("https://www.innocv.com/");
        driver.findElement(By.linkText("Contacto")).click();
        List<WebElement> faradayElements = driver.findElements(By.linkText("Faraday"));
        int faradayCount = faradayElements.size();
        System.out.println("Caso de prueba 2: Faraday aparece " + faradayCount + " veces.");

        // Caso de prueba 3
        driver.get("https://www.innocv.com/");
        driver.findElement(By.linkText("Contacto")).click();
        driver.findElement(By.id("enviar")).click();
        WebElement errorMessage = driver.findElement(By.className("error"));
        if (errorMessage.isDisplayed() && errorMessage.getText().equals("Campo requerido")) {
            System.out.println("Caso de prueba 3: Se muestra el mensaje de error 'Campo requerido' en rojo.");
        } else {
            System.out.println("Caso de prueba 3: El mensaje de error no se muestra correctamente.");
        }

        // Caso de prueba 4
        driver.get("https://www.innocv.com/");
        driver.findElement(By.linkText("Contacto")).click();
        WebElement noticiasSection = driver.findElement(By.id("noticias"));
        List<WebElement> newsDates = noticiasSection.findElements(By.className("date"));
        for (WebElement dateElement : newsDates) {
            String dateText = dateElement.getText();
            
        }

        driver.quit();
    }
}
