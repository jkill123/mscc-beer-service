package com.pinchuk.yevhen.msccbeerservice.repositories;

import com.pinchuk.yevhen.msccbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * @author Pinchuk Yevhen
 * @created 15/03/2020 - 19:011
 */
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
