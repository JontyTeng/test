import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Test01 {
   //���������ǣ�������һ�飬Ů����һ�飬Ҫ��ģ������ͶƱ����0-100(����0��100)��Ʊ����
   //ͬһ���ڲ��ܳ����ظ��ģ�����Ʊ�����������Ǻ�Ʊ������Ů����д�뵽�ļ��У���Ŀ��·���µ�Info.txt)
	public static void main(String[] args) throws Exception {
		 String [] manArr = {"�ܽ���","л����","��ѧ��"};
		 String [] wonArr = {"����֥","����","�������"};
		 // һ�����ǌ���һ��Ʊ�� һ�M���ǌ���һ�MƱ��
		 /**
		  * ��һ���� ��Ҫ��һ����Ӧ��ϵ��map
		  * �ڶ����� �������map��ͨ�����map�е�Ʊ(������Ʊ) ��ö�Ӧ������
		  * �������� ���������д�뵽�ļ���
		  * */
		 // �����ڸ����Ͳ������ʵ�֣���ֻ֪����Ҫ�������map֮�����һ����Ӧ��ϵ  ��Ӧ��ϵ�Ϳ����������
           Map<String,Integer> manMap =  putValueToMap(manArr);		 
           Map<String,Integer> wonMap =  putValueToMap(wonArr);
           // ������һ���� ���Ͼ��Ѿ�����һ�����ж�Ӧ��ϵ��map�� : Ʊ������
           // �ҵ��뷨���Ҳ���ϸ�ڣ� ��ֻ֪�������һ�����������������������һ������׼���õ�map������������ҷ���һ�����Ʊ��������
          String manStar =  ergidocMapForReadNum(manMap);
          String wonStar = ergidocMapForReadNum(wonMap);
           // ����һ���� ��������������
          writeStarToFile(manStar + " " + wonStar);
	}
	private static void writeStarToFile(String str) throws Exception {
		 BufferedWriter bw = new BufferedWriter(new FileWriter("Info.txt"));
		 bw.write(str);
		 bw.close();
	}
	private static String ergidocMapForReadNum(Map<String, Integer> map) {
		//��ֻ֪�������һ�����������������������һ������׼���õ�map������������ҷ���һ�����Ʊ��������
		// ͨ�����Ʊ��ȥ�����������  ͨ�^value  ȥ������Ƕ�Ӧ��key
		// value : ����Ʊ��
		//map.get(key);
		// ��һ���� Ҫ�@������value 
		int max = 0 ;
		for(String key : map.keySet()){
			   Integer value = map.get(key);
			   if(max < value ){
				      max  =   value; 
				    //
			   } 
			   //�Ѿ����������value ������Ʊ 
		}
		String line  = null;
		for(String key : map.keySet()){
			   // �ٴα������map��ȥ��max ��ֵ�Ͷ�Ӧmap.get(key )��ֵ����һ���Աȣ�������max ������һ��ֵ��ȣ���Ϊ���Ʊ��
			   if(max == map.get(key)){  
				   System.out.println(key);
				    line = key;
			   }
		}
	   return line;
	}
	//�����ڸ����Ͳ������ʵ�֣���ֻ֪����Ҫ�������map֮�����һ����Ӧ��ϵ  ��Ӧ��ϵ�Ϳ����������
	private static Map<String, Integer> putValueToMap(String[] arr) {
		//ע�⣺�������Ӧ��ϵ�У�Ʊ���ǲ����ظ���
		Map<String,Integer> map = new HashMap<String,Integer>();
		// map.put(����,Ʊ);  //ע�⣺ �����ǏĔ��M�Ё�Ʊ������Random �S�C���ɵ�
		// ����˭��key��˭��value
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
	// ���ɲ������}���S�C��
	private static HashSet<Integer> createNoRepeatNum(int num) { //num ��Ҫ���������������
		HashSet<Integer> hs= new HashSet<Integer>();
		while(hs.size() < num){
			hs.add(new Random().nextInt(101));
		}
		return hs;
	}
}
