package com.multicampus.springboot.service;

import com.multicampus.springboot.dao.ITodoDAO;
import com.multicampus.springboot.dto.PageRequestDTO;
import com.multicampus.springboot.dto.PageResponseDTO;
import com.multicampus.springboot.dto.TodoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService implements ITodoService{

    @Autowired
    ITodoDAO dao;

    @Override
    public List<TodoDTO> selectAll() {
        return dao.selectAllDAO();
    }

    @Override
    public TodoDTO view(String tno) {
        return dao.viewDAO(tno);
    }

    @Override
    public int insert(TodoDTO todoDTO) {
        return dao.insertDAO(todoDTO);
    }

    @Override
    public int modify(TodoDTO todoDTO) {
        return dao.modifyDAO(todoDTO);
    }

    @Override
    public int remove(String tno) {
        return dao.removeDAO(tno);
    }

    @Override
    public PageResponseDTO<TodoDTO> search(PageRequestDTO pageRequestDTO) {


        return new PageResponseDTO<TodoDTO>(pageRequestDTO,dao.searchDAO(pageRequestDTO), dao.searchCountDAO(pageRequestDTO) );
    }

    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {

        List<TodoDTO> todoList = dao.selectList(pageRequestDTO);

        int total = dao.getCount(pageRequestDTO);

        PageResponseDTO<TodoDTO>  pageResponseDTO = PageResponseDTO.<TodoDTO>withAll()
                .dtoList(todoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }

}
