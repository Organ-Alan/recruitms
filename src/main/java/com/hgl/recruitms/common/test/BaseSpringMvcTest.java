package com.hgl.recruitms.common.test;


import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration("classpath:spring.xml"),
        @ContextConfiguration("classpath:spring-mvc.xml")
})
public class BaseSpringMvcTest  {

    @Autowired
    private WebApplicationContext webApplicationContext;

    protected MockMvc mockMvc;

    @Before
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
                .alwaysDo(MockMvcResultHandlers.print()).build();
    }

    public MockMvc getMockMvc(){
        return mockMvc;
    }

    public ResultActions perform(MockHttpServletRequestBuilder requestBuilder) throws Exception{
        return getMockMvc().perform(requestBuilder.header("token", "test"));
    }

}
