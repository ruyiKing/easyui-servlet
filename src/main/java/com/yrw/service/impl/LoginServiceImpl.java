package com.yrw.service.impl;

import com.yrw.service.LoginService;
import com.yrw.utils.JdbcUtils;
import com.yrw.vo.Form;

import java.util.List;

public class LoginServiceImpl implements LoginService {

	JdbcUtils jdbcUtils = null;

	public LoginServiceImpl() {
		jdbcUtils = new JdbcUtils();
	}

	public Form doLogin(List<Object> params) {
        Form form = null;
        jdbcUtils.getConnection();  
        String sql = "select * from yrw_user where login_no=? ";
        try{
            form = jdbcUtils.findSimpleRefResult(sql, params,Form.class);
        }catch(Exception e){  
            e.printStackTrace();  
        }  
        finally{  
            jdbcUtils.releaseConn();  
        }  
          
        return form;
	}

}
