package shigz.learn.y22.m10.w4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大史 on 2022/10/26
 */
public class ParametersParse {

    public static void main(String[] args) {
        List<String> parameterList = listParameters("xcopy /s c:\\\\ d:\\\\e");
        System.out.println(parameterList.size());
        for (String parameter:parameterList) {
            System.out.println(parameter);
        }
    }

    private static List<String> listParameters(String str) {
        List<String> resultList = new ArrayList<>();
        char[] charArr = str.toCharArray();
        int i = 0;
        int startIndex = 0;
        while (i < charArr.length) {
            if (charArr[i] == ' ') {
                //空格字符
                if (startIndex < i) {
                    //开始和结束字符之间有参数,则参数添加到结果中
                    resultList.add(str.substring(startIndex,i));
                }
                startIndex = i + 1;
                i++;
            } else if (charArr[i] == '"') {
                //引号字符
                //和下一个引号之间的内容添加到结果中
                int nextIndex = str.indexOf("\"",i + 1);
                resultList.add(str.substring(i + 1,nextIndex));
                //开始索引和当前索引都置为下一个引号后
                startIndex = nextIndex + 1;
                i = nextIndex + 1;
            } else {
                //其他字符,当前索引后移
                i++;
            }
        }
        if (startIndex < charArr.length) {
            //若还有剩余字符,则添加到结果中
            resultList.add(str.substring(startIndex));
        }
        return resultList;
    }

}
