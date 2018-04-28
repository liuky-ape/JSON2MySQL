package util;

import beans.Data;
import beans.ResultData;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import dao.JSONDao;
import org.apache.ibatis.session.SqlSession;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JSONParase {
    /*
        从本地读取json文件，再通过fastjson进行批量解析；
     */
    public static void paraseJSON(String inputPath) throws IOException {
        File readFileName = new File(inputPath); // 要读取以上路径的input文件
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream(readFileName)); // 建立一个输入流对象reader
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        List listResult = null;
        while ((br.readLine())!=null) {
            if(br.readLine()==null){break;}
            line = br.readLine(); //按行读取，再输入进行解析
           System.out.println(line);
            JSONObject list = (JSONObject) JSON.parse(line);//解析第一层；
            String tempid = list.getString("id");
            String tempmmac = list.getString("mmac");
            String temprate = list.getString("rate");
            String temptime = list.getString("time");
            String templat = list.getString("lat");
            String templon = list.getString("lon");
            JSONArray tempArray = list.getJSONArray("data");
            //解析第二层；
            List<Data> res = JSON.parseObject(tempArray.toJSONString(),
                    new TypeReference<List<Data>>() {
                    });
            ResultData rd = null;
            listResult = new ArrayList();
            for (int i = 0; i < tempArray.size(); i++) {
                SqlSession session= IntoMySQL.getSession();
                JSONDao jd=session.getMapper(JSONDao.class);
                JSONObject list1 = (JSONObject) JSON.parse(tempArray.get(i).toString());
                String tempmac = list1.getString("mac");
                String temprssi = list1.getString("rssi");
                String temprssi1 = list1.getString("rssi1");
                String temprssi2 = list1.getString("rssi2");
                String temprssi3 = list1.getString("rssi3");
                String tempds = list1.getString("ds");
                String temptc = list1.getString("tc");
                String tempts = list1.getString("ts");
                String temptmc = list1.getString("tmc");
                String temprouter = list1.getString("router");
                String temprange = list1.getString("range");
                rd = new ResultData();
                rd.setId(tempid);
                rd.setTime(temptime);
                rd.setLat(templat);
                rd.setLon(templon);
                rd.setRate(temprate);
                rd.setData_ds(tempds);
                rd.setData_mac(tempmac);
                rd.setData_range(temprange);
                rd.setData_router(temprouter);
                rd.setData_rssi(temprssi);
                rd.setData_rssi1(temprssi1);
                rd.setData_rssi2(temprssi2);
                rd.setData_tc(temptc);
                rd.setData_ts(tempts);
                rd.setData_tmc(temptmc);
                rd.setMmac(tempmmac);
                listResult.add(rd);
              jd.inputBatchMySQL(listResult) ;
                session.commit();
                session.clearCache();
            }
        }
        //return listResult;
    }

}
