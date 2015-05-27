package fox.test.bikemethere;

import android.util.JsonReader;

import java.util.Scanner;

/**
 * Created by Ian on 5/20/2015.
 */
public class Extract {

    private String extract1(String raw) {
        String myreturn = "";
        //TODO: if there is no length to raw, send error (actually, do in MainActivity
        Scanner sc = new Scanner((raw)).useDelimiter("\r\n");
        //Boolean status = raw.contains("status");
        sc.next();

        String bullshit = sc.findInLine(("OK"));
        if(bullshit.length() > 0) {
            while ((sc.hasNextLine())) {


            }
        }

        //Boolean status = raw.contains("status");
        sc.close();
        return myreturn;
    }
}
