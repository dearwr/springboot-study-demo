package com.example.demo.algorithm;

/**
 * 字符串问题
 */
public class StringProblems {

    public static void main(String[] args) {
        char[] a = new char[]{'a', 'b', 'c', 'd', 'c', 'b', 'c'};
        char[] b = new char[]{'b', 'c',};
        char[] c = new char[]{'c', 'b'};
        a = swap(a, b, c);
        System.out.println(a);
    }

    /**
     * A、B、C 是 3 个字符串。把 A 中包含的所有 B 都替换为 C，如果替换以后还有 B 就继续替
     * 换，直到 A 不包含 B 为止。
     * 1. 请编写程序实现以上功能。不允许使用系统提供的字符串比较、查找和替换函数。
     * 2. 以上程序是否总是能正常输出结果？如果不是，列出哪些情况下无法正常输出结果，尽
     * 可能详细和全面。
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static char[] swap(char[] a, char[] b, char[] c) {
        int lenB = b.length;
        int lenC = c.length;
        boolean existB;
        boolean nextLoop = true;
        while (nextLoop) {
            nextLoop = false;
            for (int i = 0; i < a.length - lenB; ) {
                existB = true;
                for (int j = 0; j < lenB; j++) {
                    if (a[i + j] != b[j]) {
                        existB = false;
                        break;
                    }
                }
                if (existB) {
                    a = change(a, c, i, a.length, lenB, lenC);
                    nextLoop = true;
                    i += lenC;
                } else {
                    i++;
                }
            }
        }
        return a;
    }

    private static char[] change(char[] a, char[] c, int i, int lenA, int lenB, int lenC) {
        char[] newA = new char[lenA + lenC - lenB];
        for (int j = 0; j < i; j++) {
            newA[j] = a[j];
        }
        for (int j = 0; j < lenC; j++) {
            newA[i + j] = c[j];
        }
        int index = i + lenC;
        for (int j = i + lenB; j < lenA; j++) {
            newA[index++] = a[j];
        }
        return newA;
    }
}
