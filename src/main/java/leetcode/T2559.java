package leetcode;

public class T2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] isVowelSum = new int[words.length+1];
        int[] queriesRes = new int[queries.length];
        for (int i = 1; i < words.length+1 ; i++) {
            isVowelSum[i] = isVowelSum[i-1];
            if (isVowel(words[i-1])) isVowelSum[i] += 1;
        }
        for (int i = 0; i < queries.length; i++) {
            queriesRes[i] = isVowelSum[queries[i][1]+1] - isVowelSum[queries[i][0]];
        }
        return queriesRes;
    }

    private boolean isVowel(String word) {
        char[] Vowel = new char[]{'a','e','i','o','u'};
        boolean beginIs = false;
        boolean endIs = false;
        for(char ch : Vowel){
            if (ch == word.charAt(0)) beginIs = true;
            if (ch == word.charAt(word.length()-1)) endIs = true;
        }
        return beginIs&&endIs;
    }
}
