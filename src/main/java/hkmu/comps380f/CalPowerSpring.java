package hkmu.comps380f;

import hkmu.comps380f.op.Operation;

public class CalPowerSpring {
    private int power;
    private Operation ops;

    public CalPowerSpring(int power, Operation ops) {
        this.power = power;
        this.ops = ops;
    }

    public String getOpsName() {
        return ops.getOpsName();
    }

    public long operate(long op1, long op2) {
        return ops.operate((long) Math.pow(op1, power), (long) Math.pow(op2, power));
    }

    public String getPower() {
        return String.valueOf(power);
    }
}
