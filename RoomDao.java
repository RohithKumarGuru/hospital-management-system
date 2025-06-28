package com.project.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management_system.dto.Room;
import com.project.hospital_management_system.exception.RoomIdNotFound;
import com.project.hospital_management_system.repo.RoomRepo;

@Repository
public class RoomDao {
	@Autowired
	RoomRepo roomRepo;
	
	public Room saveRoom(Room room) {
		return roomRepo.save(room);
	}
	
	 public Room fetchRoomById(int roomId) {
	        Optional<Room> optional = roomRepo.findById(roomId);
	        if (optional.isPresent()) {
	            return optional.get();
	        } else {
	            throw new RoomIdNotFound();
	        }
	    }
	
	public Room deleteRoomById(int roomId) {
		Room room=fetchRoomById(roomId);
		roomRepo.delete(room);
		return room;
	}
	
	public Room updateRoomById(int oldRoomId,Room newRoom) {
		newRoom.setRoomId(oldRoomId);
		return roomRepo.save(newRoom);
	} 
	
	public List<Room> fetchAllRoom(){
		return roomRepo.findAll();
	}

}
