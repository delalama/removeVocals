package com.delalama.backingtracks.repository;

import com.delalama.backingtracks.model.Audio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudioRepository extends MongoRepository<Audio,String> {


}
