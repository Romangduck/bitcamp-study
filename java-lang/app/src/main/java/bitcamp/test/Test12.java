package test;

public class Test12 {
  public static void main(String[] args) {
    int count = 0;
    int sum = 0;


    count = 0;
    sum = 0;
    while (count < 100) {
      count++;
      if ((count & 1) == 0) { // count & 1 ==> count & 0x01 ==> count % 2
        sum += count;
      }
    }
    System.out.printf("count=%d, sum=%d\n", count, sum);


    System.out.println("------------------------");

    count = 0;
    sum = 0;
    while (count < 100) {
      count++;
      if (count % 2 == 0)
        continue; // 다음 문장을 실행하지 않고 즉시 조건 검사로 이동한다.
      sum += count;
    }

    System.out.printf("count=%d, sum=%d\n", count, sum);

    // int count = 0;
    // int sum = 0;

    // 1부터 100까지의 카운트를 하는데 단 합은 50까지만 계산한다.
    // => break 사용 전
    count = 0;
    sum = 0;
    while (count < 100) {
      count++;
      if (count > 50) // 50을 넘어가면 합을 수행하지 않지만 100까지 계속 반복한다.
        continue;
      sum += count;
    }
    System.out.printf("count=%d, sum=%d\n", count, sum);


    count = 0;
    sum = 0;
    while (count < 100) {
      count++;
      if (count > 50) // 50을 넘어가면 합을 수행하지 않지만 100까지 계속 반복한다.
        continue;
      sum += count;
    }
    System.out.printf("count=%d, sum=%d\n", count, sum);

    System.out.println("------------------------");

    // => break 사용 후
    count = 0;
    sum = 0;
    while (count < 100) {
      count++;
      if (count > 50)
        break; // 즉시 반복문을 종료하고 나간다.
      sum += count;
    }
    System.out.printf("count=%d, sum=%d\n", count, sum);

  }
}




 