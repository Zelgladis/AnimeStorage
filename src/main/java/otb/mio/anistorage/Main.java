package otb.mio.anistorage;

import otb.mio.anistorage.form.Jinfo;
import otb.mio.anistorage.db.Sqliter;

import java.io.IOException;


public class Main
{
    public static void main(String[] args) throws IOException {
//        Jinfo jinfo = new Jinfo();
//        jinfo.setVisible(true);
        String root_path = System.getProperty("user.dir");
        String bd_path = root_path + "/src/main/resources/bd/Test.db";
        System.out.println(bd_path);

        Sqliter sqliter = new Sqliter(bd_path);

    }
}