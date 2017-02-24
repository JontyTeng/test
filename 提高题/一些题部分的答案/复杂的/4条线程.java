package cn.itcast.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		/*
		 * 用线程模拟竞拍过程 创建４条线程，代表４个人，设置线程名称分别为：（“匿名Ａ”，“匿名Ｂ”，“匿名Ｃ”，“匿名Ｄ”）。４个人一共可以竞拍８次，
		 * 每次竞拍出的价为１－100（包含１和100）的随机数，每次出价需要3000ms,
		 * 创建1个map集合<线程名，出价>将这四个人存入进去，出价默认为0，开始竞价后将每个人每次出的价存放进去，
		 * 竞拍结束后以每个人最后出价为准。将竞拍价最高的线程名和成交价打印出来 打印格式如下： 匿名A以98元的价格成交
		 */
		Map<String,Integer> map = new HashMap<String,Integer>();
		String [] arr = {"匿名A","匿名B","匿名C","匿名D"};
	/*	map.put("匿名A", 0);*/
		for (int i = 0; i < arr.length; i++) {
			  map.put(arr[i], 0);
		}
		MyRunnable mr = new MyRunnable(map);
		for (String temp : arr) {
			  new Thread(mr,temp).start();;
		}
	}
}
class MyRunnable implements Runnable{

	Map<String,Integer> map   = new HashMap<String,Integer>();
	public MyRunnable(Map<String,Integer> map){
		 this.map = map;
	}
	int count = 0;//共享数据，一共8次
	int resultNum =  0;
	@Override
	public void run() {
		int randomNum  = 0;
		String name = Thread.currentThread().getName();
		while(true){
			synchronized (this) {
			if(count >= 8){
				resultNum++;
				if(resultNum == 4){
					 printMap(map);
				}
				 break;
			}
			randomNum = new Random().nextInt(100)+1;
			map.put(name, randomNum);
			count++;
			}
		  	System.out.println(name+"出價了"+randomNum+"元");
		}
	}
	private void printMap(Map<String, Integer> map) {
	    // 目前阶段，我手上有了一个map，那如何找到map中最大的值所对应的key呢？
		int max = 0;
	    for(String key :map.keySet()){
	    	 int value = map.get(key);
	    	 if(max < value){
	    		 max =  value;
	    	 }
	    }
	   for(String key : map.keySet()){
		    if(max == map.get(key)){
//		    	  说明咱们最大值所对应的key已经找到
		    	 System.out.println(key+"抽中了最大值且最大值是"+map.get(key));
		    }
	   }
	}
}