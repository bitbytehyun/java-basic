package spring;

import jakarta.transaction.UserTransaction;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JtaEx {
    private UserTransaction utx;

    public JtaEx() throws NamingException {
        InitialContext ctx = new InitialContext();
        utx = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
    }

    public void doBusiness() throws Exception {
        try {
            utx.begin();
            utx.commit();
        } catch (Exception e) {
            utx.rollback();
            throw e;
        }

    }
}
