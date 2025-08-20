package com.excelapi.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.excelapi.entity.ExcelDetail;
import com.excelapi.repository.ExcelDataRepo;

@Service
public class ExcelService {

	
	@Autowired
    private ExcelDataRepo excelDataRepo;

    public void save(MultipartFile file) {

        try {
            List<ExcelDetail> eDetail = ExcelHelper.convertExcelToListOfProduct(file.getInputStream());
            this.excelDataRepo.saveAll(eDetail);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<ExcelDetail> getAllProducts() {
        return this.excelDataRepo.findAll();
    }

}
