package com.minisrm.admin.service;

import com.minisrm.admin.model.Test;

import java.util.List;

public interface TestService {
    List<Test> selectList(Test test, String orderBy);

    List<Test> selectAll();
}
