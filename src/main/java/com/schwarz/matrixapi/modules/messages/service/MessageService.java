package com.schwarz.matrixapi.modules.messages.service;

import com.schwarz.matrixapi.modules.messages.model.Message;
import com.schwarz.matrixapi.modules.messages.model.MessageDTO;
import com.schwarz.matrixapi.modules.messages.repository.MessageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public void sendMessage(MessageDTO messageDTO) {
        createMessage(messageDTO);
    }

    public List<MessageDTO> getAllMessages() {
       List<Message> messages = this.messageRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
       return messages.stream().map(message ->
               MessageDTO.builder()
                       .message(message.getMessage()).id(message.getId()).build()).toList();
    }

    public void createMessage(MessageDTO messageDTO) {
        messageRepository.save(Message.builder()
                .message(messageDTO.getMessage())
                .build());
    }

}
