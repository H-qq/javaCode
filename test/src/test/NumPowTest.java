package test;

import java.awt.font.NumericShaper;

/*
 * 
 * �۲����������ĳ�����ֵ�ƽ������λ�ۼ���Ȼ��������
1^3=1
8^3=512 5+1+2=8
17^3=4913 4+9+1+3=17
��
����������1��8��17���ڣ�����������ʵ�������һ���ж��ٸ���
 */
public class NumPowTest {
	public static void main(String[] args) {
		int x = 0;
		for (int i = 0; i < 1000; i++) {
			if (num(i*i*i)==i) {
				x+=1;
			}
		}	
		System.out.println(x);
	}
public static int  num(int n) {
	int count = 0;
	if (n!=0) {
		while(n>0) {
		count = count+n%10;
		n = n/10;
		}
	}
	return count;
}	
	
}

