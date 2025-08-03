
// we maintain two hashmaps to map characters from string s to t and vice versa.
// if we find a character in s that has already been mapped to a different character in t, we return false
// similarly, if we find a character in t that has already been mapped to a different character in s, we return false
// if we can traverse both strings without conflicts, we return true

import java.util.*;

class Problem2 {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       String s=sc.nextLine();
       String t=sc.nextLine();
       System.out.println(isIsomorphic(s, t));
    }
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sMap.containsKey(sChar)) {
                if (sMap.get(sChar) != tChar) return false;
            } else {
                sMap.put(sChar, tChar);
            }
            if (tMap.containsKey(tChar)) {
                if (tMap.get(tChar) != sChar) return false;
            } else {
                tMap.put(tChar, sChar);
            }
        }
        return true;
    }
}
