package hello;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SampleController {
	
	@RequestMapping("/")
	@ResponseBody
	String home(){
		return "Hello World!";
	}
	
	/**
	 * 导出excel
	 * @param response
	 */
	@RequestMapping("/downloadexcel")
	public void exportExcel(HttpServletResponse response){
		String src = "classpath:companies.xlsx";
		try{
			FileInputStream cvs = new FileInputStream(ResourceUtils.getFile(src));
			XSSFWorkbook wb = new XSSFWorkbook(cvs);
			//HSSFWorkbook wb = new HSSFWorkbook(cvs);
			XSSFSheet sheet = wb.getSheetAt(0);
			 //表头那一行
		    XSSFRow titleRow = sheet.getRow(0);

		    //表头那个单元格
		    XSSFCell titleCell = titleRow.getCell(0);

		    String title = titleCell.getStringCellValue();
		    wb.close();
		    String[] fieds = title.split(";");
		    XSSFWorkbook workbook = new XSSFWorkbook();
		    XSSFSheet wrSheet = workbook.createSheet("Companies");
		    XSSFRow row = wrSheet.createRow(0); //构建第一行数据
		    XSSFCell cell = null;
		    int i = 0;
		    for (String val : fieds) {
				if(val.indexOf("\"") >= 0){
					val = val.replace("\"", "");
				}
				cell = row.createCell(i);
				cell.setCellValue(val);
				i++;
				System.out.println(val);
			}
		    
		    //System.out.println("标题是："+);
		    //wb.close();
		    String fileName = new String(("导出Excel标题").getBytes("gb2312"),"iso8859-1") + ".xlsx";
		    response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		    response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		    response.setCharacterEncoding("utf-8");
		    ServletOutputStream outputStream = response.getOutputStream();
		    workbook.write(outputStream);
		    outputStream.flush();
		    outputStream.close();
		    workbook.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("系统发生未知异常");
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SampleController.class, args);

	}

}
