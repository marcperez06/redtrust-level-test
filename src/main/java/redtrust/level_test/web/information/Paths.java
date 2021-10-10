package redtrust.level_test.web.information;

public class Paths {
	
	public static final String FILE_SEPARATOR = System.getProperty("file.separator");
	public static final String USER_DIR = System.getProperty("user.dir");
	
	public static final String RESOURCES_PATH = USER_DIR + FILE_SEPARATOR + "resources" + FILE_SEPARATOR;
	public static final String DRIVERS = RESOURCES_PATH + "drivers" + FILE_SEPARATOR;
	public static final String CHROME_DRIVER = RESOURCES_PATH + "drivers" + FILE_SEPARATOR + "chromedriver.exe";
}
