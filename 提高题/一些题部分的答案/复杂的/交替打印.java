package cn.itcast.test;

public class Test02 {
	// 2．已知一个数组[2,4,6,2,1,5],将该数组进行排序（降序，不能用工具类进行排序），创建两条线程交替输出排序后的数组，线程名自定义
	public static void main(String[] args) {
		int[] arr = { 2, 4, 6, 2, 1, 5 };
		sortArr(arr);
		MyThread mt = new MyThread(arr);
		new Thread(mt, "线程1").start();
		new Thread(mt, "线程2").start();
	}

	private static void sortArr(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}

class MyThread implements Runnable {

	int[] arr = null;

	public MyThread(int[] arr) {
		this.arr = arr;
	}
	int i = 0;
	boolean falg = true;
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		while (true) {
			synchronized (this) {
			  if (i >= 6) {
				    this.notify();
					break;
			  }
			 /* if(i % 2 == 0 && name.equals("线程1")){
				  System.out.println(name +"  "+ arr[i]);
			      i++;
			  }else if(i % 2 == 1 && name.equals("线程2")){
				  System.out.println(name+"  "+arr[i]);
			      i++;
			  }*/
			 if(falg){
				 falg = false;
				 this.notify();
				 System.out.println(name+"  "+arr[i]);
				 i++;
				 
				 try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }else{
				 falg = true;
				 this.notify();
				 System.out.println(name+"  "+arr[i]);
				 i++;
				 try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 }
		      
			}
		}
	}

}
