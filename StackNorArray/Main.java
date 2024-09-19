package StackNorArray;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aman
 */
public class Main {

    public static boolean checkString(String str) {
        StackNorArray<Character> S = new StackNorArray<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[')
                S.push(ch);
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (S.isEmpty() || !isPair(S.peak(), ch)) {
                    return false;
                } else {
                    S.pop();
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkString("{([)}"));
        StackNorArray<Integer> Stack = new StackNorArray<>();
        Stack.push(3);
        Stack.push(6);
        Stack.push(1);
        Stack.push(4);
        Stack.push(5);
        System.out.println(Stack.toString());
        deleteSecOdd(Stack);
        System.out.println(Stack);
    }

    private static boolean isPair(char begin, char end) {
        if (begin == '(' && end == ')')
            return true;
        if (begin == '{' && end == '}')
            return true;
        if (begin == '(' && end == ')')
            return true;
        return false;
    }

    private static void deleteSecOdd(StackNorArray<Integer> S) {
        StackNorArray<Integer> Temp = new StackNorArray<>();
        while (!S.isEmpty()) {
            Temp.push(S.pop());
        }
        int c = 0;
        while (!Temp.isEmpty()) {
            Integer Data = Temp.pop();
            if (Data % 2 == 1) {
                c++;
                if (c == 2) {
                    continue;
                }
            }
            S.push(Data);
        }
    }
}
