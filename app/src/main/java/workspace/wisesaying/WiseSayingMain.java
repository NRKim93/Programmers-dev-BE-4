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
//프로그램 시작점이어디있나요?
//App.java에서 WiseSayingMain.java를 호출하고 있습니다. 
//그건 아닌데 혹시 원래 실행하던 방식대로 프로그램 실행해보실수있을까요?
//수업외적인것이라 놓친것은 없습니다 .PowerShell에 chcp 65001 옵션을 입력해준게 제대로 적용된것같습니다. 이만 가보겠습니다...
//감사합니다. 