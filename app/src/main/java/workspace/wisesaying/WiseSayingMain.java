package workspace.wisesaying;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingMain {
    public static Scanner sc = new Scanner(System.in,"EUC-KR");
    boolean startFlg = true;
    public static int id = 1;
    String cmd = "";
    public static List<Integer> id_list = new LinkedList<>();
    public static List<String> authur_list = new LinkedList<>();
    public static List<String> wise_saying_list = new LinkedList<>();

    public void Main() throws Exception {
        System.out.println("== 명언 앱 ==");
        while (startFlg) {
            System.out.print("명령) ");
            cmd = sc.nextLine();
            if (cmd.trim().equals("종료")) {
                sc.close();
                startFlg = false;
            } else if (cmd.trim().equals("등록")) {
                WiseSayingAddList.AddList();
            } else if (cmd.trim().equals("목록")) {
                WiseSayingShowList.ShowList();
            } else if (cmd.trim().equals("삭제")) {
                WiseSayingDelete.DeleteList();
            } else if (cmd.trim().equals("수정")) {
                WiseSayingEdit.EditList();
            } else if (cmd.trim().equals("빌드")) {
                WiseSayingBuild.BuildList();
            }
        }
    }
}