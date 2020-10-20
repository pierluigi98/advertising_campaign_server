package com.pierluigi.advertising_campaign;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdvertisingCampaignApplicationTests {

    @Test
    void contextLoads() {
    }

}

/*
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@WebMvcTest(CampaignController.class)
@RunWith(MockitoJUnitRunner.class)
@AutoConfigureMockMvc

@SpringBootTest //create an application context containing all the objects we need for all the test
class AdvertisingCampaignApplicationTests {
    @Test
    public void Context(){}

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private CampaignService campaignService;

	@Test
	void verifyFind() throws Exception {
		List<Counter> list = new ArrayList<>();
		list.add(new Counter(Counter.Categories.LISTEN_RADIO,139));
		list.add(new Counter(Counter.Categories.LISTEN_WEB,3093));
		Campaign campaign = new Campaign("1","aa","bb",list);
		List<Campaign> list1 = Arrays.asList(campaign);

		given(campaignService.readAll()).willReturn(list1);

		mockMvc.perform(
				(get("/readAll")
				.contentType(MediaType.APPLICATION_JSON)
				.with(httpBasic("username","password"))))
				.andExpect(status().isOk());
	}

}
*/