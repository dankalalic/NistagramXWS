package com.example.PostService.Model;

import java.util.List;

public class ListIntegerWrapper {

    private List<Integer> integerList;

    public ListIntegerWrapper(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public ListIntegerWrapper() {
    }

    public List<Integer> getIntegerList() {
        return integerList;
    }

    public void setIntegerList(List<Integer> integerList) {
        this.integerList = integerList;
    }
}
