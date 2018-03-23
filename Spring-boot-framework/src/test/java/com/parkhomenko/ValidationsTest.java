package com.parkhomenko;

import com.parkhomenko.validation.CommentEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Dmytro Parkhomenko
 *         Created on 27.11.16.
 */

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ValidationsTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void spring_validator_test() throws Exception {

        CommentEntity dto = new CommentEntity();
        dto.setPhone("");
        dto.setText("my first comment");

        mvc.perform(post("/spring/validator/comment")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(dto))
        )
                .andExpect(status().isOk())
                .andExpect(content().string("error"));;
    }

    @Test
    public void hibernate_validator_test_fail() throws Exception {

        CommentEntity dto = new CommentEntity();
        dto.setPhone("1234567890*");
        dto.setText("my first comment");

        mvc.perform(post("/hibernate/validator/comment")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(dto))
        )
                .andExpect(status().isOk())
                .andExpect(content().string("error"));
    }

    @Test
    public void hibernate_and_spring_validators_test_fail() throws Exception {

        CommentEntity dto = new CommentEntity();
        dto.setPhone("1234567890*");
        dto.setText("");

        mvc.perform(post("/springhibernate/validator/comment")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(dto))
        )
                .andExpect(status().isOk())
                .andExpect(content().string("error"));
    }
}
