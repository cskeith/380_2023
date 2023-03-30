package hkmu.comps380f;

import hkmu.comps380f.op.Operation;

import java.util.Collection;

public class CollectionSpring {
    private Collection<Operation> ops;

    public String operateResult(long op1, long op2) {
        String result = "";
        for (Operation op : ops)
            result += "The result of " + op1
                    + op.getOpsName() + op2 + " is "
                    + op.operate(op1, op2) + "!!</br>";
        return result;
    }

    public void setOps(Collection<Operation> ops) {
        this.ops = ops;
    }
}
