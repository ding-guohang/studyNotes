package com.dgh.study.serialize;

//import com.alibaba.com.caucho.hessian.io.Hessian2Input;
//import com.alibaba.com.caucho.hessian.io.Hessian2Output;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;

/**
 * @author guohang.ding on 2017/5/9.
 */
public class HessianTest {

    public static class Base implements Serializable {
        private String bussnessFlag = "PAI";

        public String getBussnessFlag() {
            return bussnessFlag;
        }

        public Base setBussnessFlag(String bussnessFlag) {
            this.bussnessFlag = bussnessFlag;
            return this;
        }

    }

    public static class Prod extends Base {
        private String bussnessFlag = "NTS";
        transient String date = "bbbbb";

        public String getBussnessFlag() {
            return bussnessFlag;
        }

        public Prod setBussnessFlag(String bussnessFlag) {
            this.bussnessFlag = bussnessFlag;
            return this;
        }

        public String getDate() {
            return date;
        }

        public Prod setDate(String date) {
            this.date = date;
            return this;
        }
    }

    public void testName() throws Exception {

        /*File file = new File("./aaa");
        FileOutputStream os = new FileOutputStream(file);
        Hessian2Output output = new Hessian2Output(os);

        Prod prod = new Prod();
        prod.setDate("sdsfsdfs");
        Base base = prod;
        System.out.println(base.getBussnessFlag());
        System.out.println(prod.getBussnessFlag());
        output.writeObject(prod);
        output.close();
        os.close();

        FileInputStream in = new FileInputStream(new File("./aaa"));
        Hessian2Input is = new Hessian2Input(in);
        prod = (Prod) is.readObject(Prod.class);
        base = prod;
        System.out.println(base.getBussnessFlag());
        System.out.println(prod.getBussnessFlag());*/
    }

    public static void main(String[] args) throws Exception {
        new HessianTest().testName();
    }

}
