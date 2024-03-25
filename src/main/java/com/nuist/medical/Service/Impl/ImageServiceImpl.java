package com.nuist.medical.Service.Impl;

import com.nuist.medical.Pojo.Images;
import com.nuist.medical.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 吴思宇
 * @Description:
 * @Param:
 * @Date Created in 2024-03-24-12:42
 * @Modified By:
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageService imageService;


    @Override
    public List<Images> getImageList() {
        return imageService.getImageList();
    }
}
