package bitcamp.rdp;

import java.util.Scanner;

public class Test1 {
  public static void main(String[] args) {
    System.out.println("공동현관 사용자 등록 시스템"); //A
    System.out.println("------------------------");

    // 키보드 스캐너 준비
    Scanner sc = new Scanner(System.in);

    final int MAX_SIZE = 100;
    int userId = 1;
    int length = 0;

    // 호수 정보 등록
    int[] no = new int[MAX_SIZE];
    int[] bdno = new int[MAX_SIZE];
    int[] roomno = new int[MAX_SIZE];
    int[] password = new int[MAX_SIZE];

    for (int i = 0; i < MAX_SIZE; i++) {
      System.out.print("몇동에 사십니까?"); //B
      int bdno1 = sc.nextInt();

      // 201~205동
      if (bdno1 >= 201 && bdno1 <= 205) {
        bdno[i] = bdno1;
      } else {
        System.out.println("없는 동입니다."); //C
        
      }

      System.out.print("몇호에 사십니까?"); //D
      int roomno1 = sc.nextInt();

      // 101~506호, 호수 끝자리 1~6
      if ((roomno1 >= 101 && roomno1 <= 506) && (roomno1 % 100 >= 1 && roomno1 % 100 <= 6)) {
        roomno[i] = roomno1;
      } else {
        System.out.println("없는 호수입니다."); //E
        
      }

      System.out.print("암호를 설정해주세요: "); //F
      int password1 = sc.nextInt();
      if (password1 >= 0 && password1 <= 9999) && (String.format("%04d", i));{
        password[i] = password1;
      } else {
        System.out.println("암호를 재설정해주세요.");
        continue;
      }

      no[i] = userId++;

      length++;

      System.out.print("계속 하시겠습니까?(Y/n) ");//G
      sc.nextLine(); // 이전에 nextInt()를 실행한 후 남아 있던 줄바꿈 코드를 제거한다.
      String response = sc.nextLine();
      if (!response.equalsIgnoreCase("Y")) {
        break;
      }
    }

    for (int i = 0; i < length; i++) {
      System.out.println("---------------------------------------");
      System.out.printf("동: %d, 호수: %d, 비밀번호: %d\n", bdno[i], roomno[i], password[i]);
      System.out.println("---------------------------------------");
    }

    sc.close();
  }
}
// System.out.println(" 몇호에 사십니까 ?: ");
// roomno[i] = sc.next();

// System.out.println(" 암호를 설정해주세요. ");
// password[i] = sc.next();
