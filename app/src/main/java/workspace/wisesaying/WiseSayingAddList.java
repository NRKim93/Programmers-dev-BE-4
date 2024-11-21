package workspace.wisesaying;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static workspace.wisesaying.WiseSayingMain.*;

public class WiseSayingAddList {

    public static void AddList() {
        System.out.print("명언 : ");
        String wise_saying_v = sc.nextLine();
        System.out.print("작가 : ");
        String authur_v = sc.nextLine();

        id_list.add(id);
        authur_list.add(authur_v);
        wise_saying_list.add(wise_saying_v);

        File json_f = new File("C:\\WorkSpace\\WiseSaying\\app\\src\\main\\java\\workspace\\db\\",id+".json");
        File id_f = new File("C:\\WorkSpace\\WiseSaying\\app\\src\\main\\java\\workspace\\db","lastId"+".txt");

        String json = String.format(
                "{ \"id \": %d, \"content \": \"%s\",\"authur\": \"%s\"}", id,wise_saying_v,authur_v
        );

        try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(id_f));
                bw.write(Integer.toString(id));
                bw.close();
                bw = new BufferedWriter(new FileWriter(json_f));
                bw.write(json+"\n");
                bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(id + " 번 명언이 등록되었습니다.");
        id++;
    }
}
