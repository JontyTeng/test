package cn.itcast.home;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HomeWork01 {

	public static void main(String[] args) {
	/*	1��
		 map�����������ݣ�(����=2���ƹ�=2.5��������=5������=3������=3.5)
		 a��ʵ��һ��ѯ�ʼ۸�ķ�ʽ(��ȡ�û��ڿ���̨������߲����ƣ�Ȼ���ڸ�map�����в�ѯ��Ӧ�ļ۸�)�У�
		 ��������Ӧ�ļ۸����û������ʾ�û�"�Ѿ�����"
		 b�����ƹϵļ۸��ϵ�1Ԫ(����ֱ�Ӹ�ֵ3.5)
		 c������������ļ۸����3���߲����ƴ�ŵ���ǰ��Ŀ��Ŀ¼�£��ļ����Զ���	 */
		 HashMap<String,Double>hm =   readyDataForMap();// ׼��map��Ҫ������;
		 String str = readStrForConsole();// �Ӽ���¼����Ҫ��ѯ�ʵĻ���
		 askPriceForGoods(hm,str);// ����һ��������ȥѯ����Ʒ�ļ۸�  �� ������: ��Ӧ��Ʒ
		 
		 //  �ѻƹ� ��Ϊkey ȡ������Ӧ��value,��һ���Ż�ȥ: double + int +long -->ת���������������     byte short char-->  ת����int����
		 ergidocMap(hm);//����map  --��value >3  :  ����map���õ����е�key��ͨ��key���ҵ���Ӧ��value  �������жϣ����value >3 ��������
	}
	private static void ergidocMap(HashMap<String, Double> hm) {
		    Set<String> keySet = hm.keySet();
		    Iterator<String> it= keySet.iterator();
		    while(it.hasNext()){ //���������ָ���ǲ��ᶯ��
		    	 // ȡ��Ԫ��
		    	 String next = it.next();
		    	 Double value = hm.get(next);
		    	 if(value > 3){
		    		   System.out.println(next);
		    	 }
		    }
		
	}
	private static void askPriceForGoods(HashMap<String, Double> hm, String str) {
	
		 if(hm.containsKey(str)){
			  // map���������Ʒ
			  System.out.println(str+"���ļ۸���"+hm.get(str));
		 }else{
			  //map�в�����
			  System.out.println("�Ѿ�����");
		 }
	}
	private static String readStrForConsole() {
		System.out.println("��������Ҫ������");
		return new Scanner(System.in).next();
		
	}

	private static HashMap<String, Double> readyDataForMap() {
		HashMap<String, Double> map = new HashMap<String,Double>();
		map.put("����", 2.0);
		map.put("�ƹ�", 2.5);
		map.put("������", 5.0);
		map.put("����", 3.0);
		map.put("����", 3.5);
		return map;
	}
}
