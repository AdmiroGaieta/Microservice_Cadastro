package com.ms.email.consumers;

import com.ms.email.dtos.EmailRecordDto;
import com.ms.email.models.EmailModel;
import com.ms.email.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailSendException;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${broker.queue.email.name}")
public void listenEmailQueue(@Payload EmailRecordDto emailRecordDto) {
    var emailModel = new EmailModel();
    BeanUtils.copyProperties(emailRecordDto, emailModel);
    System.out.println("Mensagem recebida da fila: " + emailModel);

    try {
        
        emailService.sendEmail(emailModel);
        System.out.println("E-mail enviado com sucesso para: " + emailModel.getEmailTo());
    } catch (MailAuthenticationException e) {
        System.out.println("Erro de autenticação SMTP ao enviar e-mail para: " + emailModel.getEmailTo());
        e.printStackTrace();
    } catch (MailSendException e) {
        System.out.println("Erro ao enviar e-mail para: " + emailModel.getEmailTo());
        e.printStackTrace();
    } catch (Exception e) {
        System.out.println("Erro desconhecido ao enviar e-mail para: " + emailModel.getEmailTo());
        e.printStackTrace();
    }
}

}
