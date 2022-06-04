package org.suhong.leetcode.problems.p14;

// https://leetcode.com/problems/longest-common-prefix/
class Solution {

    // misunderstood the question.
    public String longestCommonPrefix1(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < strs.length; i++) {
            int currentStringLength = strs[i].length();
            if (currentStringLength < minLength) {
                minIndex = i;
                minLength = currentStringLength;
            }
        }

        String target = strs[minIndex];
        String longestSuffix = "";
        startOfSuffix:
        for (int i = 0; i < target.length(); i++) {
            String currentLongestSuffix = "";
            lengthOfSuffix:
            for (int j = i + 1; j <= target.length(); j++) {
                String suffix = target.substring(i, j);
                for (int k = 0; k < strs.length; k++) {
                    if (!strs[k].contains(suffix)) {
                        continue lengthOfSuffix;
                    }
                }
                if (currentLongestSuffix.length() < suffix.length()) {
                    currentLongestSuffix = suffix;
                }
            }
            if (currentLongestSuffix.length() > longestSuffix.length()) {
                longestSuffix = currentLongestSuffix;
            }
        }

        return longestSuffix;
    }

    // second shot.
    public String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();
        String firstElement = strs[0];
        for (int i = 0; i < firstElement.length(); i++) {
            char currentCharacter = firstElement.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != currentCharacter) {
                    return builder.toString();
                }
            }
            builder.append(currentCharacter);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String[] strs1 = {"flower","flow","flight"};
        String[] strs2 = {"dog","racecar","car"};
        String[] strs3 = {"ab","a"};

        System.out.println(s.longestCommonPrefix(strs1));
        System.out.println(s.longestCommonPrefix(strs2));
        System.out.println(s.longestCommonPrefix(strs3));
    }
}
