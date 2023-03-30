package com.multicampus.springboot.service;

import com.multicampus.springboot.dto.TodoDTO;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
@Nested
@SpringBootTest
@DisplayName("TodoList 서비스 테스트하기")
public class TodoServiceTest {

    @Autowired(required = false)
    TodoService service;

    @DisplayName("Test11")
    @Nested
    class Test11{



    @DisplayName("모든 글을 리스트로 출력하기")
    @Test

    public void selectAllTest(){
        List<TodoDTO> list = service.selectAll();
        Assertions.assertNotNull(list);
    }

    @DisplayName("글 상세보기")
    //@Test
    //@RepeatedTest(value=1000, name="{displayName} 중 {currentRepetition} of {totalRepetitions}")
    @ParameterizedTest
    @CsvSource(value={"1","10","30"})
    public void viewTest(String tno) throws Exception{
        TodoDTO todoDTO = service.view(tno);
        //Assertions.assertNotNull(todoDTO);
//        Assertions.assertEquals(todoDTO.getTitle(),"test8");
        //assertThat(todoDTO.getTitle()).isEqualTo("test8");
    }

    }

}
