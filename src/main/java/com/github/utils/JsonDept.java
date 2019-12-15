package com.github.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@ToString
public class JsonDept {

    private Integer id;
    private String text;
    private String state;//节点状态,'open' 或 'closed'，默认：'open'
    private boolean checked;//表示该节点是否被选中
    private List<JsonDept> children;

}
