package com.lin.appapidemo.serviceimpl;

import com.lin.appapidemo.mapper.PositionMapper;
import com.lin.appapidemo.model.Position;
import com.lin.appapidemo.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionServiceImpl implements PositionService {
    @Autowired(required = false)
    private PositionMapper positionMapper;
    @Override
    public void addPosition(Position position) {
        positionMapper.insert(position);
    }

    @Override
    public void deletePosition(int pid) {
        positionMapper.deleteByPrimaryKey(pid);
    }

    @Override
    public List<Position> findAllByUserid(int userid) {
        return positionMapper.findAllByUserid(userid);
    }
}
