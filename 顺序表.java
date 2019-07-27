public class MyArrayList(){
	private int [] array;
	private int size;
	public MyArrayList(){
		array = new int[20];
		size = 0;
	}
	//尾插
	public void pushBack(int element){
		array[size++] = elemente;
	} 
	//头插
	public void pushFront(int element){
		for(i = size;i>=1;i++){
			array[i] = array[i-1];
		}
		array[0] = element;
		size++;
	}
	//指定位置插入指定元素
	public void insert (int index,int e){
		for(i = size ; i > index;i--){
			array[i] = array[i-1];
		}
		array(index) = e;
		size++;  
	}
	//尾删
	public void popBack(){
		if(size <= 0){
			System.err.println("顺序表为空")；
			return;
		}
		array[--size] = 0;
	}
	//头删
	public void popFront(){
		for(int i =0;i<size-1;i++){
			array[i] = array[i+1];
		}
		array[--size] = 0;
	}
	//删除指定位置
	public void eaese(int index){
		if(index>=size||index<0){
			System.err.println("输入下标错误");
			return;
		}
		for(int i = index;i<size-1;i++){
			array[i] = array[i+1];
		}
		array[--size] = 0;
	}
	//打印
	public void print(){
		for(int i = 0;i < size ; i++){
			System.out.print(array[i] + ' ');
		}
		System.out.println();
	}
9}
