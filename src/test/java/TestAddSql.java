import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.yrw.utils.JdbcUtils;

public class TestAddSql {
	
JdbcUtils jdbcUtils = null;
	
	public TestAddSql() {
		jdbcUtils = new JdbcUtils();
	}
	
	@Test
	public void addMenu(){
		List<Object> params = new ArrayList<>();
		Integer parent_id = null,menu_quade;
		String menu_name,menu_url = null;
		String sql="";
		
		for(int i=1;i<=10;i++){
			params.removeAll(params);
			if(i<3){
				if (!(i==1)) {
					parent_id =1;
				}
			}else if (i<=6 ) {
				parent_id =2;
			}else {
				parent_id =3;
			}
			if(i<4){
				menu_name = "父菜单"+i;
				menu_quade=1;
			}else{
				menu_name = "子菜单"+i;
				menu_quade=2;
			}
			
			params.add(parent_id);
			params.add(menu_name);
			params.add(menu_url);
			params.add(menu_quade);
			sql = "insert into yrw_menu(parent_id, menu_name, menu_url,menu_quade) values (?, ?, ?, ?)";  
			this.addform(params,sql);
		}
	}

	public boolean addform(List<Object> params,String sql) {
		boolean flag = false;  
        jdbcUtils.getConnection();  
         System.out.println("sql="+sql);
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
