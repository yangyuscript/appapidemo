package com.lin.appapidemo.service;

import com.lin.appapidemo.model.Position;

import java.util.List;

public interface PositionService {
    void addPosition(Position position);
    void deletePosition(int pid);
    List<Position> findAllByUserid(int userid);
}
