package learn.java.concepts;

import java.util.Stack;

public class Try {

    static void main() {
        IO.println(isValid("({[)"));
    }

    public static boolean isValid(String s) {

        Stack<Character> match = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);



                if((c == ')' )&& ('('== match.peek())){
                    match.pop();
                } else if ((c == ']') && ('['==match.peek())){
                    match.pop();
                } else if ((c == '}') && ('{'==match.peek())){
                    match.pop();
                } else {
                    match.push(c);
                }


            IO.println(match);
        }

        return match.empty();

        // Map<Character, Character> paranthesis = new HashMap<>();
        // paranthesis.put('(', ')');
        // paranthesis.put('[', ']');
        // paranthesis.put('{', '}');

        // Stack<Character> match = new Stack<>();

        // match.push('A');

        // for (int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);
        //     if ((paranthesis.get(match.peek()) != null) && (c == paranthesis.get(match.peek()))) {
        //         match.pop();
        //     } else {
        //         match.push(c);
        //     }

        // }

        // return match.size() == 1 ? true : false;
        // int c = 0;
        // Map<Character, Character> paranthesis = new HashMap<>();
        // paranthesis.put('(', ')');
        // paranthesis.put('[', ']');
        // paranthesis.put('{', '}');

        // current_open = s.charAt(0);
        // c++;
        // for (int i = 1; i < s.length(); i++) {

        //     if (!paranthesis.containsKey(current_open)) {
        //         return false;
        //     }

        //     if (s.charAt(i) == (paranthesis.get(current_open))) {
        //         c--;
        //     } else {
        //         current_open = s.charAt(i);
        //         c++;
        //     }
        // }

        // return c == 0 ? true : false;

    }

}
