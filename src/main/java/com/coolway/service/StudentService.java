package com.coolway.service;

import javax.servlet.http.HttpServletResponse;

public interface StudentService {
    void exportExcel(HttpServletResponse response, String fileName);
}
