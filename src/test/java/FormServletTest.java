import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yrw.servlet.FormServlet;


/**
 * Created by fate on 2015/9/10.
 */
public class FormServletTest {
	 private HttpServletRequest mockRequest;
	    private HttpServletResponse mockResponse;

	    @Before
	    public void setUp(){
	        new FormServlet();

	        mockRequest = EasyMock.createMock(HttpServletRequest.class);         //加载
	        mockResponse = EasyMock.createMock(HttpServletResponse.class);
	    }

	    @After
	    public void tearDown(){
	        EasyMock.verify(mockRequest);        //验证
	        EasyMock.verify(mockResponse);
	    }


	    @Test
	    public void testDoPostHttpServletRequestHttpServletResponse() throws ServletException, IOException {

	        mockRequest.getParameter("name");         //传入参数
	        EasyMock.expectLastCall().andReturn("1");

	        mockRequest.getParameter("email");       //传入参数
	        EasyMock.expectLastCall().andReturn("chevy");

	        mockRequest.getParameter("subject");     //传入参数
	        EasyMock.expectLastCall().andReturn("男");
	        
	        mockRequest.getParameter("message");     //传入参数
	        EasyMock.expectLastCall().andReturn("男");
	        
	        mockRequest.getParameter("language");     //传入参数
	        EasyMock.expectLastCall().andReturn("en");

	        EasyMock.replay(mockRequest);                    //回放
	        EasyMock.replay(mockResponse);

	        //servlet.doPost(mockRequest, mockResponse);  //调用

	    }
}
