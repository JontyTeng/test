package cn.itcast.home;

import java.util.Arrays;

public class HomeWork02 {
/*	2、
	 1、定义一个String类型的对象，在对象中存放8位数字。要求：
		A：将字符串索引为3的字符查询出来，并且用a进行替换
		B：使用两种方法在字符串后追加"bcdefd"
		C：将新的字符串中索引能被3整除不能被6整除的字符打印出来  // 将字符串中的数字能被3整除整除不能被6整除的字符打印出来     c/数字  --> int   c恰好能够满足  \
		// 在字符中有一个方法，判断该字符是否是一个数字  --> 
	
	 注：每个需求都需要输出验证*/
	public static void main(String[] args) {
		 
		  String str = "12345846"; //先把字符串转化成字符数组，通过字符数组遍历，拿到每一位元素，再把遍历过程中的 x   =  3 拿出来  --》将这个值给他改变了
		 // char charAt = str.charAt(3);
		 //System.out.println(charAt);
		   String newStr = relaceStr(str);
		// System.out.println(newStr);
		   String newStr2 = addStr(newStr);
		   String newStr3 = addStr2(newStr2);
		   System.out.println(newStr3);
		   printStr(newStr2); 	   
	}

    private static String addStr2(String newStr2) {
    	String concat = newStr2.concat("bcdefd");
	  return concat;
}

	private static void printStr(String newStr2) {// 将字符串转化成数组，拿到数组遍历，拿到他的索引，对索引进行操作
		  //Character.isDigit('3');// 这个字符所对应的内容是否是一个数字
		  char[] charArray = newStr2.toCharArray();
		  for (int i = 0; i < charArray.length; i++) {
			    if(i % 3 == 0 && i %6 != 0  ){
			    	  System.out.println(charArray[i]);
			    }
	      }
    
    	  
    
    }

	private static String addStr(String newStr) {
    	// 不推荐直接使用+
    	//String concat = newStr.concat("bcdefd");
        StringBuilder sb = new StringBuilder();
        sb.append(newStr);
        sb.append("bcdefd");
		return sb.toString();
	}

	private static String relaceStr(String str) {
    	
       char[] charArray = str.toCharArray();
       //增强for 是不能改变数组或者集合中的值
      /* for (int i = 0; i < charArray.length; i++) {
	 	   if( i  == 3 ){
	 		    //是第三个源
	 		  charArray[i] = 'a'; //将字符a 赋值给第三号元素
	 	   }
	    }*/
       charArray[3] = 'a';
       String resultStr = new String(charArray);
	   return resultStr;
    }
}
