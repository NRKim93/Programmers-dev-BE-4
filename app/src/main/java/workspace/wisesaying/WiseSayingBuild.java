package workspace.wisesaying;

import static workspace.wisesaying.WiseSayingMain.authur_list;
import static workspace.wisesaying.WiseSayingMain.id_list;
import static workspace.wisesaying.WiseSayingMain.wise_saying_list;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WiseSayingBuild {

    public static void BuildList() throws Exception{
        File f = new File("C:\\WorkSpace\\app\\src\\main\\java\\workspace\\db\\wiseSaying\\data.json");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));

        try {
            bw.write("[");
            for(int i = 0; i < id_list.size(); i++) {
                String json = String.format("\n\t{ \n\t \"id \": %d, \n\t \"content \": \"%s\",\n\t \"authur\": \"%s\"\n\t}", id_list.get(i),wise_saying_list.get(i),authur_list.get(i));
                if (i == id_list.size()-1) {
                    bw.write(json);
                } else {
                    bw.write(json+",");
                }
            }
            bw.write("\n]");
            bw.close();
        } catch (Exception e) {
            System.out.println("하하 잘못됐지롱~");
        }
    }
    
}