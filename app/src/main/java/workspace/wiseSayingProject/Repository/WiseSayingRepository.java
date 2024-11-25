package workspace.wiseSayingProject.Repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import workspace.wiseSayingProject.WiseSaying;

/*
 * 데이터의 조회/수정/삭제/생성을 담당
 * 스캐너 사용금지, 출력 금지
 * 
 */

public class WiseSayingRepository {

    public static File f;
    public static BufferedWriter bw;
    
    // 명언 등록 시, lastId.txt 파일 && id.json 파일 생성 기능 
    public static String CreateFile(int id, String wiseSayingV, String autuhurV) throws IOException {
        //a
        String createResult = ""; 

        f = new File("C:\\WorkSpace\\WiseSaying\\app\\src\\main\\java\\workspace\\db","lastId"+".txt");

        try {
            bw = new BufferedWriter(new FileWriter(f));
            bw.write(Integer.toString(id));
            bw.close();
            createResult = "complete";
        } catch (Exception e) {
            createResult = "idFileFail";
        }

        f = new File("C:\\WorkSpace\\WiseSaying\\app\\src\\main\\java\\workspace\\db\\",id+".json");
        String json = String.format( "{ \"id \": %d, \"content \": \"%s\",\"authur\": \"%s\"}", id,wiseSayingV,autuhurV );

        try {
            bw = new BufferedWriter(new FileWriter(f));
            bw.write(json);
            bw.close();
            createResult = "complete";
        } catch (Exception e) {
            createResult = "wiseSayingFileFail";
        }

        return createResult;
    }

    // 빌드 시 data.json 파일 생성 기능 
    public static String CreateBuildFile(List<WiseSaying> list) throws IOException {
        String buildResult = "";
        f = new File("C:\\WorkSpace\\WiseSaying\\app\\src\\main\\java\\workspace\\db\\data.json");
        bw = new BufferedWriter(new FileWriter(f));
        
        try {
            bw.write("[");
            for(int i = 0; i < list.size(); i++) {
                String json = String.format("\n\t{ \n\t \"id \": %d, \n\t \"content \": \"%s\",\n\t \"authur \": \"%s\"\n\t}", list.get(i).getId(),list.get(i).getWiseSaying(),list.get(i).getAuthor());
                if (i == list.size()-1) {
                    bw.write(json);
                } else {
                    bw.write(json+",");
                }
            }
            bw.write("\n]");
            bw.close();
            buildResult = "complete";
        } catch (Exception e) {
            buildResult = "buildFailed";
        }

        return buildResult;

    }

    // 명언 조회 시, id.json 파일들을 전부 읽어들여 리스트화 하여 화면에 return 
    public static List<WiseSaying> WiseSayingFile() throws IOException {
    
        List<WiseSaying> repoList = new ArrayList<>(); // 리턴 배열
        List<String> repoListV = new ArrayList<>();
        f = new File("C:\\WorkSpace\\WiseSaying\\app\\src\\main\\java\\workspace\\db","lastId"+".txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        int lastId = Integer.parseInt(br.readLine());

        for (int i = lastId; i > 0; i--) {
            f = new File("C:\\WorkSpace\\WiseSaying\\app\\src\\main\\java\\workspace\\db\\",i+".json");
            if(f.exists()) {
                br = new BufferedReader(new FileReader(f));
                String s = br.readLine();
    
                s = s.replace("{","").replace("}","");
                String[] jsonContents = s.split(",");
    
                for(String jsonContent : jsonContents) {
                    String[] keyVal = jsonContent.split(":");
                    String val = keyVal[1].trim().replace("\"", "");
                    
                    repoListV.add(val);
                }
            } else {
                //a
            }
        }
        br.close();    

        List<Integer> idList = new ArrayList<>();
        List<String> wiseList = new ArrayList<>();
        List<String> authurList = new ArrayList<>();
        
        for(int j = 0; j < repoListV.size(); j++) {
            if(j%3 == 0) {
                idList.add(Integer.parseInt(repoListV.get(j)));
            } else if (j%3 == 1) {
                wiseList.add(repoListV.get(j));
            } else if (j%3 == 2) {
                authurList.add(repoListV.get(j));
            }
        }

        for (int j = 0; j < idList.size(); j++) {
            repoList.add(new WiseSaying(idList.get(j), wiseList.get(j), authurList.get(j)));
        }

        return repoList;
    }

    // id 체크 
    public static String IdCheck(int id) throws IOException {
        String idCheckResult = "";
        f = new File("C:\\WorkSpace\\WiseSaying\\app\\src\\main\\java\\workspace\\db\\",id+".json");

        if(f.exists()) {
            idCheckResult = "complete";
        } else {
            idCheckResult = "fileNotExists";
        }

        return idCheckResult;
    }

    //명언파일 수정 시, 수정 대상 id.json 파일 읽어오기 
    public static String[] ReadFile (int id) throws IOException {
        String []readFile = new String[2];
        List<String> repoListV = new ArrayList<>();
        f = new File("C:\\WorkSpace\\WiseSaying\\app\\src\\main\\java\\workspace\\db\\",id+".json");
        BufferedReader br = new BufferedReader(new FileReader(f));
        
        if(f.exists()) {
                br = new BufferedReader(new FileReader(f));
                String s = br.readLine();
    
                s = s.replace("{","").replace("}","");
                String[] jsonContents = s.split(",");
    
                for(String jsonContent : jsonContents) {
                    String[] keyVal = jsonContent.split(":");
                    String val = keyVal[1].trim().replace("\"", "");
                    
                    repoListV.add(val);
                }
                readFile[0] = repoListV.get(1);
                readFile[1] = repoListV.get(2);
            } else {
                //a
            }

        return readFile;
    }

    //파일 삭제 시, id.json 파일 삭제 기능 
    public static String DeleteidFile(int id) throws IOException {
        String delResult = "";
        f = new File("C:\\WorkSpace\\WiseSaying\\app\\src\\main\\java\\workspace\\db\\",id+".json");
        
        if(f.delete()) {
            delResult = "deleteComplete";
        } else {
            delResult = "deleteFail";
        }

        return delResult;

    }

    // 파일 편집 시 id.json 재생성. 
    public static String EditFile(int id, String wiseSayingV, String autuhurV) throws IOException{
        String editResult = ""; 
        f = new File("C:\\WorkSpace\\WiseSaying\\app\\src\\main\\java\\workspace\\db\\",id+".json");        
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            String json = String.format( "{ \"id \": %d, \"content \": \"%s\",\"authur\": \"%s\"}", id,wiseSayingV,autuhurV );
            bw.write(json);
            bw.close();
            
            editResult = "complete";
            
        } catch (Exception e) {
            // TODO: handle exceptio
            editResult = "editFail";
        }

        return editResult;
    }
    
}
