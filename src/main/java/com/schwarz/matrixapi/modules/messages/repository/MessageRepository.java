package com.schwarz.matrixapi.modules.messages.repository;

import com.schwarz.matrixapi.modules.messages.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {


}
