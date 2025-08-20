package com.excelapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelapi.entity.ExcelDetail;

public interface ExcelDataRepo extends JpaRepository<ExcelDetail, String>{

}
