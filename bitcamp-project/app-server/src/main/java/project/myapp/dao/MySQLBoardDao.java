package project.myapp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import project.myapp.vo.AttachedFile;
import project.myapp.vo.Board;

public class MySQLBoardDao implements BoardDao {

    SqlSessionFactory sqlSessionFactory;

    public MySQLBoardDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void insert(Board board) {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        sqlSession.insert("project.myapp.dao.BoardDao.insert", board);
    }

    @Override
    public List<Board> findAll(int category) {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        return sqlSession.selectList("project.myapp.dao.BoardDao.findAll", category);
    }


    @Override
    public Board findBy(int category, int no) {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("categoryNo", category);
        paramMap.put("boardNo", no);

        return sqlSession.selectOne("project.myapp.dao.BoardDao.findBy", paramMap);
    }

    @Override
    public int update(Board board) {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        return sqlSession.update("project.myapp.dao.BoardDao.update", board);
    }

    @Override
    public int updateCount(Board board) {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        return sqlSession.update("project.myapp.dao.BoardDao.updateCount", board);
    }

    @Override
    public int delete(Board board) {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        return sqlSession.delete("project.myapp.dao.BoardDao.delete", board);
    }

    @Override
    public int insertFiles(Board board) {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        return sqlSession.insert("project.myapp.dao.BoardDao.insertFiles", board);
    }

    @Override
    public AttachedFile findFileBy(int no) {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        return sqlSession.selectOne("project.myapp.dao.BoardDao.findFileBy", no);
    }

    @Override
    public int deleteFile(int no) {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        return sqlSession.delete("project.myapp.dao.BoardDao.deleteFile", no);
    }

}
