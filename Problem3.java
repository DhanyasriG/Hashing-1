

// We maintain 2 hashmaps: 
// - map1 to map characters from the pattern to words in the string s
// - map2 to map words in s back to characters in the pattern
// - If the character has already been mapped to a different word, return false
// - If the word has already been mapped to a different character, return false
// If we complete the loop without any conflicts, return true

import java.util.*;
public class Problem3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.nextLine();
        String s = sc.nextLine();
        System.out.println(wordPattern(pattern, s));
    }
    public static boolean wordPattern(String pattern, String s) {
        String[] word = s.split(" ");
        if(word.length != pattern.length()) return false;

        HashMap<Character, String> map1 = new HashMap(); //checks pattern to word
        HashMap<String, Character> map2 = new HashMap(); //checks word to pattern
        for(int i=0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            String w=word[i];
            if(map1.containsKey(c)){
                if(!map1.get(c).equals(w))
                    return false;
            }else
                map1.put(c,w);

            if(map2.containsKey(w)){
                if(!map2.get(w).equals(c))
                    return false;
            }else
                map2.put(w,c);    
        }
        return true;
    }
}