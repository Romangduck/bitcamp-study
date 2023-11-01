package project.myapp.dao;

import java.util.List;
import project.myapp.vo.AttachedFile;
import project.myapp.vo.Board;

public interface BoardDao {
    void insert(Board board);
    List<Board> findAll(int category);
    Board findBy(int category, int no);
    int update(Board board);
    int updateCount(Board board);
    int delete(Board board);

    int insertFiles(Board board);
    AttachedFile findFileBy(int no);
    int deleteFile(int fileNo);
}