package com.schwarz.matrixapi.modules.messages;

import com.schwarz.matrixapi.infrastructure.dto.ServiceResponseDTO;
import com.schwarz.matrixapi.modules.messages.model.MessageDTO;
import com.schwarz.matrixapi.modules.messages.service.MessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/message")
@AllArgsConstructor
@Slf4j
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/send")
    public ResponseEntity<ServiceResponseDTO> send(@RequestBody MessageDTO messageDTO) {
        try {
            this.messageService.sendMessage(messageDTO);
            return ResponseEntity.ok(new ServiceResponseDTO( "00", "message sent"));
        } catch (Exception e) {
            log.error("Error sending message", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<MessageDTO>> getAll() {
        try {
            return ResponseEntity.ok(this.messageService.getAllMessages());
        } catch (Exception e) {
            log.error("Error getting messages", e);
            return ResponseEntity.internalServerError().build();
        }
    }

}
