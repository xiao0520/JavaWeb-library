package com.config;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
	
    private static Properties properties;
    private static Map<String,Object> beans;
    
    static {
    	
        try {

            properties = new Properties();

            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("daobean.properties");
            properties.load(in);
 
            beans = new HashMap<String,Object>();
    
            Enumeration<Object> keys = properties.keys();
 
            while(keys.hasMoreElements()) {
            	
                String key = keys.nextElement().toString();
     
                String beanPath = properties.getProperty(key);
            
            
                Object value = Class.forName(beanPath).getDeclaredConstructor().newInstance();
                
                beans.put(key,value);
            }
            
            in = BeanFactory.class.getClassLoader().getResourceAsStream("servicebean.properties");
            properties.load(in);
            keys = properties.keys();
            
            while(keys.hasMoreElements())  {
                String key = keys.nextElement().toString();
     
                String beanPath = properties.getProperty(key);
            
            
                Object value = Class.forName(beanPath).getDeclaredConstructor().newInstance();
                
                beans.put(key,value);
            }
            

        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败!");
        }
    }
    
    
    public static Object getBean(String beanName) { return beans.get(beanName);  }
    

}
