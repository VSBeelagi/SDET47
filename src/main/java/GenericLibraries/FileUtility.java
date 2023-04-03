package GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	
	/**
	 * This method is used to read data from property file
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author Vijayalaxmi
	 */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.FilePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}

}
