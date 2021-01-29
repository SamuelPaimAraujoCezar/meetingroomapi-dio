package com.digital.crud.saladereuniao.saladereuniao.service;

import com.digital.crud.saladereuniao.saladereuniao.exception.ResourceNotFoundException;
import com.digital.crud.saladereuniao.saladereuniao.model.Room;
import com.digital.crud.saladereuniao.saladereuniao.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public ResponseEntity<List<Room>> listAllRooms() {
        List<Room> allRooms = roomRepository.findAll();

        return ResponseEntity.ok().body(allRooms);
    }

    public ResponseEntity<Room> getRoomById(Long id) throws ResourceNotFoundException {
        Room room = verifyIfExists(id);

        return ResponseEntity.ok().body(room);
    }

    private Room verifyIfExists(Long id) throws ResourceNotFoundException {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public ResponseEntity<Room> createRoom(Room room) {
        Room savedRoom = roomRepository.save(room);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedRoom);
    }

    public ResponseEntity<Room> updateRoom(Long id, Room roomToUpdate) throws ResourceNotFoundException {
        verifyIfExists(id);
        roomToUpdate.setId(id);

        Room updatedRoom = roomRepository.save(roomToUpdate);

        return ResponseEntity.ok().body(updatedRoom);
    }

    public ResponseEntity<Map<String, Boolean>> deleteRoom(Long id) throws ResourceNotFoundException {
        verifyIfExists(id);

        roomRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}
