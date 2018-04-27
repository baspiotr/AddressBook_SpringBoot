package com.baspiotr.addressbook.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchForm {

    private String query;

    @Override
    public String toString() {
        return "SearchForm{" +
                "query='" + query + '\'' +
                '}';
    }
}
