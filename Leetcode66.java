//实现整数数组组成的数字加一

public class Leetcode66 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if(digits[len-1] < 9){      //最后一位不是9时，直接最后一位加一即可
            digits[len-1]++;
            return digits;
        }

        StringBuilder sb = new StringBuilder();     //StringBuilder存储序列
        int add = 1;        //由于要加一，进位置为1
        for(int i = len - 1; i >= 0; i--){      //从右往左
            int sum = digits[i] + add;      //和
            if(sum >= 10){      //有进位
                digits[i] = 0;      //当前为0
                sb.append(digits[i]);       //加入序列，进位置一
                add = 1;
            }else{      //无进位
                digits[i] = sum;        //当前位即为和
                sb.append(digits[i]);
                add = 0;        //进位置零
            }
        }
        if(add == 1){       //最后若有进位则加入序列
            sb.append(add);
        }

        char[] tmp = sb.reverse().toString().toCharArray();     //反序得到序列
        int[] res = new int[tmp.length];
        for(int i = 0; i < tmp.length; i++){        //得到整数数组
            res[i] = tmp[i] - '0';
        }

        return res;
    }

    public static void main(String[] args) {
        Leetcode66 ts = new Leetcode66();
        int[] t = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        for(int each : ts.plusOne(t)){
            System.out.println(each);
        }
    }
}
