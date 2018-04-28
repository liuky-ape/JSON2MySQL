package dao;

import beans.ResultData;

import java.util.List;

public interface JSONDao {
    //批量导入的接口
    boolean inputBatchMySQL(List<ResultData> resultDataList);
}
