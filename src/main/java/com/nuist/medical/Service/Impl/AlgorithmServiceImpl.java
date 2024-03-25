package com.nuist.medical.Service.Impl;

import com.nuist.medical.Pojo.Algorithm;
import com.nuist.medical.Service.AlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 吴思宇
 * @Description:
 * @Param:
 * @Date Created in 2024-03-17-15:01
 * @Modified By:
 */
@Service
public class AlgorithmServiceImpl implements AlgorithmService {

    @Autowired
    private AlgorithmService algorithmService;

    @Override
    public List<Algorithm> getAlgorithmList() {
        return algorithmService.getAlgorithmList();
    }

    @Override
    public void uploadNewAlgorithm(Algorithm algorithm) {
        algorithmService.uploadNewAlgorithm(algorithm);
    }
}
