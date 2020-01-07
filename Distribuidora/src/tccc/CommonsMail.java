/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class CommonsMail {

    public void EnviarEmail(String Assunto, String Mensagem, String Email) {

        SimpleEmail email = new SimpleEmail();

        try {
            email.setDebug(true);
            email.setHostName("smtp.gmail.com");
            email.setAuthentication("suportetramontina@gmail.com", "alphaparnaiba");
            email.setSSL(true);
            email.addTo(Email); //pode ser qualquer email  
            email.setFrom("suportetramontina@gmail.com"); //será passado o email que você fará a autenticação
            email.setSubject(Assunto);
            email.setMsg(Mensagem);
            email.send();

        } catch (EmailException e) {
            System.out.println(e.getMessage());
        }
    }
}
