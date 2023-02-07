package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IMailDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IManagerConnection;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Mail;

import java.util.LinkedList;
import java.util.List;

public class MailDAO implements IMailDAO {
    private  final IManagerConnection mc;
    public MailDAO(ManagerConnection mc) {
        this.mc = mc;
    }
    public List<Mail> getAllMails(){
        List<Mail> mails;
        try{
            mc.EntityManager().getTransaction().begin();
            mails=mc.EntityManager().createQuery("SELECT id FROM VoteWithMail  ORDER BY date ",Mail.class).getResultList();
            mc.EntityManager().getTransaction().commit();
        }catch (Exception e){
            if(mc.EntityManager()!=null){
                mc.EntityManager().getTransaction().rollback();
            }
            throw new RuntimeException("Erorr DataBase", e);
        }finally {
            if (mc.EntityManager()!=null){
                mc.EntityManager().close();
            }
        }
        return mails;
    }

    public List<Mail> mailSender(){
        List<Mail> mails=getAllMails();
        List <Mail> mailToSend=new LinkedList<>();
        for(Mail item:mails){
            if(item.isValidateEmail()&&item.isSendMassage()){
                mailToSend.add(item);
            }
        }
        return mailToSend;
    }

    public Mail getSpecialMail(long id){
        Mail mails;
        try {
            mc.EntityManager().getTransaction().begin();
            mails=mc.EntityManager().find(Mail.class,id);
            mc.EntityManager().getTransaction().commit();
        } catch (Exception e){
        throw new RuntimeException("Erorr DataBase", e);
    }finally {
        if (mc.EntityManager()!=null){
            mc.EntityManager().close();
        }
    }
        return mails;
    }

    public boolean addEmail(Mail email) {

        try {
           mc.EntityManager().getTransaction().begin();
           mc.EntityManager().persist(email);
           mc.EntityManager().getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (mc.EntityManager()!=null){
                mc.EntityManager().close();
            }
        }
        return true;
    }


    public boolean updateEmail(Long id,String message, boolean validateEmail,
                               boolean sendMessage, long lastSendTime, String email) {

        try {
            mc.EntityManager().getTransaction().begin();
            Mail mail = mc.EntityManager().find(Mail.class,id);
            if(mail==null){
                return false;
            }
            mail.getMessageText();
            mail.setValidateEmail(validateEmail);
            mail.setSendMassage(sendMessage);
            mail.setLastSendTime(System.currentTimeMillis());
            mail.setAdressMail(email);
            mc.EntityManager().merge(mail);
            mc.EntityManager().getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (mc.EntityManager()!=null){
                mc.EntityManager().close();
            }
        }
        return true;
    }


    public boolean deleteEmail(long id) {

        try {
            mc.EntityManager().getTransaction().begin();
            Mail mail = mc.EntityManager().find(Mail.class,id);
            if(mail!=null){
                mc.EntityManager().remove(mail);
            } else {
                return false;
            }
            mc.EntityManager().getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (mc.EntityManager()!=null){
                mc.EntityManager().close();
            }
        }
        return true;
    }
}
