package hkmu.comps380f.op;

public class OpMultiply implements Operation{
    @Override
    public long operate(long op1, long op2) {
        return op1 * op2;
    }

    @Override
    public String getOpsName() {
        return " times ";
    }
}
