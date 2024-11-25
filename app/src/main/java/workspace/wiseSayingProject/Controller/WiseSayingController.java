package workspace.wiseSayingProject.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import workspace.wiseSayingProject.WiseSaying;
import workspace.wiseSayingProject.Service.WiseSayingServiceImpl;

/*
 * 역할 : 고객의 명령을 입력받고 적절을 응답을 표현
 * 스캐너 사용가능
 * 출력 사용가능
 */

public class WiseSayingController {
    final public static Scanner sc = new Scanner(System.in,"EUC-KR");
    boolean startFlg = true;
    String cmd = "";
    public static int id = 1;
    List <WiseSaying> controllList = new ArrayList<>();

    public void run() throws IOException {
        System.out.println("== 명언 앱 ==");
        
        while (startFlg) {
            System.out.print("명령) ");
            cmd = sc.nextLine();

            switch (cmd.trim()) {
                case "종료" :
                    sc.close();
                    startFlg = false;
                    break;

                case "등록" :
                    System.out.print("명언 : ");
                    String wiseSayingV = sc.nextLine();
                    System.out.print("작가 : ");
                    String authurV = sc.nextLine();
                    String addResult =  WiseSayingServiceImpl.AddWiseSayingList(id, wiseSayingV, authurV);

                    switch (addResult) {
                        case "idFileFail":
                            System.out.println("lastId.txt 파일 생성 실패. ");
                            break;
                        
                        case  "wiseSayingFileFail" :
                            System.out.println("명언 파일 생성 실패. ");
                            break;
                    
                        case  "complete" :
                            System.out.println(id + "번 명언이 등록되었습니다.");
                            break;
                  
                        default:
                            break;
                    }

                    id++;
                    break;

                case "목록" :
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");

                    controllList = WiseSayingServiceImpl.ShowList();

                    for ( int i = controllList.size()-1; i >= 0; i-- ) {
                        System.out.println(controllList.get(i).getId() + " / " + controllList.get(i).getAuthor() + " / " + controllList.get(i).getWiseSaying());
                    }

                    break;

                case "삭제" :
                    System.out.print("삭제? id = ");
                    String inputIdVal = sc.nextLine();
                    int deleteIdVal = Integer.parseInt(inputIdVal);
                    String idCheckResult = WiseSayingServiceImpl.IdCheck(deleteIdVal);
                    String delResult =  WiseSayingServiceImpl.DeleteList(deleteIdVal);
                    //WiseSayingDelete.DeleteList();

                    switch (idCheckResult) {
                        case "complete":  
                        switch (delResult) {
                            case "deleteComplete" :
                                System.out.println(deleteIdVal + "번 명언이 삭제 되었습니다. ");
                                break;
                        
                            default:
                                System.out.println(deleteIdVal + "번 명의 삭제에 실패하였습니다. ");
                                break;
                        }
                            break;
                    
                        default:
                            System.out.println(deleteIdVal + "번의 명언이 존재하지 않습니다. ");
                            break;
                    }


                    break;

                case "수정" :
                    //WiseSayingEdit.EditList();
                    System.out.print("수정 ? id = ");
                    int editIdVal = Integer.parseInt(sc.nextLine());
                    idCheckResult = WiseSayingServiceImpl.IdCheck(editIdVal);

                    switch (idCheckResult) {
                        case "complete":
                            String[] readResult = WiseSayingServiceImpl.ReadFile(editIdVal);
                            System.out.println("명언(기존) : " + readResult[0]);
                            System.out.print("명언 : ");
                            String wsV = sc.nextLine();

                            System.out.println("작가(기존) : " + readResult[1]);
                            System.out.print("작가 : ");
                            String atV = sc.nextLine();

                            String editResult = WiseSayingServiceImpl.EditList(editIdVal, wsV, atV);
                            
                            switch (editResult) {
                                case "complete":
                                    System.out.println(editIdVal + "번 명언이 수정 되었습니다. ");
                                    break;
                            
                                default:
                                    System.out.println(editIdVal + "번 명언의 수정에 실패 하였습니다. ");
                                    break;
                            }
                            break;
                    
                        default:
                            System.out.println(editIdVal + "번의 명언이 존재하지 않습니다. ");
                            break;
                    }
                    
                    break;

                case "빌드" :
                    String buildResult = WiseSayingServiceImpl.BuildList();

                    switch (buildResult) {
                        case "complete":
                            System.out.println("data.json 파일의 내용이 갱신되었습니다.");                    
                            break;
                            
                        case "buildFailed":
                            System.out.println("빌드 파일 생성 실패. ");
                            break;
                    
                        default:
                            break;
                    }
                    break;

                default:
                    break;
            }
        }
    } 
}
