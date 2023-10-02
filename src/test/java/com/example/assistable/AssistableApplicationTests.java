package com.example.assistable;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class AssistableApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testVerifyBankAccountSuccess() throws Exception {
        mockMvc.perform(post("/bank-account-verification")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("memberkey", "PB-FLU001")
                        .param("password", "062fd17a5e1b41b4e627406410e4769d")
                        .param("accountNumber", "10109358234")
                        .param("idNumber", "OP0397476")
                        .param("accountType", "current")
                        .param("branchCode", "645")
                        .param("yourReference", "reference123"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
                .andExpect(content().string("{\"Status\":\"Failure\",\"Error\":\"Insufficient funds, Please fund account or contact support @ support@pbverify.co.za..\"}"));
    }

    @Test
    public void testVerifyBankAccountMissingParameters() throws Exception {
        mockMvc.perform(post("/bank-account-verification")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("accountNumber", "10109358234")
                        .param("idNumber", "OP0397476")
                        .param("accountType", "current"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void contextLoads() {
    }

}
