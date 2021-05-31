package String;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Given a string s, check if the letters can be rearranged so that two characters that are adjacent to each other
are not the same.
If possible, output any possible result.  If not possible, return the empty string.
 */
public class reorganiziing_string {
    public static void main(String[] args){
        String s = "aab";
        System.out.println(reOrganize(s));
        System.out.println(Reorganize(s));
    }
// using heap and hashing
    private static String Reorganize(String S) {
        int freq[] = new int[26];
        for (char c : S.toCharArray()) freq[c - 'a']++;

        boolean canform = check(freq);
        if (!canform) return "";

        PriorityQueue<Pair> pq = new PriorityQueue<> (new CustomSort ());
        for (int i=0; i<26; i++) if (freq[i] > 0) pq.add(new Pair(freq[i], i));

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Pair p1 = pq.poll();
            Pair p2 = pq.poll();

            if (p1 != null) sb.append((char)(p1.index + 'a'));
            if (p2 != null) sb.append((char)(p2.index + 'a'));

            if (p1 != null && p1.freq-1 > 0) pq.add(new Pair(p1.freq-1, p1.index));
            if (p2 != null && p2.freq-1 > 0) pq.add(new Pair(p2.freq-1, p2.index));
        }
        return sb.toString();
    }

    private static boolean check(int[] freq) {
        int totalSum = 0;
        for (int a : freq) totalSum += a;
        for (int a : freq) if (totalSum - a < a-1) return false;
        return true;
    }

    // using hashmap and priority queue
    private static String reOrganize(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        PriorityQueue<Character> heap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        heap.addAll(map.keySet());

        while(heap.size() > 1){
            char first = heap.poll();
            char second = heap.poll();

            res.append(first);
            res.append(second);

            map.put(first, map.get(first)-1);
            if(map.get(first) >= 1){
                heap.offer(first);
            }
            map.put(second, map.get(second)-1);
            if(map.get(second) >= 1){
                heap.offer(second);
            }
        }
        if(!heap.isEmpty()){
            char lastChar = heap.poll();
            if(map.get(lastChar) > 1){
                return "";
            }else{
                res.append(lastChar);
            }
        }

        return res.toString();
    }
}

class Pair{
    int freq;
    int index;

    public Pair(int freq, int index) {
        this.freq = freq;
        this.index = index;
    }
}

class CustomSort implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
        if (p1.freq == p2.freq) return p1.index - p2.index;
        return p2.freq - p1.freq;
    }
}
