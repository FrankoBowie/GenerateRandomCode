import java.util.ArrayList;
import java.util.Scanner;
import java.security.SecureRandom;

public class Main {
  private static final SecureRandom generateNumRandom = new SecureRandom();

  public static void main(String[] args) {
    ArrayList<String> codeString = new ArrayList();
    Scanner sc = new Scanner(System.in);
    char answ = '';
    boolean flag;
    String code = newCode();
    System.out.println("Código Aleatorio: " + code); // Translate: Random Code
    codeString.add(code);
    do {
      System.out.println("¿Desea crear otro código aleatorio? [Si: Ss No: Nn]"); 
      // Translate: Want to create other random code? [Yes: Ss No: Nn]
      answ = sc.next().charAt(0);
      if (answ == s || answ == S) {
        do {
          code = newCode();
          flag = codeComp(code, codeString);
        } while (flag == true);
        codeString.add(code);
        System.out.println("Código Aleatorio : " + code); // Translate: Random Code
      } else {
        break;
      }
    } while (answ == 1);
    sc.close();
  }

  public static String newCode() {
    int numRandom = 1 + generateNumRandom.nextInt(9998);
    String numString = String.valueOf(numRandom);
    int dignum = numString.length();
    String code = "";
    switch (dignum) {
      case 1:
        code = "00000" + numRandom;
        break;
      case 2:
        code = "0000" + numRandom;
        break;
      case 3:
        code = "000" + numRandom;
        break;
      case 4:
        code = "00" + numRandom;
        break;
    }
    return code;
  }

  public static boolean codeComp(String code, ArrayList<String> codeString) {
    boolean flag = false;
    for (int i = 0; i < codeString.size(); i++) {
      if (code.equals(codeString.get(i))) {
        flag = true;
      } else {
        flag = false;
      }
    }
    return flag;
  }
}
