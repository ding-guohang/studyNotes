package com.dgh.study.jvm.gc;

/**
 * 对象可以在被GC时自救
 * 但是只能自救一次，因为finalize只会被调用一次
 * <p>
 * Result:
 * "finalize"
 * "is alive"
 * "had gc"
 *
 * @author guohang.ding on 2017/6/14.
 */
public class FinalizeEscape {

    public static FinalizeEscape SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("is alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize");
        FinalizeEscape.SAVE_HOOK = this;
    }


    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscape();

        // 第一次自救
        SAVE_HOOK = null;
        System.gc();
        // finalize所处的F-Queue优先级太低，等它0.5秒
        Thread.sleep(500);

        if (null == SAVE_HOOK) {
            System.out.println("had gc");
        } else {
            SAVE_HOOK.isAlive();
        }

        //重复代码，尝试自救
        SAVE_HOOK = null;
        System.gc();
        // finalize所处的F-Queue优先级太低，等它0.5秒
        Thread.sleep(500);

        if (null == SAVE_HOOK) {
            System.out.println("had gc");
        } else {
            SAVE_HOOK.isAlive();
        }
    }
}
