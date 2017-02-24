package cn.itcast.home;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HomeWork01 {

	public static void main(String[] args) {
	/*	1、
		 map中有如下数据：(茄子=2，黄瓜=2.5，西红柿=5，土豆=3，豆角=3.5)
		 a、实现一个询问价格的方式(获取用户在控制台输入的蔬菜名称，然后在该map集合中查询对应的价格)有，
		 则输出相对应的价格，如果没有则提示用户"已经卖完"
		 b、将黄瓜的价格上调1元(不能直接赋值3.5)
		 c、将所有输出的价格大于3的蔬菜名称存放到当前项目根目录下，文件名自定义	 */
		 HashMap<String,Double>hm =   readyDataForMap();// 准备map需要的数据;
		 String str = readStrForConsole();// 从键盘录入需要的询问的货物
		 askPriceForGoods(hm,str);// 定义一个方法，去询问商品的价格  ： 参数是: 对应商品
		 
		 //  把黄瓜 作为key 取出来对应的value,加一，放回去: double + int +long -->转化成最大数据类型     byte short char-->  转化成int类型
		 ergidocMap(hm);//遍历map  --》value >3  :  遍历map，拿到所有的key，通过key，找到对应的value  ，进行判断，如果value >3 则进行输出
	}
	private static void ergidocMap(HashMap<String, Double> hm) {
		    Set<String> keySet = hm.keySet();
		    Iterator<String> it= keySet.iterator();
		    while(it.hasNext()){ //这个方法，指针是不会动的
		    	 // 取出元素
		    	 String next = it.next();
		    	 Double value = hm.get(next);
		    	 if(value > 3){
		    		   System.out.println(next);
		    	 }
		    }
		
	}
	private static void askPriceForGoods(HashMap<String, Double> hm, String str) {
	
		 if(hm.containsKey(str)){
			  // map中有这个商品
			  System.out.println(str+"他的价格是"+hm.get(str));
		 }else{
			  //map中不包含
			  System.out.println("已经卖完");
		 }
	}
	private static String readStrForConsole() {
		System.out.println("请输入您要的数据");
		return new Scanner(System.in).next();
		
	}

	private static HashMap<String, Double> readyDataForMap() {
		HashMap<String, Double> map = new HashMap<String,Double>();
		map.put("茄子", 2.0);
		map.put("黄瓜", 2.5);
		map.put("西红柿", 5.0);
		map.put("土豆", 3.0);
		map.put("豆角", 3.5);
		return map;
	}
}
