package cn.itcast.home;

import java.util.Arrays;

public class HomeWork02 {
/*	2��
	 1������һ��String���͵Ķ����ڶ����д��8λ���֡�Ҫ��
		A�����ַ�������Ϊ3���ַ���ѯ������������a�����滻
		B��ʹ�����ַ������ַ�����׷��"bcdefd"
		C�����µ��ַ����������ܱ�3�������ܱ�6�������ַ���ӡ����  // ���ַ����е������ܱ�3�����������ܱ�6�������ַ���ӡ����     c/����  --> int   cǡ���ܹ�����  \
		// ���ַ�����һ���������жϸ��ַ��Ƿ���һ������  --> 
	
	 ע��ÿ��������Ҫ�����֤*/
	public static void main(String[] args) {
		 
		  String str = "12345846"; //�Ȱ��ַ���ת�����ַ����飬ͨ���ַ�����������õ�ÿһλԪ�أ��ٰѱ��������е� x   =  3 �ó���  --�������ֵ�����ı���
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

	private static void printStr(String newStr2) {// ���ַ���ת�������飬�õ�����������õ��������������������в���
		  //Character.isDigit('3');// ����ַ�����Ӧ�������Ƿ���һ������
		  char[] charArray = newStr2.toCharArray();
		  for (int i = 0; i < charArray.length; i++) {
			    if(i % 3 == 0 && i %6 != 0  ){
			    	  System.out.println(charArray[i]);
			    }
	      }
    
    	  
    
    }

	private static String addStr(String newStr) {
    	// ���Ƽ�ֱ��ʹ��+
    	//String concat = newStr.concat("bcdefd");
        StringBuilder sb = new StringBuilder();
        sb.append(newStr);
        sb.append("bcdefd");
		return sb.toString();
	}

	private static String relaceStr(String str) {
    	
       char[] charArray = str.toCharArray();
       //��ǿfor �ǲ��ܸı�������߼����е�ֵ
      /* for (int i = 0; i < charArray.length; i++) {
	 	   if( i  == 3 ){
	 		    //�ǵ�����Դ
	 		  charArray[i] = 'a'; //���ַ�a ��ֵ��������Ԫ��
	 	   }
	    }*/
       charArray[3] = 'a';
       String resultStr = new String(charArray);
	   return resultStr;
    }
}
