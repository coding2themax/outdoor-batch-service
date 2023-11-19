package com.coding2themax.outdoor.outdoorbatchservice.batchprocessing;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import com.coding2themax.outdoor.outdoorbatchservice.model.USState;

public class StateItemProcessor implements ItemProcessor<USState, USState> {

  @Override
  @Nullable
  public USState process(@NonNull USState item) throws Exception {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'process'");
  }

}
