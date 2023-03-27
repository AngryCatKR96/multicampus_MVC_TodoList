package com.multicampus.springboot.controller;

import com.multicampus.springboot.dto.PageRequestDTO;
import com.multicampus.springboot.dto.TodoDTO;
import com.multicampus.springboot.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MyController {

    @Autowired
    private ITodoService service;

    @GetMapping("/")
    public @ResponseBody String root(){
        return "todo 게시판 만들기";
    }

    @GetMapping("/listAll")
    public String list(Model model){
        model.addAttribute("list", service.selectAll());
        return "list";
    }

    @GetMapping("/view")
    public String view(@RequestParam("tno") String tno,  Model model){
        model.addAttribute("dto", service.view(tno));
        return "view";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerProcess(TodoDTO todoDTO){
        int nResult = service.insert(todoDTO);
        System.out.println("입력 행 수 : "+ nResult);
        return "redirect:list";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modify(@RequestParam("tno") String tno, Model model){
        model.addAttribute("dto", service.view(tno));
        return "modify";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyProcess(TodoDTO todoDTO){
//        System.out.println("tno 값 : " + todoDTO.getTno() );
//        System.out.println("title 값 : " + todoDTO.getTitle() );
//        System.out.println("dueDate 값 : " + todoDTO.getDueDate() );
//        System.out.println("writer 값 : " + todoDTO.getWriter() );

        if(todoDTO.getFinished() == null){
            todoDTO.setFinished("0");
        }else {
            todoDTO.setFinished("1");
        }
        //System.out.println("finished값 : "+ todoDTO.getFinished() );
        int nResult = service.modify(todoDTO);
        System.out.println("수정 행 수 : "+ nResult);
        return "redirect:list";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("tno") String tno){
        service.remove(tno);
        return "redirect:list";
    }

    @GetMapping("/search")
    public String search(PageRequestDTO pageRequestDTO, Model model){
        model.addAttribute("responseDTO", service.search(pageRequestDTO));
        return "list";
    }

    @GetMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model){
        // log.info(pageRequestDTO);

//        if(bindingResult.hasErrors()){
//            pageRequestDTO = PageRequestDTO.builder().build();
//        }

        model.addAttribute("responseDTO", service.getList(pageRequestDTO));
    }

}
