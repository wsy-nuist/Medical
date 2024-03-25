package com.nuist.medical.Service;

import com.nuist.medical.Pojo.Algorithm;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @Author: 吴思宇
 * @Description:
 * @Param:
 * @Date Created in 2024-03-17-14:58
 * @Modified By:
 */
@Mapper
public interface AlgorithmService {

    List<Algorithm> getAlgorithmList();

    void uploadNewAlgorithm(Algorithm algorithm);

}
