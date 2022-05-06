package day02;
import java.util.*;
import java.io.*;
import java.math.*;
/**
 * @author hongtao
 * @create 2022-04-11-9:35
 */


public class DiffTest {
    static int N = 100010;
    static int n, L; //n表示发表的论文数量，L表示至多在综述引用的论文数量
    static int[] C = new int[N]; //c[i]表示第i篇论文得到了几次引用

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static boolean check(int x) //判断x是否可以是h指数
    {
        int ans = 0; //统计有多少篇引用次数 >= x的论文
        for(int i = 1; i <= n; i ++ )
        {
            if(C[i] >= x) ans ++;
        }
        if(ans >= x) return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        L = Integer.parseInt(str[1]);
        String[] s = br.readLine().split(" ");
        for(int i = 1; i <= n; i ++ )
            C[i] = Integer.parseInt(s[i - 1]);
        Arrays.sort(C, 1, n + 1); // 从小到大排序

        //确认二分区间
        int l = 1;
        int r = n;
        while(l < r) //二分出最大的,满足条件的h指数
        {
            int mid = l + r + 1>> 1;
            if(check(mid)) l = mid;
            else r = mid - 1;
        }
        //出来的l就是h指数
        //贪心
        for(int i = n; i >= 1; i -- )
        {
            if(L == 0) break;
            if(C[i] <= l) // 让引用次数距离h指数最近的论文，引用次数+1
            {
                C[i] ++;
                L --;
            }
        }
        // 再二分一遍
        l = 1;
        r = n;
        while(l < r)
        {
            int mid = l + r + 1>> 1;
            if(check(mid)) l = mid;
            else r = mid - 1;
        }
        System.out.println(l);
    }
}
