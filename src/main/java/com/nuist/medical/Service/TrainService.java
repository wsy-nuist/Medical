package com.nuist.medical.Service;

import com.nuist.medical.Pojo.Train;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 吴思宇
 * @Description:
 * @Param:
 * @Date Created in 2024-01-27-17:26
 * @Modified By:
 */
@Mapper
public interface TrainService {

    List<Train> getTrainList();

    void uploadNewTrainList(Train train);

    List<Train> queryTrainList(String filename);

    void deleteTrainFile(String id);

    Train getOneList(String id);
}
