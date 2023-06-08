package bitcamp.project;

import bitcamp.project.util.Prompt;
import bitcamp.project.handler.MemberHandler;

public class App {
  
    public static void main(String[] args) {

      printTitle();

      while (MemberHandler.available()) {
        MemberHandler.inputMember();
        if (!promptContinue()) {
          break;
        }
      }
      MemberHandler.printMembers();
  
      Prompt.close();
    }

    static void printTitle() {
      System.out.println("신체검사 관리 시스템");
      System.out.println("----------------------------------");
    }


    static boolean promptContinue() {
      String response= Prompt.("계속 하시겠습니까?(Y/n) ");
      if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
        return false;
      }
      return true;
    }
  }



