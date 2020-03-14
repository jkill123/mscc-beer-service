package com.pinchuk.yevhen.msccbeerservice.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Pinchuk Yevhen
 * @created 14/03/2020 - 19:07
 */
public class BeerPageList extends PageImpl<BeerDto> {
    public BeerPageList(List<BeerDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeerPageList(List<BeerDto> content) {
        super(content);
    }
}
