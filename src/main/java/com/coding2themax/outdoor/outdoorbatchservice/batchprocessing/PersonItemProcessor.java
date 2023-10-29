package com.coding2themax.outdoor.outdoorbatchservice.batchprocessing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.NonNull;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

  private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

  @Override
  public Person process(@NonNull Person person) throws Exception {
    final String firstName = person.firstName().toUpperCase();
    final String lastName = person.lastName().toUpperCase();

    final Person transformedPerson = new Person(firstName, lastName);
    log.info("Converting (" + person + ") into (" + transformedPerson + ")");

    return transformedPerson;

  }

}
