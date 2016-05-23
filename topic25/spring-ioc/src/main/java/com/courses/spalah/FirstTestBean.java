package com.courses.spalah;

/**
 * @author Ievgen Tararaka
 */
public class FirstTestBean {
    private SecondTestBean secondTestBean;
    private ThirdTestBean thirdTestBean;

    public void foo() {
        secondTestBean.sayHello();
        thirdTestBean.doStuff();
    }

    public FirstTestBean(SecondTestBean secondTestBean) {
        this.secondTestBean = secondTestBean;
    }

    public void setThirdTestBean(ThirdTestBean thirdTestBean) {
        this.thirdTestBean = thirdTestBean;
    }
}
