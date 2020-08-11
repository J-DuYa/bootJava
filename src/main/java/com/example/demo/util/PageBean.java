package com.example.demo.util;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PageBean<T> {
    // 当前页
    private Long currentNo;

    // 单页显示数据条数
    private Long pageSize;

    // 总的数据条数
    private Long totalRecord;

    // 总页数
    private Long totalPage;

    // 开始索引
    private Long startIndex;

    // 分页显示
    private Long start;
    private Long end;

    // 数据集合
    private List<T> dataList;

    public PageBean(Long currentNo, Long pageSize, Long totalRecord) {
        this.currentNo = currentNo;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        if (totalRecord % pageSize == 0) {
            this.totalPage = totalRecord / pageSize;
        } else {
            this.totalPage = totalRecord / pageSize + 1;
        }

        this.startIndex = (currentNo - 1) * pageSize;

        this.start = 1L;
        this.end = 5L;
        if (totalPage <= 5) {
            this.end = this.totalPage;
        } else {
            this.start = currentNo - 2;
            this.end = currentNo + 2;

            if (start < 0) {
                start = 1L;
                end = 5L;
            }

            if (end > this.totalPage) {
                this.end = totalPage;
                this.start = end - 5;
            }
        }
    }
}
