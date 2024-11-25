package workspace.wiseSayingProject;

/*
 * 명언 객체(번호/명언내용/작가)
 * 컨트롤러, 서비스, 리포지터티 모두에서 사용가능
*/

public class WiseSaying {
    int id; // 명언 id(엄밀히 말하면 Seq 번호)
    String wiseSaying; // 명언 내용
    String author; // 작가

    public WiseSaying (int id, String wiseSaying, String author) {
        this.id = id;
        this.wiseSaying = wiseSaying;
        this.author = author;
    }
        // Getters
        public int getId() {
            return id;
        }
            
        public String getWiseSaying() {
            return wiseSaying;
        }

        public String getAuthor() {
            return author;
        }
}
