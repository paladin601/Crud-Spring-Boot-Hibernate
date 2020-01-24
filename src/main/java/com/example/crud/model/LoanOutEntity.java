package com.example.crud.model;

import java.util.List;

public class LoanOutEntity {

    private List<LoanEntity> items;
    private PagingEntity paging;

    public LoanOutEntity(List<LoanEntity> list, int page, int size, float total){
        this.items=list;
        this.paging=new PagingEntity(page,size,total);
    }

    public List<LoanEntity> getItems() {
        return items;
    }

    
    public void setItems(List<LoanEntity> items) {
        this.items = items;
    }
    
    public PagingEntity getPaging() {
        return paging;
    }

    public void setPaging(PagingEntity paging) {
        this.paging = paging;
    }
    

}