// aaabbbaabb

import java.util.HashMap;

public class Count {
    public static void main(String[] args) {
        String str = "aaabbbaabb";
        // System.out.println("Enter String: ");
        
        // int count_a = 0, count_b = 0;

        // for(int i=0; i<str.length(); i++) {
        //     Character ch = str.charAt(i);
        //     if(ch == 'a') {
        //         count_a++;
        //     } else if (ch == 'b') {
        //         count_b++;
        //     }
        // }
        // System.out.println("a: "+count_a);
        // System.out.println("b: "+count_b);

        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i=0; i<str.length(); i++) {
            Character ch = str.charAt(i);

            if(hm.containsKey(ch)) {
                hm.put(ch, (hm.get(ch)+1));
            } else {
                hm.put(ch, 1);
            }
        }

        

        System.out.println(hm);
    }
}

// name, id, salary

// SELECT name from EMP_TABLE ASC;