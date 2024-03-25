package com.nuist.medical.Service.Impl;

import com.nuist.medical.Pojo.Model;
import com.nuist.medical.Service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelService modelService;

    @Override
    public List<Model> queryModelList() {
        return modelService.queryModelList();
    }

    @Override
    public void createEmptyModel(Model m) {
        modelService.createEmptyModel(m);
    }
}
