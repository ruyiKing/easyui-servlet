package com.yrw.test.excelReadandExport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TestExportExcel {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) {
		
		Student s1 = new Student();
		Student s2 = new Student();
		s1.setId(1);
		s1.setName("赵一");
		s1.setAge(12);
		s1.setBirth(new Date());
		
		s2.setId(1);
		s2.setName("田二");
		s2.setAge(22);
		s2.setBirth(new Date());
		
		
		List<Student> uList = new ArrayList<Student>();
		uList.add(s1);
		uList.add(s2);
		
		//String title = Message.getString("manifestIExportTitle");  
		String title = "数据列表";  
	    String[] rowsName = new String[]{"序号","人员id","姓名","年龄","生日"};  
		List<Object[]>  dataList = new ArrayList<Object[]>();  
		Object[] objs = null;  
		for (int i = 0; i < uList.size(); i++) {  
		    Student man = uList.get(i);  
		    objs = new Object[rowsName.length];  
		    objs[0] = i;  
		    objs[1] = man.getId();
		    objs[2] = man.getName();  
		    objs[3] = man.getAge();  
		    objs[4] = man.getBirth();  
		    //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		    //String date = df.format(man.getModiDate());  
		    //objs[5] = date;  
		    dataList.add(objs);  
		}  
		String fileName = "Excel-" + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xlsx";
		ExportXExcel ex = new ExportXExcel(fileName,title, rowsName, dataList);  
		try {
			ex.export();
			System.out.println("xlsx导出成功");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
