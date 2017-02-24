import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Test01 {
   //有两组明星，男明星一组，女明星一组，要求模拟网络投票生成0-100(包含0和100)的票数，
   //同一组内不能出现重复的，并将票数最多的男明星和票数最多的女明星写入到文件中（项目根路径下的Info.txt)
	public static void main(String[] args) throws Exception {
		 String [] manArr = {"周杰伦","谢霆锋","张学友"};
		 String [] wonArr = {"張柏芝","王菲","居里夫人"};
		 // 一個明星對應一個票數 一組明星對應一組票數
		 /**
		  * 第一步： 需要搞一个对应关系的map
		  * 第二步： 遍历这个map，通过这个map中的票(是最多的票) 获得对应的明星
		  * 第三步： 将这个明星写入到文件中
		  * */
		 // 我现在根本就不想如何实现，我只知道我要将数组和map之间产生一个对应关系  对应关系就靠我这个方法
           Map<String,Integer> manMap =  putValueToMap(manArr);		 
           Map<String,Integer> wonMap =  putValueToMap(wonArr);
           // 到了这一步： 手上就已经有了一个具有对应关系的map了 : 票和明星
           // 我的想法：我不管细节： 我只知道我设计一个方法，让这个方法遍历上一个方法准备好的map，这个方法替我返回一个最大票数的明星
          String manStar =  ergidocMapForReadNum(manMap);
          String wonStar = ergidocMapForReadNum(wonMap);
           // 到这一步： 我手上有明星了
          writeStarToFile(manStar + " " + wonStar);
	}
	private static void writeStarToFile(String str) throws Exception {
		 BufferedWriter bw = new BufferedWriter(new FileWriter("Info.txt"));
		 bw.write(str);
		 bw.close();
	}
	private static String ergidocMapForReadNum(Map<String, Integer> map) {
		//我只知道我设计一个方法，让这个方法遍历上一个方法准备好的map，这个方法替我返回一个最大票数的明星
		// 通过这个票数去获得最大的明星  通過value  去获得咱们对应的key
		// value : 最大的票數
		//map.get(key);
		// 第一步： 要獲得最大的value 
		int max = 0 ;
		for(String key : map.keySet()){
			   Integer value = map.get(key);
			   if(max < value ){
				      max  =   value; 
				    //
			   } 
			   //已经获得了最大的value 即最大的票 
		}
		String line  = null;
		for(String key : map.keySet()){
			   // 再次遍历这个map，去将max 的值和对应map.get(key )的值进行一个对比，如果这个max 和其中一个值相等，即为最大票数
			   if(max == map.get(key)){  
				   System.out.println(key);
				    line = key;
			   }
		}
	   return line;
	}
	//我现在根本就不想如何实现，我只知道我要将数组和map之间产生一个对应关系  对应关系就靠我这个方法
	private static Map<String, Integer> putValueToMap(String[] arr) {
		//注意：在这个对应关系中，票数是不可重复的
		Map<String,Integer> map = new HashMap<String,Integer>();
		// map.put(名字,票);  //注意： 名字是從數組中來，票是利用Random 隨機生成的
		// 到底谁是key，谁是value
		  HashSet<Integer> hs = createNoRepeatNum(arr.length);
		  Iterator<Integer> it = hs.iterator();
		  for (int i = 0; i < arr.length; i++) {
			 if(it.hasNext()){
				 int next = it.next();
			     map.put(arr[i], next);
			 }
		}
		 System.out.println(map);
		return map;
	}
	// 生成不帶重複的隨機數
	private static HashSet<Integer> createNoRepeatNum(int num) { //num 是要产生的随机数个数
		HashSet<Integer> hs= new HashSet<Integer>();
		while(hs.size() < num){
			hs.add(new Random().nextInt(101));
		}
		return hs;
	}
}
