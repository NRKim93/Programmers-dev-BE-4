package workspace.wisesaying;

import static workspace.wisesaying.WiseSayingMain.*;

public class WiseSayingDelete {

    public static void DeleteList() {
            System.out.print("삭제? id = ");
            String a = sc.nextLine();
            int id_v = Integer.parseInt(a);

            if(id_list.contains(id_v)) {
                id_list.remove(id_v - 1);
                authur_list.remove(id_v - 1);
                wise_saying_list.remove(id_v - 1);

                System.out.println(id_v + "번 명언이 삭제 되었습니다.");
            } else {
                System.out.println(id_v + "번 명언은 존재하지 않습니다.");
            }




    }
}
