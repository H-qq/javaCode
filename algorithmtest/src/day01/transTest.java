package day01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hongtao
 * @create 2022-04-10-13:32
 */

public class transTest {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        s1.uniqueMorseRepresentations(new String[]{"gin","zen","gig","msg"});

    }
}
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] leter = new String[]{".-", "-...",
                "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-."
                , "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                "...-", ".--", "-..-", "-.--", "--.."};
        int conunt = 1;
        String str = null;
        String[] compare = new String[words.length];
        //将所有单词转换成摩斯密码
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <words[i].length() ; j++) {
                str=leter[words[i].charAt(j) - 'a'];
                compare[i]+=str;
            }
        }
        //转换结束 统计相同的
        //创建一个集合
        List list = new ArrayList();
        //遍历数组往集合里存元素
        for(int i=0;i<compare.length;i++){
            //如果集合里面没有相同的元素才往里存
            if(!list.contains(compare[i])){
                list.add(compare[i]);
            }
        }
        //toArray()方法会返回一个包含集合所有元素的Object类型数组
        Object[] newArr = list.toArray();
        conunt = newArr.length;
        System.out.println(conunt);
        return conunt;
    }
}