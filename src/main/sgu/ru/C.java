package main.sgu.ru;

import java.nio.charset.Charset;
import java.util.Random;

public class C {
    private final Integer RANDOM_STR_LEN = 10;
    private final Integer ROUNDS_NUM = 100000;

    private String classicString() {
        String result = new String();
        for (int i = 0; i < ROUNDS_NUM; i++) {
            String generatedString = genRandomStr(RANDOM_STR_LEN);
            result += generatedString;
        }
        return result;
    }

    private StringBuffer stringBuffer() {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < ROUNDS_NUM; i++) {
            String generatedString = genRandomStr(RANDOM_STR_LEN);
            result.append(generatedString);
        }
        return result;
    }

    private StringBuilder stringBuilder() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < ROUNDS_NUM; i++) {
            String generatedString = genRandomStr(RANDOM_STR_LEN);
            result.append(generatedString);
        }
        return result;
    }

    private String genRandomStr(Integer charNums) {
        byte[] array = new byte[charNums];
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-16"));
        
        return generatedString;
    }

    public void main(String[] args) {
        long start = System.currentTimeMillis();
        classicString();
        System.out.println("Classic String: " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        stringBuffer();
        System.out.println("String Buffer: " + (System.currentTimeMillis() - start) + " мс");

        start = System.currentTimeMillis();
        stringBuilder();
        System.out.println("String Builder: " + (System.currentTimeMillis() - start) + " мс");
    }
}
