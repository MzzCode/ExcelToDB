package com.excelapi.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.excelapi.entity.ExcelDetail;


public class ExcelHelper {
	
	//check that file is of excel type or not
    public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }

    }


    //convert excel to list of products

    public static List<ExcelDetail> convertExcelToListOfProduct(InputStream is) {
        List<ExcelDetail> list = new ArrayList<>();

        try (XSSFWorkbook workbook = new XSSFWorkbook(is)) {
        	
        	
        	
        	XSSFSheet sheet = workbook.getSheet("sheet1");
            
            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();

                //  Skip the header row (first row)
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                //  Skip section header rows like "1st Floor" or "2nd Floor"
                Cell firstCell = row.getCell(0);
                if (firstCell == null || firstCell.getCellType() == CellType.BLANK) {
                    continue;
                }

                String cellValue = firstCell.toString().trim();
                if (cellValue.equalsIgnoreCase("1st Floor") || cellValue.equalsIgnoreCase("2nd Floor")) {
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;

                ExcelDetail E = new ExcelDetail();

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                    case 0:
                        E.setName(cell.getStringCellValue());
                        break;
                    case 1:
                        E.setPrevious_Month((int) cell.getNumericCellValue());
                        break;
                    case 2:
                        E.setCurrent_Month((int) cell.getNumericCellValue());
                        break;
                    case 3:
                        E.setTotal_Unit((int) cell.getNumericCellValue());
                        break;
                    case 4:
                        E.setRate_Per((int) cell.getNumericCellValue());
                        break;
                    case 5:
                        E.setPrevious_Due((int) cell.getNumericCellValue());
                        break;
                    case 6:
                        E.setTotal_Amount((int) cell.getNumericCellValue()); 
                        break;
                    case 7:
                        E.setBilling_Cycle(cell.getStringCellValue());
                        break;
                    case 8:
                        E.setPaid(cell.getBooleanCellValue());
                        break;
                            
                        default:
                            break;
                    }
                    cid++;

                }

                list.add(E);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }



}
