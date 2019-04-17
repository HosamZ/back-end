package at.nacs.the_magic_8ball.controller;

import at.nacs.the_magic_8ball.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@ConfigurationProperties("list")
public class Manager {

  @Setter
  private List<Message> messages;

  public Message display() {
    int listSize = messages.size();
    int nextRandom = new Random().nextInt(listSize);
    Message message = messages.get(nextRandom);
    return message;
  }
}