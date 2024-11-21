package workspace.wiseSaying;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class WiseSaying {
    int id;
    String author;
    String wiseSaying;

    public WiseSaying (int id, String author, String wiseSaying) {
        this.id = id;
        this.author = author;
        this.wiseSaying = wiseSaying;
    }
        // Getters
        public int getId() {
            return id;
        }
    
        public String getAuthor() {
            return author;
        }
    
        public String getWiseSaying() {
            return wiseSaying;
        }
}

public class WiseSayingMain {
    public static Scanner sc = new Scanner(System.in,"EUC-KR");
    boolean startFlg = true;
    public static int id = 1;
    String cmd = "";
    /*  코드 리뷰 반영
     *  public static List<Integer> idList = new LinkedList<>();
     *  public static List<String> authurList = new LinkedList<>();
     *  public static List<String> wiseSayingList = new LinkedList<>();
     */

    public static List<WiseSaying> list = new ArrayList<>();

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

    class WiseSayingAddList {

    public static void AddList() {
        System.out.print("명언 : ");
        String wiseSayingV = sc.nextLine();
        System.out.print("작가 : ");
        String authurV = sc.nextLine();

        list.add(new WiseSaying(id,authurV,wiseSayingV));

        File json_f = new File("C:\\WorkSpace\\WiseSaying\\app\\src\\main\\java\\workspace\\db\\",id+".json");
        File id_f = new File("C:\\WorkSpace\\WiseSaying\\app\\src\\main\\java\\workspace\\db","lastId"+".txt");

        String json = String.format(
                "{ \"id \": %d, \"content \": \"%s\",\"authur\": \"%s\"}", id,wiseSayingV,authurV
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

class WiseSayingBuild {

    public static void BuildList() throws Exception{
        File f = new File("C:\\WorkSpace\\WiseSaying\\app\\src\\main\\java\\workspace\\db\\data.json");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));

        try {
            bw.write("[");
            for(int i = 0; i < list.size(); i++) {
                WiseSaying ws = list.get(i);
                String json = String.format("\n\t{ \n\t \"id \": %d, \n\t \"content \": \"%s\",\n\t \"authur \": \"%s\"\n\t}", ws.id,ws.wiseSaying,ws.author);
                if (i == list.size()-1) {
                    bw.write(json);
                } else {
                    bw.write(json+",");
                }
            }
            bw.write("\n]");
            bw.close();
            System.out.println("data.json 파일의 내용이 갱신되었습니다.");
        } catch (Exception e) {
            System.out.println("하하 잘못됐지롱~");
        }
    }
    
}

class WiseSayingDelete {

    public static void DeleteList() {
            System.out.print("삭제? id = ");
            String a = sc.nextLine();
            int idV = Integer.parseInt(a);
            int idx = idV - 1; 
            WiseSaying ws =list.get(idx);

            if (ws.id == idV) {
                list.remove(idx);
                System.out.println(idV + "번 명언이 삭제 되었습니다.");
            } else {
                System.out.println(idV + "번 명언은 존재하지 않습니다.");
            }
    }
}

class WiseSayingEdit {
    public static void EditList() {

        System.out.print("수정 ? id = ");
        String a = sc.nextLine();
        int idV = Integer.parseInt(a);
        int idx = idV -1;
        WiseSaying ws = list.get(idx);

        if(ws.id == idV) {
            System.out.println("명언(기존) : " + ws.wiseSaying);
            System.out.print("명언 : ");
            String wsV = sc.nextLine();
            //list.set(idV);
            //list.set(new WiseSaying(idV, a, a))
            

            System.out.println("작가(기존) : " + ws.author);
            System.out.print("작가 : ");
            String atV  = sc.nextLine();
            //list.set(idx,at_v);
            list.set(idx, new WiseSaying(idV, atV, wsV));
        } else  {
            System.out.println(idV + " 번 명언은 존재하지 않습니다. ");
        }
    }
}

class WiseSayingShowList {

    public static void ShowList() {
        System.out.println(" 번호 / 작가 / 명언 ");
        System.out.println(" ---------------------- ");
        for(int i = list.size()-1; i >= 0; i--) {
            WiseSaying ws = list.get(i);
            System.out.println(ws.id + " / " + ws.author + " / " + ws.wiseSaying);
        }

    }
}

}