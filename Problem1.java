
// for each word we cal hash value by multiplying prime numbers corresponding to each character
// then we group words with same hash value together

import java.util.*;
public class Problem1{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String[] strs={"eat","tea","tan","ate","nat","bat"};
        List<List<String>> grouped = groupAnagrams(strs);

        for (List<String> group : grouped) {
            System.out.println(group);
        }
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Double,List<String>> map=new HashMap<>();
        for(String s:strs){
            double hash=generateHash(s);
            if(!map.containsKey(hash))
                map.put(hash,new ArrayList<>());
            map.get(hash).add(s);
        }
        return new ArrayList<>(map.values());
    }
    public static double generateHash(String word){
        int primes[]=new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
            41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        double hash=1;
        for(char c:word.toCharArray()){
            hash*=primes[c-'a'];
        }
        return hash;
    }
}   