package com.nuist.medical.Service;

import com.nuist.medical.Pojo.Images;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 吴思宇
 * @Description:
 * @Param:
 * @Date Created in 2024-03-24-12:41
 * @Modified By:
 */
@Mapper
public interface ImageService {

    List<Images> getImageList();

}
