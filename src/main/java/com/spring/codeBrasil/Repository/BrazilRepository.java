package com.spring.codeBrasil.Repository;
import com.spring.codeBrasil.model.Brazil;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;

public interface BrazilRepository extends  CrudRepository  <Brazil, Long> {
    @Query("FROM Brazil br " +
            "WHERE LOWER(br.state) like %:searchTerm% " +
            "OR LOWER(br.uf) like %:searchTerm%")
        default Page<Brazil> search(
            @Param("searchTerm") String searchTerm,
            Pageable pageable) {
        return null;
    }
}