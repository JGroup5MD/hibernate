package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.models;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IMailDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IManagerConnection;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.MailEntity;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.util.ManagerConnection;

import javax.persistence.EntityManager;
import java.util.LinkedList;
import java.util.List;

public class MailDAO implements IMailDAO {
    private  final IManagerConnection mc;
    public MailDAO(ManagerConnection mc) {
        this.mc = mc;
    }
    public List<MailEntity> getAllMails(){
        List<MailEntity> mails;
        EntityManager em=null;
        try{
            mc.EntityManager().getTransaction().begin();
            mails=mc.EntityManager().createQuery("SELECT id FROM VoteWithMail  ORDER BY date ", MailEntity.class).getResultList();
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

    public List<MailEntity> mailSender(){
        List<MailEntity> mails=getAllMails();
        List <MailEntity> mailToSend=new LinkedList<>();
        for(MailEntity item:mails){
            if(item.isValidateEmail()&&item.isSendMassage()){
                mailToSend.add(item);
            }
        }
        return mailToSend;
    }

    public MailEntity getSpecialMail(long id){
        MailEntity mails;
        try {
            mc.EntityManager().getTransaction().begin();
            mails=mc.EntityManager().find(MailEntity.class,id);
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

    public boolean addMail(MailEntity email) {

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
            MailEntity mail = mc.EntityManager().find(MailEntity.class,id);
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
            MailEntity mail = mc.EntityManager().find(MailEntity.class,id);
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
