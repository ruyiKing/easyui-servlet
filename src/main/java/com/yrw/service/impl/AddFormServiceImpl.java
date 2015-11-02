package com.yrw.service.impl;

import java.util.List;

import com.yrw.service.AddFormService;
import com.yrw.utils.JdbcUtils;

public class AddFormServiceImpl implements AddFormService {
	
	JdbcUtils jdbcUtils = null;
	
	public AddFormServiceImpl() {
		jdbcUtils = new JdbcUtils();
	}

	public boolean addform(List<Object> params) {
		boolean flag = false;  
        jdbcUtils.getConnection();  
        String sql = "insert into yrw_user(name, email, subject,message,language) values (?, ?, ?, ?, ?)";  
        try{  
            flag = jdbcUtils.updateByPreparedStatement(sql, params);  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
        finally{  
            jdbcUtils.releaseConn();  
        }  
          
        return flag;  
	}

}
