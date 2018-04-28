package test;

import java.io.IOException;
import static util.JSONParase.paraseJSON;

public class Demo {
    public static void main(String[] args) throws IOException {
        paraseJSON("src/main/resource/yaojiaohui.json");
    }

}
