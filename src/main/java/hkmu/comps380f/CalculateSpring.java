package hkmu.comps380f;

import hkmu.comps380f.op.Operation;

public class CalculateSpring {
    private Operation ops;

    public void setOps(Operation ops) {
        this.ops = ops;
    }

    public long operate(long op1, long op2) {
        return ops.operate(op1, op2);
    }

    public String getOpsName() {
        return ops.getOpsName();
    }

}
