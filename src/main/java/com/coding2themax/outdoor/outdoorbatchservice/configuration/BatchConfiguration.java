package com.coding2themax.outdoor.outdoorbatchservice.configuration;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.coding2themax.outdoor.outdoorbatchservice.model.Park;
import com.coding2themax.outdoor.outdoorbatchservice.model.USState;

@Configuration
public class BatchConfiguration {

  @Bean
  public FlatFileItemReader<USState> stateReader() {

    return new FlatFileItemReaderBuilder<USState>().name(
        "personItemReader").resource(new ClassPathResource("state.csv"))
        .delimited()
        .names("id", "fullname")
        .targetType(USState.class)
        .build();

  }

  @Bean
  public JsonItemReader<Park> jsonParkItemReader() {

    return new JsonItemReaderBuilder<Park>().jsonObjectReader(new JacksonJsonObjectReader<>(Park.class))
        .resource(new ClassPathResource("park.json"))
        .name("parkJsonItemReader")
        .build();
  }

  @Bean
  public JdbcBatchItemWriter<USState> writer(DataSource dataSource) {
    return new JdbcBatchItemWriterBuilder<USState>()
        .sql("INSERT INTO usstate (id, fullname) VALUES (:id, :fullname)")
        .dataSource(dataSource)
        .beanMapped()
        .build();
  }

  @Bean
  public Job importUserJob(JobRepository jobRepository, Step step1, JobCompletionNotificationLister listener) {
    return new JobBuilder("importUserJob", jobRepository).listener(listener).start(step1).build();

  }

  @Bean
  public Step step1(JobRepository jobRepository, DataSourceTransactionManager transactionManager,
      FlatFileItemReader<USState> stateReader, JdbcBatchItemWriter<USState> writer) {
    return new StepBuilder("step1", jobRepository)
        .<USState, USState>chunk(3, transactionManager)
        .reader(stateReader)
        .writer(writer)
        .build();
  }
}
