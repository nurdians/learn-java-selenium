import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumExample {
    public static void main(String[] args) {
        // Set lokasi ChromeDriver (ubah path sesuai lokasi driver di komputer Anda)
        System.setProperty("webdriver.chrome.driver", "/Users/nurdian/Downloads/chromedriver-mac-arm64/chromedriver");

        // Inisialisasi WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Buka situs Google
            driver.get("https://www.google.com");

            // Cari elemen input pencarian
            WebElement searchBox = driver.findElement(By.name("q"));

            // Masukkan kata kunci dan kirimkan (tekan Enter)
            searchBox.sendKeys("Apa itu Selenium?");
            searchBox.submit();

            // Tunggu beberapa saat agar hasil muncul (opsional)
            Thread.sleep(3000);

            // Ambil elemen hasil pencarian pertama
            WebElement firstResult = driver.findElement(By.cssSelector("h3"));

            // Cetak teks dari hasil pencarian pertama
            System.out.println("Hasil pertama: " + firstResult.getText());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Tutup browser
            driver.quit();
        }
    }
}
