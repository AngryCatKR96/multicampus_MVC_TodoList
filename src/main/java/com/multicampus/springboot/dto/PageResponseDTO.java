package com.multicampus.springboot.dto;

import lombok.*;

import java.util.List;


@Data
public class PageResponseDTO <E>{

    private int page; // 현재 페이지
    private int size; // 한 페이지당 글 개수
    private int total; //  총 글 개수

    private int start; // 한 그룹에서 시작 페이지 번호
    private int end; // 한 그룹에서 마지막 페이지 번호

    // 이전 페이지 존재 여부
    private boolean prev;
    // 다음 페이지 존재 여부
    private boolean next;

    private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total){

        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;

        this.end = (int)(Math.ceil(this.page/10.0)) * 10; //
        this.start = this.end - 9; //

        int last = (int)(Math.ceil((total/(double)size))); // 제일 마지막 페이지 번호
        this.end = end > last ? last : end; 

        this.prev = this.start > 1; // 그룹 기준
        this.next = total > this.end * this.size;

    }




}
