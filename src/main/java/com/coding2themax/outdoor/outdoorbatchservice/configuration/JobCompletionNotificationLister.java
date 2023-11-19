package com.coding2themax.outdoor.outdoorbatchservice.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.coding2themax.outdoor.outdoorbatchservice.model.USState;

@Component
public class JobCompletionNotificationLister implements JobExecutionListener {

  private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationLister.class);

  private final JdbcTemplate jdbcTemplate;

  public JobCompletionNotificationLister(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void afterJob(JobExecution jobExecution) {
    if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
      log.info("!!! JOB FINISHED! Time to verify the results");

      jdbcTemplate
          .query("SELECT id, fullname FROM usstate", new DataClassRowMapper<>(USState.class))
          .forEach(USState -> log.info("Found <{{}}> in the database.", USState));
    }
  }

}
