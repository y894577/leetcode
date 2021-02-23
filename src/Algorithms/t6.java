package Algorithms;

public class t6 {
    public static String convert(String s, int numRows) {
        //一组z里元素的个数 方便计算bias
        int setNum = numRows + numRows - 2;
        char[] str = s.toCharArray();
        int length = str.length;

        String change = "";

        if (numRows == 1)
            return s;

        //按照行数迭代
        for (int i = 0; i < numRows; i++) {
            //按照列数迭代
            for (int j = 0; j + i < length; j += setNum) {
                //输出竖列为满的值
                change += str[i + j];
                //排除第一行和最后一行
                int bias = (j / 2 + setNum / 2 - i) * 2 + i;
                if (i != 0 && i != numRows - 1 && bias < length) {
                    //输出间隔空间的值
                    change += str[bias];
                }
            }
        }
        return change;
    }

    public static void main(String[] args) {
        String str = convert("LEETCODEISHIRING", 3);
        System.out.println(str);
    }
}
