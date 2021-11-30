package crawling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CrwalingTest {
	public static String id = "webdriver.chrome.driver";
	public static String path = "E:/chromedriver.exe";

	public static void main(String[] args) {
		int count = 991;
		// 크롬 드라이버 사용하기 위해 로딩
		System.setProperty(id, path);

		// 크롬 브라우저를 열어줄 때 사용할 옵션들 설정할 수 있는 객체
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		String url = "https://www.dhlottery.co.kr/common.do?method=main";
		// 아까 설정해준 옵션들을 기준으로 크롬 드라이버 실행
		WebDriver driver = new ChromeDriver(options);
		// 실행된 드라이버로 주어지는 url 접속시키기
		driver.get(url);

		// 회차 긁어오기
		for (int i = count; i >= 1; i--) {
			System.out.print(driver.findElement(By.id("lottoDrwNo")).getText() + "회 : ");

			// 보너스 번호를 포함한 7개의 요소 긁어오기

			for (WebElement el : driver.findElements(By.className("ball_645"))) {
				System.out.print(el.getText() + " ");

			}
			if(i != 1) {
				//현재 보고 있는 회차가 1이 아닐때
				driver.findElement(By.className("prev")).click();
			}
			System.out.println();
			
			//쓰레드끼리 꼬이지 않게 쉬어주는 구간이다.
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				;
			}
		}
		
		//드라이버 종료하기
		driver.close();
		driver.quit();
	}
}
