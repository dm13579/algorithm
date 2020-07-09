package com.dm;

public class BitMap {

	byte[] bits;		//如果是byte那就一个只能存8个数
	int max;			//表示最大的那个数

	public BitMap(int max) {
		this.max = max;
		bits = new byte[(max >> 3) + 1];		//max/8 + 1
	}	
	public void add(int n) {		//往bitmap里面添加数字
		
		int bitsIndex = n >> 3;		// 除以8 就可以知道在那个byte
		int loc = n % 8;		///这里其实还可以用&运算

		//接下来就是要把bit数组里面的 bisIndex这个下标的byte里面的 第loc 个bit位置为1
		bits[bitsIndex] |= 1 << loc; //
		System.out.println("添加后二进制:"+Integer.toBinaryString(bits[bitsIndex]));
	}

	public void remove(int n){
		int bitsIndex = n >> 3;		// 除以8 就可以知道在那个byte
		int loc = n % 8;		///这里其实还可以用&运算
		System.out.println("删除前二进制:"+Integer.toBinaryString(bits[bitsIndex]));
		bits[bitsIndex] &= ~(1 << loc); //
		System.out.println("删除后二进制"+Integer.toBinaryString(bits[bitsIndex]));
		// 00000000 00000000 00000000 00001000
		// 11111111 11111111 11111111 11110111
		// 00000000 00000000 00000000 00001100
		// 00000000 00000000 00000000 00000100
	}

	public boolean find(int n) {
		int bitsIndex = n >> 3;		// 除以8 就可以知道在那个byte
		int loc = n % 8;		///这里其实还可以用&运算
		
		int flag = bits[bitsIndex] & (1 << loc);	//如果原来的那个位置是0 那肯定就是0 只有那个位置是1 才行
		if(flag == 0) return false;
		return true;
	}
	public static void main(String[] args) {
		BitMap bitMap = new BitMap(200000001);	//10亿
		bitMap.add(2);// 0 ，2
		bitMap.add(3);// 0 ，3
		bitMap.add(65);// 8 ，1
		bitMap.add(66);// 8 ，2

		System.out.println(bitMap.find(3));
		bitMap.remove(3);
		System.out.println(bitMap.find(3));
		System.out.println(bitMap.find(64));
	}
	
}
