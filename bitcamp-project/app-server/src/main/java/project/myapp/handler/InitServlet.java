package project.myapp.handler;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import project.myapp.dao.BoardDao;
import project.myapp.dao.MemberDao;
import project.myapp.dao.MySQLBoardDao;
import project.myapp.dao.MySQLMemberDao;
import project.util.NcpConfig;
import project.util.NcpObjectStorageService;
import project.util.SqlSessionFactoryProxy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(
        value="/init",
        loadOnStartup = 1
)
public class InitServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public static SqlSessionFactory sqlSessionFactory;
    public static BoardDao boardDao;
    public static MemberDao memberDao;
    public static NcpObjectStorageService ncpObjectStorageService;

    @Override
    public void init() throws ServletException {
        System.out.println("InitServlet.init() 호출됨!");

        try {
            sqlSessionFactory = new SqlSessionFactoryProxy(
                    new SqlSessionFactoryBuilder().build(
                            Resources.getResourceAsStream("project/myapp/config/mybatis-config.xml")));

            boardDao = new MySQLBoardDao(sqlSessionFactory);
            memberDao = new MySQLMemberDao(sqlSessionFactory);
            ncpObjectStorageService = new NcpObjectStorageService(new NcpConfig());


        } catch (Exception e) {
            System.out.println("InitServlet.init() 실행 중 오류 발생!");
            e.printStackTrace();
        }
    }
}
