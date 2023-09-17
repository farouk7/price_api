package com.price.price_api;

import com.price.price_api.dao.Price;
import com.price.price_api.service.PriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PriceService priceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testScenario1() throws Exception {
        testScenario("Test 1", "2020-06-14 10:00:00");
    }

    @Test
    public void testScenario2() throws Exception {
        testScenario("Test 2", "2020-06-14 16:00:00");
    }

    @Test
    public void testScenario3() throws Exception {
        testScenario("Test 3", "2020-06-14 21:00:00");
    }

    @Test
    public void testScenario4() throws Exception {
        testScenario("Test 4", "2020-06-15 10:00:00");
    }

    @Test
    public void testScenario5() throws Exception {
        testScenario("Test 5", "2020-06-16 21:00:00");
    }

    private void testScenario(String testName, String dateTimeStr) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = sdf.parse(dateTimeStr);

        Long brandId = 1L;
        Long productId = 35455L;

        Price mockPrice = new Price();
        when(priceService.findApplicablePrice(brandId, productId, date)).thenReturn(mockPrice);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/getPrice")
                        .param("brandId", String.valueOf(brandId))
                        .param("productId", String.valueOf(productId))
                        .param("date", dateTimeStr)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // You can further assert the content or other properties of the response
        System.out.println(testName + ": petición a las " + dateTimeStr + " del producto " + productId + " para la brand " + brandId );
    }
}