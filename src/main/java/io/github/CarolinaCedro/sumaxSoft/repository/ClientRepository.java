package io.github.CarolinaCedro.sumaxSoft.repository;

import io.github.CarolinaCedro.sumaxSoft.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    @Query(" select e from Client e" +
            " where upper( e.name ) like upper( :name )")
    List<Client> findByNameIsLikeIgnoreCase(@Param("name") String name);
}
