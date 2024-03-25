package com.nuist.medical.Service.Impl;

import com.nuist.medical.Pojo.Train;
import com.nuist.medical.Service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 吴思宇
 * @Description:
 * @Param:
 * @Date Created in 2024-01-27-17:27
 * @Modified By:
 */

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    TrainService trainService;

    @Override
    public List<Train> getTrainList() {
        return trainService.getTrainList();
    }

    @Override
    public void uploadNewTrainList(Train train) {
        trainService.uploadNewTrainList(train);
    }

    @Override
    public List<Train> queryTrainList(String filename) {
        return trainService.queryTrainList(filename);
    }

    @Override
    public void deleteTrainFile(String id) {
        trainService.deleteTrainFile(id);
    }

    @Override
    public Train getOneList(String id) {
        return trainService.getOneList(id);
    }
}
