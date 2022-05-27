import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.GregorianCalendar;
import java.util.Properties;

public class Mesageiro {
    public static void enviarProgramacaoDeHoje(String destinatario){
        Persistencia salvar = new Persistencia();
        CentralDeInformacoes cadastrar = salvar.recuperarCentral("arquivo.xml");

        Properties props = new Properties();
        props.put("mail.smtp.user","ellencassiamatos@gmail.com");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "25");
        props.put("mail.debug", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.EnableSSL.enable","true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");


        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("ellencassiamatos@gmail.com", "ellen45@cassia");
            }
        });

        session.setDebug(true);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ellencassiamatos@gmail.com"));
            Address[] toUser = InternetAddress.parse(destinatario);
            message.setRecipients(Message.RecipientType.TO, toUser);

            GregorianCalendar gc=new GregorianCalendar();
            int dia = gc.get(gc.DAY_OF_WEEK);
            String saida = "";

            for(ProgramaDeTv p: cadastrar.getTodosProgramas()){
                if(p.getDias().getTempo() == dia){
                    saida += p.getNome() + "- ";
                }
            }
            // cabeçalho do gmail
            message.setSubject("Programação de hoje");
            // corpo do e-mail
            message.setText(saida);
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}
