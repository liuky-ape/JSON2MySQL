package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

public class IntoMySQL {

    private static SqlSessionFactory sessionFactory;
    static {
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream("config/configuration.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally
            { if (in != null)
                {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    }
                }
            }
        }
    public static SqlSession getSession(){
        return sessionFactory.openSession();
    }

}
