package com.design.mode.singleton;
/**
 *  A Singleton , we can only create one instance
 */
public class SingletonA  {
	
	 private volatile static SingletonA singletonA;
	 private SingletonA() {}
	   public static SingletonA getSingletonA() {
		   if (singletonA == null) {  
			          synchronized (SingletonA.class) {  
			            if (singletonA == null) {  
			            	singletonA = new SingletonA();  
			            }  
			          }  
			     }  
			      return singletonA;  
			   }  
}