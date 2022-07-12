package org.suhong.leetcode.problems.p278;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

// https://leetcode.com/problems/first-bad-version/
class Solution extends VersionControl {

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int mid = (start + end) / 2;
        while (start <= end) {
            if (isBadVersion(mid)) {
                end = mid-1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        return mid;
    }

    public static void main(String[] args) {

    }

}

class VersionControl {

    boolean isBadVersion(int version) {
        Versions versions = new Versions(4);
        if (version >= 4) return true;
        return false;
    }
}

class Versions {

    private int firstBadVersion;

    public Versions(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
    }

}