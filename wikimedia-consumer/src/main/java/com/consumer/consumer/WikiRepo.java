package com.consumer.consumer;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface WikiRepo extends PagingAndSortingRepository<WikiModel,Integer> {

}
