package cn.itcast.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		/*
		 * ���߳�ģ�⾺�Ĺ��� ���������̣߳��������ˣ������߳����Ʒֱ�Ϊ�����������������������¡����������á����������ġ�����������һ�����Ծ��ģ��Σ�
		 * ÿ�ξ��ĳ��ļ�Ϊ����100����������100�����������ÿ�γ�����Ҫ3000ms,
		 * ����1��map����<�߳���������>�����ĸ��˴����ȥ������Ĭ��Ϊ0����ʼ���ۺ�ÿ����ÿ�γ��ļ۴�Ž�ȥ��
		 * ���Ľ�������ÿ����������Ϊ׼�������ļ���ߵ��߳����ͳɽ��۴�ӡ���� ��ӡ��ʽ���£� ����A��98Ԫ�ļ۸�ɽ�
		 */
		Map<String,Integer> map = new HashMap<String,Integer>();
		String [] arr = {"����A","����B","����C","����D"};
	/*	map.put("����A", 0);*/
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
	int count = 0;//�������ݣ�һ��8��
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
		  	System.out.println(name+"���r��"+randomNum+"Ԫ");
		}
	}
	private void printMap(Map<String, Integer> map) {
	    // Ŀǰ�׶Σ�����������һ��map��������ҵ�map������ֵ����Ӧ��key�أ�
		int max = 0;
	    for(String key :map.keySet()){
	    	 int value = map.get(key);
	    	 if(max < value){
	    		 max =  value;
	    	 }
	    }
	   for(String key : map.keySet()){
		    if(max == map.get(key)){
//		    	  ˵���������ֵ����Ӧ��key�Ѿ��ҵ�
		    	 System.out.println(key+"���������ֵ�����ֵ��"+map.get(key));
		    }
	   }
	}
}