package com.wxb.community;

public class TestAdmin {
/*    @Test
    public void rePwd(){
        Session session=HibernateUtil.getCurrentSession();
        session.beginTransaction();
        String name="小鸣";
        String oldPwd="222";
        List<AdminEntity> ad=session.createQuery("from AdminsEntity where name=? and pwd=? ").setParameter(0, name).setParameter(1, oldPwd).list();
       // int Id=adminEntityList.get(0).getId();
       *//* AdminsEntity ad=session.get(AdminsEntity.class,1);*//*
        ad.get(0).setPwd("1234");
        session.update(ad.get(0));
        session.getTransaction().commit();
        HibernateUtil.close(session);
    }
    @Test
    public void add(){
        Session session=HibernateUtil.getCurrentSession();
        session.beginTransaction();
        AdminEntity ad=new AdminEntity();

        ad.setName("ab");
        ad.setPwd("222");
        ad.setIntroduction("你就是个弟弟");
        session.save(ad);
        session.getTransaction().commit();
        HibernateUtil.close(session);
    }*/

}
