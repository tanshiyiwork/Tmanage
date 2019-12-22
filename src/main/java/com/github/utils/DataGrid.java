package com.github.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class DataGrid {

    private Integer total;
    private List<Object> rows;
}
