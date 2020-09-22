package org.yasking.easycrud.utils;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class CustomConfigUtil {
    private static ResourceBundle resourceBundle = null;
    private static ResourceBundle resourceBundleActive = null;
    public static Map<String, String> environmentMap = null;
    static {
        resourceBundle = ResourceBundle.getBundle("application");
        resourceBundleActive = ResourceBundle.getBundle("application-"+resourceBundle.getString("spring.profiles.active"));
        environmentMap  = System.getenv();
    }

    /**
     * 得到配置文件中的值
     */
    public static String getString(String key) {
        if(environmentMap.containsKey(key)){
            return environmentMap.get(key);
        }else if(resourceBundleActive.containsKey(key)){
            return resourceBundleActive.getString(key);
        } else if (resourceBundle.containsKey(key)) {
            return resourceBundle.getString(key);
        }
        return null;
    }

    /*
      从配置文件获取动态数据源
     */
    public static Map<String, Object> getDynamicDataSourceMap(String dataSourceName) {

        Map<String, Object> map = new HashMap<String, Object>();

        Enumeration<String> en =  resourceBundleActive.getKeys();

        while (en.hasMoreElements()) {
            String key = en.nextElement();
            if(key.startsWith(dataSourceName)){
                map.put(key.replace(dataSourceName+".", ""), String.valueOf(resourceBundleActive.getString(key)));
            }
        }
        return map;
    }
}
