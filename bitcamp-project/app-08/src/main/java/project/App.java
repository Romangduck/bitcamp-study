package project;

import project.util.Prompt;
import project.handler.MemberHandler;

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
      System.out.println("신체검사");
      System.out.println("----------------------------------");
    }


    static boolean promptContinue() {
      String response= Prompt.inputString("계속 하시겠습니까?(Y/n) ");
      if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
        return false;
      }
      return true;
    }
  }



