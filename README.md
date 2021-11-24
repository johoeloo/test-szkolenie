# test-szkolenie     @BeforeEach
     public void setUp() {
         
         try {
             System.setProperty("webdriver.gecko.driver", Paths.get(getClass().getClassLoader()
                     .getResource("drivers/geckodriver.exe").toURI()).toFile().getAbsolutePath());
             
 //            System.setProperty("webdriver.chrome.driver", Paths.get(getClass().getClassLoader()
 //                    .getResource("drivers/chromedriver.exe").toURI()).toFile().getAbsolutePath());
             
         } catch (URISyntaxException e) {
             e.printStackTrace();
         }
 
         driver = new FirefoxDriver();
 //        driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
         driver.manage().deleteAllCookies();
         driver.manage().window().maximize();
         
     }
