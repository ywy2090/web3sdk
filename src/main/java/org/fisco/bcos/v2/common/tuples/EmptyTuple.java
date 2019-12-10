package org.fisco.bcos.v2.common.tuples;

/** Empty Tuple type. */
public class EmptyTuple implements Tuple {

    @Override
    public int getSize() {
        return 0;
    }
}
