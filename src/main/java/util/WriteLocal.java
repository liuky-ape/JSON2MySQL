package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;


public class WriteLocal {
    // 构建写到本地的writer
    public void writelocal(String obj,BufferedWriter writer) throws IOException {
        writer.write(obj);
        writer.flush();
    }

    public static void main(String[] args) throws IOException {
        WriteLocal writer=new WriteLocal();
        //读取本地文件的，地址
        String inpath = "/Users/admin/Documents/临时数据/贵阳数博会wifi_data";
        FileInputStream infile = new FileInputStream(inpath);
        BufferedReader in = new BufferedReader(new InputStreamReader(infile));
       //本地写
        String outpath = "wifi_data_guiyang.csv";
        FileOutputStream fos = new FileOutputStream(outpath);
        java.io.BufferedWriter out = new BufferedWriter(new java.io.OutputStreamWriter(fos));
        String lines;
        String tempid ;
        String tempmmac ;
        String temprate ;
        String temptime ;
        String templat ;
        String templon ;
        String tempmac ;
        String temprssi;
        String temprssi1 ;
        String temprssi2 ;
        String temprssi3 ;
        String tempds ;
        String temptc ;
        String tempts ;
        String temptmc ;
        String temprouter ;
        String temprange ;
        while ((in.readLine()) != null) {
            String line = in.readLine(); //按行读取，再输入进行解析
            System.out.println(line);
            if(line.contains("?,")) {
                line=line.replace("?,", "?\",");
            }
            JSONObject list = (JSONObject) JSON.parse(line);//解析第一层；
             tempid = list.getString("id");
            tempmmac = list.getString("mmac");
             temprate = list.getString("rate");
             temptime = list.getString("time");
             templat = list.getString("lat");
             templon = list.getString("lon");
            JSONArray tempArray = list.getJSONArray("data");
            //解析第二层；
            for (int i = 0; i < tempArray.size(); i++) {
                JSONObject list1 = (JSONObject) JSON.parse(tempArray.get(i).toString());
                 tempmac = list1.getString("mac");
                 temprssi = list1.getString("rssi");
                 temprssi1 = list1.getString("rssi1");
                 temprssi2 = list1.getString("rssi2");
                 temprssi3 = list1.getString("rssi3");
                 tempds = list1.getString("ds");
                 temptc = list1.getString("tc");
                 tempts = list1.getString("ts");
                 temptmc = list1.getString("tmc");
                 temprouter = list1.getString("router");
                 temprange = list1.getString("range");
            lines=tempid+","+tempmac+","+temprssi+","+temprssi1+","+temprssi2+","+temptmc+","+temprouter+","
                    +temprange+","+tempmmac+","+temprate+","+temptime+","+templat+","+templon+","+tempts
                    +","+tempds+","+temprssi3+","+temptc+"\n";
                writer.writelocal(lines,out);
            }
        }
    }
}