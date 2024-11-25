package workspace.wiseSayingProject.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import workspace.wiseSayingProject.WiseSaying;
import workspace.wiseSayingProject.Repository.WiseSayingRepository;

/*
 * 순수 비지니스 로직
 * 스캐너 사용금지, 출력 금지
 */

public class WiseSayingServiceImpl implements WiseSayingService {

    public static List <WiseSaying> serviceList = new ArrayList<>();
    
    public static String AddWiseSayingList(int id, String wiseSayingV, String authurV) throws IOException {
        serviceList.add(new WiseSaying(id, wiseSayingV, authurV));
        String addResult = WiseSayingRepository.CreateFile(id, wiseSayingV, authurV);

        return addResult;
    }
    
    public static List <WiseSaying> ShowList() throws IOException {
        //serviceList = WiseSayingRepository.ReadBuildFile();
        serviceList = WiseSayingRepository.WiseSayingFile();
        
        return serviceList;
    }

    public static String IdCheck(int targetId) throws IOException {
        String idCheckResult = WiseSayingRepository.IdCheck(targetId);
        return idCheckResult;
    }

    public static String EditList(int editId, String wiseSayingV, String authurV) throws IOException {
        String editResult =  WiseSayingRepository.EditFile(editId,wiseSayingV,authurV);
        return editResult;

    }

    public static String[] ReadFile(int targetId) throws IOException {
        String[] readResult = WiseSayingRepository.ReadFile(targetId);

        return readResult;

    }

    public static String DeleteList(int deleteTargetId) throws IOException {
        String delResult = WiseSayingRepository.DeleteidFile(deleteTargetId);

        return delResult;

    }

    public static String BuildList() throws IOException {
        //serviceList
        String buildResult = WiseSayingRepository.CreateBuildFile(serviceList);

        return buildResult;
    }

}
