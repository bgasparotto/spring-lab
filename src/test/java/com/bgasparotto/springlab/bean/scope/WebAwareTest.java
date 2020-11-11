package com.bgasparotto.springlab.bean.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WebAwareTest {

    @Autowired
    private MockMvc mvc;

    protected String getAndReturn(String uri) {
        return getAndReturn(uri, null);
    }

    protected String getAndReturn(String uri, MockHttpSession session) {
        try {
            return mvc
                    .perform(getRequest(uri, session))
                    .andExpect(status().isOk())
                    .andReturn()
                    .getResponse()
                    .getContentAsString();
        } catch (Exception e) {
            throw new AssertionError("Could not perform GET request on URI " + uri);
        }
    }

    private MockHttpServletRequestBuilder getRequest(String uri, MockHttpSession session) {
        MockHttpServletRequestBuilder requestBuilder = get(uri);
        if (session != null) {
            requestBuilder.session(session);
        }

        return requestBuilder;
    }
}
