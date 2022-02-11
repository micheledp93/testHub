package it.unikey.testhub_server.BLL.service;
import java.util.List;

public interface EmailService {
    void sendEmail(List<String> emails);
}
