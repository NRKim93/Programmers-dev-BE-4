package workspace.wisesaying;

import static workspace.wisesaying.WiseSayingMain.*;

public class WiseSayingEdit {
    public static void EditList() {

        System.out.print("수정 ? id = ");
        String a = sc.nextLine();
        int id_v = Integer.parseInt(a);
        int idx = id_v -1;

        if(id_list.contains(id_v)) {
            System.out.println("명언(기존) : " + wise_saying_list.get(idx));
            System.out.print("명언 : ");
            String ws_v = sc.nextLine();
            wise_saying_list.set(idx,ws_v);

            System.out.println("작가(기존) : " + authur_list.get(idx));
            System.out.print("작가 : ");
            String at_v  = sc.nextLine();
            authur_list.set(idx,at_v);
        } else  {
            System.out.println(id_v + " 번 명언은 존재하지 않습니다. ");
        }
    }
}
