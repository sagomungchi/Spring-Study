package board;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by seansin@cbnu.ac.kr.com on 08/08/2019
 * Blog : http://dailyworker.github.io
 * Github : http://github.com/dailyworker
 */
@XmlRootElement(name = "boardList")
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardListVO {

    @XmlElement(name = "board")
    private List<BoardVO> boardList;

    public List<BoardVO> getBoardList() {
        return boardList;
    }

    public void setBoardList(List<BoardVO> boardList) {
        this.boardList = boardList;
    }
}
