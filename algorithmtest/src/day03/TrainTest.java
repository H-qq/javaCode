package day03;

import java.util.Scanner;

/**
 * @author hongtao
 * @create 2022-04-13-11:03
 */

public class TrainTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] Nui = new int[m][n];
        //赋值
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Nui[i][j] = scanner.nextInt();
            }
        }
        //遍历牛
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                int a = i;
                int b = j;
                int maxa = 0;
                int maxb = 0;
                for (int k = 0; k < m; k++) {
                    int proa = 0;
                    int prob = 0;
                    for (int l = 0; l < n; l++) {
                        if (Nui[k][l]==a){
                            proa = l;
                        }
                        if (Nui[k][l]==b){
                            prob = l;
                        }
                    }
                    if (proa<prob){
                        maxa+=1;
                    }
                    if (proa>prob){
                        maxb+=1;
                    }
                }
                if (maxa==m || maxb==m){
                    count+=1;
                }

            }
        }
        System.out.println(count);
    }
}
