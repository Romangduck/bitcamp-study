package bitcamp.programmers.ex03;

public class Test12 {
    public String solution(String bin1, String bin2) {
        long newValue = Long.parseLong(bin1, 2) + Long.parseLong(bin2, 2);

        return Long.toBinaryString(newValue);
    }
}

// 이진수 더하기