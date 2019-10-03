package org.app.mongodb.services;

import org.app.mongodb.models.Impiegato;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpiegatoRepository extends MongoRepository<Impiegato, Long> {



}
