package com.digital.crud.saladereuniao.saladereuniao.controller;

import com.digital.crud.saladereuniao.saladereuniao.exception.ResourceNotFoundException;
import com.digital.crud.saladereuniao.saladereuniao.model.Room;
import com.digital.crud.saladereuniao.saladereuniao.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> getAllRooms() {
        return roomService.listAllRooms();
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) throws ResourceNotFoundException {
        return roomService.getRoomById(id);
    }

    @PostMapping("/rooms")
    public ResponseEntity<Room> createRoom (@Valid @RequestBody Room room) {
        return roomService.createRoom(room);
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @Valid @RequestBody Room roomToUpdate) throws ResourceNotFoundException {
        return roomService.updateRoom(id, roomToUpdate);
    }

    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRoom(@PathVariable Long id) throws ResourceNotFoundException {
        return roomService.deleteRoom(id);
    }
}
