package com.phonecounter.server.controller;

import com.phonecounter.server.model.DailyRecord;
import com.phonecounter.server.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecordController {
    private final RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping(path = {"record"})
    List<DailyRecord> getDailyRecords(@RequestParam("userId") Long id) {
        return recordService.gerRecord(id);
    }

    @PostMapping(path = {"record"})
    private void saveDailyRecords(@RequestBody List<DailyRecord> dailyRecords, @RequestParam("userId") Long id) {
        recordService.saveRecord(dailyRecords, id);
    }
}
