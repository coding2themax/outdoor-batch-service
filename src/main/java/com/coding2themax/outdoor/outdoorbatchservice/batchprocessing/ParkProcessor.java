package com.coding2themax.outdoor.outdoorbatchservice.batchprocessing;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import com.coding2themax.outdoor.outdoorbatchservice.model.Park;
import com.coding2themax.outdoor.outdoorbatchservice.model.dto.ParkDTO;

public class ParkProcessor implements ItemProcessor<Park, ParkDTO> {

  @Override
  @Nullable
  public ParkDTO process(@NonNull Park item) throws Exception {
    return new ParkDTO(item.parkCode(), item.url(), item.fullname(), item.description());
  }

}
