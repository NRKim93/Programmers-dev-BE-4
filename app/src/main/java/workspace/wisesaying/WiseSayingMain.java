package workspace.wisesaying;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingMain {
    public static Scanner sc = new Scanner(System.in);
    boolean startFlg = true;
    public static int id = 1;
    String cmd = "";
    public static List<Integer> id_list = new LinkedList<>();
    public static List<String> authur_list = new LinkedList<>();
    public static List<String> wise_saying_list = new LinkedList<>();

    public void Main() {
        System.out.println("== 명언 앱 ==");
        while (startFlg) {
            System.out.print("명령) ");
            cmd = sc.nextLine();

            if (cmd.equals("종료")) {
                sc.close();
                startFlg = false;
            } else if (cmd.equals("등록")) {
                WiseSayingAddList.AddList();
            } else if (cmd.equals("리스트")) {
                WiseSayingShowList.ShowList();
            } else if (cmd.equals("삭제")) {
                WiseSayingDelete.DeleteList();
            } else if (cmd.equals("수정")) {
                WiseSayingEdit.EditList();
            }
        }
    }
}