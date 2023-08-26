package bitcamp.programmers.ex03;

class Test9 {
    public int solution(int num, int k) {
        int answer = -1; 
        String[] arr = String.valueOf(num).split("");
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(String.valueOf(k))) {
                answer = i + 1;
                break; 
            }
        }
        
        return answer;
    }
}

//숫자 찾기
