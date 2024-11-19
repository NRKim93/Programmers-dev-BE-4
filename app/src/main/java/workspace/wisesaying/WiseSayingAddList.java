package workspace.wisesaying;

import static workspace.wisesaying.WiseSayingMain.*;

public class WiseSayingAddList {

    public static void AddList() {
        System.out.print("명언 : ");
        String authur_v = sc.nextLine();
        System.out.print("작가 : ");
        String wise_saying_v = sc.nextLine();

        id_list.add(id);
        authur_list.add(authur_v);
        wise_saying_list.add(wise_saying_v);

        System.out.println(id + " 번 명언이 등록되었습니다.");
        id++;
    }
}
