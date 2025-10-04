package ru.kalugin.ai.yandex.src.com.company;

import java.io.IOException;

public class LongestRepeatingCharacterReplacement424 {


    public static void main(String[] args) throws IOException {
        System.out.println(characterReplacement("AABAAAAAAAABBAAAAAAAAAAAA", 1));
    }

    public static int characterReplacement(String s, int k) {

        int[] count = new int[26];
        int maxCount = 0;
        int maxLength = 0;
        //  var sbStr = "";
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A'] += 1;
            // sbStr = s.substring(left,right+1);
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
            while (right - left + 1 > k + maxCount) {
                count[s.charAt(left) - 'A'] -= 1;
                left++;
                //     sbStr = s.substring(left,right+1);
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

}