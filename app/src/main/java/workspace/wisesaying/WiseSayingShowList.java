package workspace.wisesaying;

import static workspace.wisesaying.WiseSayingMain.*;

public class WiseSayingShowList {

    public static void ShowList() {
        System.out.println(" 번호 / 작가 / 명언 ");
        System.out.println(" ---------------------- ");
        for(int i = id_list.size()-1; i >= 0; i--) {
            System.out.println(id_list.get(i) + " / " + authur_list.get(i) + " / " + wise_saying_list.get(i));
        }

    }
}
