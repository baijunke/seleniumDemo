

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDirverDemoThree {
	
	public static void main(String[] args) {
		//加载浏览器驱动
		System.setProperty("webdriver.gecko.driver","C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");
		//创建webDriver
		WebDriver driver = new FirefoxDriver();
		//隐式等待
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//浏览器请求网址
		driver.get("http://www.51zxw.net/");  
//		driver.navigate().to("http://www.51zxw.net/");
//		driver.navigate().forward();   //向前导航
//		driver.navigate().back();		//导航回
        //请求结束，最大化浏览器窗口
        driver.manage().window().maximize();
        //显示等待，等待用户名输入框出现，，如果等待时常超出10秒则抛出异常
//        WebElement nameBox = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        //获取用户名元素
        WebElement nameBox = driver.findElement(By.name("username"));
        //赋值
        nameBox.sendKeys("沟边边的一支穿云箭");
        WebElement pwd = driver.findElement(By.name("password"));
        pwd.sendKeys("bai259775");
        //获取下拉框
        Select sele = new Select(driver.findElement(By.name("CookieDate")));
        //选择显示值
        sele.selectByVisibleText("留一月");
        
        /*driver.findElement(By.xpath("/html/body/header/div/div/a[2]")).click();
        driver.findElement(By.xpath("//*[@id='TANGRAM__PSP_10__userName']")).sendKeys("10485@qq.com");;*/
        //获取文本框中值
        String result = pwd.getAttribute("value");
        System.out.println(result);
        /*WebElement nameBox2 = nameBox1.findElement(By.id("cnt-box")).findElement(By.className("m-cnt")).findElement(By.className("m-container")).findElement(By.id("account-box"));
        nameBox2.findElement(By.name("email")).sendKeys("10485");;*/
        //获取登陆按钮
        WebElement btn = driver.findElement(By.className("lobtn"));  
        try {
        	//线程睡眠三秒，目的是看下值是否输入
        	Thread.sleep(3000);
        	btn.click();
        	
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[6]/table[1]/tbody/tr/td[1]/table/tbody/tr[2]/td/div/div/div[1]/dl[1]/dd/a[1]")).click();
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //退出驱动程序并关闭该驱动程序的所有相关窗口。
        //driver.quit();
        //关闭浏览器
        driver.close(); 
	}
}
