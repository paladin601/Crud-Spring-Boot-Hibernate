package com.example.crud.model;

public class PagingEntity {

    private int page;
    private int size;
    private float total;

    public PagingEntity(int pageAux, int sizeAux, float totalAux) {
        this.page = pageAux;
        this.size = sizeAux;
        this.total = totalAux;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

}