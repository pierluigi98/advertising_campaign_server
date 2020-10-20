package com.pierluigi.advertising_campaign.Controller;
import com.jayway.jsonpath.JsonPath;
import com.pierluigi.advertising_campaign.Domain.Campaign;
import com.pierluigi.advertising_campaign.Domain.Counter;
import com.pierluigi.advertising_campaign.Service.CampaignService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CampaignController.class)
public class CampaignControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CampaignService campaignService;
/*
    @Test
    public void TestFindAll() {
        try {
            mockMvc.perform(
                    get("/prova")
                            .with(httpBasic("username","password")))
                    .andExpect(status().isOk())
                    .andExpect(content().string("prova"));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

 */
    @Test
    public void TestIncrement() {

        Campaign expect = campaignService.findById("1");

        try {
            mockMvc.perform(post("/increment")
                    .with(httpBasic("username","password"))
                    .param("id","1")
                    .param("inc","10")
                    .param("cat", String.valueOf(Counter.Categories.LISTEN_RADIO)))
                    .andExpect(status().isOk());
                    //.andExpect(content().string(expect.toString()));

            } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

}