public class Leetcode67 {
    public String addBinary(String a, String b) {
        char[] achar = a.toCharArray();     //转换成字符数组
        char[] bchar = b.toCharArray();
        int add = 0;        //记录进位，初始时为0
        int lena = a.length();      //记录长度
        int lenb = b.length();

        StringBuilder sb = new StringBuilder();     //存储结果

        for(int i = lena - 1, j = lenb - 1; i >= 0 || j >= 0; i--, j--){
            int sum = 0;        //存储每位和
            if(i >= 0 && j >= 0){       //都没到头
                sum = achar[i] - '0' + bchar[j] - '0' + add;        //则两数相加。原数组为字符数组，注意转换
            }
            else if(i >= 0){        //b到头了，则加a的数
                sum = achar[i] - '0' + add;
            }else{      //a到头了，则加b的数
                sum = bchar[j] - '0' + add;
            }

            if(sum > 1){
                //System.out.println(sum);
                sb.append(sum % 2);     //加上进位，有可能为3，因此本位剩余应用模计算
                add = 1;        //进位重置
            }else{
                //System.out.println(sum);
                sb.append(sum);
                add = 0;
            }
        }

        if(add == 1){       //最后有进位则加入
            sb.append(1);
        }

        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode67 ts = new Leetcode67();
        String a = "1111";
        String b = "1111";
        System.out.println(ts.addBinary(a, b));
    }
}
