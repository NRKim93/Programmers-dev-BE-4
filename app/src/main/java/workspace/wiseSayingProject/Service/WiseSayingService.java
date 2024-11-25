package workspace.wiseSayingProject.Service;
/*
 * 순수 비지니스 로직
 * 스캐너 사용금지, 출력 금지
 */

import java.io.IOException;
import java.util.List;

import workspace.wiseSayingProject.WiseSaying;

public interface WiseSayingService {
    
    public static String EditList(int editId, String wiseSayingV, String authurV) {
        return null;
    }

    public static String DeleteList(int deleteTargetId) {
        return null;

    }
    
    public static String IdCheck(int targetId) {
        return null;
    }
    
    public static String AddWiseSayingList(int id, String wiseSayingV, String authurV) {
        return null;
        
    }
    
    public static List <WiseSaying> ShowList() throws IOException {
        return null;
        
    }
    
    public static String BuildList() throws IOException {
        return null;
    }

    
    public static String[] ReadFile(int targetId) throws IOException {
        return null;

    }
}
